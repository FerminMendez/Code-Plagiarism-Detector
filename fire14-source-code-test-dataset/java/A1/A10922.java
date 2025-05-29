package codejam.qualification;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import codejam.Task;

public class B extends Task {

	private int t;
	private String[][] testCases;
	private String[] resultset;

	public B(String[] args) {
		super(args);
	}

	public static void main(String[] args) throws IOException {
		Task taskB = new B(args);
		taskB.execute();
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
			
			int n = Integer.valueOf(testCase[0]);
			int s = Integer.valueOf(testCase[1]);
			int p = Integer.valueOf(testCase[2]);
			int y = 0;
			
			for (int i = 3; i < 3 + n; i++) {
				int t = Integer.valueOf(testCase[i]);
				if (Math.ceil((float) t / 3) >= p) {
					y++;
				} else if (s > 0 && t > 1 && (Math.round((float) t / 3) + 1) >= p) {
					y++;
					s--;
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
