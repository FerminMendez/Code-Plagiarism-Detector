import java.io.*;
import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.fill;
import static java.util.Arrays.binarySearch;
import static java.util.Arrays.sort;

public class Main {
	public static void main(String[] args) throws IOException {
		long prevTime = System.currentTimeMillis();
		new Main().run();
		System.err.println("Total time: " + (System.currentTimeMillis() - prevTime) + " ms");
		System.err.println("Memory status: " + memoryStatus());
	}

//	String inputFile = "sample.txt";
	String inputFile = "input/C-small-attempt0.in";
//	String inputFile = "input/C-large.in";
	
	String outputFile = "output.txt";
	
	void run() throws IOException {
		in = new BufferedReader(new FileReader(inputFile));
		out = new PrintWriter(outputFile);
		solve();
		out.close();
	}
	
	final int MAXN = 2000000;
	String[] sNums = new String [MAXN + 1];
	
	void solve() throws IOException {
		for (int i = 0; i <= MAXN; i++)
			sNums[i] = Integer.toString(i);
		
		for (int testCase = 1, testCases = nextInt(); testCase <= testCases; testCase++) {
			solve(testCase);
		}
	}

	int leftBorder, rightBorder;
	
	void solve(int testCase) throws IOException {
		out.print("Case #" + testCase + ": ");

		leftBorder = nextInt();
		rightBorder = nextInt();
		
		long ans = 0L;
		
		for (int num = leftBorder; num <= rightBorder; num++) {
			ans += calc(num);
		}
		
		out.println(ans);
	}

	int curNum;
	int curLen;
	int[] digits;
	int[] perm = new int [10];
	int[] used = new int [10];
	int tick = 1;
	StupidSet validNums = new StupidSet();
	
	long calc(int num) {
		curNum = num;
		validNums.clear();
		String sNum = sNums[num];
		digits = new int [sNum.length()];
		for (int i = 0; i < sNum.length(); i++)
			digits[i] = sNum.charAt(i) - '0';
		curLen = sNum.length();
		
//		tick++;
//		rec(0);
		
		for (int i = 0; i < curLen; i++)
			shift(i);
		
		return validNums.size();
	}

	void shift(int offset) {
		if (digits[offset] == 0) return;
		for (int i = 0; i < curLen; i++)
			perm[i] = (offset + i) % curLen;
		updateAns();
	}


//	void rec(int n) {
//		if (n == curLen) {
//			updateAns();
//		} else {
//			for (int i = 0; i < curLen; i++) {
//				if (used[i] != tick && (n > 0 || digits[i] > 0)) {
//					used[i] = tick;
//					perm[n] = i;
//					rec(n + 1);
//					used[i] = tick - 1;
//				}
//			}
//		}
//	}

	void updateAns() {
		int num = getCurrentNum();
		if (curNum < num && num <= rightBorder)
			validNums.add(num);
	}

	int getCurrentNum() {
		int ret = 0;
		int pow = 1;
		for (int i = curLen - 1; i >= 0; i--) {
			ret += pow * digits[perm[i]];
			pow *= 10;
		}
		return ret;
	}
	
	class StupidSet {
		final int MAXN = 10000000;
		int[] used = new int [MAXN + 1];
		int tick = 1;
		int size = 0;
		
		void clear() {
			tick++;
			size = 0;
		}
		
		void add(int x) {
			if (used[x] != tick) {
				used[x] = tick;
				size++;
			}
		}
		
		int size() {
			return size;
		}
	}

	/*************************************************************** 
	 * Input 
	 **************************************************************/
	
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st = new StringTokenizer("");
	
	String nextToken() throws IOException {
		while (!st.hasMoreTokens())
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}
	
	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}
	
	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}
	
	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}
	
	int[] nextIntArray(int size) throws IOException {
		int[] ret = new int [size];
		for (int i = 0; i < size; i++)
			ret[i] = nextInt();
		return ret;
	}
	
	long[] nextLongArray(int size) throws IOException {
		long[] ret = new long [size];
		for (int i = 0; i < size; i++)
			ret[i] = nextLong();
		return ret;
	}
	
	double[] nextDoubleArray(int size) throws IOException {
		double[] ret = new double [size];
		for (int i = 0; i < size; i++)
			ret[i] = nextDouble();
		return ret;
	}
	
	String nextLine() throws IOException {
		st = new StringTokenizer("");
		return in.readLine();
	}
	
	boolean EOF() throws IOException {
		while (!st.hasMoreTokens()) {
			String s = in.readLine();
			if (s == null)
				return true;
			st = new StringTokenizer(s);
		}
		return false;
	}
	
	/*************************************************************** 
	 * Output 
	 **************************************************************/
	void printRepeat(String s, int count) {
		for (int i = 0; i < count; i++)
			out.print(s);
	}
	
	void printArray(int[] array) {
		if (array == null || array.length == 0)
			return;
		for (int i = 0; i < array.length; i++) {
			if (i > 0) out.print(' ');
			out.print(array[i]);
		}
		out.println();
	}
	
	void printArray(long[] array) {
		if (array == null || array.length == 0)
			return;
		for (int i = 0; i < array.length; i++) {
			if (i > 0) out.print(' ');
			out.print(array[i]);
		}
		out.println();
	}
	
	void printArray(double[] array) {
		if (array == null || array.length == 0)
			return;
		for (int i = 0; i < array.length; i++) {
			if (i > 0) out.print(' ');
			out.print(array[i]);
		}
		out.println();
	}
	
	void printArray(double[] array, String spec) {
		if (array == null || array.length == 0)
			return;
		for (int i = 0; i < array.length; i++) {
			if (i > 0) out.print(' ');
			out.printf(Locale.US, spec, array[i]);
		}
		out.println();
	}
	
	void printArray(Object[] array) {
		if (array == null || array.length == 0)
			return;
		boolean blank = false;
		for (Object x : array) {
			if (blank) out.print(' '); else blank = true;
			out.print(x);
		}
		out.println();
	}
	
	@SuppressWarnings("rawtypes")
	void printCollection(Collection collection) {
		if (collection == null || collection.isEmpty())
			return;
		boolean blank = false;
		for (Object x : collection) {
			if (blank) out.print(' '); else blank = true;
			out.print(x);
		}
		out.println();
	}
	
	/*************************************************************** 
	 * Utility
	 **************************************************************/
	static String memoryStatus() {
		return (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() >> 20) + "/" + (Runtime.getRuntime().totalMemory() >> 20) + " MB";
	}
	
	static void checkMemory() {
		System.err.println(memoryStatus());
	}
	
	static long prevTimeStamp = Long.MIN_VALUE;
	
	static void updateTimer() {
		prevTimeStamp = System.currentTimeMillis();
	}
	
	static long elapsedTime() {
		return (System.currentTimeMillis() - prevTimeStamp);
	}
	
	static void checkTimer() {
		System.err.println(elapsedTime() + " ms");
	}
}
