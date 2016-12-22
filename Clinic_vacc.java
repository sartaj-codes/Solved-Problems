package p;

import java.io.*;
import java.util.*;
class city implements Comparable<city>
{
    long  popu;
    long  clinic;
    long  load;
    public city(long a )
    {
        this.popu = a;
        this.clinic = 1;
        this.load = this.popu/this.clinic;
    }
    public boolean equals(city temp)
    {
       return (this.load == temp.load);
    }
    public int compareTo(city temp)
    {
        if(this.equals(temp))
        return 0;
        else if(this.load > temp.load)
        return 1;
        else
        return -1;
    }
    
}
public class Clinic_vacc{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int total = sc.nextInt();
		PriorityQueue <city> obj = new PriorityQueue<city>(Collections.reverseOrder());
		for(int i = 0 ; i < N; i++)
		{   
		    long a = sc.nextLong();
		   city obj1 = new city(a);
		    obj.add(obj1);
		}
		/*while(!obj.isEmpty())
		{   
			city t = obj.poll();
			System.out.print(t.load);
		}*/
		for( int i = 0; i <(total - N); i++)
		{
			city t = obj.poll();
			t.clinic++;
			t.load = t.popu/ t.clinic;
			if(t.popu%t.clinic !=0)
				t.load++;
			obj.add(t);
		}
		city t = obj.poll();
		System.out.print(t.load);
		
		
	}
}