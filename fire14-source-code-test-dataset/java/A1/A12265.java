import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.*;


public class Solution implements Runnable {

	public static void main(String[] args) {
		new Thread(new Solution()).start();
	}
	
	@Override
	public void run() {
		try {
			solve();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Laja in solution");
		}
	}
	
	private String next() throws IOException {
		while (tok == null || !tok.hasMoreTokens()) {
			tok = new StringTokenizer(cin.readLine());
		}
		
		return tok.nextToken();
	}
	
	private int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
	
	private long nextLong() throws IOException {
		return Long.parseLong(next());
	}
	
	BufferedReader cin;
	StringTokenizer tok;
	PrintWriter cout;
	
	public void solve() throws Exception {
		//cin = new BufferedReader(new FileReader("input.txt"));
		cin = new BufferedReader(new FileReader("B-small-attempt0.in "));
		cout = new PrintWriter("output.txt");
		//cout = new PrintWriter("");
		
		int testcases = nextInt();
		for (int testcase = 0; testcase < testcases; ++testcase) {
			int n = nextInt();
			int s = nextInt();
			int p = nextInt();
			
			int[] a = new int[n];
			for (int i = 0; i < n; ++i) {
				a[i] = nextInt();
			}
			
			int[][] d = new int[n + 1][s + 1];
			for (int i = 0; i < n + 1; ++i) {
				Arrays.fill(d[i], -10000);
			}
			
			d[0][s] = 0;
			
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j <= s; ++j) {
					int mod = a[i] % 3;
					int del = a[i] / 3;
					
					// non surprising
					if (mod == 0) {
						d[i + 1][j] = max(d[i + 1][j], d[i][j] + toInt(del >= p));
					} else {
						d[i + 1][j] = max(d[i + 1][j], d[i][j] + toInt(del + 1 >= p));
					}
					
					// surprising
					if (j > 0 && 2 <= a[i] && a[i] <= 28) {
						if (mod == 2) {
							d[i + 1][j - 1] = max(d[i + 1][j - 1], d[i][j] + toInt(del + 2 >= p));
						} else {
							d[i + 1][j - 1] = max(d[i + 1][j - 1], d[i][j] + toInt(del + 1 >= p));
						}
					}
				}
			}
			
			cout.println("Case #" + (testcase + 1) + ": " + d[n][0]);
		}
		
		cout.close();
	}

	private int toInt(boolean b) {
		return b ? 1 : 0;
	}
}
