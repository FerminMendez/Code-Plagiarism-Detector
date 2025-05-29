package gcj2012;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class RecycledNumbersClean {
	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner(
				new File(
						"/Users/olvitole/Dropbox/workspace/Googe Code/src/gcj2012/files/C-small-attempt1.in"));
		int t = Integer.parseInt(in.nextLine());
		OutputStream outStr = new FileOutputStream(
				"/Users/olvitole/Dropbox/workspace/Googe Code/src/gcj2012/files/C1s-output.txt");
		PrintStream printOut = new PrintStream(outStr);
		for (int zz = 1; zz <= t; zz++) {
			ArrayList<String> record = new ArrayList<String>();
			String input = in.nextLine().trim();
			String parts[] = input.split(" ");
			int A = Integer.parseInt(parts[0]);
			int B = Integer.parseInt(parts[1]);
			int count = 0;
			if (!(B <= 9)) {
				int iFliped = 0;
				String iFlipedString = "";
				String iString = "";

				for (int i = A; i <= B; i++) {
					iString = i + "";
					int first = 0;
					int second = 0;
					for (int j = 1; j < iString.length(); j++) {
						System.out.println();
						first = (int) (i / (Math.pow(10, j)));
						second = (int) (i % (Math.pow(10, j)));
						iFlipedString = "" + second + "" + first;

						iFliped = Integer.parseInt(iFlipedString);
						if (iFliped <= B && iFliped > i
								&& !iString.equals(iFlipedString)
								&& !record.contains(iString + iFlipedString)) {
							count++;
							record.add(iString + iFlipedString);
						} 
					}
				}
			}
			String output = count + "";
			printOut.append("Case #" + zz + ": " + output + "\n");
		}

		System.setOut(printOut);
	}

}
