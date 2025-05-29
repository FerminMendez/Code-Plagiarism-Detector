import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Map.Entry;


public class Recycled {

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer tok;

	static int nextInt() throws IOException {
		return parseInt(next());
	}

	static long nextLong() throws IOException {
		return parseLong(next());
	}

	static double nextDouble() throws IOException {
		return parseDouble(next());
	}

	static String next() throws IOException {
		while (tok == null || !tok.hasMoreTokens()) {
			tok = new StringTokenizer(in.readLine());
		}
		return tok.nextToken();
	}
	
	static String nextLine() throws IOException {
		return in.readLine();
	}
	
	static char at(String s, int i) {
		return s.charAt(i);
	}

	public static void main(String[] args) {
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream("C-small-attempt0.in")));
			out = new PrintWriter(new OutputStreamWriter(new FileOutputStream("C-out")));
//			in = new BufferedReader(new InputStreamReader(System.in));
//			out = new PrintWriter(new OutputStreamWriter(System.out));
			int t = nextInt();
			for (int i = 0; i < t; i ++) {
				solve(i+1, nextInt(), nextInt());
			}
			in.close();
			out.close();
		} catch (Throwable e) {
			e.printStackTrace();
			exit(1);
		}
	}

	
	private static void solve(int id, int a, int b) throws IOException {
		HashMap<String, DJ> map = new HashMap<String, DJ>();
		for (int i = a; i <= b; i ++) {
			String key = "" + i;
			map.put(key, new DJ());
		}
		for (int i = a; i <= b; i ++) {
			String s = "" + i;
			String t = move(s);
			while (true) {
				if (t.charAt(0)!='0') {
					DJ dj1 = map.get(s);
					DJ dj2 = map.get(t);
					if (dj2 != null && dj1 != null)
						merge(dj1, dj2);
				}
				t = move(t);
				if (s.equals(t)) break;
			}
		}
		int res = 0;
		for (Entry<String, DJ> e: map.entrySet()) {
			DJ dj = e.getValue();
			if (dj.count > 1) {
				res += dj.count * (dj.count-1) / 2;
			}
		}
		out.println("Case #"+id+": " + res);
	}
	
	static String move(String s) {
		if (s.length() == 1) return s;
		char c = s.charAt(s.length()-1);
		return "" + c + s.substring(0, s.length()-1);
	}
	
	static DJ merge(DJ d1, DJ d2) {
		DJ p1 = d1.getP();
		DJ p2 = d2.getP();
		if (p1 != p2) {
			if (p1.rank == p2.rank) {
				p2.parent = p1;
				p1.rank ++;
				p1.count += p2.count;
				return p1;
			} else if (p1.rank > p2.rank) {
				p2.parent = p1;
				p1.count += p2.count;
				return p1;
			} else {
				p1.parent = p2;
				p2.count += p1.count;
				return p2;
			}
		} else {
			return p1;
		}
	}
	
	static class DJ {
		DJ parent = null;
		int rank = 0;
		int count = 1;
		
		DJ getP() {
			if (parent == null) {
				return this;
			}
			DJ p = parent.getP();
			this.parent = p;
			return p;
		}
	}
}

