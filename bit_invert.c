#include<stdio.h>
int main()
{
     int num, p, n;
     scanf("%d%d%d", &num,&n,&p);
     n = 1 << n;
     n--; 
     n =  n << (p-1);
     num = (num ^ n);
     printf("%d\n", num);
     return 0;
}
