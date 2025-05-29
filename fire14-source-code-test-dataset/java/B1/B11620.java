import java.util.*;
import java.io.*;

public class C {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new FileReader(args[0]));
		in.readLine();
		
		int caseNum = 0;
		while (in.ready()) {
			solve(++caseNum, in.readLine());
		}
	}
	
	public static void solve(int caseNum, String caseInput) {		
		String[] inputSegments = caseInput.split(" ");
		String i1 = inputSegments[0];
		String i2 = inputSegments[1];
		int v1 = Integer.parseInt(i1);
		int v2 = Integer.parseInt(i2);
		int d = i1.length();
		int baseValue = (int) Math.pow(10, d);
		
		HashSet<String> uniquePair = new HashSet<String>();
		if (baseValue == 1) {
			// do nothing
		} else {
			String n;
			int value;
			for (int i = v1; i <= v2; ++i) {
				n = String.valueOf(i);
				for (int j = 1; j < d; ++j) {
					value = Integer.parseInt(n.substring(j) + n.substring(0, j));
					if (value >= v1 && value <= v2 & value != i) {
						uniquePair.add(n + " - " + value);
					}
				}
			}
		}
		System.out.printf("Case #%d: %d\n", caseNum, uniquePair.size()/2);
	}
}