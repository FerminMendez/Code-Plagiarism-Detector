// Google Code Jam 2011
// lid

package Real;
import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import org.apache.commons.lang.ArrayUtils;

@SuppressWarnings("unused")
class T3 implements Runnable {
    // params
//	static String filePrefix = "/jam/C-example";
	static String filePrefix = "/jam/C-small-attempt0";
	//static String filePrefix = "/jam/A-large";
	
	// I/O
	private InputReader in;
	//@SuppressWarnings("unused")
	private PrintWriter out;
	
    public static void main(String[] args) {
        new Thread(new T3()).start();	// init filestreams then start thread
    }
    
    // Init filestreams
    public T3() {
		try {
			System.setIn(new FileInputStream(filePrefix + ".in"));
			System.setOut(new PrintStream(new FileOutputStream(filePrefix + ".out")));
		} catch (FileNotFoundException e) {
			log("Tried to open " + filePrefix + ".in");
			throw new RuntimeException();
		}
		in = new InputReader(System.in);
		out = new PrintWriter(System.out);

    }
    
    // Start thread
    public void run() {
    	// Keep track of time for efficiency (Zaphod)
		long startTime = System.currentTimeMillis();
    	
    	logn("Starting.");
    	int num_cases = in.readInt();
    	logn("Num_cases: " + num_cases);
    	
    	ArrayList<Integer> list = new ArrayList<Integer>(50);
    	for (int case_num = 0; case_num < num_cases; case_num++) {
    		// brute force that bitch
    		int start = in.readInt();
    		int end = in.readInt();
    		int numOut = 0;
    		
    		for (Integer cur = start; cur <= end; cur++) {
    			String curS = cur.toString();
				for (int rotnum = 0; rotnum < curS.length(); rotnum++) {
//					String curSr = curS.substring(beginIndex)
					curS = curS.substring(curS.length()-1,curS.length()) + curS.substring(0,curS.length()-1);
					if (curS.charAt(0) == '0')
						continue;
					Integer rotInt = Integer.parseInt(curS);
					if (rotInt <= end && rotInt >= start && rotInt > cur)
					{
						list.add(rotInt);
						numOut++;
						logn("" + cur + "," + curS);
//						break;
					}
				}
				
    		}
    		fout("Case #" + (case_num + 1) + ": ");
    		fout("" + numOut);
    		fout ("\n");
    	}
    	
    	logn("Done.");
    	
		long stopTime = System.currentTimeMillis();
		logn("Time: " + (stopTime - startTime) / 1000.0);
    }
    
    private static void fout (String msg) {
    	System.out.print(msg);
    }
    
    private static void log (String msg) {
    	System.err.print(msg);
    }
    
    private static void logn (String msg) {
    	System.err.println(msg);
    }
    
    // readCharacter, readString, readInt, readLong, readLine, readDouble
	//@SuppressWarnings("unused")
	// from Egor Kulikov
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
	
	//@SuppressWarnings("unused")
	private static int getBit (int input, int pos) {
    	input >>= pos;
    	return input & 0x0001;
    }
}

