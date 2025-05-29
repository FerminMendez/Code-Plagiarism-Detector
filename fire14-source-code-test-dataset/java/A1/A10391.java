package qualification2012;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class B {

	private final String f = "src\\qualification2012\\B-small-attempt0";
	private BufferedReader in;
	private PrintWriter out;
	private StringTokenizer token;
		

	
	private B() throws IOException {
		in = new BufferedReader(new FileReader(f+".in"));
		out = new PrintWriter(f + ".out");
		eat("");

		int t = nextInt();
		for (int i = 1; i <= t; i++) {
			write("Case #"+i+": ");
			solve();
		}
		
		in.close();
		out.close();
	}
	
	private void solve() throws IOException {	
		int n = nextInt();
		int s = nextInt();
		int p = nextInt();
		
		
		int scores = 0;
		
		int[] googlers = new int[n];
		for (int i = 0; i < n; i++) {
			googlers[i] = nextInt();
		}
		
		int possibles = 0;
		for (int i = 0; i < googlers.length; i++) {
			int g = googlers[i];
			
			if (g >= 3*p - 2 && g >= p) {
				scores++;
			} else if (g >= 3*p - 4 && g >= p) {
				possibles++;
			}
		}
		
		scores += ((s <= possibles)? s : possibles);
		write(scores + "\n");
	}

	private String nextLine() throws IOException {
		return in.readLine();
	}
	
	private String next() throws IOException {
		while (!token.hasMoreTokens()) {
			String line = in.readLine();
			if (line == null) {
				return null;
			}
			eat(line);
		}
		return token.nextToken();
	}
		
	private int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
	
	private long nextLong() throws IOException {
		return  Long.parseLong(next());
	}
	
	private void eat(String s) {
		token = new StringTokenizer(s);
	}

	private void write(String s) {
		System.out.print(s);
		out.print(s);
	}
	
	public static void main(String[] args) {
		try {
			new B();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

