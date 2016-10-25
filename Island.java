package p;

public class Island {
	static boolean valid(int arr[][] , int m, int n, boolean [][]visited)
	{
		if(m >= 0 && m < 4  && n >= 0 && n <= 4 && arr[m][n] == 1 && !visited[m][n])
			return true;
		else return false;
	}
	
	
	static void DFS(int arr[][], int row, int col, boolean visited[][], int c)
	{
		if(visited[row][col] == false)
		{
		 visited[row][col] = true; 
		 int rowN[] = {-1, 0, 1, -1, 1, -1, 0, 1};
	     int colN[] = {-1, -1, -1, 0, 0, 1, 1, 1};
	    for( int m = 0; m < 8; m++)
	    {  
	    	if( valid(arr, row+rowN[m], col+colN[m], visited) )
	    	{  DFS(arr, row+rowN[m], col+colN[m], visited, c ); }
	    
		}
		}
	    
	}
	 static int c = 1;   
	static void DFS(int arr[][], int row, int col, boolean visited[][])
	{   
		
		DFS(arr, row, col, visited, c);
	}
	
     static int calNumber(int [][]arr, int m, int n)
     {
    	 boolean [][]visited = new boolean[m][n]; 
    	 int count = 0;
    	 for(int i = 0; i < m ; i++ )
    	 {
    		 for(int j = 0; j < n; j++ )
    		 {
    			 if(arr[i][j] == 1 && !visited[i][j])
    			 {	
    				 count++; 
    				 DFS(arr, i, j, visited);
    			 
    			 }
    		 }
    	 }
    	 return count;
     }
	
	public static void main(String[] args) {
    int [][]arr={ {1, 1, 0, 1, 1},
                  {1, 0, 0, 0, 1},
                  {0, 0, 0, 0, 1},
                  {1, 0, 1, 1, 1},
                };
   
	  System.out.print("\n"+"Total Number of Islands : " +calNumber(arr,4,5));   
	
	}
	
}
