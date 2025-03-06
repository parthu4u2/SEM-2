#include <stdio.h>
#include <math.h>

int sender(int arr[10], int n)
{
    int checksum, sum = 0, i;
    printf("\n***SENDER SIDE***\n");

    for (i = 0; i < n; i++)
        sum += arr[i];

    printf("SUM IS: %d", sum);

    checksum = ~sum;
    printf("\nCHECKSUM IS: %d", checksum);

    return checksum;
}

void receiver(int arr[10], int n, int sch)
{
    int checksum, sum = 0, i;
    printf("\n\n***RECEIVER SIDE***\n");

    for (i = 0; i < n; i++)
        sum += arr[i];

    printf("SUM IS: %d", sum);

    sum = sum + sch;
    checksum = ~sum;

    printf("\nCHECKSUM IS: %d", checksum);
    
}

void main()
{
    int n, sch;

    printf("\nENTER SIZE OF THE STRING: ");
    scanf("%d", &n);

    int arr[n];

    printf("ENTER THE ELEMENTS OF THE ARRAY TO CALCULATE CHECKSUM:\n");
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }

    sch = sender(arr, n);

    receiver(arr, n, sch);

    
}
