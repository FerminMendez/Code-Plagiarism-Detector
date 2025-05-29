import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ProblemC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		File in = new File(
				"D:/Feng/Workspace/googlecodejam2012/problemC/in/C-small-attempt0.in");

		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(
					"D:/Feng/Workspace/googlecodejam2012/problemC/out/out.txt"));
			StringBuilder s;
			String line = "";
			int min, max = 0;
			int count = 1;
			Scanner scanner = new Scanner(in);
			// Ignore the first line showing total count
			scanner.nextLine();
			while (scanner.hasNextLine()) {
				s = new StringBuilder("Case #");
				s.append(count);
				s.append(": ");
				line = scanner.nextLine();
				String[] limits = line.split(" ");
				min = Integer.parseInt(limits[0]);
				max = Integer.parseInt(limits[1]);
				
				s.append(countRecycledPairs(min, max));

				System.out.println(s);
				out.write(s.toString());
				out.newLine();
				count++;
			}
			scanner.close();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int countRecycledPairs(int min, int max) {
		
		//List<String> recycledPairs = new ArrayList<String>(1000);
		Set<String> recycledPairs = new HashSet<String>();
		String s = "";
		int m;

		for (int n = min; n < max; n++) {
			// Need at least 2 digits to recycle
			// Cannot have trailing zeroes i.e. n mod 10 = 0
			// Cannot have digits that are all the same

			s = String.valueOf(n);
			for (int numDigitsToReplace = 1; numDigitsToReplace < s.length(); numDigitsToReplace++) {
				// System.out.print(numDigitsToReplace + ", ");
				m = recycle(n, numDigitsToReplace);
				if ((m > n) && (m <= max)) {
					recycledPairs.add(n + ":" + m);
					//count++;
				}

			}

		}
		//System.out.print(recycledPairs.size());
		//System.out.println(recycledPairs.toString());
		return recycledPairs.size();
	}

	public static int recycle(int n, int numDigits) {

		String s = String.valueOf(n);
		StringBuilder sb = new StringBuilder(s);
		String rearDigits = s.substring(s.length() - numDigits);
		sb.delete(sb.length() - numDigits, sb.length());
		sb.insert(0, rearDigits);
		if (sb.toString().startsWith("0")) {
			return 0;
		}
		return Integer.parseInt(sb.toString());

	}

	public static boolean hasSameDigits(int i) {
		String s = String.valueOf(i);
		char[] chars = s.toCharArray();
		char firstDigit = chars[0];
		for (char c : chars) {
			if (c != firstDigit)
				return false;
		}
		return true;
	}
}
