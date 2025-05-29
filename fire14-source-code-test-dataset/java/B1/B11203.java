import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.HashSet;


public class Recycled {

	public static void main(String[] args) throws Exception {
		Recycled object = new Recycled();
		object.solve(object.getClass().getSimpleName().toLowerCase());
		}	
	
	public HashSet<Long> hash;
	public int powersOfTen[];

		private void solve(String filePrefix) throws Exception {
			
			StreamTokenizer st = new StreamTokenizer(new BufferedReader(new FileReader(filePrefix + ".in")));
			PrintWriter pw = new PrintWriter(new FileWriter(filePrefix + ".out"));
			
			st.nextToken();
			int testsCount = (int) st.nval;			
			
			for (int tc=0; tc<testsCount; tc++)
			{
				st.nextToken();
				int a = (int) st.nval;
				
				st.nextToken();
				int b = (int) st.nval;
				
				int digits = 0;
				int temp = a;
				
				while (temp > 0)
				{
					temp /= 10;
					digits++;
				}
				
				powersOfTen = new int[digits];
				powersOfTen[0] = 1;
				
				for (int i=1; i<powersOfTen.length; i++)
					powersOfTen[i] = powersOfTen[i-1]*10;
				
				hash = new HashSet<Long>();
				
				for (int n=a; n<b; n++)
				{
					generate(a, b, n, digits);					
				}								
														
				pw.write("Case #" + (tc+1) + ": " + hash.size() + "\n");
			}
			
			pw.flush();
			pw.close();			
		}

		private void generate(int a, int b, int n, int digits) {
			
			for (int take=1; take<digits; take++)
			{
				int first = n / powersOfTen[take];
				int last = n % powersOfTen[take];
				
				int m = last * powersOfTen[digits-take] + first;
				
				if (m <= n)
					continue;
				
				if (m < a || m > b)
					continue;
				
				long encoded = (n+0L) << 30L;
				encoded += m;
				
				if (encoded < 0)
					throw new RuntimeException();
				
				hash.add(encoded);
			}			
		}
}
