package p;
import java.util.*;
public class TrieStr_cal extends TrieInsertM {
   
	/* This fxn is for calaculate how many strings are exist that are power set of str*/
	
	int fxnCal(String str)
	{
		TrieNode t = root; int c = 0; int i,m;
		Stack <TrieNode> s = new Stack<TrieNode>();
		i = 0;
		while( i < str.length())            // here firstly point to last char of str coz this is common to all
		{ t = t.nodes[str.charAt(i)-'a']; i++;}
		s.push(t);
		
		  while(!s.empty())
		{   
			TrieNode t2 = s.pop();
			m = 0;
			for( i = 0; i < 26; i++)  /* m is act as flag while string is completed an then nothing to push in */
			{                          /* stack using  m examins weather a string completed than after that increment  c*/
				if(t2.nodes[i] != null) { m = 1; s.push(t2.nodes[i]); }
			}
			if( m== 0)
				c++;
		} 
		return c;
	}
public static void main(String[] args) {
		TrieStr_cal obj = new TrieStr_cal();
		obj.insert("sartaj", 10);
		obj.insert("sanjit", 20);
		obj.insert("sanjeev", 80);
		obj.insert("palvy", 350);
		obj.insert("kaur", 312);
		obj.insert("singh", 98);
		obj.insert("is", 33);
		obj.insert("king", 70);
		System.out.println(obj.fxnCal("s"));

	}

}
