import java.io.*;
import java.util.*;
public class Dancing {
	static void solve() throws IOException {
		int T = nextInt();
		for(int c = 1; c <= T; c++) {
			int N = nextInt();
			int S = nextInt();
			int P = nextInt();
			int[] sc = new int[N];
			for(int i = 0; i < sc.length; i++) 
				sc[i] = nextInt();
			Arrays.sort(sc);
			int res = 0;
			for(int i = sc.length - 1, used = S; i >= 0; i--) {
				if(3*P - 2 <= sc[i])
					res++;
				else {
					if(used > 0 && sc[i] >= 2 && (3*P - 4 == sc[i] || 3*P - 3 == sc[i])) {
						res++;
						used--;
					}
				}
			}
			out.println("Case #" + c + ": " + res);
		}
	}
	public static void main(String[] args) {
		try {
			br = new BufferedReader(new FileReader("input.txt"));
			out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
			solve();
			out.close();
		} catch (Throwable e) {
			e.printStackTrace();
			System.exit(239);
		}
	}
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter out;
	static String nextToken() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String line = br.readLine();
			if (line == null) {
				return null;
			}
			st = new StringTokenizer(line);
		}
		return st.nextToken();
	}
	static int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}	
	static long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}
	static double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}
}
