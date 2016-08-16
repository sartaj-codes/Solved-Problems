#include<stdio.h>
int main()
{
     int n_1, n_2;
     scanf("%d%d", &n_1,&n_2);
     printf("Bit_And:%d\n ", ~( (~n_1) | (~n_2) ));
     return 0;
}
 
