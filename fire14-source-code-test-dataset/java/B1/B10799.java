import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.TreeSet;


public class Qual3 {
	private static BufferedReader r;
	private static PrintStream outFile;
	private static PrintStream out = new PrintStream(new OutputStream() {
		@Override
		public void write(int b) throws IOException {
			System.out.write(b);
			outFile.write(b);
		}
	});

	public static void main(String[] args) throws IOException {
		File f = new File("/home/blarson/input");
		r = new BufferedReader(new FileReader(f));
		outFile = new PrintStream(new FileOutputStream(new File("/home/blarson/output")));
		final int numCases = readInt();
		
		for(int i = 0; i < numCases; i++) {
			out.print("Case #" + (i+1) + ": ");

			solve();
			
			out.println();
		}
		
		out.close();
	}
	
	private static void solve() throws IOException {
		int[] nums = readIntArray(2);
		int a = nums[0];
		int b = nums[1];
		
		int numRecycled = 0;
		TreeSet<Integer> found = new TreeSet<Integer>();
		
		// Brute force!
		for(int c = a; c < b; c++) {
			int numChars = numChars(c);
			found.clear();
			for(int i = 1; i < numChars; i++) {
				int power = (int) Math.pow(10, i);
				int left = (int) (c / power);
				int right = c % power;
				int num = right * (int)Math.pow(10, numChars-i) + left;
				if(num > c && num <= b  && found.add(num)) {
					numRecycled++;
				}
			}
		}
		
		out.print(numRecycled);
	}

	private static int numChars(int c) {
		if(c < 10) {
			return 1;
		} else if (c < 100) {
			return 2;
		} else if (c < 1000) {
			return 3;
		} else if (c < 10000) {
			return 4;
		} else if (c < 100000) {
			return 5;
		} else if (c < 1000000) {
			return 6;
		} else {
			return 7;
		}
	}

	private static int[] readIntArray(int maxItems) throws IOException {
		int[] array = new int[maxItems];
		String line = r.readLine().trim();
		String[] data = line.split(" ");
		for(int i = 0; i < data.length && i < maxItems; i++) {
			array[i] = new Integer(data[i]);
		}
		return array;
	}

	private static int readInt() throws IOException {
		String line = r.readLine().trim();
		return new Integer(line);
	}

}