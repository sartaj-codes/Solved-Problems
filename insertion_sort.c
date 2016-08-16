# include<stdio.h>
int main()
{
    int n,i = 0,j = 0, temp = 0, m=0;
    scanf("%d", &n);
    int arr[n];
    for( i = 0; i < n; i++ )
    {
        scanf("%d", &arr[i]);
    }
    for( i = 1; i < n; i++ )
    {
        temp = arr[i];
         
        for( j = i - 1; j >= 0; j-- ) 
        {
                 if( arr[j] > temp )
                 {
                      arr[j+1] = arr[j];  for( m = 0; m < n; m++ )
                                              {
                                        printf("%d ", arr[m]);
                                          } printf("\n");

                 }
                 else
                 {   
                      
                      break;
                 }
             
             
        }
        arr[j+1] = temp;
             for( m  = 0; m < n; m++ )
                {
                 printf("%d ", arr[m]);
                 } printf("\n");

   }
  /* for( i = 0; i < n; i++ )
   {
       printf("%d ", arr[i]);
   }
   printf("\n");
  */ return 0;
} 
