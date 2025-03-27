#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <sys/wait.h> // ✅ Added this header to fix "implicit declaration of wait()"

#define FIFO_NAME "/tmp/crc_fifo"
#define MAX_SIZE 32 // Max length of binary divisor

// Function to check if divisor is valid
int is_valid_divisor(const char *divisor)
{
    int len = strlen(divisor);

    // A valid CRC divisor must:
    // - Be at least 2 bits long
    // - Start and end with '1'
    if (len < 2 || divisor[0] != '1' || divisor[len - 1] != '1')
    {
        return 0; // Invalid
    }
    return 1; // Valid
}

int main()
{
    int fd;
    char divisor[MAX_SIZE];
    pid_t pid;

    // Create FIFO (named pipe)
    mkfifo(FIFO_NAME, 0666);

    // Forking process to create sender and receiver
    pid = fork();

    if (pid < 0)
    {
        perror("Fork failed");
        exit(1);
    }

    // Child Process: Receiver
    if (pid == 0)
    {
        sleep(1); // Small delay to ensure sender writes first
        printf("\n[Receiver] Waiting for divisor...\n");

        // Open FIFO for reading
        fd = open(FIFO_NAME, O_RDONLY);
        if (fd == -1)
        {
            perror("Error opening FIFO for reading");
            exit(1);
        }

        // Read divisor from FIFO
        read(fd, divisor, MAX_SIZE);
        close(fd);

        printf("[Receiver] Received divisor: %s\n", divisor);

        // Validate divisor
        if (is_valid_divisor(divisor))
        {
            printf("[Receiver] ✅ Valid CRC divisor.\n");
        }
        else
        {
            printf("[Receiver] ❌ Invalid CRC divisor. (Must start and end with 1 and be at least 2 bits long)\n");
        }

        // Remove FIFO
        unlink(FIFO_NAME);
    }
    // Parent Process: Sender
    else
    {
        printf("[Sender] Enter CRC Divisor in binary format: ");
        scanf("%s", divisor);

        // Open FIFO for writing
        fd = open(FIFO_NAME, O_WRONLY);
        if (fd == -1)
        {
            perror("Error opening FIFO for writing");
            exit(1);
        }

        // Write divisor to FIFO
        write(fd, divisor, strlen(divisor) + 1);
        close(fd);

        printf("[Sender] Divisor sent to receiver.\n");

        // ✅ Fix: Use wait() correctly
        wait(NULL); // Wait for child process to complete
    }

    return 0;
}