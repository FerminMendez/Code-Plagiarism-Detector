import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;


public class ProblemB {

	public static void main(String[] args) {
		try {
			BufferedReader bufReader = new BufferedReader(new FileReader(args[0]));
		
			int numOfCases = Integer.parseInt(bufReader.readLine());
			int a, b;
			for (int i = 0; i < numOfCases; i++) { // should change 2 to numOfCases!!!
				Set<String> distinctRecycledPairs = new HashSet<String>();
				String line = bufReader.readLine();
				a = Integer.parseInt(line.substring(0, line.indexOf(' ')));
				b = Integer.parseInt(line.substring(line.indexOf(' ') + 1, line.length()));
				//System.out.println("A = " + a + " B = " + b);
				for (int j = a; j <= b; j++) {
					String n = "" + j;
					for (int k = 1; k < n.length(); k++) {
						String possibleM = n.substring(k) + n.substring(0, k);
						if (Integer.parseInt(possibleM) > Integer.parseInt(n)  && Integer.parseInt(possibleM) >= a && Integer.parseInt(possibleM) <= b) {
							// the pair (n,m) may repeat, so use a set
							// there should be a better way though
							distinctRecycledPairs.add(n + " " + possibleM);
						}
					}
				}
				System.out.println("Case #" + (i+1) + ": " + distinctRecycledPairs.size());
			}
			
			bufReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
