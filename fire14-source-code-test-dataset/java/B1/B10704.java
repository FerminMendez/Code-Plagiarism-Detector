import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.HashSet;

public class ProblemB {

	static int A;
	static int B;
	static HashSet<Integer> set;

	public static void main(String[] args) {

		try {
			/* Reading */
			FileInputStream fstream = new FileInputStream("input.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			/* Writing */
			FileWriter fw = new FileWriter(new File("output"));
			BufferedWriter bw = new BufferedWriter(fw);

			String strLine;

			Integer T = 0;
			int caseCounter = 0;

			while ((strLine = br.readLine()) != null) {
				if (caseCounter == 0) {
					T = new Integer(strLine);
				} else {
					set = new HashSet<Integer>();
					int index =strLine.indexOf(' ');
					A = new Integer(strLine.substring(0, index).trim());
					B = new Integer(strLine.substring(index).trim());

					int nbRecycledPairs = 0;
					for (int i = A; i <= B; i++) {
						if (!set.contains(i)) {
							nbRecycledPairs += findRecycled(i);
						}
					}

					String toPrint;
					if (caseCounter == T) {
						toPrint = "Case #" + caseCounter + ": "
								+ nbRecycledPairs;
					} else {
						toPrint = "Case #" + caseCounter + ": "
								+ nbRecycledPairs + "\n";
					}
					System.out.print(toPrint);
					bw.write(toPrint);
				}
				caseCounter++;
			}
			in.close();
			bw.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}

	}

	static int findRecycled(int n) {
		String s = Integer.toString(n);
		int nbRecycled = 0;
		int nbRecycledPairs = 0;
		for (int i = 0; i < s.length(); i++) {
			String t = s.substring(i) + s.substring(0, i);
			if (t.charAt(0) != '0' && isInSet(t) && !t.equals(s)
					&& !set.contains(new Integer(t))) {
				set.add(new Integer(t));
				nbRecycled++;
			}

		}
		if (nbRecycled != 0) {
			nbRecycled++;
		}
		nbRecycledPairs = nbRecycled * (nbRecycled - 1) / 2;

		return nbRecycledPairs;
	}

	static boolean isInSet(String n) {
		int i = new Integer(n);
		if (i >= A && i <= B) {
			return true;
		}
		return false;
	}
}
