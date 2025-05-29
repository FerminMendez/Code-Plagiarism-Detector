import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;


public class B {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Scanner a = new Scanner(new File("/Users/anurag/Dev/Java/workspace/CodeJam/src/input"));
		FileWriter w = new FileWriter(new File("/Users/anurag/Dev/Java/workspace/CodeJam/src/output"));
		int T = a.nextInt();
		for (int t = 1; t <= T; ++t) {
			int lower = a.nextInt();
			int upper = a.nextInt();
			
			int numInversions = 0;
			for (int i = lower; i <= upper; ++i) {
				int maxPower = (int) Math.log10(i);
				int rotatedNumber = i;
				do {
					int lastDigit = rotatedNumber % 10;
					rotatedNumber = ((int) (rotatedNumber/10)) + (int) (lastDigit * Math.pow(10, maxPower));
					
					if (rotatedNumber >= lower && rotatedNumber <= upper && rotatedNumber != i) {
						++numInversions;
					}
					
				} while (rotatedNumber != i);
				
			}
			
			w.write(String.format("Case #%d: %d\n", t, numInversions/2));
		}
		
		w.close();

	}
	
	
	
	


}
