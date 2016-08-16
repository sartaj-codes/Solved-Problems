#include <stdio.h>
int f_gcd(int a, int b)
{
    if( a > b )
    {
        
      if( !(a % b) )
      {
           return b;
      }
     b = a % b;
     a = a - b;
     f_gcd(a,b);
    }
   else
   {
       return a;
   }
}
int main()
{
    int a, b;
    scanf("%d%d", &a,&b);
    printf("GCD:%d\n", f_gcd(a,b));
    return 0;

}





