package p;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph_predfnd {

	private int V, E;
	LinkedList<Integer> adj[];
	int edgeTo[];
	int edgeToSP[];
	int flag = 0;

	Graph_predfnd(int v) {
		this.V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++)
			adj[i] = new LinkedList();
		edgeTo = new int[v];
		edgeToSP = new int[v];
	}

	void addEdge(int v, int e) {
		adj[v].add(e);
		//adj[e].add(v);
		E++;
	}

	/* HERE IT IS ONLY A BFS BY USING A QUEUE */
	void bfs(int src) {
		boolean visited[] = new boolean[V];
		LinkedList<Integer> s = new LinkedList<Integer>();
		s.add(src);
		visited[src] = true;
		while (s.size() != 0) {
			src = s.poll();
			System.out.print(src + " ");
			Iterator<Integer> i = adj[src].listIterator();
			while (i.hasNext()) {
				src = i.next();
				if (!visited[src]) {
					visited[src] = true;
					s.add(src);
				}
			}
		}
	}

	/* MAINTAINING A ARRAY OF CONNECTING COMPONET GIVING A ID */
	void connectedComponent() {
		int id = 0;
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				dfs(i, id++, visited);
			}
		}
	}

	void dfs(int src, int id, boolean visited[]) {
		visited[src] = true;
		edgeTo[src] = id;
		Iterator<Integer> it = adj[src].listIterator();
		while (it.hasNext()) {
			src = it.next();
			if (!visited[src])
				dfs(src, id, visited);
		}

	}

	/* BFS FOR SHORTEST PATH */
	void shortestPath() {
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				bfsShortest(i, visited);
			}
		}
	}

	void bfsShortest(int src, boolean visited[]) {
		LinkedList<Integer> s = new LinkedList<Integer>();
		edgeToSP[src] = src;
		int p;
		s.add(src);
		visited[src] = true;
		while (s.size() != 0) {
			src = s.poll();
			p = src;
			Iterator<Integer> i = adj[src].listIterator();
			while (i.hasNext()) {
				/* Here we storing a parent of every node */
				src = i.next();
				if (!visited[src]) {
					visited[src] = true;
					s.add(src);
					edgeToSP[src] = p;
				}
			}
		}
	}

	/* FOR CYCLE DETECTION */
	/*void checkCycle(int src, int psrc, int c, boolean[] visited) {
		visited[src] = true;
		Iterator<Integer> it = adj[src].listIterator();
		while (it.hasNext()) {
			src = it.next();
			if (c > 2 && src == psrc || c == 1 && src == psrc)
				flag = 1;
			else {
				if (!visited[src])
					checkCycle(src, psrc, c + 1, visited);
			}
		}

	}
    */
	
	/*OPTIMISE SOLUTION FOR CYCLE DETECTION*/
	boolean checkCycle(int src, int parent, boolean []visited)
	{   
		visited[src] = true;
		Integer i;
		Iterator<Integer> it = adj[src].listIterator();
		while(it.hasNext())
		{   
			i = it.next();
			if(!visited[i])
			{
				if(checkCycle(i,src,visited))
					return true;
			}
			else
			{  
				if(i != parent)
					return true;
					 
			}
		}
		return false;
	}	
		
      void checkCycle() {
		int m = 0;
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++) {
		    if(!visited[i])	
		    {  if(checkCycle(i, -1, visited))
			   {  
				System.out.println("Yes, there is cycle exists");
				m = 1;
				break;
			   }
		    }
		}
		if (m == 0)
			System.out.println("No, don't have a cycle");
	}

	void print() {
		
		for (int i = 0; i < V; i++)
			System.out.print(edgeToSP[i] + " ");
	}

	public static void main(String[] args) {
		Graph_predfnd obj = new Graph_predfnd(5);
		obj.addEdge(0, 1);
		obj.addEdge(1, 2);
		obj.addEdge(2, 3);
		// obj.addEdge(1, 0);
		// obj.addEdge(3, 4);
		obj.addEdge(3, 0);

		// obj.bfs(2);
		// obj.connectedComponent();
		 obj.checkCycle();
		//obj.shortestPath();
		//obj.print();

	}

}
