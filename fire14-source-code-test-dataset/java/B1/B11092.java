package probc;

import codejam.CodeJam;

public class Main extends CodeJam {

	public static void main(String[] args) {
		new Main() {
			// Override the input file with the following: e.g. if the value is "large", then read "A-large.in" instead of the default
			// @SuppressWarnings("unused")
			// public static final String OVERRIDE_INPUT_FILE = "small-attempt0"; // "large";
		};
	}

	// --------------------------------------------------------------------------------------------------------------

	@Override
	public void solve() {

		int T = readInt();
		for (int t = 0; t < T; t++) {
			int A = readInt();
			int B = readInt();

			int totRecycPairs = 0;
			int[] recycNums = new int[10];
			for (int n1 = A; n1 < B; n1++) {
				int numRecyc = 0;
				String s1 = n1 + "";
				for (int j = 1, l = s1.length(); j < l; j++) {
					String s2 = s1.substring(j) + s1.substring(0, j);
					int n2 = Integer.parseInt(s2);
					if (n2 > n1 && n2 <= B) {
						// Uniquify -- necessary?
						boolean found = false;
						for (int i = 0; i < numRecyc && !found; i++)
							if (recycNums[i] == n2)
								found = true;
						if (!found)
							recycNums[numRecyc++] = n2;
					}
				}

				totRecycPairs += numRecyc;
				//					System.out.println("> " + n1);
			}
			writeCaseNumThenLine("" + totRecycPairs);
		}
	}

}
