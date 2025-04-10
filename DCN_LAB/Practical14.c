#include <stdio.h>
#include <stdlib.h>
#include <unistd.h> // For sleep function

int main() {
    int i, packets[10], content = 0, newcontent, time, clk, bucket_size, output_rate;

    // Generate random packet sizes
    for (i = 0; i < 5; i++) {
        packets[i] = rand() % 10;
        if (packets[i] == 0)
            i--; // Regenerate if packet size is 0
    }

    printf("\nEnter output rate of the bucket: ");
    scanf("%d", &output_rate);

    printf("\nEnter Bucket size: ");
    scanf("%d", &bucket_size);

    for (i = 0; i < 5; ++i) {
        if ((packets[i] + content) > bucket_size) {
            if (packets[i] > bucket_size)
                printf("\nIncoming packet size %d greater than the size of the bucket\n", packets[i]);
            else
                printf("\nBucket size exceeded\n");
        } else {
            newcontent = packets[i];
            content += newcontent;
            printf("\nIncoming Packet: %d\n", newcontent);
            printf("Transmission left: %d\n", content);
            time = rand() % 10;
            printf("Next packet will come at: %d\n", time);

            for (clk = 0; clk < time && content > 0; ++clk) {
                printf("\nLeft time: %d", (time - clk));
                sleep(1);

                if (content > 0) {
                    printf("\nTransmitted\n");
                    if (content < output_rate)
                        content = 0;
                    else
                        content -= output_rate;
                    printf("Bytes remaining: %d\n", content);
                } else {
                    printf("\nNo packets to send\n");
                }
            }
        }
    }

    return 0;
}
