#include<stdio.h>
int main(int arg1, char *arg2[])
{
      printf("%c\n%c\n", *++arg2[0], *(++arg2)[0]);
      return 0;
}
