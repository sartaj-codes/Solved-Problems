# include<stdio.h>
int binary_search(int arr[],int num,int n)
{   
    int low = 0, high = n;
    
     int   mid = low + high;
        while( high >low )    
         {
         mid = (low + high)/2; 
         if( arr[mid] == num )
         {
         return 1;
         }
        if( num < arr[mid] )
         {
              high = mid;
         }
         else
         {
           low = (mid+1);
         }
     }
     return 0;
}
int main()
{
    int arr[]={1,2,3,4,10};
    int num = 9, n = 5;
    int find = binary_search(arr,num,n-1);
    if( find )
    {
         printf("Exist\n");
    }
    else
    {
        printf("Not_exist\n");
    }
    return 0;
}

  
