package p;



public class TrieInsertM {
	class TrieNode{
	  	   Integer value;
	  	  TrieNode []nodes = new TrieNode[26];
	    }
		  protected TrieNode root = new TrieNode();
		  
		  void insert(String s, int val)
		  {
		  	TrieNode p = root;
		  	int i;
		  	for( i = 0; i < s.length(); i++)
		  	{
		  		int index = s.charAt(i) - 'a';
		  	    if ( p.nodes[index] == null)
		                    p.nodes[index] = new TrieNode();
		  	     p = p.nodes[index];
		  	}
		  	p.value = val;
		  }

}
