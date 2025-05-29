import java.util.Scanner;
import java.util.TreeSet;


public class RecycledNumbers {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int numCases = s.nextInt();
		s.nextLine();
		for (int i = 0; i < numCases; i++) {
			TreeSet<Integer> found = new TreeSet<>();
			int count = 0;
			int a = s.nextInt();
			int b = s.nextInt();
			String bStr = b + "";
			for (int n = a; n < b; n++) {
				String numStr = n + "";
				for (int j = 1; j < numStr.length(); j++) {
					if (numStr.charAt(j) < numStr.charAt(0)) {
						continue;
					}
					if (numStr.length() == bStr.length() && numStr.charAt(j) > bStr.charAt(0)) {
						continue;
					}
					String numRot = numStr.substring(j) + numStr.substring(0, j);
					int m = Integer.parseInt(numRot);
					//System.out.println("DEBUG: Trying " + n + "," + m);
					if (n < m && m <= b) {
						found.add(m);
						//System.out.println("DEBUG: Found");
					}
				}
				count += found.size();
				found.clear();
			}
			System.out.println("Case #" + (i+1) + ": " + count);
		}
	}

}
