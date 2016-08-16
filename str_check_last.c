# include<stdio.h>
# include<string.h>
int main()
{
   char str1[] = "sartaj";
   char str2[] = "taj";
   int m = strlen(str2) - 1;
   int i = 0;
   if( str2 == NULL )
       printf("NOT_f\n");
   while( m )
   {
       if( str2[m] != str1[(strlen(str1)-1)-i] )
       {
           break;
       }
       i++; m--;
   }
   if( m )
     printf("Not_followed\n");
   else
     printf("Followed\n");
   return 0;
 }
