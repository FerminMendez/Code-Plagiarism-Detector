package y2012.Qualification;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class RecycledNumbers extends IOStream {

	public RecycledNumbers(String fileName) {
		super(fileName);
	}

	private int runThisTestCase() throws IOException {
		Set<RecycledSet> recycledPairs = new HashSet<RecycledSet>();
		String[] limits = bufferedReader.readLine().split(" ");
		long a = Long.valueOf(limits[0]);
		long b = Long.valueOf(limits[1]);
		long num = a;

		while (num <= b) {
			String numString = String.valueOf(num);
			int numDigits = numString.length();
			for (int idx = 0; idx < numDigits; idx++) {
				String recycledString = numString.substring(idx)
				+ numString.substring(0, idx);

				long recycled = Long.valueOf(recycledString);
				if (recycled >= a && recycled <= b && num != recycled) {
					RecycledSet rs = new RecycledSet(num, recycled);
					recycledPairs.add(rs);
				}
			}
			num++;
		}
		
		return recycledPairs.size();
	}

	public static void main(String[] args) throws Exception {

		RecycledNumbers obj = new RecycledNumbers("/net/10.0.0.60/Users/454083/Desktop/Moshin/CodeJam/RecycledNumbers");
		try {
			obj.getReader();
			obj.getWriter();
			int testcases = Integer.parseInt(bufferedReader.readLine().trim());
			for (int testcase = 1; testcase <= testcases; testcase++) {
				int value = obj.runThisTestCase();
				bufferedWriter.write("Case #" + testcase + ": " + value + "\n");
				System.out.println("Case #" + testcase + ": " + value);
			}
			obj.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

class RecycledSet {

	long num1;
	long num2;

	public RecycledSet(long num1, long num2) {
		if (num1 < num2) {
			this.num1 = num1;
			this.num2 = num2;
		} else {
			this.num1 = num2;
			this.num2 = num1;
		}
	}

	public int hashCode() {
		return (int) (num1 & num2);
	}

	public boolean equals(Object o) {
		if (o instanceof RecycledSet) {
			RecycledSet rs = (RecycledSet) o;
			if (this.num1 == rs.num1 && this.num2 == rs.num2) {
				return true;
			}
		}
		return false;

	}

}

class IOStream {

	static public BufferedReader bufferedReader = null;
	static public BufferedWriter bufferedWriter = null;

	String fileName = "";

	public IOStream(String fileName) {
		this.fileName = fileName;
	}

	protected void getReader() throws IOException {
		bufferedReader = new BufferedReader(new FileReader(new File(fileName
				+ ".in")));
	}

	protected void getWriter() throws IOException {
		bufferedWriter = new BufferedWriter(new FileWriter(new File(fileName
				+ ".out")));
	}

	protected void close() throws IOException {
		if (bufferedReader != null)
			bufferedReader.close();
		if (bufferedWriter != null) {
			bufferedWriter.flush();
			bufferedWriter.close();
		}
	}

	protected int[] splitString2Int(String[] words) {
		int[] ints = new int[words.length];
		int i = 0;
		for (String str : words) {
			ints[i] = Integer.parseInt(str);
			i++;
		}

		return ints;
	}
}
