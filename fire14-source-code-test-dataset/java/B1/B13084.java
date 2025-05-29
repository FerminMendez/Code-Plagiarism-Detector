import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	FastScanner in;
	PrintWriter out;

	Main() {
		in = new FastScanner(IO_Type.CONSOLE).getScanner();
		out = new FastWriter(IO_Type.CONSOLE).getWriter();

		// in = new FastScanner(IO_Type.TEST, "test.txt").getScanner();
		// out = new FastWriter(IO_Type.TEST, "result.txt").getWriter();

		// in = new FastScanner(IO_Type.FILE, "input.txt").getScanner();
		// out = new FastWriter(IO_Type.TEST, "output.txt").getWriter();
	}

	public static void main(String[] args) throws IOException {
		Main task = new Main();
		task.solve();
		task.close();
	}

	public void close() {
		in.close();
		out.close();
	}
	
	public void solve() throws IOException {
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			int A = in.nextInt();
			int B = in.nextInt();
			int[]tab = new int[B - A + 1];
			for (int j = 0; j < tab.length; j++) {
				tab[j] = j + A;
//				System.out.println(tab[j]);
			}
			HashSet<Pair> set = new HashSet<Pair>();
			for (int j = 0; j < tab.length; j++) {
				int K = tab[j];
				if (K != -1)
				for (int step = 10; ; step *= 10) {
					int tmp = K / step;
					if (tmp > 0) {
						int last = K % step;
						int q = K / step;
						StringBuilder sb = new StringBuilder();
						sb.append(last);
						sb.append(q);
						int ans = Integer.parseInt(sb.toString());
						String v = Integer.toString(ans);
						String x = Integer.toString(K);
						if (ans <= B && ans >= A) {
							if (tab[j] != tab[ans - A] && v.length() == x.length()) {
								Pair p = new Pair();
								p.setN(Math.min(tab[j], tab[ans - A]));
								p.setM(Math.max(tab[j], tab[ans - A]));
								set.add(p);
							}
						}
					}
					else break;
				}
				
			}
			out.println("Case #" + (i + 1) + ": " + set.size());			
		}
		
	}
	class Pair {
		int n;
		int m;
		public int getN() {
			return n;
		}
		public void setN(int n) {
			this.n = n;
		}
		public int getM() {
			return m;
		}
		public void setM(int m) {
			this.m = m;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + m;
			result = prime * result + n;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (m != other.m)
				return false;
			if (n != other.n)
				return false;
			return true;
		}
		private Main getOuterType() {
			return Main.this;
		}
	}
}

class Algebra {
	/****
	 * Number of co-prime numbers on [1, n]. Number a is Co-prime if gcd (a, n)
	 * == 1 O (sqrt(n))
	 ****/
	public static int phi(int n) {
		int result = n;
		for (int i = 2; i * i <= n; ++i) {
			if (n % i == 0) {
				while (n % i == 0) {
					n /= i;
				}
				result -= result / i;
			}
		}
		if (n > 1) {
			result -= result / n;
		}
		return result;
	}

	/****
	 * Raise number a to power of n. O (log n)
	 ****/
	public static int binpow(int a, int n) {
		int res = 1;
		while (n != 0) {
			if ((n & 1) == 1)
				res *= a;
			a *= a;
			n >>= 1;
		}
		return res;
	}

	/****
	 * Finding the greatest common divisor of two numbers. O (log min(a, b))
	 ****/
	public static int gcd(int a, int b) {
		return (b != 0) ? gcd(b, a % b) : a;
	}

	/****
	 * Finding the lowest common multiple of two numbers. O (log min(a, b))
	 ****/
	public static int lcm(int a, int b) {
		return a / gcd(a, b) * b;
	}

	/****
	 * Eratosthenes Sieve of numbers - [0..n]. True - simple, False - not
	 * simple. O (n log log n)
	 ****/
	public static boolean[] sieveOfEratosthenes(int n) {
		boolean[] prime = new boolean[n + 1];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		for (int i = 2; i <= n; ++i) {
			if (prime[i]) {
				if (i * 1L * i <= n) {
					for (int j = i * i; j <= n; j += i) {
						prime[j] = false;
					}
				}
			}
		}
		return prime;
	}
}

class IO_Type {

	public static String CONSOLE = "console";
	public static String FILE = "file";
	public static String TEST = "test";

}

class FastScanner {

	BufferedReader br;
	StringTokenizer st;

	FastScanner getScanner() {
		return this;
	}

	FastScanner(String type) {
		if (type.equals("console")) {
			FastScanner(System.in);
		}
	}

	FastScanner(String type, String inFileName) {
		if (type.equals("file")) {
			File f = new File(inFileName);
			try {
				FastScanner(new FileInputStream(f));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else if (type.equals("test")) {
			File f = new File(inFileName);
			try {
				FastScanner(new FileInputStream(f));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	void FastScanner(InputStream in) {
		br = new BufferedReader(new InputStreamReader(in));
	}

	String next() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				System.err.println(e);
				return "";
			}
		}
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	long nextLong() {
		return Long.parseLong(next());
	}

	double nextDouble() {
		return Double.parseDouble(next());
	}

	float nextFloat() {
		return Float.parseFloat(next());
	}

	BigInteger nextBigInt() {
		return new BigInteger(next());
	}

	void close() {
		try {
			br.close();
		} catch (IOException e) {
		}
	}
}

class FastWriter {

	PrintWriter pw;

	PrintWriter getWriter() {
		return pw;
	}

	FastWriter(String type) {
		FastWriter(type);
	}

	FastWriter(String type, String outFileName) {
		FastWriter(type, outFileName);
	}

	PrintWriter FastWriter(String type) {
		if (type.equals("console")) {
			pw = new PrintWriter(System.out);
		}
		return pw;
	}

	PrintWriter FastWriter(String type, String outFileName) {
		if (type.equals("console")) {
			pw = new PrintWriter(System.out);
		} else if (type.equals("test")) {
			try {
				pw = new PrintWriter(new File(outFileName));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else if (type.equals("file")) {
			try {
				pw = new PrintWriter(new File(outFileName));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return pw;
	}

}
