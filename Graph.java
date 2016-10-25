package p;
import java.util.*;
public class Graph {
	/* here it is a node type of linked list that to be added*/
	class Node
	{
		int data; Node next = null;
		Node(int n)
		{
			data = n;
		}
	}
	/* Bag class consists of first and last node of 
	 * every path from every vertex exist  , here degree is how many nodes are added 
	 */
	class Bag 
	{
		Node first, last;
		int degree;
		/* this method just adding new node at last on particular vertex*/
		public void enqueue(int N)
		{
			Node curr = last;
			last = new Node(N);
			if(degree == 0) first = last;
			else  curr.next = last;  
			degree++;     
		}
		/* this class mainly for sending the the data of bag class 
		 * wihout giving access to their first ,last etc things
		 */
		class customIterator implements Iterator<Integer>
		{
			
			Node t = first;
			@Override
			public boolean hasNext()
			{
				return t != null;
			}
			@Override
			public Integer next()
			{
				Node t2 = t;
				t = t.next;
				return t2.data;
			}
			@Override
			public void remove(){ }
			public boolean end(){
				if(t == null) return true;
				else return false;
			}
		}
		public Iterator getIterator()
		{
			return new customIterator();
		}
   }
	
		int V ; int E;
	    Bag[] adj ;	
	    Graph(int v)
	    {
	    	this.V = v;
	    	adj = new Bag[V];
	    	for(int i = 0; i < v; i++)
	    	      adj[i] = new Bag();		
	    }
	    void addEdge(int v, int e)
	    {
	    	adj[v].enqueue(e);
	    	//adj[e].enqueue(v);
	    	if(v != e) E += 1;
	    	E += 1;
	    }
	    /* DFS class has a method to travese graph and check path is exist 
	     * or
	     *  not
	     */
	    public class DFS{
	    	private boolean visited[] = new boolean[V];
	    	// recursive approach
	    	public void dfsTraverse(int src)
	    	{
	    		visited[src] = true;
	    		System.out.print(src +" ");
	    		Iterator i = adj[src].getIterator();
	    		while(i.hasNext())
	    		{
	    			int n_src = (int)i.next();
	    			if(visited[n_src]!= true)dfsTraverse(n_src);
	    			
	    		} 
	    	}
	    	//  Itervative approach
	    	/*public void dfs_n(int src)
	    	{
	    		for( i = 0 )
	    	}
	    	public void dfsTraverseIter(int src)
	    	{  
	    		Iterator i = adj[src].getIterator();
	    		Stack <Integer> s = new Stack<Integer>();
	    		
	    		while(!s.empty() || !visited[src])
	    		{		
 	    		        while( i.hasNext() || !visited[src])
 	    		         {     
 	       			           if(visited[src]){  src = (int)i.next(); }
 	       			           else{  System.out.print(src +" ");
 	       			           visited[src] = true; 
 	       				       s.push(src);  i = adj[src].getIterator(); }
                   	      }  
 	    		          
 	    		          while( !s.empty())
 	    		          {   boolean flag = false;
 	    		        	  src = s.pop(); i = adj[src].getIterator();
 	    		        	  while(i.hasNext() || !visited[src])
 	    		        	  { 
 	    		        		  if(visited[src]) src = (int)i.next();
 	    		        		  else { flag = true; break;}
 	    		        	  }
 	    		        	  if(flag) break;
 	    		           }
 	    		   }
	    	}*/
	    	
	    }
	    public class BFS{
	    	private boolean visited[] = new boolean[V];
	    	
	    	public void bfsTraverse(int src)
	    	{
	    		LinkedList<Integer> q = new LinkedList<Integer> ();
	    		visited[src] = true;
	    		q.add(src); Iterator i ;
	    		while(q.size()!= 0)
	    		{
	    			src = q.poll(); System.out.print(src + " ");
	    			 i = adj[src].getIterator();
	    			 while(i.hasNext())
	    			 {   src = (int)i.next();
	    				 if(!visited[src])
	    				 {
	    					 visited[src] = true; q.add(src);
	    				 }
	    				 
	    			 }
	    		}
	    		
	    	}
	    	
	    	
	    	
	    }
		void print(int n)
		{
			Iterator t = adj[n].getIterator();
			while(t.hasNext())
			   System.out.print(t.next() +" ");
							
	    }
	
    
	public static void main(String[] args) {
       Graph obj2 = new Graph(4);
       obj2.addEdge(0,1);
       obj2.addEdge(0,2);
       obj2.addEdge(1,2);
       obj2.addEdge(2,0);
       obj2.addEdge(2,3);
       obj2.addEdge(3,3);
      
       //obj2.print(1);
       Graph.DFS D_obj = obj2.new DFS();
       Graph.BFS B_obj = obj2.new BFS();
       //D_obj.dfsTraverse(0);
       //obj.dfsTraverseIter(2);
       B_obj.bfsTraverse(2);       
	}
}


