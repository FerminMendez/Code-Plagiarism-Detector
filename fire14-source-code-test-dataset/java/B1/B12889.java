import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 */

/**
 * @author Kamlesh Saran Dev
 * 
 */
public class RecycledPair {

	int a;
	int b;

	/**
	 * @param i
	 * @param j
	 */
	public RecycledPair(int a, int b) {
		this.a = a;
		this.b = b;
	}

	/**
	 * @return
	 */
	public int getNumberOfPairs() {
		int count = 0;
		for (int n = a; n < b; n++) {
			Set<Integer> allCombinations = giveAllCombinations(n, b);
			count = count + allCombinations.size();
		}
		return count;
	}

	/**
	 * @param n
	 * @return
	 */
	private Set<Integer> giveAllCombinations(int n, int b) {
		Set<Integer> result = new HashSet<Integer>();
		String nStr = Integer.toString(n);
		for (int i = 1; i < nStr.length(); i++) {
			String backPart = nStr.substring(i);
			String frontPart = nStr.substring(0, i);
			int newNumber = Integer.valueOf((backPart + frontPart));

			if (n < newNumber && newNumber <= b) {
				result.add(newNumber);
			}
		}
		return result;
	}

	public static void main(String args[]) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(
				new FileReader(
						new File(
								"C:\\Documents and Settings\\Kamlesh\\Desktop\\codejam\\C-small-attempt0.in")));
		int numberOfTest = Integer.valueOf(bufferedReader.readLine());
		for (int i = 1; i <= numberOfTest; i++) {
			String line = bufferedReader.readLine();
			String limits[] = line.split("\\ ");
			RecycledPair rp = new RecycledPair(Integer.valueOf(limits[0]), Integer.valueOf(limits[1]));
			System.out.println("Case #" + i + ": " +  rp.getNumberOfPairs());

		}
	}

}
