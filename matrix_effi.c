#include <stdio.h>
int main()
{
     int n, i = 0, j = 0;
     scanf("%d", &n);
     int arr[n][n], e_rows =0, e_cols=0;
     for( i = 0; i < n; i++ )
     {
         for( j = 0; j < n; j++ )
         {
              scanf("%d", &arr[i][j]);
         }
     }
     for( i = 0; i < n; i++ )
     {
         for( j = 0; j < n; j++ )
         {
             if( arr[i][j] == 0 )
             {
                 e_rows = e_rows | (1<<i);
                 e_cols = e_cols | (1<<j); 
             }
         }
      }
      
     for( i = 0; i < 32; i++ )
     {
          if(e_rows & (1<<i))
          {
              for( j = 0; j < n; j++ )
              {
                  arr[i][j] = 0;
              }
          }
     }

     for( i = 0; i < 32; i++ )
     {
          if(e_cols & (1<<i) )
          {
              for( j = 0; j < n; j++ )
              {
                  arr[j][i] = 0;
              }
          }
     }

      for( i = 0; i < n; i++ )
     {
         for( j = 0; j < n; j++ )
         {
              printf("%d ", arr[i][j]);
         }
         printf("\n");
     }

     return  0;
}

      
