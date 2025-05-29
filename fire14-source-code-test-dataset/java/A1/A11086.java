import java.util.Scanner;


public class ProblemB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] maxs = genmaxs();
		
		// check correct maxs
		//for(int i = 0; i < maxs.length; i++){
		//	System.out.println(i + ": " + maxs[i][0] + " " + maxs[i][1]);
		//}
		
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++){
			int v = processCase(sc, maxs);
			
			System.out.println("Case #" + (i+1) + ": " + v);
		}
	}
	
	public static int processCase(Scanner sc, int[][] maxs){
		int numGooglers = sc.nextInt(); // N
		int numSurprising = sc.nextInt(); // S
		int maxBest = sc.nextInt(); // p
		
		int numPure = 0;
		int numImpure = 0;
		
		int[] pts = new int[numGooglers];
		
		// find the number of pure vals
		for(int i = 0; i < pts.length; i++){
			pts[i] = sc.nextInt();
			
			// check to see if purely reached
			if(maxs[pts[i]][0] >= maxBest){
				numPure++;
			} else if(maxs[pts[i]][1] >= maxBest) {
				numImpure++;
			}
		}
		
		if(numImpure > numSurprising) numImpure = numSurprising;
		
		return numPure + numImpure;
	}
	
	public static int[][] genmaxs(){
		int[][] maxs = new int[31][];
		
		// set up high maximums
		for(int i = 0; i < maxs.length; i++){
			maxs[i] = new int[]{0,0};
		}
		
		// loop through the triples
		for(int i = 0; i < 11; i++){
			for(int j = 0; j < 11; j++){
				for(int k = 0; k < 11; k++){
					int sum = i + j + k;
					int max = max(i, j, k);
					
					// find the max value in each reg and supr triple for a val
					if(isReg(i, j, k) && max > maxs[sum][0]){
						maxs[sum][0] = max;
					}
					if(isSupr(i, j, k) && max > maxs[sum][1]){
						maxs[sum][1] = max;
					}
				}
			}
		}
		
		return maxs;
	}
	
	public static int max(int i, int j, int k){
		return Math.max(i, Math.max(j, k));
	}
	
	public static boolean isReg(int i, int j, int k){
		return bigDiff(i, j, k, 1);
	}
	
	public static boolean isSupr(int i, int j, int k){
		return bigDiff(i, j, k, 2);
	}
	
	public static boolean bigDiff(int i, int j, int k, int diff){
		return Math.abs(i - j) <= diff && Math.abs(j - k) <= diff && Math.abs(k - i) <= diff;
	}

}
