package recycledNumbers;

import java.awt.font.NumericShaper;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Recycle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Limits> bLimits = null;
		BufferedReader br;

		// loading
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));

			String line;
			int lCounter = 0;
			int numLines, low, upp;
			Limits ls;
			String[] bounds;

			while ((line = br.readLine()) != null) {
				if (lCounter == 0) {
					numLines = Integer.parseInt(line);
					bLimits = new ArrayList<Limits>(numLines);
					lCounter++;
				} else {
					bounds = line.split(" ");
					low = Integer.parseInt(bounds[0]);
					upp = Integer.parseInt(bounds[1]);
					ls = new Limits(low, upp);
					bLimits.add(ls);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// go
		int count = 1;
		for (Limits ls : bLimits) {
			calcRecycledPairs(ls.getLow(), ls.getUpp(), count);
			count++;
		}

	}

	private static void calcRecycledPairs(int low, int upp, int count) {

		Set<RecycledPair> recPairs = new HashSet<RecycledPair>();

		for (int num = low; num <= upp; num++) {

			int numRotations = Integer.toString(num).length() - 1;

			int originalNum = num;
			// recNums.add(originalNum);
			String numS = Integer.toString(num);
			String rotNumS;
			int rotNum;

			while (numRotations > 0) {

				rotNumS = rotate(numS);

				// System.out.println("[" + numS + ";" + rotNumS + "]");

				rotNum = Integer.parseInt(rotNumS);

				if (!(originalNum == rotNum) && !numS.equals(rotNumS) && rotNum >= low && rotNum <= upp
						&& !recPairs.contains(new RecycledPair(originalNum, rotNum))) {
					// System.out.println("*** (" + originalNum + "," + rotNum +
					// ")");
					recPairs.add(new RecycledPair(originalNum, rotNum));
				}

				numS = rotNumS;
				numRotations--;
			}
		}

		System.out.println("Case #" + count + ": " + recPairs.size());

	}

	private static String rotate(String num) {

		String last = Character.toString(num.charAt(num.length() - 1));
		char[] prefix = new char[num.length() - 1];
		num.getChars(0, num.length() - 1, prefix, 0);

		String s = last + new String(prefix);
		return s;
	}

}
