#include <stdio.h>
int main()
{
    int n, i = 0, product = 1 ;
    scanf("%d", &n);
    int arr[n],arr1[n],arr2[n];
    for( i = 0; i < n; i++ )
    {
         scanf("%d", &arr[i]);
    }
    arr1[0] = 1;  
    for( i = 1; i < n; i++ )
    {
        arr1[i] = arr1[i-1]  * arr[i-1]; 
    }
    arr2[n-1] = 1;
    for( i = n; i > 0; i-- )
    {
         arr2[i-2] = arr2[i-1]  * arr[i-1];  
    }
    for( i = 0; i < n; i++ )
    { 
         arr2[i] *= arr1[i];  
    }
    
    for( i = 0; i < n; i++ )
    {
         printf("%d ", arr2[i]); 
    }
    return 0;
}
    
    

