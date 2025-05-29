
import java.io.*;
import java.util.*;

public class QualC{		
		
		private BufferedReader in;	
		private StringTokenizer st;
		private PrintWriter out;
		
		void solve() throws IOException{
			
			int kases = nextInt();
			int kase = 0;
			while(kases-->0){
				kase++;
				out.print("Case #"+kase+": ");
				int a = nextInt();
				int b = nextInt();
				int ans = 0;
				for (int n = a; n <= b; n++) {
					for (int m = n+1; m <= b; m++) {
						String x = n+"";
						String y = m+"";
						if(x.length() != y.length()) continue;
						String z = x+x;
						if(z.contains(y)) ans++;
					}
				}
				out.println(ans);
				
			}
		}
			

		QualC() throws IOException {
			in = new BufferedReader(new FileReader("input.txt"));	
			out = new PrintWriter(new FileWriter("output.txt"));
			eat("");
			solve();	
			out.close();
		}

		private void eat(String str) {
			st = new StringTokenizer(str);
		}

		String next() throws IOException {
			while (!st.hasMoreTokens()) {
				String line = in.readLine();
				if (line == null) {
					return null;
				}
				eat(line);
			}
			return st.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public static void main(String[] args) throws IOException {
			new QualC();
		}

		int gcd(int a,int b){
			if(b>a) return gcd(b,a);
			if(b==0) return a;
			return gcd(b,a%b);
		}

}
