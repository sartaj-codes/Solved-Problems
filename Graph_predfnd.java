package p;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph_predfnd {
      
	  private int V, E;   
	  LinkedList <Integer> adj[];
	  Graph_predfnd(int v)
	  {
		  this.V  = v;
		  adj = new LinkedList[v];
		  for(int i = 0; i < v; i++)
			  adj[i] = new LinkedList();
	  }
	  void addEdge(int v,int e)
	  {
		  adj[v].add(e);
		  //adj[e].add[j];
		  E++;
	  }
	  void bfs(int src)
	  {
		  boolean visited[] = new boolean[V];
		  LinkedList <Integer> s = new LinkedList<Integer>();
		  s.add(src); visited[src] = true;
		  while(s.size() != 0)
		  {
			  src = s.poll(); System.out.print(src+ " ");
			  Iterator<Integer> i = adj[src].listIterator();
			  while(i.hasNext())
			  {    src = i.next();
				  if(!visited[src])
				  {
					  visited[src] = true; s.add(src);
				  }
			  }
		  }
	  }
	
	
	public static void main(String[] args) {
		   Graph_predfnd obj = new Graph_predfnd(4);
		   obj.addEdge(0,1);
	       obj.addEdge(0,2);
	       obj.addEdge(1,2);
	       obj.addEdge(2,0);
	       obj.addEdge(2,3);
	       obj.addEdge(3,3);
	       
	       obj.bfs(2);
		

	}

}
