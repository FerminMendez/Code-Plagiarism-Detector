//saurabh

import java.io.*;
import java.util.*;

public class Recycle
{
	public static void main(String args[]) throws IOException
	{
		Recycle ob=new Recycle();
		int T,A,B;
		Scanner c= new Scanner(new File("Recycle.txt"));
		T=c.nextInt();
		int ans[]=new int[T];
		for(int i=0;i<T;i++)
		{	
			A=c.nextInt();
			B=c.nextInt();
			int nPairs=0;
			for(int j=A;j<B;j++)
			{
				nPairs+=ob.get_pairs2(j,B);
			}
			ans[i]=nPairs;
		}
				
		for(int i=0;i<T;i++)
			System.out.println("Case #"+(i+1)+": "+ans[i]);
	}
	
	int get_pairs2(int x, int B)
	{
		int base=x;
		String s=Integer.toString(B);
		int n=s.length();
		double mul=Math.pow(10,(n-1));
		LinkedList<Integer> L=new LinkedList<Integer>();
		for(int i=0;i<n;i++)
		{
			int y=x%10;
			x/=10;
			x+=y*mul;
			if(x>base && x<=B)
				if(!L.contains(x)) {
					L.add(x);
				}
		}
		return L.size();
	}
}
