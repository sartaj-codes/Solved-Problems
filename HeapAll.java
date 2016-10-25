package p;

public class HeapAll {
   private  int heap_size = 0;
   private int []heap = new int [15];
   void swap(int a, int b)
   {
	   int temp = heap[a]; heap[a] = heap[b]; 
	   heap[b] = temp;
   }
  private  void swim(int i)
   {    /* here it is recursive approach*/
	   if(i > 1 && heap[i] > heap[i/2] )
	   {   
		   swap(i,i/2);
		   swim(i/2);
	   }
	  
   }
  private void sink(int i)
  {
	  int max = i;
	  if( (2*i) < heap_size   && heap[2*i] > heap[max]) max = 2*i;
	  if( (2*i + 1 ) < heap_size && heap[2*i + 1] > heap[max] ) max = 2*i +1;
	  if(max != i)
	  {
		swap(max,i); sink(max);  
	  }
  }
	void insert(int key)
	{
	   if(heap_size == 15) System.out.println("Overflow!! no space here for insertion");
	   else {
	       heap_size++;
	       heap[heap_size ] = key;
	       swim(heap_size);
		 
	     }
	}
	int getMax()
	{
		swap(heap_size,1);
		int key = heap[heap_size];
		heap_size--;
		
		sink(1);
		return key;
	}
	void sort()
	{   int i= heap_size;
		while(i != 0)
		{	getMax(); 
		    i--;
		}
	}
	void delete(int n)
	{
		int m = heap_size;
		int  i = 1;
		while(i <= m)
		{
		   if( heap[i] == n)
		   {
			   swap(i,m); heap_size--; sink(i); break;
		   }
		   i++;
		}
	}
	void printHeap()
	{
		int i;
		for( i = 1; i <= heap_size; i++ )
			System.out.print(heap[i]+ " ");
	}
 
	public static void main(String[] args) {
		
		HeapAll obj = new HeapAll();
		obj.insert(1);
		obj.insert(2);
		obj.insert(3);
		obj.insert(4);
		obj.insert(5);
		//System.out.println( obj.getMax());
		//System.out.println( obj.heap[5]);
		  //obj.sort();
		  obj.delete(4);
		  obj.printHeap();
	}

}
