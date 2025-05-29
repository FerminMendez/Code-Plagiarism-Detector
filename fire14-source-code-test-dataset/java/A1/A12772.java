import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Test {
	static BufferedReader reader;
	static StringTokenizer tokenizer;
	static PrintWriter writer;

	static int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	static long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	static double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	static String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	public static void main(String[] args) throws IOException {
		reader = new BufferedReader(new InputStreamReader(new FileInputStream("b.in")));
		tokenizer = null;
		writer = new PrintWriter("b.out");
		solve();
		reader.close();
		writer.close();
	}

	private static void test() throws IOException
	{
		int n = nextInt();
		int s = nextInt();
		int p = nextInt();
		
		int[] sum = new int[n];
		for(int i=0;i<n;i++)
		{
			sum[i]=nextInt();
		}
		
		int res=0;
		
		for(int i=0;i<n;i++)
		{
			if(sum[i]==0)
			{
				if(p==0)
					res++;
				continue;
			}
			
			if(sum[i]==1)
			{
				if(p<=1)
					res++;
				continue;
			}
			
			if((sum[i]+2)/3>=p)
			{
				res++;
				continue;
			}
			
			if(s>0)
			{
				if((sum[i]+4)/3>=p)
				{
					s--;
					res++;
				}
			}
		}
		writer.print(res);
	}
	
	private static void solve() throws IOException {		
		int t = nextInt();
		for(int i=1;i<=t;i++)
		{
			writer.print("Case #"+i+": ");
			test();
			writer.println();
		}
	}
}
