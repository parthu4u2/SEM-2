 #include <stdio.h>
#include <math.h>

// function to calculate the paritybits
void generateHammingCode(int data[], int encoded[])
{
    // data bits placement(position 3,5,6 and 7)
    encoded[2] = data[0]; // d1
    encoded[4] = data[1]; // d2
    encoded[5] = data[2]; // d3
    encoded[6] = data[3]; // d4

    // calculate parity bits
    encoded[0] = encoded[2] ^ encoded[4] ^ encoded[6]; // p1
    encoded[1] = encoded[2] ^ encoded[5] ^ encoded[6]; // p2
    encoded[3] = encoded[4] ^ encoded[5] ^ encoded[6]; // p4
}
// function to detect and correct a single-bit error
void detectAndCorrect(int received[])
{
    int p1 = received[0] ^ received[2] ^ received[4] ^ received[6];
    int p2 = received[1] ^ received[2] ^ received[5] ^ received[6];
    int p4 = received[3] ^ received[4] ^ received[5] ^ received[6];

    int errorPos = p1 * 1 + p2 * 2 + p4 * 4;

    if (errorPos != 0)
    {
        printf("Error detected at position : %d\n", errorPos);
        received[errorPos - 1] ^= 1; // correct the error
    }
    else
    {
        printf("No error detected.\n");
    }
}

int main()
{
    int data[4], encoded[7], received[7];

    printf("Enter 4-bit data (Space-Separated): ");
    for (int i = 0; i < 4; i++)
    {
        scanf("%d", &data[i]);
    }

    // Genrate hamming code
    generateHammingCode(data, encoded);

    printf("Encoded data: ");
    for (int i = 0; i < 7; i++)
    {
        printf("%d", encoded[i]);
    }
    printf("\n");

    // Simulating transmission (allow user to input received bits)
    printf("Enter received 7-bit data: ");
    for (int i = 0; i < 7; i++)
    {
        scanf("%d", &received[i]);
    }

    // detect and correct errors
    detectAndCorrect(received);

    printf("Corrected data: ");
    for (int i = 0; i < 7; i++)
    {
        printf("%d", received[i]);
    }
    printf("\n");
    return 0;
}