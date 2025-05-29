package google.codejam2012.awanish;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class RecycledNumbers {
	static long total = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner inputScan = new Scanner(System.in);
		int noOfCases = Integer.parseInt(inputScan.nextLine());
		long start;
		long end;
		for (int i = 1; i <= noOfCases; i++) {
			total = 0;

			String startend = inputScan.nextLine();
			StringTokenizer st = new StringTokenizer(startend, " ");
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			for (long j = start; j <= end; j++) {
				checkPair(j, start, end);
			}
			System.out.println("Case #" + i + ": " + total/2);

		}

	}

	private static void checkPair(long j, long start, long end) {

		ArrayList a = new ArrayList();
		String tocheck = String.valueOf(j);
		a.add(tocheck);
		for (int c = 0; c < tocheck.length(); c++) {
			tocheck = rotate(tocheck);
			if (!a.contains(tocheck) && !tocheck.substring(0, 1).equals("0")
					&& start <= Integer.parseInt(tocheck)
					&& Integer.parseInt(tocheck) <= end) {
				a.add(tocheck);
				total++;
			}
		}

	}

	private static String rotate(String tocheck) {
		// TODO Auto-generated method stub
		return tocheck.substring(tocheck.length() - 1, tocheck.length())
				+ tocheck.substring(0, tocheck.length() - 1);
	}
}
