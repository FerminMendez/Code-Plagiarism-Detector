package dom.zar.jam.qualifications;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DancingWithTheGooglers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int inputLines = in.nextInt();
		for (int i = 0; i < inputLines;) {
			int googlersAmount = in.nextInt();
			int suprising = in.nextInt();
			int minPoints = in.nextInt();
			
			final int[] googlers = new int[googlersAmount];
			for (int k = 0; k < googlersAmount; ++k) {
				googlers[k] = in.nextInt();
			}
			
			System.out.println("Case #" + ++i + ": "
					+ result(suprising, minPoints, googlers));
		}
	}
	
	private static int result(int suprising, int minPoints,
			int[] googlers) {
		
		final List<Integer> filtered = new ArrayList<Integer>();
		for (int points : googlers) {
			boolean hasMin = (points / 3) >= minPoints;
			boolean oneLessThanMin 
				= ((points - minPoints) >> 1) == (minPoints - 1); 					
			
			if (!(hasMin || oneLessThanMin)) {
				filtered.add(points);
			}
		}
		
		int probable = 0;
		for (Integer points : filtered) {
			if (points - minPoints < 0) continue;
			int restPoints = (points - minPoints) >> 1; 
			if (Math.abs(restPoints - minPoints) <= 2) 
				probable++;
		}
		probable = Math.min(probable, suprising);
		
		return googlers.length - filtered.size() + probable;
	}
}
