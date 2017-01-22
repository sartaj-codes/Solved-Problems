import java.util.Iterator;
import java.util.*;

public class LargestCycle {
	LinkedList<Integer> adj[];
	int V, E;
	LargestCycle(int V, int E)
	{
		this.V = V;
		this.E = E;
		adj = new LinkedList[V];
		
		for(int i = 0 ; i < V; i++)
		    adj[i] = new LinkedList();
	}
	void addEdge(int a , int b)
	{
		adj[a].add(b);
	}
	int count = 0;
    int findSize()
    {   
    	int max = -1;
    	/*for(int i = 0; i < V; i++)
    	{ */  boolean visited[] = new boolean[V];
    	    count = 0;
    	    findSize(0,0,visited,-1);
    		//System.out.print(count+" ");
    	    if(count > max)
    			max = count;
    //	}
    	return max;
    }
    void findSize(int src, int dis, boolean visited[],int p)
    {
        visited[src] = true;
        p++;
       // System.out.print("p:"+p+" "+ "src:" + src+ "\n");
        if(src==dis && p > 1)
        {  //System.out.print("p:"+p+" ");
          if(p > count) 	
              count = p;
          //System.out.print(count+" ");
        }
        else
        {
          Iterator <Integer>it = adj[src].iterator();
		  Integer i;
		  while(it.hasNext())
		  {
			  i = it.next();
			  //System.out.print("i:" + i);
			  if(i == dis)
				  findSize(i,dis,visited,p);
			  if(!visited[i])
				  findSize(i,dis,visited,p);
		  }
	    }
        visited[src] = false;
        p--;
      }
    
    
    
	public static void main(String arg[])
	{
		Scanner in = new Scanner(System.in);
		int V = in.nextInt();
		int E = in.nextInt();
		LargestCycle obj = new LargestCycle(V,E);
		while(E-- != 0)
		{
			int a = in.nextInt();
			int b = in.nextInt();
			obj.addEdge(a,b);
		}
		System.out.print(obj.findSize());
		
		
	}
}
