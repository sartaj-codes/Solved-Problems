#include<stdio.h>
#include<stdlib.h>
struct Node
{
    int data;
    struct Node * next;
};
struct Node * first1 = NULL;
struct Node * first2 = NULL;
void create_node (int s,int data)
{   struct Node * new_node = (struct Node *)malloc(sizeof(struct Node));
    new_node->data = data;
    new_node->next = NULL;
    struct Node *ptr;
    if( s )
     {   ptr = first2;
         if( ptr  == NULL )
          {
               first2 = new_node;
          }
          else
          {
          
             while( ptr->next != NULL )
                    ptr  = ptr->next;
             ptr->next = new_node;   
          }
     } 
    else
     {   
          ptr = first1; 
          if( ptr  == NULL )
          {
               first1 = new_node;
          }
          else
          {
               while( ptr->next != NULL )
                      ptr  = ptr->next;
               ptr->next = new_node;   
          }
    }
    
}
void reverse_list()
{
    struct Node * ptr ,*ptr1, *curr;
    ptr = first1;
    curr = ptr->next; 
    ptr-> next = NULL;
    
    while( curr != NULL )
    {
         ptr1 = curr->next;
         curr->next = ptr;
         ptr = curr;
         curr = ptr1;
    }
    first1 = ptr;  
   
}
void copy_list()
{   
    struct Node * ptr = first1;
    while(ptr != NULL)
    {
            create_node(1,ptr->data);
            ptr = ptr->next;
    }
}     
int check_palin()
{
    struct Node * ptr1 = first1;
    struct Node * ptr2 = first2;
    while(ptr1 != NULL)
    {
         if( ptr1->data != ptr2->data )
                  return 0;    
           
         ptr1 = ptr1->next;
         ptr2 = ptr2->next;
    }
    return 1;       
}
int main()
{
   
   create_node(0,1);
   create_node(0,2);
   create_node(0,1);
   
   copy_list();
   reverse_list();
   if( check_palin() )
          printf("Palindrome\n");
   else
          printf("Not_palindrome\n"); 
   
   
     return 0;
}  


