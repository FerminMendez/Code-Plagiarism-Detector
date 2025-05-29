import java.io.*;
import java.util.*;
import java.math.*;

public class Main
{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer tokenizer=null;
	
	public static void main(String[] args) throws IOException
	{
		new Main().execute();
	}
	
	void debug(Object...os)
	{
		System.out.println(Arrays.deepToString(os));
	}
	
	int ni() throws IOException
	{
		return Integer.parseInt(ns());
	}
	
	long nl() throws IOException 
	{
		return Long.parseLong(ns());
	}
	
	double nd() throws IOException 
	{
		return Double.parseDouble(ns());
	}
		
	String ns() throws IOException 
	{
		while (tokenizer == null || !tokenizer.hasMoreTokens()) 
			tokenizer = new StringTokenizer(br.readLine());
		return tokenizer.nextToken();
	}
	
	String nline() throws IOException
	{
		tokenizer=null;
		return br.readLine();
	}
		
	
	//Main Code starts Here
	int totalCases, testNum;	
	
	void execute() throws IOException
	{
		totalCases = ni();
		for(testNum = 1; testNum <= totalCases; testNum++)
		{
			input();
			System.out.print("Case #"+testNum+": ");
			solve();
		}
	}

	void solve()
	{
		long count = 0;
		for(int i =a;i<=b;i++)
			for(int j =a;j<=b;j++)
			{
				if(i<=j)
					continue;
				String x = Integer.toString(i);
				String y = Integer.toString(j);
				
				if(x.length()==y.length())
				{
					x = x+x;
					if(x.contains(y))
						count++;
				}
			}
		
		System.out.println(count);
	}
	
	void printarr(int [] a,int b)
	{
		for(int i = 0;i<=b;i++)
		{
			if(i==0)
				System.out.print(a[i]);
			else
				System.out.print(" "+a[i]);
		}
		System.out.println();
	}
	int a,b;
	boolean input() throws IOException
	{
		a=ni();
		b=ni();
		return true;
	}
}