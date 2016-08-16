# include<stdio.h>
int last_element_index(int arr[], int F,int L)
{
    while(L != 0)
    {
        int  M = (F + L) / 2;
        if( arr[M] > arr[M+1] )
            return M;
        if( arr[M-1] > arr[M] )
            return (M-1);
        if(arr[M] < arr[F])
            L = M;
        else
          F = (M+1);
    }
} 
int binary_search(int arr[], int index, int num, int n)
{     
       
       int F, L;
       if( num > arr[index] )
       {
           F = (index+1);
           L = n;
       }
       else
       {
           F = 0;
           L = index;
       }

      while ( L > F )
      {
          int mid = (F + L) / 2;
          if( arr[mid] == num )
              return 1;
          if( arr[mid] > num )
              L = mid;
          else
              F = (mid+1);
      } 
      return 0;
}

int main()
{
    int arr[]={11, 12, 13, 1, 2, 3, 4}, n = 7;
    int find_num = 120;
    int last_ele = last_element_index(arr, 0, n-1);
   // printf("%d \n", last_ele);
   if( binary_search(arr, last_ele, find_num, n-1) )
   {
       printf("Number_Exist\n");
   }
   else
   {
       printf("Not_exist\n");
   }
   
   return 0;
}
   
