import java.util.*;
import java.io.*;

public class recycle {
	private static Reader in;
	private static PrintWriter out;
	public static final String NAME = "C-small-attempt0";

	private static int pow, A, B;
	private static void main2() throws IOException {
		A = in.nextInt();
		B = in.nextInt();
		
		pow = 1; int tmp = A;
		while (tmp > 0) {
			pow *= 10;
			tmp /= 10;
		}
		pow /= 10;
		
		int count = 0;
		for (int i = A; i <= B; i++)
			count += can (i);
		
		out.println (count);
	}
	
	private static int can (int n) {
		int k = shift(n), res = 0;
		while (k != n) {
			if (k >= A && k <= B && k > n) res++;
			k = shift(k);
		}
		return res;
	}
	
	private static int shift(int n) {
		return (n % 10) * pow + n / 10;
	}

	public static void main(String[] args) throws IOException {
		in = new Reader(NAME + ".in");
		out = new PrintWriter(new BufferedWriter(new FileWriter(NAME + ".out")));

		int numCases = in.nextInt();
		for (int test = 1; test <= numCases; test++) {
			out.print("Case #" + test + ": ");
			main2();
		}

		out.close();
		System.exit(0);
	}

	/** Faster input **/
	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public Reader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[1024];
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			else
				return ret;
		}

		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			else
				return ret;
		}

		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9')
					ret += (c - '0') / (div *= 10);
			}
			if (neg)
				return -ret;
			else
				return ret;
		}

		public char nextChar() throws IOException {
			char ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			return (char) c;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}
}
