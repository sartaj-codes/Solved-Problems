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
public class Tree_ansester {
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
/* finding ancestor*/
void findAncestor(int A, int B)
{
	if( root.key == A || root.key == B )   //if input includes root  
		System.out.println("Ancestor:-1");
	else	
	{ Nod ans = findAncestor(root,A,B); System.out.println("Ancestor:" + ans.key); }
}
Nod findAncestor(Nod nod_t, int A,int B)
{
	Nod prev = nod_t;
	while(nod_t.left != null || nod_t.right != null)
	{
		if(A == nod_t.key || B == nod_t.key)
			return prev;
		if(A > nod_t.key && nod_t.key > B || B > nod_t.key && nod_t.key > A)
			return nod_t;
		if(A > nod_t.key && B > nod_t.key)
		{  prev = nod_t; nod_t = nod_t.right; }
		else
		{ prev = nod_t; nod_t = nod_t.left; }
	}
	return null; 
	
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree_ansester obj = new Tree_ansester();
		   obj.insert(50);
		   obj.insert(2);
		   obj.insert(9);
		   obj.insert(52);
		   obj.insert(15);
		   obj.insert(7);
		   obj.insert(59);
		   obj.insert(1);
		   obj.findAncestor(52,59);
		   

	}
}

