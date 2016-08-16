# include<stdio.h>
int binary_search(int arr[],int num,int n)
{   
    
    
     //int   mid = low + high;
          if(low < high)
          return 0;
         mid = (low + high)/2; 
         if( arr[mid] == num )
         {
         return 1;
         }
        if( num <arr[mid] )
         {
            binary_search(arr,0,mid-1);
         }
         else
         {
           binary_search(arr,mid+1,n);
         }
     }
     return 0;
}
    
int main()
{
    int arr[]={1,2,3,4,10};
    int num = 4, n = 4;
    int find = binary_search(arr,num,n);
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

  
