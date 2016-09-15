class Nod{
		int key;
       Nod left;
	   Nod right;
	   Nod(int n)
	   {
		   this.key  = n;
		   this.left = null;
		   this.right = null;
	   }
	}

public class Tree {
	
	private Nod root = null;
	void  insert(int key)
	{
		root = insert(root,key);
	}
	/* inserting in tree according to their value */
	private Nod insert(Nod root, int key)
	{
		if(root == null) return new Nod(key); 
		if(root.key > key) 
			root.left = insert(root.left, key);
		else
			root.right = insert(root.right, key);
		return root;
	}
	/* displaying content through right side and left side */
	void disp()
	{
		Nod left_p = root; Nod right_p = root;
		System.out.println("ROOT:" + root.key);
		System.out.println("LEFT SIDE");
		while(left_p != null)
		{
			System.out.println(left_p.key + " ");
			left_p = left_p.left;
		}
		System.out.println("RIGHT SIDE");
		while(right_p != null)
		{
			System.out.println(right_p.key + " ");
			right_p = right_p.right;
		}
	}
	/* fxn for fetching min*/
	Nod getMin(Nod root)
	{ 
	    Nod left_p = root;
	    while(left_p != null && left_p.left != null)
		     left_p = left_p.left;
	    return left_p;
	}   
	/* FXN for fetching maximum */
	Nod getMax(Nod root)
	{ 
	    Nod right_p = root;
	    while(right_p == null && right_p.right != null)
		     right_p = right_p.left;
	    return right_p;
	}
	/* FXN for delete min element in tree */
	void delMIN(Nod root_1)
	{ 
		//Nod result = root;
		Nod left_p = root_1;
		if(left_p.left == null)
			     root = left_p.right; 
		else{
		while( left_p.left.left != null)
		     left_p = left_p.left;
	    left_p.left = left_p.left.right;
		
	    }
		//return root;
	}
	/*Fxn for deleting a root */
	void delRoot(Nod node_t)
	{
		Nod t = node_t; // storing temp root 
		Nod new_root = getMin(node_t.right);
		delMIN(node_t.right);
		new_root.left = t.left; new_root.right = t.right;
		root = new_root;
		
	}
	/*Fxn for randamly delete */
	
	
	
	public static void main(String[] args) {
	   Tree obj = new Tree();
	   obj.insert(50);
	   obj.insert(2);
	   obj.insert(9);
	   obj.insert(52);
	   obj.insert(15);
	   obj.insert(7);
	   obj.insert(59);
	   //obj.disp(); /* if wanna display left and right side of tree then uncomment it*/ 
	   Nod d_node = obj.getMin(obj.root);
	   System.out.println("Minimum in TREE:" + d_node.key);
	   d_node = obj.getMax(obj.root);
	   System.out.println("Maximum in TREE:" +d_node.key);
	  obj.delMIN(obj.root);
	   d_node = obj.getMin(obj.root);
	  System.out.println("Minimum in TREE after deletion:" + d_node.key);
	   System.out.println("Root Before:" + obj.root.key);
	   obj.delRoot(obj.root);
	   System.out.println("Root After:" + obj.root.key);
	   

	}

}
