
public class Problem {

	public int googlers;
	public int surprisingTriplets;
	public int bestResult;
	public int[] totals;
	
	public Problem(int googlers, int suprisingTriplets, int bestResult, int[] totals) {
		super();
		this.googlers = googlers;
		this.surprisingTriplets = suprisingTriplets;
		this.bestResult = bestResult;
		this.totals = totals;
	}

	public int solve() {
		
		boolean[] bestTotals = new boolean[totals.length];
		
		for (int i = 0; i < bestTotals.length; i++) {
			bestTotals[i] = tryFindingAnswer(totals[i], false);
		}
		
		// Try to find surprising results
		int i = 0;
		int surprising = surprisingTriplets;
		while (i < bestTotals.length && surprising > 0) {
			
			if (!bestTotals[i]) {
				bestTotals[i] = tryFindingAnswer(totals[i], true);
				
				if (bestTotals[i]) {
					surprising--;
				}
			}		
			
			i++;
		}
		
		int finalResult = 0;
		for (boolean b : bestTotals) {
			if (b) {
				finalResult++;
			}
		}
		
		return finalResult;
	}
	
	private boolean tryFindingAnswer(int total, boolean isSurprising) {
		
		if (total == 0) {
			return (bestResult == 0);
		}
		
		total -= bestResult;
		if (total >= 20) {
			return true;
		} 
		
		int lowLimit = bestResult - 1;
		int highLimit = bestResult + 1;
		
		if (isSurprising) {
			lowLimit--;
			highLimit++;
		}
		
		if (lowLimit < 0) {
			lowLimit = 0;
		}
		
		if (highLimit > 10) {
			highLimit = 10;
		}
		
		if (highLimit * 2 < total) {
			return true;
		}		
		
		for (int i = lowLimit; i <= highLimit; i++) {
			int tempOtherValue = total - i;
			
			if (tempOtherValue >= lowLimit && tempOtherValue <= highLimit) {
				return true;
			}
		}
		
		return false;
	}
}
