import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class RecycledNumbers {

	private static long findMatchesForNumber(Long number, long a, long b) {

		long matches = 0;
		
		Set<Long> set = new HashSet<>();

		String str = number.toString();

		for (int i = 1; i < str.length(); i++) {

			String begin = str.substring(0, i);
			String end = str.substring(i);

			Long recycled = new Long(end + begin);

			if (recycled > number && recycled >= a && recycled <= b
					&& !set.contains(recycled)) {
				
				matches++;
				
				set.add(recycled);
			}
		}

		return matches;
	}

	private static long handleCase(long a, long b) {
		long totalMatches = 0;

		for (long i = a; i <= b; i++) {
			totalMatches = totalMatches + findMatchesForNumber(i, a, b);
		}

		return totalMatches;
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		// Open the file that is the first
		// command line parameter
		FileInputStream fstream = new FileInputStream(args[0]);
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;

		FileWriter outFile = new FileWriter("c:\\data\\q3\\output.txt");
		PrintWriter out = new PrintWriter(outFile);

		long t = new Long(br.readLine());

		for (int i = 0; i < t; i++) {
			strLine = br.readLine();
			StringTokenizer token = new StringTokenizer(strLine);

			long a = new Long(token.nextToken());
			long b = new Long(token.nextToken());

			// System.out.println("numbers: " + a + " " + b);

			long matches = handleCase(a, b);
			
			long index = i+ 1;

			String strToPrint = "Case #" + index + ": " + matches;
			out.println(strToPrint);
			System.out.println(strToPrint);
		}

		in.close();
		out.close();
	}
}
