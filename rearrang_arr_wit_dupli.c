#include <stdio.h>
int main()
{
     int arr[] = {3, 2 , 0, 1};
     int n = 3, c = 0, i = 0, m, n1 = 4; 
     while( n )
     {
          c++;
          n = n / 2;
     }
     while( 3 >= i)
     {   
        
         if( arr[arr[i]] > (n1 - 1) ) 
                 { arr[i] = arr[i] << c; 
                 arr[i] = arr[i] | (arr[arr[i]>>c] >> c);}     
         else
                 {
                arr[i] = arr[i] << c; 
              arr[i] = arr[i] | arr[arr[i]>>c];}
        i++;    
     }
    /*for( i = 0; 4 > i; i++ )
               printf("%d ", arr[i]);
    */
     i = 0;
     m = (1<<c) - 1;
     while( 3 >= i )
     {
           arr[i] = arr[i] & m;
           i++;
     }
     for( i = 0; 4 > i; i++ )
               printf("%d ", arr[i]);

     return 0;
}

