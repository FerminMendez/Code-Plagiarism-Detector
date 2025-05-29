import java.io.*;
import java.util.*;

public class SpeakingTheTongues implements Runnable {
	public static void main(String[] args) throws IOException {
		new Thread(new SpeakingTheTongues()).start();
	}

	public BufferedReader br;

	public StringTokenizer in;

	public PrintWriter out;

	public String nextToken() throws IOException {
		while (in == null || !in.hasMoreTokens()) {
			in = new StringTokenizer(br.readLine());
		}

		return in.nextToken();
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	String[] s = { "ejp mysljylc kd kxveddknmc re jsicpdrysi",
			"rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd",
			"de kr kd eoya kw aej tysr re ujdr lkgc jv" };
	String[] sa = { "our language is impossible to understand",
			"there are twenty six factorial possibilities",
			"so it is okay if you want to just give up" };

	char[] to = new char[300];

	public void precalc() {
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s[i].length(); j++) {
				to[s[i].charAt(j)] = sa[i].charAt(j);
			}
		}

		to['q'] = 'z';
		to['z'] = 'q';
	}

	public void solve() throws IOException {
		String s = br.readLine();

		for (int i = 0; i < s.length(); i++) {
			out.print(to[s.charAt(i)]);
		}

		out.println();
	}

	public void run() {
		try {
			br = new BufferedReader(new FileReader("A-small.in"));
			out = new PrintWriter("a.out");

			precalc();

			int t = nextInt();
			for (int i = 0; i < t; i++) {
				out.print("Case #" + (i + 1) + ": ");
				solve();
			}

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
