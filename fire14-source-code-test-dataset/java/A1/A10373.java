package gcj2012;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class DancingWithTheGooglersClean {
	public static void main(String[] args) throws FileNotFoundException {

		 Scanner in = new Scanner(
		 new File(
		 "/Users/olvitole/Dropbox/workspace/Googe Code/src/gcj2012/files/B-small-attempt3.in"));
		int t = Integer.parseInt(in.nextLine());
		OutputStream outStr = new FileOutputStream(
				"/Users/olvitole/Dropbox/workspace/Googe Code/src/gcj2012/files/B3s-output.txt");
		PrintStream printOut = new PrintStream(outStr);
		for (int zz = 1; zz <= t; zz++) {
			String input = in.nextLine().trim();
			String parts[] = input.split(" ");
			int n = Integer.parseInt(parts[0]);
			int s = Integer.parseInt(parts[1]);
			int p = Integer.parseInt(parts[2]);
			ArrayList<Integer[]> triplets = new ArrayList<Integer[]>();
			int tempTp = 0;
			int tempScore = 0;
			int count = 0;
			for (int i = 0; i < n; i++) {
				tempTp = Integer.parseInt(parts[3 + i]);

				if (tempTp % 3 == 0) {
					tempScore = tempTp / 3;
					Integer[] tempTrip = { tempScore, tempScore, tempScore };
					triplets.add(tempTrip);
				} else if (tempTp % 3 == 1) {
					tempScore = tempTp / 3;
					Integer[] tempTrip = { tempScore, tempScore,
							(tempScore + 1) };
					triplets.add(tempTrip);
				} else if (tempTp % 3 == 2) {
					tempScore = tempTp / 3;
					Integer[] tempTrip = { tempScore, (tempScore + 1),
							(tempScore + 1) };
					triplets.add(tempTrip);
				}

			}

			for (Integer[] intPrint : triplets) {
				if (intPrint[2] >= p) {
					count++;
				} else {
					if ((intPrint[2] + 1 == p) && intPrint[1] > 0
							&& (intPrint[2] == intPrint[1])) {

						if (s > 0) {
							s--;
							count++;
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
