#include<stdio.h>
int main()
{
     int arr[] = {1, 0, 2, 3, 0, 4,-1, -2, -32, 1, 2, 3, 8, 8 ,10, 0};
     int i = 0, first_1 = 0, last_1 = 0, diff = 0;
     int n = (sizeof(arr) / sizeof(arr[0]));    
     while( i < n )
     {
         if( arr[i] != 0)
         {
             first_1 = i;
             while( arr[i] != 0 && i < n)
             {
                  i++;
             }
             last_1 = i - 1;
             if( diff < (last_1 - first_1) )
             {
                  /* first = first_1;
                   last = last_1;*/
                   diff = (last_1 - first_1);
             }
        } i++;
    }
    printf("%d\n",  (diff + 1));
    return 0;
}
               
