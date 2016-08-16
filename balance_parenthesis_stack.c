#include <stdio.h>
#include<stdlib.h>
struct Node 
{
    char data;
    struct Node * next;
};
struct Node* first = NULL;
static int size = 0;
void push(char data)
{
     struct Node * new_node = (struct Node *) malloc( sizeof(struct Node ));
     new_node->data = data;
     new_node->next = first;
     first = new_node;
     size++;
}
void pop()
{   struct Node * old_new = first;
    first = first->next;
    size--;
    old_new->next = NULL;
    free(old_new);
}  
char top()
{
   return first->data;
}
int is_empty()
{
    if(first == NULL)
           return 1;
    else
           return 0;
}
int check_bal( char * str)
{    
     int i = 0; 
     //int t_1, t_2, t_3 = -'a';
     while( str[i] != '\0' )
     {
            if(str[i] == '[' || str[i] == '(' || str[i] == '{' )
                      { push( str[i] ); }
            
            else if( top() == '(' && str[i] == ')')
            {
                        if( (top() - str[i]) + 1) 
                                  return 0;   
             
                        pop();
            }
            else  
             {
                   if( (top() - str[i]) + 2)
                                return 0;
                   
                       pop();
             }    

            
             
            i++;
      }
       
      return 1;
}
                  

int main()
{
    char * str ="{()()}";
    
    if( check_bal(str) )
          printf("Balanced\n");
    else
          printf("Not_Balanced\n");
  
   return 0;
}









