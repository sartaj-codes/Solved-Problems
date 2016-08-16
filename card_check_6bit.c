#include<stdio.h>
int suit_arrn(char c)
{
    if(c == 'C')
        return 0;
    if(c == 'D')
        return 1;
    if(c == 'H')
        return 2;
    if(c == 'S')
        return 3;
}
int value_arrn(char c)
{
    if(c == 'J')
        return 11;
    if(c == 'Q')
        return 12;
    if(c == 'K')
        return 13;

   return( (int)(c - '0') );
}


int main()
{
    char c_1, c_2, c_3, c_4;
    int n_1, n_2;
    scanf("%c", &c_1);
    scanf("%c", &c_2);
    scanf("%c", &c_3);
    scanf("%c", &c_4);
    n_1 = suit_arrn(c_1);
    n_1 = n_1 << 4;
    n_1 = n_1 + value_arrn(c_2);
    n_2 = suit_arrn(c_3);
    n_2 = n_2 << 4;
    n_2 = n_2 + value_arrn(c_4);
  
    if( !(n_1 ^ n_2) )
         printf("Equal_cards\n");
    else
        printf("Unequal_cards\n");
     
    return 0;
}
    
