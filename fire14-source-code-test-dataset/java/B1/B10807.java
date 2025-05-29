package codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RecycledPairs {
	
	private static String filename = "C-small-attempt0.in";

	public static boolean isRecycledPair(int n, int m) {
		String sn = Integer.toString(n);
		String sm = Integer.toString(m);
		int length = sn.length();
		String shiftedString = "";
		for (int i = 1; i <= length; i++) {
			shiftedString = sn.substring(i, length) + sn.substring(0, i);
			//System.out.println(shiftedString + " " + sn + " " + sm);
			if (shiftedString.equals(sm)) return true;
		}
		return false;
	}
	
	public static int recycledPairs(int A, int B) {
		int acc = 0;
		for (int n = A, m; n < B; n++) {
			m = n + 1;
			for (; m <= B; m++) {
				if (isRecycledPair(n, m)) acc++;
			}
		}
		return acc;
	}
	
	public static void main(String[] args) {;
	try {
		BufferedReader in = new BufferedReader(new FileReader(filename));
		BufferedWriter out = new BufferedWriter(new FileWriter(filename + ".out"));
		
		String currentString = in.readLine();
		int testCases = Integer.parseInt(currentString);
		
		for (int i = 1; i <= testCases; i++) {
			String[] input = in.readLine().split(" ");
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);
			int result = recycledPairs(A, B);
			out.write("Case #" + i + ": " + result + '\n');
		}	
		
		out.close();
		in.close();
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}
}
