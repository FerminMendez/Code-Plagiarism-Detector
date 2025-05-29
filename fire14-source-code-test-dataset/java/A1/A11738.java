
public class Scores {
	private int N;	// Number of Googlers
	private int S; 	// Number of surprising triplets of scores
	private int p;	// Score at least 
	private int[] t; 	// total point of Googlers

	public Scores(String str) {
		String[] tmpArr = str.split(" "); 
		N = Integer.parseInt(tmpArr[0]); 
		S = Integer.parseInt(tmpArr[1]);
		p = Integer.parseInt(tmpArr[2]);
		
		t = new int[N];
		for (int i=0; i<N; i++) {
			t[i] = Integer.parseInt(tmpArr[i+3]);
		}
	}
	
	public int getMaxNumberOfGooglerOverScore() {
		int minTNormal = 3 * p -2 ;  // Normal : p, p-1, p-1
		int minTSurprising = 3 * p - 4 ; // surprising triplets : p, p-2, p-2
		
		if (p == 0) {
			return t.length; 
		} else if (p == 1) {
			minTSurprising = 3 * p -2 ; // p, p-1, p-1 
		}
		
		
		int maxNumber = 0 ; 		
		int surpNumber = 0 ; 
		for (int i=0; i<N; i++) {
			if (t[i] >= minTNormal) {
				maxNumber++ ; 
			} else if (t[i] >= minTSurprising) {
				surpNumber++ ; 
			}
	 	}
		
		if (S < surpNumber) {
			surpNumber = S ;
		}
		
		return maxNumber+surpNumber; 
	}

}
