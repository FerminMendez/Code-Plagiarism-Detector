import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Google Code Jam 2012 Qualification Round - Problem C. Recycled Numbers
 * 
 * @author matlock
 *
 */
public class RecycledNumbers {

	public static void main(String[] args) {
		RecycledNumbers g = new RecycledNumbers();
		g.goGo();
	}

	public void goGo() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int testCases = Integer.parseInt(in.readLine());
			
			for (int i = 1; i <= testCases; i++) {
				String inputText = in.readLine();
				String[] numberPair = inputText.split(" ", 2);
				
				int matches = runTestCase(Integer.valueOf(numberPair[0]), Integer.valueOf(numberPair[1]));
				
				System.out.println("Case #" + i + ": " + matches);
			}
		} catch (IOException e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}

	public int runTestCase(int startVal, int endVal) {
		Set<String> sourceSet = new HashSet<String>();
		Set<String> discoveredSet = new HashSet<String>();
		int totalMatches = 0;
		// first store all the source numbers
		for (int j = startVal; j <= endVal; j++) {
			sourceSet.add(String.valueOf(j));
		}

		for (int j = startVal; j <= endVal; j++) {
			StringBuffer buf = new StringBuffer(String.valueOf(j));
			int len = buf.length() - 1; // don't need last rotation, so -1
			// rotate the characters
			for (int k = 0; k < len; k++) {
				buf.append(buf.charAt(0));
				buf.deleteCharAt(0);
				
				if (Integer.valueOf(buf.toString()) != j) {
					if (sourceSet.contains(buf.toString()) &&
							!discoveredSet.contains(String.valueOf(j) + buf.toString())) {
						discoveredSet.add(String.valueOf(j) + buf.toString());
						discoveredSet.add(buf.toString() + String.valueOf(j));
						totalMatches++;
						sourceSet.remove(String.valueOf(j)); // remove from set
					}
				}
			}			
		}

		return totalMatches;
	}

}
