#include<stdio.h>
int main()
{
     int arr[] = { 1, 1, 2, 2, 3, 3, 4, 5, 6, 5, 4, 6};
     int n, i ,j,n2=0;
     n = sizeof(arr) / sizeof(arr[0]);
     for( i = 0; i < n; i++ )
     {
         for( j = 0; j < n; j++ )
         {
              if( i != j && arr[i] == arr[j] )
              {
                    arr[j] = -555;
              }
         }
     }
     for( i = 0 ; i < n ; i++ )
     {
          if( arr[i] != -555 )
          {
               n2++;
          }
      }
      printf("%d\n",  (n-n2));
      return 0;
}
