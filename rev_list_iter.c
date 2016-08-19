#include<stdio.h>
#include<stdlib.h>
struct Node
{
    int data;
    struct Node * next;
};
struct Node * first = NULL;
void create_node (int data)
{
    struct Node * new_node = (struct Node *)malloc(sizeof(struct Node));
    new_node->data = data;
    new_node->next = NULL;

    if( first  == NULL )
    {
         first = new_node;
    }
    else
    {
          struct Node * ptr = first;
          while( ptr->next != NULL )
                 ptr  = ptr->next;

          ptr->next = new_node;   
    }
}
void reverse_list()
{
    struct Node * ptr ,*ptr1, *curr;
    ptr = first;
    curr = ptr->next; 
    ptr-> next = NULL;
    
    while( curr != NULL )
    {
         ptr1 = curr->next;
         curr->next = ptr;
         ptr = curr;
         curr = ptr1;
    }
    first = ptr;  
   
}
void display()
{
    struct Node * ptr = first;
    while(ptr != NULL)
    {
          printf("%d ", ptr->data);
          ptr = ptr->next;
    }       
     
  
}
int main()
{
   int  i ;
   for( i = 1; 6 > i; i++ )
          create_node(i);
   reverse_list(); 
   
   display();
   return 0;
}  

            
    
  
  
    

