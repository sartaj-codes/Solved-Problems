#include<stdio.h>
int main()
{
    int num, n, n1 ;
    scanf("%d", &num);
    n1 = 1 << 4;
    n1--;
    n = num & n1;
    
    n = n << 4; 
    num = num >> 4; 
    n = n | num;
    printf("%d ", n);
    return 0;
 }
