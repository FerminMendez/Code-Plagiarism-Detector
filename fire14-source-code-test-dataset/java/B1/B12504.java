/**
 * 
 */
package pandit.codejam;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

/**
 * @author Manu Ram Pandit
 * 
 */
public class RecycledNumbers {
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		FileInputStream fStream = new FileInputStream(
				"input.txt");

		Scanner scanner = new Scanner(new BufferedInputStream(fStream));
		Writer out = new OutputStreamWriter(new FileOutputStream("output.txt"));

		int T = scanner.nextInt();
		int A, B;
		int counter = 0;
		for (int count = 1; count <= T; count++) {
			A = scanner.nextInt();
			counter = 0;
			B = scanner.nextInt();
			for (int i = A; i <= B; i++) {
				counter += noOfDistinctPairs(i, B);
			}
			// System.out.println("Case #" + count + ": " + counter);
			out.write("Case #" + count + ": " + counter + "\n");
		}
		fStream.close();
		out.close();
	}

	/**
	 * This method returns the
	 * 
	 * @param current
	 * @param B
	 * @return
	 */
	public static int noOfDistinctPairs(int current, int B) {
		int count = 0;
		String s = String.valueOf(current);
		int length = s.length();
		String temp;
		int tempNo;
		for (int i = 0; i < length - 1; i++) {
			temp = s.substring(i + 1, length).concat(s.substring(0, i + 1));
			tempNo = Integer.parseInt(temp);
			if (tempNo == current)
				break;
			if (tempNo > current && tempNo <= B) {
				++count;
			}
		}
		return count;
	}
}
