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
	int A,B;

	void execute() throws IOException
	{
		totalCases = ni();
		for(testNum = 1; testNum <= totalCases; testNum++)
		{
			if(!input())
				break;
			solve();
		}
	}

	void solve() throws IOException
	{		
		int count = 0;
		for(int i = A;i<=B;i++)
		{
			HashSet<Integer> hs = new HashSet<Integer>();
			String s = String.valueOf(i);
			int k = s.length();
			for(int j = 0;j<k;j++)
			{
				String x = s.substring(j,k) + s.substring(0,j);
				int no = Integer.parseInt(x);
				if(no>i && no<=B)				
					hs.add(no);				
			}
			count+= hs.size();
		}		
		System.out.printf("Case #%d: %d\n",testNum,count);
		System.err.printf("Case #%d: %d\n",testNum,count);
	}

	boolean input() throws IOException
	{
		A = ni();
		B = ni();
		return true;
	}


}


