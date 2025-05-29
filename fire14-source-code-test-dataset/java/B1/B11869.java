import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;


public class RecycledNumbers
{
	static BufferedReader br;
	static PrintWriter pw;
	
	static HashMap<String, Boolean> map;
	
	public static void main(String args[])throws IOException
	{
		initFiles();
		
		readFiles();
	}
	
	private static void readFiles()throws IOException
	{
		int n = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=n; i++)
		{
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(tokens.nextToken());
			int B = Integer.parseInt(tokens.nextToken());
			
			int count = findPairs(A, B);
			
			pw.println("Case #" + i + ": " + count);
		}
		
		pw.close();
		br.close();
	}
	
	private static int findPairs(int A, int B)
	{
		map = new HashMap<String, Boolean>();
		
		int numRecycleables = 0;
		for(int i = A; i <= B; i++)
		{
			numRecycleables += getNumRecycled(i, B);
		}
		
		return map.size();
	}
	
	private static int getNumRecycled(int n, int B)
	{
		String nStr = "" + n;
		
		int count = 0;
		for(int i = 1; i < nStr.length(); i++)
		{
			String mStr = nStr.substring(i) + nStr.substring(0, i);
			
			int m = Integer.parseInt(mStr);
			
			if(m > n && m <= B)
			{
				System.out.println(n + "--> " + m);
				
				map.put(nStr + mStr, true);
				count++;
			}
		}
		
		return count;
	}
	
	private static void initFiles()throws IOException
	{
		br = new BufferedReader(new FileReader("C-small-attempt0.in"));
		pw = new PrintWriter(new FileWriter("Recycle.out"));
	}
}
