package student;

import java.io.*;
import java.util.*;

public class test {
	
	public static int getShift(String t, int pos)
	{
		int len = t.length()/2;
		return Integer.parseInt(t.substring(pos,pos+len));
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		
		Scanner fin = new Scanner(new File("a.txt"));
		int ncase = fin.nextInt();
		
		int a=0,b=0;
		
		for(int cc = 1; cc<=ncase;cc++)
		{
			a= fin.nextInt();
			b= fin.nextInt();
			HashSet<Pair> set = new HashSet<Pair>();
			for(int i=a;i<=b;i++)
			{
				String t = (""+i) + (""+i);
				int len = t.length()/2;
				for(int j=1;j<len;j++)
				{
					int p = getShift(t, j);
					if(p>=a&&p<=b&&(""+p).length()==len && p!=i)
						set.add(new Pair(i,p));
				}
			}
			System.out.println("Case #" + cc + ": " + set.size()/2);
		}
			
	}
}
class Pair
{
	public int a,b;
	public Pair(int x,int y)
	{
		a=x;b=y;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + b;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (a != other.a)
			return false;
		if (b != other.b)
			return false;
		return true;
	}
}
