import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecycleSolution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String inFilename = "C-small-attempt0.in";
		String outFilename = inFilename.substring(0, inFilename.length() - 3)
				+ ".out";
		try {
			Scanner sc = new Scanner(new File(inFilename));
			PrintStream ps = new PrintStream(new FileOutputStream(outFilename));
			int testCases = Integer.parseInt(sc.nextLine());
			for (int i = 1; i <= testCases; i++) {
				// logic
				if (i >= 1) {
					ps.println();
				}
				String data = sc.nextLine();
				String[] parts = data.split(" ");
				int min = Integer.parseInt(parts[0], 10);
				int max = Integer.parseInt(parts[1], 10);
				int pairCount = 0;
				for (int test = min; test < max; test++) {
					List<Integer> orderings = orderingsOf(test);
					for (int ordering : orderings) {
						if (ordering > test && ordering <= max
								&& ordering >= min) {
							if ((ordering + "").length() == (max + "").length())
								pairCount++;
						}
					}
				}
				System.out.println("Case #" + i + ": " + pairCount);
				ps.print("Case #" + i + ": " + pairCount);
			}
			sc.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static List<Integer> orderingsOf(int number) {
		List<Integer> myOrderings = new ArrayList<Integer>();
		String base = "" + number;
		int baselen = base.length();
		for (int i = 0; i < baselen; i++) {
			String thisperm = base.substring(baselen - i);
			if (baselen - i > 0) {
				thisperm += base.substring(0, baselen - i);
			}
			// Strip out 0-starting
			int tplen = ("" + Integer.parseInt(thisperm, 10)).length();
			if (tplen == baselen)
				myOrderings.add(Integer.parseInt(thisperm, 10));
		}
		return myOrderings;
	}

}
