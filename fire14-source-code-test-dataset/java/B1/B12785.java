package qualification;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recycled {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int numCases = s.nextInt();
		
		for (int i = 1; i <= numCases; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			
			int numRecycled = countRecycled(a, b);
			
			System.out.printf("Case #%d: %d\n", i, numRecycled);
		}
	}
	
	private static int countRecycled(int a, int b) {
		int result = 0;
		
		StringBuilder sbB = new StringBuilder();
		sbB.append(b);
		
		List<Integer> register = new ArrayList<Integer>();
		
		for (int i = a; i <= b; i++) {
			register.clear();
			
			if (i < 10) continue;
			
			StringBuilder sb = new StringBuilder();
			sb.append(i);
			
			for (int j = sb.length() - 1; j > 0; j--) {
				StringBuilder newCombinedSb = new StringBuilder();
				newCombinedSb.append(sb.substring(j)).append(sb.substring(0,  j));
				
				if (newCombinedSb.charAt(0) == '0') continue;
				
				if (newCombinedSb.charAt(0) > sbB.charAt(0)) continue;

				if (newCombinedSb.charAt(0) < sb.charAt(0)) continue;

				int newCombinedInt = Integer.parseInt(newCombinedSb.toString());
				
				if (newCombinedInt <= b && newCombinedInt > i) {
					if (!register.contains(newCombinedInt)) {
						register.add(newCombinedInt);
					}
				}
			}
			
			result += register.size();
		}
		
		return result;
	}

}
