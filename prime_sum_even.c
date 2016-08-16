#include<stdio.h>
#include<math.h>
int calc_prime(int n)
{    int j, f = 0;
     for( j = 2; sqrt(n) >= j; j++ )
     {
           if( n % j ==0 )
           {
                f = 1;
                break;
           }
    }
    if( f )
       return 0;
    else
       return 1;
}

int main()
{
    int N,m ,i = 3 ;
    scanf("%d", &N);
    while(i < N )
    {
              m = N - i;
              if( calc_prime(m) && calc_prime( i ) )
              {
                   printf("%d %d\n", i,(N-i));
                   break;
              }
           
         i++;
    }
    return 0;
}
