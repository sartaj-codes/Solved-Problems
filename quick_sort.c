#include<stdio.h>
#include <sys/time.h>
void swap_n(int *a,int *b)
{
    int temp = *a;
        *a = *b;
        *b = temp;
}

int pivot_ele(int arr[], int l, int h)
{   
     int i =  (l - 1);
     while( h-1 >= l ) 
     {
          if(arr[l] <= arr[h])
          {   i++;
              swap_n(&arr[l], &arr[i]);
               
          }
          l++;
     }
     swap_n(&arr[i+1],&arr[h]); 
     return (i+1);
}


void quick_sort(int arr[], int l, int h)
{
     if( l < h )
     {
          int pos = pivot_ele(arr,l ,h);
          quick_sort(arr,l, pos-1);
          quick_sort(arr,pos+1,h);
     }
}
/////////////////////////////using random///////////


int pivot_ele1(int arr[], int l, int h)
{   
     int pivot =rand() % ((h - l) + 1);
     int i =  (l - 1);
     while( h > l ) 
     {
          if(arr[l] < arr[l+pivot])
          {   i++;
              swap_n(&arr[l], &arr[i]);
               
          }
          l++;
     }
     swap_n(&arr[i+1],&arr[h]); 
     return (i+1);
}


void quick_sort1(int arr[], int l, int h)
{
     if( l < h )
     {
          int pos = pivot_ele1(arr,l ,h);
          quick_sort1(arr,l, pos-1);
          quick_sort1(arr,pos+1,h);
     }
}

int main()
{
    //int arr[] = {1, 2, 3, 9, 5, 6, 7};
    int arr[1000],i;
    for(i = 0; i <1000; i++ )
            arr[i] = i;   

    int size = ( sizeof(arr) / sizeof(arr[0]) );
    
    
   struct timeval t;
   gettimeofday(&t,NULL);
   double t1, t2, t3, t4;
   t1=t.tv_sec * 1000000 + t.tv_usec;
   quick_sort(arr,0,size-1);
   gettimeofday(&t,NULL);
   t2=t.tv_sec * 1000000 + t.tv_usec;  
  
   gettimeofday(&t,NULL);
   t3=t.tv_sec * 1000000 + t.tv_usec; 
   quick_sort1(arr,0,size-1);
   gettimeofday(&t,NULL);
   t4=t.tv_sec * 1000000 + t.tv_usec;
    
    printf("Without rand:%g\nwit rand:%g\n", (t2 - t1) , (t4 - t3));
/*
 int i;
    for(i = 0; i < size; i++ )
          printf("%d ", arr[i]);
  */  
return 0;
} 
