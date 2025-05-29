import java.io.*;
import java.util.*;
public class Recycled {
	static boolean[] vis;
	static int pairs;
	static int countDig(int a) {
		int res = 1;
		while(a >= 10) {
			a /= 10;
			res++;
		}
		return res;
	}
	static void solve() throws IOException {
		int T = nextInt();
		for(int c = 1; c <= T; c++) {
			int A = nextInt();
			int B = nextInt();
			vis = new boolean[B+1];
			int res = 0;
			for(int i = A; i <= B; i++) {
				int pairs = 1;
				if(!vis[i]) {
					vis[i] = true;
					int dig = countDig(i);
					for(int j = 1; j < dig; j++) {
						int suf = i % (int)Math.pow(10, j);
						int temp = i;
						temp /= Math.pow(10, j);
						if(countDig(suf) != j || suf == 0)
							continue;
						temp += suf * Math.pow(10, dig - j);
						if(temp <= B && temp >= A) {
							if(vis[temp])
								continue;
							vis[temp] = true;
							pairs++;
						}
					}
				}
				res += pairs * (pairs - 1) / 2;
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
