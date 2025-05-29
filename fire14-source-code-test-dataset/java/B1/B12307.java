import java.io.*;

import java.awt.geom.Point2D;
import java.text.*;
import java.math.*;
import java.util.*;

public class Main implements Runnable {

	final String problem = "C";
//	final String filename = problem + "-sample";
	 final String filename= problem+"-small-attempt0";
	// final String filename= problem+"-small-attempt1";
	// final String filename= problem+"-large";

	long ans;

	public void solve(int A, int B) throws Exception {
		ans = 0;
		boolean[] was = new boolean[B + 1];
		for (int num = A; num <= B; num++) {
			if (was[num])
				continue;
			int dig = 0, p = 1;
			while (p <= num) {
				dig++;
				p *= 10;
			}

			int count = 1;
			int x = num;
			p /= 10;
			for (int i = 1; i < dig; i++) {
				int high = x / p;
				int y = (x - high * p) * 10 + high;
				if (y==num) break;
				if (y >= p && y>=A && y<=B) {
					was[y] = true;
					count++;
				}
				x = y;
			}
			ans += count * (count - 1) / 2;
		}
	}

	public void solve_gcj() throws Exception {
		int tests = iread();
		for (int test = 1; test <= tests; test++) {
			out.write("Case #" + test + ": ");
			solve(iread(), iread());
			out.write(ans + "\n");
		}
	}

	public void run() {
		try {
			// in = new BufferedReader(new InputStreamReader(System.in));
			// out = new BufferedWriter(new OutputStreamWriter(System.out));
			in = new BufferedReader(new FileReader(filename + ".in"));
			out = new BufferedWriter(new FileWriter(filename + ".out"));
			solve_gcj();
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public int iread() throws Exception {
		return Integer.parseInt(readword());
	}

	public double dread() throws Exception {
		return Double.parseDouble(readword());
	}

	public long lread() throws Exception {
		return Long.parseLong(readword());
	}

	BufferedReader in;

	BufferedWriter out;

	public String readword() throws IOException {
		StringBuilder b = new StringBuilder();
		int c;
		c = in.read();
		while (c >= 0 && c <= ' ')
			c = in.read();
		if (c < 0)
			return "";
		while (c > ' ') {
			b.append((char) c);
			c = in.read();
		}
		return b.toString();
	}

	public static void main(String[] args) {
		try {
			Locale.setDefault(Locale.US);
		} catch (Exception e) {

		}
		new Thread(new Main()).start();
		// new Thread(null, new Main(), "1", 1<<25).start();
	}
}