package sebastianco;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;


public class RecycledNumbers {

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
						i, new TestCase(reader.readLine()).computePairs()));
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
		
		private int a;
		private int b;
		
		public TestCase(String caseLine) {
			String[] tokens = caseLine.split(" ");
			a = Integer.parseInt(tokens[0]);
			b = Integer.parseInt(tokens[1]);
		}
		
		public int computePairs() {
			
			Set<String> distinctPairs = new HashSet<String>();
			
			final String strB = String.valueOf(b);
			final int maxRotations = strB.length() - 1; 
			
			int recycledPairs = 0;
			for (int i = a; i < b; i++) {
				String strI = String.valueOf(i); // System.out.println("==" + strI);
				
				StringBuilder number = new StringBuilder(strI);				
				for (int j = 1; j <= maxRotations; j++) {
					rotate(number);
					String strNumber = number.toString();
					if (strI.compareTo(strNumber) < 0
							&& strNumber.compareTo(strB) <= 0) {
						if (distinctPairs.add(strI + strNumber)) {
							recycledPairs++; // System.out.println(strNumber);
						}
					}
				}
				
			}
			
			return recycledPairs;
		}
		
		private void rotate(StringBuilder number) {
			char c = number.charAt(number.length() - 1);
			for (int i = number.length() - 1; i > 0; i--) {
				number.setCharAt(i, number.charAt(i-1));
			}
			number.setCharAt(0, c);
		}
		
	}
	
	
}
