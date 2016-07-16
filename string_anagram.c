# include <stdio.h>
# include <string.h>
# define NO_OF_CHARS 256
int anagram(char *str1, char *str2)
{
	
	int count1[NO_OF_CHARS] = {0};
	int count2[NO_OF_CHARS] = {0};
	int i;
	for (i = 0; str1[i] && str2[i]; i++)
	{
		count1[str1[i]]++;
		count2[str2[i]]++;
	}
       	if (str1[i] || str2[i])
	return 0;

	for (i = 0; i < NO_OF_CHARS; i++)
		if (count1[i] != count2[i])
			return 0;

	return 1;
}

void swap_c(char *str1, char *str2 )
{
    char str[100];
    strcpy(str,str1);
    strcpy(str1,str2);
    strcpy(str2,str);
}

 

int main()
{
   int  n, i = 0, j = 0; 
   scanf("%d", &n);
   char ch_r[n][100];
   for( i = 0; i < n; i++ )
   {
        scanf("%s",  ch_r[i]);
   }
   i = 0;
   j = i + 1;
   while( i < n-1 && j < n)
   {    
                 
        if( anagram(ch_r[i], ch_r[j]) )
       {
             if( i != (j - 1) )
             {
                  swap_c(ch_r[i + 1],ch_r[j]);
                  i++; j = i + 1; 
             }
             else
             {
                i++; j = i + 1;
             }
  
       }
       else
       {   
            j++;    
       }

    }
   
    for( i = 0; i < n; i++ )
    {   
        printf("%s ",  ch_r[i]);
        
    }
    printf("\n");
    return 0;
}
