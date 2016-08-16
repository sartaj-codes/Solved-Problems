# include<stdio.h>

int main()
{
    FILE * fb;
    fb = fopen("sss.txt","w");
    FILE* fb2;
    fb2 = fopen("abc.txt","w");
    fseek(fb,-1,SEEK_END);
    int c = ftell(fb)+1;
    while(c>=0)
      {
      char d = fgetc(fb);
      fputc(fb2,d);
      fseek(fb2,-2,SEEK_CUR);
      c--;
      }
    return 0;
}
    

