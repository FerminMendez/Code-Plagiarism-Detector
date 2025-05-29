package codejam.qualification;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import codejam.Task;

public class C extends Task {

	private int t;
	private String[][] testCases;
	private String[] resultset;

	public C(String[] args) {
		super(args);
	}

	public static void main(String[] args) throws IOException {
		Task taskC = new C(args);
		taskC.execute();
	}

	protected void catchInputData() throws IOException {
		t = Integer.parseInt(readLine());
		testCases = new String[t][];

		// iterates over cases
		for (int c = 0; c < t; c++) {
			testCases[c] = readLine().split(" ");
		}
	}

	protected void processInputData() {
		resultset = new String[t];

		// iterates over cases
		for (int c = 0; c < t; c++) {
			String[] testCase = testCases[c];
			
			int a = Integer.parseInt(testCase[0]);
			int b = Integer.parseInt(testCase[1]);
			int y = 0;
			
			for (int n = a; n < b; n++) {
				Set<Integer> mset = new HashSet<Integer>();
				String sn = String.valueOf(n);
				for (int i = 1; i < sn.length(); i++) {
					if (sn.charAt(i) != '0') {
						String sm = sn.substring(i) + sn.substring(0, i);
						int m = Integer.parseInt(sm);
						if (m > n && m <= b && !mset.contains(m)) {
							y++;
							mset.add(m);
						}
					}
				}
			}
			
			resultset[c] = ""+y;
		}
	}

	protected void generateOutputFile() throws IOException {
		// iterates over cases
		for (int c = 0; c < t; c++) {
			writeLine("Case #" + (c + 1) + ": " + resultset[c]);
		}
	}

}
