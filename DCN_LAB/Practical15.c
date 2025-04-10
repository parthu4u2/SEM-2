#include <stdio.h>
#include <stdbool.h>
#include <unistd.h> // for usleep function

int main()
{
    int bucket_size, output_rate;

    // User input for bucket size and output rate
    printf("Enter the bucket size: ");
    scanf("%d", &bucket_size);
    printf("Enter the output rate of the bucket: ");
    scanf("%d", &output_rate);

    int bucket = 0; // Current size of the bucket

    while (true)
    {
        // Generate some data, e.g., incoming packets
        int incoming_packets;
        printf("Enter the number of incoming packets: ");
        scanf("%d", &incoming_packets);

        // Add incoming packets to the bucket
        if (bucket + incoming_packets <= bucket_size)
        {
            bucket += incoming_packets;
        }
        else
        {
            printf("Bucket overflow! Dropping %d packets.\n", incoming_packets + bucket - bucket_size);
            bucket = bucket_size; // Bucket is full
        }

        // Transmit data from the bucket
        if (bucket >= output_rate)
        {
            printf("%d packets transmitted.\n", output_rate);
            bucket -= output_rate;
        }
        else
        {
            printf("Bucket empty.\n");
        }

        // Wait for a second before the next iteration
        usleep(1000000); // Sleep for 1 second (1 million microseconds)
    }

    return 0;
}
