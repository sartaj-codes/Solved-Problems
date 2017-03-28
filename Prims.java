package p;
import java.util.*;
public class Prims{
    int V, E;
    LinkedList<Integer> adj[];
    int weights[][];
    int path[];
    Prims(int a, int b)
    {
    	this.V = a;
    	this.E = b;
    	adj = new LinkedList[V];
    	path = new int [V];
    	weights = new int[V][V];
    	for(int i = 0; i < V; i++)
    	   adj[i] = new LinkedList(); 
    }
    void add(int a,int b, int val)
    {
    	if(a != b)
    	{		
    	  adj[a].add(b);
    	  adj[b].add(a);
    	  weights[a][b] = val;
    	  weights[b][a] = val;
    	}	
    }
    void findPath()
    {
       boolean visited[] = new boolean[V];
       int arr[] = new int[V];
       int index = 0;
       for(int i = 0; i < V; i++)
       {
    	   if(!visited[i])
    	     findPath(i,visited,arr, index);
       }
    }
    void findPath(int src , boolean []visited,int[] arr, int index)
    {   
    	 visited[src] = true;
    	 arr[index++]   = src;
    	 int min = 1000;
    	 int cols = 0;
    	 for(int i = 0; i < index; i++)
    	 {		 
    	   System.out.print("\n" +"src" +arr[i]+ " :-");
    	   Iterator <Integer> it = adj[arr[i]].listIterator();
    	   
    	   while(it.hasNext())
    	   {
    		   int j = (int)it.next();
    		   //System.out.print(visited[j]+" "+ j+" "+ weights[src][j]+" ");
    		   System.out.print(visited[j]+" "+arr[i]+","+ j+" "+ weights[arr[i]][j]+" ");
    		   if(!visited[j] && weights[arr[i]][j] < min)
    		   {
    			   cols = j;
    			   min = weights[arr[i]][j];
    			   System.out.print("Desired weight:" + min+ " ");
    		   }
    		   //System.out.print(visited[j]+" "+arr[i]+","+ j+" "+ weights[arr[i]][j]+" ");
    	   }
    	 } 
    	   System.out.println("choose:"+cols+ " ");
    	   if(!visited[cols])
    	      findPath(cols, visited,arr, index);
    	   //System.out.print(cols+ " ");
    	   
    	}
    	
    public static void main(String arg[])
	{
		Scanner in = new Scanner(System.in);
		Prims obj  = new Prims(4,5);
		int t = 5;
		while(t-- != 0)
		{
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			obj.add(a,b,c);
		}
		obj.findPath();
		
	}
	
}

/*Input 
0 1 4
0 7 8
1 2 8
1 7 11
2 3 7
2 5 4
2 8 2
3 4 9
3 5 14
4 5 10
5 6 2
6 7 1
7 8 7
8 6 6
*/



