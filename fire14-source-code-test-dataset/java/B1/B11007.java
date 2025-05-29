
import java.io.*;
import java.util.*;

public class RecycledNumbers {
	
	static class InputReader {
		BufferedReader bin;
		StringTokenizer tokenizer;
		
		public InputReader(InputStream in) {
			bin = new BufferedReader(new InputStreamReader(in));
			tokenizer = null;
		}
		
		public InputReader(String fname) {
			try {
				bin = new BufferedReader(new FileReader(fname));
				tokenizer = null;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		
		public String next() {
			
			while( tokenizer == null || !tokenizer.hasMoreTokens())  {
				try {
					tokenizer = new StringTokenizer(bin.readLine());
				} catch(IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
		
		public String readLine() {
			try {
				return bin.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		
		public int nextInt() {
			return Integer.parseInt(next());
		}
		
		public long nextLong() {
			return Long.parseLong(next());
		}
		
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		
		public float nextFloat() {
			return Float.parseFloat(next());
		}
		
		public void close() {
			try {
				bin.close();
				tokenizer = null;
			} catch ( IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		//InputReader in = new InputReader(System.in);
		InputReader in = new InputReader("C-small-attempt0.in");
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("A-small-rcnum.out")));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int ctr = 0,start,end;
		int numTc = in.nextInt();
		
		for ( int i = 0; i < numTc; i++ ) {
			start = in.nextInt();
			end = in.nextInt();
			ctr = 0;
			for ( int j = start; j <= end; j++ )
				for ( int k = j + 1; k <= end; k++ ) {
					String s = Integer.toString(j);
					s = s + s;
					if(s.contains(Integer.toString(k)))
						ctr++;
				}
			out.println("Case #"+(i+1)+": "+ctr);
		}
		
		out.close();
		in.close();
	}
}

