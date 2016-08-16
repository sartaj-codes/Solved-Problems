#include<stdio.h>
int main()
{
   int arr[]={1, 10 , 8 , 9, 9};
   int i, j , m, t = 0;  
   int n = 4;
   for( i = 0; i < n; i++ )
   {    t = arr[i + 1];
       if( t < arr[i] )
       {
        for( j = n; j >0; j-- )
        {
              if( t > arr[j-1] )
              {    
                  arr[j] = t;
                  for( m = 0; m <= n ;m++){
                        printf("%d ", arr[m]); }printf("\n");
                  break;
              }
              else
              {
                 arr[j] = arr[j - 1];
                 for( m = 0; m <= n ;m++)
                       printf("%d ",arr[m]);  printf("\n");              

              }

         }
     }
   }
return 0;
}

