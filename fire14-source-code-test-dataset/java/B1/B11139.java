package Qual;
import java.io.*;
import java.math.*;
import java.util.*;


public class C {
	static void start() throws IOException {
		new C().run1();
	}
	
	private final String dir = "D:\\contest\\gcj\\2012\\" + getClass().getPackage().toString().split(" ")[1] + "\\" + getClass().getSimpleName();
//	private final String inputFileName = "sample.txt";
	private final String inputFileName = "C-small-attempt0.in";
	private final String outputFileName = "res.txt";

	int A, B;
	final Set<Integer> st = new HashSet<Integer>();
	int pair(int v) {
		if(st.contains(v)) {
			return 0;
		}
		
		int res = 0;
		String s = v + "";
		for(int i = 0; i < s.length(); i++) {
			s = s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
			if(s.charAt(0) != '0') {
				final int x = Integer.parseInt(s);
				if(A <= x && x <= B && !st.contains(x)) {
					st.add(x);
					res++;
				}
			}
		}
		return res * (res - 1) / 2;
	}
	
	final int MAX = 2000000;
	boolean[] visited = new boolean[MAX * 10];
	int dfs(int x, int d) {
		if(d == 0) {
//			System.err.println(x + " " + pair(x));
			return pair(x);
		}

		if(st.contains(x)) {
			return 0;
		}
		pair(x);
		
		int res = 0;
		for(int i = 0; i <= 9; i++) {
			if(x != 0 || i != 0) {
				res += dfs(x * 10 + i, d - 1);
			}
		}
		return res;
	}
	
	void run() throws IOException {
		int T = IOFast.nextInt();
		while(T-- != 0) {
			A = IOFast.nextInt();
			B = IOFast.nextInt();
			st.clear();
			int res = 0;
			for(int i = A; i <= B; i++) {
				if(!st.contains(i)) {
					res += pair(i);
				}
			}
			printCase();
			IOFast.out.println(res);
			IOFast.out.flush();
		}
	}

	void run1() throws IOException {
		IOFast.setReader(new FileReader(dir + "\\" + inputFileName));
		IOFast.setWriter(new FileWriter(dir + "\\" + outputFileName));
		run();
	}
	
	private static int CASE;
	private static void printCase() {
		IOFast.out.print("Case #" + ++CASE + ": ");
	}
	
	public static void main(String[] args) throws IOException {
		start();
		IOFast.out.flush();
		IOFast.in.close();
		IOFast.out.close();
	}

	static
	public class IOFast {
		private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		private static PrintWriter out = new PrintWriter(System.out);

		//	private static final int BUFFER_SIZE = 50 * 200000;
		private static final StringBuilder buf = new StringBuilder();
		private static boolean[] isDigit = new boolean[256];
		private static boolean[] isSpace = new boolean[256];

		static {
			for(int i = 0; i < 10; i++) {
				isDigit['0' + i] = true;
			}
			isDigit['-'] = true;
			isSpace[' '] = isSpace['\r'] = isSpace['\n'] = isSpace['\t'] = true;
		}

		static boolean endInput;
		
		public static void setReader(Reader r) { in = new BufferedReader(r); }
		public static void setWriter(Writer w) { out = new PrintWriter(w); }

		private static int nextInt() throws IOException {
			boolean plus = false;
			int ret = 0;
			while(true) {
				final int c = in.read();

				if(c == -1) {
					endInput = true;
					return Integer.MIN_VALUE;
				}

				if(isDigit[c]) {
					if(c != '-') {
						plus = true;
						ret = c - '0';
					}
					break;
				}
			}

			while(true) {
				final int c = in.read();
				if(c == -1 || !isDigit[c]) {
					break;
				}
				ret = ret * 10 + c - '0';
			}

			return plus ? ret : -ret;
		}

		private static long nextLong() throws IOException {
			boolean plus = false;
			long ret = 0;
			while(true) {
				final int c = in.read();

				if(c == -1) {
					endInput = true;
					return Integer.MIN_VALUE;
				}

				if(isDigit[c]) {
					if(c != '-') {
						plus = true;
						ret = c - '0';
					}
					break;
				}
			}

			while(true) {
				final int c = in.read();
				if(c == -1 || !isDigit[c]) {
					break;
				}
				ret = ret * 10 + c - '0';
			}

			return plus ? ret : -ret;
		}



		private static String next() throws IOException {
			buf.setLength(0);

			while(true) {
				final int c = in.read();

				if(c == -1) {
					endInput = true;
					return "-1";
				}

				if(!isSpace[c]) {
					buf.append((char)c);
					break;
				}
			}

			while(true) {
				final int c = in.read();

				if(c == -1 || isSpace[c]) {
					break;
				}
				buf.append((char)c);
			}

			return buf.toString();
		}

		private static double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

	}
}
