import java.io.*;
import java.util.*;

public class DancingGooglers {
	
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
		InputReader in = new InputReader("B-small-attempt1.in");
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("B-small-attempt1.out")));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		
		Solver solver = new Solver(in,out);
		solver.solve();
		
		out.close();
		in.close();
	}
	
	private static class Solver {
		InputReader in;
		PrintWriter out;
		HashMap<Integer,triplet> surprising;
		HashMap<Integer,triplet> notsurprising;
		List<Integer> surp,nonsurp,both,potnsurp;
		
		private class triplet {
			int a,b,c;
			
			triplet(int a, int b, int c) {
				this.a = a;
				this.b = b;
				this.c = c;
			}
			
			public boolean surpising() {
				if(Math.abs(a - b) ==2 || Math.abs(a - c) == 2 || Math.abs(b - c) == 2)
					return true;
				return false;
			}
			
			public boolean best(int p) {
				if( a >= p || b >= p || c >= p)
					return true;
				return false;
			}
			
		}
		
		public Solver(InputReader in, PrintWriter out) {
			this.in = in;
			this.out = out;
			surprising = null;
			notsurprising = null;
			surp = null;
			nonsurp = null;
			both = null;
			potnsurp = null;
		}
		
		public void preprocess() {
			if(surprising == null || notsurprising == null) {
				surprising = new HashMap<Integer,triplet>();
				notsurprising = new HashMap<Integer,triplet>();
				surp = new ArrayList<Integer>();
				nonsurp = new ArrayList<Integer>();
				both = new ArrayList<Integer>();
				potnsurp = new ArrayList<Integer>();
				generateTriplets();
			}
		}
		
		public void solve() {
			preprocess();
			int numTc = in.nextInt();
			int numGoog,numSurp,bestScore,soln = 0,score,numberOfSurp;
			triplet temp;
			
			for ( int i = 0; i < numTc; i++ ) {
				numGoog = in.nextInt();
				numSurp = in.nextInt();
				bestScore = in.nextInt();
				surp.clear();
				nonsurp.clear();
				both.clear();
				numberOfSurp = 0;
				for ( int j = 0; j < numGoog; j++ ) {
					score = in.nextInt();
					if(surprising.containsKey(score) && notsurprising.containsKey(score)) {
						temp = surprising.get(score);
						if(temp.best(bestScore)) {
							temp = notsurprising.get(score);
							if(temp.best(bestScore))
								both.add(j);
							else 
								surp.add(j);
						}
						else {
							temp = notsurprising.get(score);
							if(temp.best(bestScore))
								nonsurp.add(j);
							else
								numberOfSurp++;
						}
					}
					else {
						if(notsurprising.containsKey(score)) {
							temp = notsurprising.get(score);
							if(temp.best(bestScore))
								nonsurp.add(j);
						}
					}
				}
				if(numSurp <= numberOfSurp + surp.size() + both.size())
					soln = countMax(numSurp,numberOfSurp);
				else
					soln = 0;
				out.println("Case #"+(i+1)+": "+soln);
			}
		}
		
		public int countMax(int numSurp, int numberOfSurp) {
			int count = both.size() + nonsurp.size();
			
			if(numSurp < surp.size())
				return count + numSurp;
			
			return count + surp.size();
		}
		
		public void generateTriplets() {
			int sum = 0;
			for ( int i = 0; i < 11; i++ ) {
				for ( int j = 0; j < 11; j++ ) {
					if(Math.abs(j - i) > 2)
						continue;
					for ( int k = 0; k < 11; k++ ) {
						if(Math.abs(k-j) > 2 || Math.abs(k-i) > 2)
							continue;
						sum = i+j+k;
						triplet temp = new triplet(i,j,k);
						if(temp.surpising())
							surprising.put(sum, temp);
						else
							notsurprising.put(sum, temp);
					}
				}	
			}
		}
		
		public int bruteforce() {
			
			return 0;
		}
		
	}
}

