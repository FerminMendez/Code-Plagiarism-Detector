import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class RecycledNumbers {
	
	public static void main(final String[] args) throws IOException {
		if (args.length == 0) {
			System.out.println("Input file must be provided as an input");
			return;
		}
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter(args[1])));
			
			List<TestCase> cases = parseInput(args[0]);
			for (final TestCase testCase : cases) {
				pw.println("Case #" + testCase.getCaseNumber() + ": " + testCase.solve());			
			}
			
		} finally {
			if(pw != null) {
				pw.close();
			}
		}
	}
	
	private static List<TestCase> parseInput(final String filename) throws IOException {
		final List<TestCase> res = new ArrayList<TestCase>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filename));
			int casesNum = Integer.parseInt(br.readLine());
			for (int i = 1; i <= casesNum; ++i) {
				String[] args = br.readLine().split("\\s");
				res.add(new TestCase(i, Integer.parseInt(args[0]), Integer.parseInt(args[1])));
			}
		} finally {
			if (br != null) {
				br.close();
			}
		}
		return res;
	}
	
	private static class TestCase {
		private final int caseNumber;
		private final int a;
		private final int b;
		
		public TestCase(int caseNumber, int a, int b) {
			super();
			this.caseNumber = caseNumber;
			this.a = a;
			this.b = b;
		}

		public int solve() {
			int res = 0;
			for(int i = a; i < b; ++i) {
				for(int j = i + 1; j <=b; ++j) {
					final String iStr = ("" + i) + i;
					final String jStr = "" + j;
					if (iStr.contains(jStr)) {
						++res;
					}
				}
			}
			return res;
		}

		public int getCaseNumber() {
			return caseNumber;
		}
	}
}
