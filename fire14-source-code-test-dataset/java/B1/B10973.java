import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class TaskC {

	static int numberLength;
	
	public static void main(String[] args ) throws FileNotFoundException {
		File fileName = new File("taskc.txt");
		Scanner inFile = new Scanner(fileName);
		int n = inFile.nextInt();
		inFile.useDelimiter("\\r?\\n");
		String[] cases = new String[n];
		for (int i = 0; i < n; i++)
			cases[i] = inFile.next();
		List<String> result = new ArrayList<String>();
		for (String caseString: cases) {
			int recycledNumbers = 0;
			Scanner caseScanner = new Scanner(caseString);
			String lowerBoundString = caseScanner.next();
			int lowerBound = Integer.parseInt(lowerBoundString);
			int upperBound = caseScanner.nextInt();
			for (int i = lowerBound; i <= upperBound; i++) {
				String iString = new Integer(i).toString();
				for (int j = i + 1; j <= upperBound; j++) {
					String jString = new Integer(j).toString();
					if (evaluate(iString, jString))
						recycledNumbers++;
				}
			}
			result.add("" + recycledNumbers);
		}
		
		for (int i = 0; i < result.size(); i++) {
			System.out.println("Case #" + (i+1) + ": " + result.get(i));
		}
	}

	private static boolean evaluate(String iString, String jString) {
		for (int n = 1; n < jString.length(); n++) {
			String testString = jString.substring(n) + jString.substring(0, n);
			if (iString.equals(testString))
				return true;
		}
		return false;
	}
	
}
