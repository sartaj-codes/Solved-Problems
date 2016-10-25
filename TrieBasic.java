package p;
/*TrieNode () Integer value, nodes */
public class TrieBasic extends TrieInsertM {
	
	/*Here it is search fxn char by char we are going down to level*/
	Integer search(String s)
	{
	   TrieNode t = root; int i;
	   for( i = 0; i < s.length(); i++)
	   {   if(t.nodes[s.charAt(i) - 'a'] == null) return i;
		   t = t.nodes[s.charAt(i) - 'a'];
	   }
	   return t.value;
	}
	/* Same as search and go to value and set it to null*/
	void softDelete(String s)
	{
		   TrieNode t = root; int i;
		   for( i = 0; i < s.length(); i++)
		   {   if(t.nodes[s.charAt(i) - 'a'] == null) return;
			   t = t.nodes[s.charAt(i) - 'a'];
		   }
		   t.value = null;
		   
	}
	/*Hard delete using recursion*/
	void hardDelete(String s)
	{
		//TrieNode t = root;
		root = hardDelete(root,s,0);
	}
	TrieNode hardDelete(TrieNode root, String s, int i)
	{//System.out.print( root.value +" ");
		//if(root == null) return null;
		if(i == s.length()) {
			root.value = null;
			int j;int m = 0;
			for( j = 0; j < 26; j++ ) 
			{
				if(root.nodes[j] != null){
					m = 1; break;
				}
			}
			if( m == 0)
			return null;
			else return root;
		}
		
		return  hardDelete(root.nodes[s.charAt(i)-'a'],s,i+1);
		
		//if(root != null)System.out.print("val: " + root.value +" ");
		//System.out.print(i);System.out.print(" ");
		//if(root.nodes[s.charAt(i)-'a'].value == null) root.nodes[s.charAt(i)-'a'] = null;
	    
		
	}

	public static void main(String[] args) {
		

		TrieBasic obj = new TrieBasic();
		obj.insert("sartaj", 10);
		obj.insert("sar", 20);
		obj.insert("dhiman", 80);
		obj.insert("palvy", 350);
		obj.insert("kaur", 312);
		obj.insert("singh", 98);
		obj.insert("is", 33);
		obj.insert("king", 70);
		//obj.softDelete("is");
		obj.hardDelete("sar");
		System.out.print(obj.search("sartaj"));
		
		
	}

}
