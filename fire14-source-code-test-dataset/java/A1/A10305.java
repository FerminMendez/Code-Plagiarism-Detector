package sebastianco;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class DancingWithGooglers {

	public static void main(String[] args) throws Exception {

		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		try {
			reader = new BufferedReader(new FileReader(new File(args[0])));
			writer = new BufferedWriter(new FileWriter(new File(args[1])));
			
			final int nrOfTestCases = Integer.valueOf(reader.readLine());
			
			String lineSepartor = "";
			for (int i = 1; i <= nrOfTestCases; i++) {
				writer.write(lineSepartor);
				writer.write(String.format("Case #%d: %d",
						i, new TestCase(reader.readLine()).computeMaxGooglers()));
				lineSepartor = "\n";
			}
	
		} finally {
			if (writer != null) {
				writer.flush();
				writer.close();
			}
			reader.close();
		}
				
	}
	
	public static class TestCase {
		
		private int n;
		private int s;
		private int p;
		private int[] t;
		
		public TestCase(String caseLine) {
			String[] tokens = caseLine.split(" ");
			n = Integer.parseInt(tokens[0]);
			s = Integer.parseInt(tokens[1]);
			p = Integer.parseInt(tokens[2]);
			t = new int[n];
			for (int i = 0; i < n; i++) {
				t[i] = Integer.parseInt(tokens[3 + i]);
			}
		}
		
//				p-1 p   p    3p-1
//				p-1 p-1 p    3p-2				
//		        p-2 p-1	p    3p-3
//				p-2 p-2 p    3p-4
		public int computeMaxGooglers() {
			
			final int minTotalScore = 3*p - 2;
			final int minSurprisingScoreA = 3*p - 3;
			final int minSurprisingScoreB = 3*p - 4;
			
			int max = 0;
			int surprising = s;
			
			for (int i = 0; i < n; i++) {
				if (t[i] >= minTotalScore) {
					max++;
				} else {
					if (surprising > 0 
							&& t[i] > 0
							&& (t[i] == minSurprisingScoreA || t[i] == minSurprisingScoreB)) {
						max++;
						surprising--;
					}
				}
			}
			
			return max;
		}
		
	}
	
	
}
