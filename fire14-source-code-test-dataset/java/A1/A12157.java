import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * @author Mikeldi Latorre (mikeldi10@gmail.com)
 */
public class Googlers implements Runnable {
	private InputReader in;
	private PrintWriter out;

	public static void main(String[] args) {
		new Thread(new Googlers()).start();
	}

	public Googlers() {
		try {
			System.setIn(new FileInputStream("B-small-attempt1.in"));
			System.setOut(new PrintStream(new FileOutputStream("B-small-attempt1.out")));
//			System.setIn(new FileInputStream("inputGooglers.txt"));
//			System.setOut(new PrintStream(new FileOutputStream("outputGooglers.txt")));
		} catch (FileNotFoundException e) {
			throw new RuntimeException();
		}
		in = new InputReader(System.in);
		out = new PrintWriter(System.out);
	}

	public void run() {
	 int numTests = in.readInt();
        for (int testNumber = 0; testNumber < numTests; testNumber++) {
        	out.println("Case #" + (testNumber + 1) + ": "+algorithm());
		}
		out.close();
	}
	
	private int algorithm(){
		int n = in.readInt();
		int s = in.readInt();
		int p = in.readInt();
		
		int nP = 0; //number of scores with at least one P or more
		int nS = 0; //number of surprising scores with at least one P
		
		for (int i = 0; i < n; i++) {
			int score = in.readInt();
			if(p<2){
				if(score>=p){
					nP++;
				}
			}else{
				int nPS = (3*p)-2; //min score for nP
				int nSS = (3*p)-4; //min score for nS
				if(score >= nPS){
					nP++;
				}else if(score >= nSS){
					nS++;
				}
			}
		}
		return nP + Math.min(nS, s);
	}
	

	private static class InputReader {
		private InputStream stream;
		private byte[] buf = new byte[1000];
		private int curChar, numChars;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		private int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public int readInt() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public long readLong() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public String readString() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuffer res = new StringBuffer();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		private boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		private String readLine0() {
			StringBuffer buf = new StringBuffer();
			int c = read();
			while (c != '\n' && c != -1) {
				buf.appendCodePoint(c);
				c = read();
			}
			return buf.toString();
		}

		public String readLine() {
			String s = readLine0();
			while (s.trim().length() == 0)
				s = readLine0();
			return s;
		}

		public String readLine(boolean ignoreEmptyLines) {
			if (ignoreEmptyLines)
				return readLine();
			else
				return readLine0();
		}

		public BigInteger readBigInteger() {
			try {
				return new BigInteger(readString());
			} catch (NumberFormatException e) {
				throw new InputMismatchException();
			}
		}

		public char readCharacter() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			return (char) c;
		}

		public double readDouble() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			double res = 0;
			while (!isSpaceChar(c) && c != '.') {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			if (c == '.') {
				c = read();
				double m = 1;
				while (!isSpaceChar(c)) {
					if (c < '0' || c > '9')
						throw new InputMismatchException();
					m /= 10;
					res += (c - '0') * m;
					c = read();
				}
			}
			return res * sgn;
		}
	}
}
