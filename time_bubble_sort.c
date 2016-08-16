 #include <stdio.h>
#include <sys/time.h>
void sort(int arr[], int n)
{
    int i = 0, j = 0, temp = 0;
    for(i = 0; i < n; i++)
    {
        for(j = 0; j < n- 1; j++)
        {
             if( arr[j] > arr[j+1] )
               {
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
               }
         } 
     }
} 
int main()
{
    int arr1[16000], arr2[8000], i = 0;
    for(i = 16000; i > 0; i--)
    {
         arr1[16000 - i] = i;
    }
    for(i = 8000; i > 0; i--)
    {
         arr1[8000 - i] = i;
    }
    
   struct timeval t;
   gettimeofday(&t,NULL);
   double t1, t2, t3, t4;
   t1=t.tv_sec * 1000000 + t.tv_usec;
   /*using bubble sort */
   sort(arr1,8000);
   gettimeofday(&t,NULL);
   t2=t.tv_sec * 1000000 + t.tv_usec; 
   gettimeofday(&t,NULL);
   t3=t.tv_sec * 1000000 + t.tv_usec; 
   sort(arr2,16000);
   gettimeofday(&t,NULL);
   t4=t.tv_sec * 1000000 + t.tv_usec;
   
   printf("%g\n", (t4 - t3) / (t2 - t1));
   return 0;
} 



