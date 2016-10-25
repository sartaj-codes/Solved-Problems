import java.util.Stack;

public class Inor_Iterative {
	private Node root = null;
	private class Node
	{
		int key;
		Node left; Node right;
		Node(int data)
		{
			this.key = data;
			this.left = null;
			this.right = null;
		}
	}
	void insert(int key) {
		root = insert1(root, key);
	}

	/* inserting in tree according to their value */
	private Node insert1(Node root, int key) {
		if (root == null)
			return new Node(key);
		if (root.key == key) {
			return root;
		}
		if (root.key > key)
			root.left = insert1(root.left, key);
		else
			root.right = insert1(root.right, key);
		return root;
	}
	void inOrder(Node root)
	{
		Node curr = root;
		Stack<Node> s = new Stack<Node>();
		/* Here push left sub-tree of root coz whole tree is
		  connected to left most nodes of tree*/
		s.push(root);
		while(curr != null)
		{   if(curr.left != null) s.push(curr.left);
			 curr = curr.left;
		}
		
		while(!(s.empty()))
		{   
			/*Here due to stack firstly pop() smallest node of tree and print*/
			curr = s.pop();
			System.out.print(curr.key + " ");
			curr = curr.right;
			/*Here push right sub tree of each left-sided nodes for traverse whole tree*/
			while(curr != null )
			{	
				if(curr != null) s.push(curr);
				 curr = curr.left;
		    }
	    }
	}
	void postOrder(Node root)
	{
		Node curr = root;
		Stack<Node> s = new Stack<Node>();
		while(!(s.empty()) || curr != null )
		{    while(curr != null)
		     {   s.push(curr); curr = curr.left;
			 }
		    Node n = s.peek();
		    if( n.right == null)
		    { 
		    	Node n1 = s.pop(); System.out.print(n1.key + " ");
		    	while(!(s.empty()) && n1 == s.peek().right)
		    	{
		    		n1 = s.pop(); System.out.print(n1.key + " ");
		    	}
		    }
		    else{
		    	   curr = n.right;
		       }
		}
	
	}
	public static void main(String[] args) {
		Inor_Iterative  obj = new Inor_Iterative();
		 obj.insert(3);
	     obj.insert(1);
	     obj.insert(2);
	     obj.insert(4);
	     obj.insert(5);
	     //obj.insert(7);
	     //obj.inOrder(obj.root);
	     obj.postOrder(obj.root);

	}

}
