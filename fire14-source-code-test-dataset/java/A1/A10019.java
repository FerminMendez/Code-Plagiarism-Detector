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
	int m,n;
	
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
		int sur=0,nons=0;
		int a = 3*p-4;
		if(p==1)
		{
			for(int i = 0 ;i<t;i++)
				if(arr[i]!=0)
					nons++;
		}
		else
		{		
			for(int i=0;i<t;i++)
			{
				if(arr[i]<a)
					continue;
				if(arr[i]-a<2)
					sur++;
				else
					nons++;
			}
		}
		System.out.println(Math.min(s,sur)+nons);
				
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
	int t,s,p;
	int[] arr;
	boolean input() throws IOException
	{
		t = ni();
		s = ni();
		p = ni();
		arr = new int[t];
		for(int i=0;i<t;i++)
			arr[i] = ni();
		return true;
	}
}