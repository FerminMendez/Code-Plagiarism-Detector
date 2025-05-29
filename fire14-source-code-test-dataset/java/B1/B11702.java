import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecycledNumbers {

	/**
	 * Input 4 1 9 10 40 100 500 1111 2222
	 * 
	 * Output
	 * 
	 * Case #1: 0 Case #2: 3 Case #3: 156 Case #4: 287
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// Reading the input file
		Scanner in = new Scanner(new File("C-small-attempt0.in"));
		// writting the input file
		FileOutputStream fos = new FileOutputStream("C-small-attempt0.out");
		PrintStream out = new PrintStream(fos);
		// Close the output stream
		int testCase = in.nextInt();
		for (int i = 0; i < testCase; i++) {
			// System.out.println("Case #" + (i + 1) + ":\t");
			out.print("Case #" + (i + 1) + ":\t");
			long A = in.nextInt();
			long B = in.nextInt();
			long small;
			long large;
			if (A < B) {
				small = A;
				large = B;
			} else {
				small = B;
				large = A;
			}
			long numberOfDistinctDigit = 0;
			/* Start The Problem */
			while (small <= large) {
				// count the digit
				String convert = String.valueOf(small);
				// System.out.println(convert);
				String src;
				String dest;
				String result;
				ArrayList<Long> firstRecord = new ArrayList<>();
				for (int q = 0; q <= convert.length() - 1; q++) {
					if ((convert.length() == q) || (convert.length() == 1)) {
						dest = "\t";
						src = convert.substring(0, q + 1);
						result = dest + src;
					} else {
						dest = convert.substring(q + 1);
						src = convert.substring(0, q + 1);
						result = dest + src;
					}
					result = result.trim();
					long resultlong = Integer.parseInt(result);
					if (result.length() == 1) {
						// System.out.println("Single Digit Number");
					} else {
						if ((resultlong <= large) && (resultlong > small)
								&& (result.length() == convert.length())
								&& (Integer.parseInt(convert) != resultlong)
								&& (!firstRecord.contains(resultlong))) {
							numberOfDistinctDigit++;
							firstRecord.add(resultlong);
							// System.out.println("Result   " + resultlong +
							// "     Result     " + numberOfDistinctDigit);
							if (i == 3) {
								System.out.println(resultlong);
							}
						}
					}
				}
				small++;
				// System.out.println("\n");
			}// while
			out.print(numberOfDistinctDigit);
			out.print("\n");
		}// for
		in.close();
		out.close();
		fos.close();
		// System.out.println("________________________END___________________");

	}

	public static String reverse(String s) {
		return new StringBuffer(s).reverse().toString();
	}
}
