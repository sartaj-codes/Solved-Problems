#include<stdio.h>
int main()
{
    int n;
    scanf("%d", &n);
    if( (n >> 1) & 1 )
    {
          printf("Negtive...\n");
    }
    else
    {
        printf("Postive\n");
    }
    return 0;
}
