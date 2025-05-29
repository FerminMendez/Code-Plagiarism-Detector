import java.util.*;
import java.io.*;

public class Mirror {
	public static void main(String[] args) throws IOException { 
		Scanner scan = new Scanner(new File("C-small-attempt0.in"));
		FileWriter fstream = new FileWriter("out.txt");
		BufferedWriter out = new BufferedWriter(fstream);
		int numCases = scan.nextInt();
		for (int z = 0; z < numCases; z++) {
			int low = scan.nextInt();
			int high = scan.nextInt();
			int count = 0;
			for (int i = low; i < high; i++) {
				String lows = "" + i;
				String[] arr = new String[lows.length() - 1];
				for (int k = 0; k < arr.length; k++) {
					lows = lows.charAt(lows.length()-1) + lows.substring(0, lows.length()-1);
					arr[k] = lows;
				}
				for ( int j = i + 1; j <= high; j++) {
					String highs = "" + j;
					for (int k = 0; k < arr.length; k++) {
						if (arr[k].equals(highs)) {
							count++;
							break;
						}
					}
				}
			}
			out.write("Case #" + (z+1) + ": " + count);
			if ( z != numCases - 1)
				out.newLine();
		}
		out.close();
	}
}