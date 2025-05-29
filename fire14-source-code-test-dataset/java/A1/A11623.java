package codejam.surprisingGooglers;



public class PossibleSurpriseCase {

	private boolean[] surprises;
	private int[] scores;
	
	private PossibleSurpriseCase(int length) {
		surprises = new boolean[length];
		scores = new int[length];
	}

	public int getMaximumPHavers(int p) {
		//System.out.println("Checking for case: "+this);
		int max = 0;
		for (int i = 0; i<scores.length; i++)
			if (canHaveP(scores[i], surprises[i], p)) max++;
		//System.out.println("Can have "+max+" minimums of "+p+".");
		return max;
	}

	private boolean canHaveP(int score, boolean surprise, int p) {
		if (score<2 && surprise) return false;
		score = surprise ? score-2:score;
		switch (score % 3){
		case 0: // clean split
			return (score/3) +(surprise?2:0) >= p;
		case 1: //one is higher
			return ((score-1)/3)+1 +(surprise?1:0) >= p;
		case 2: //one is lower
			return ((score+1)/3)  +(surprise?1:0) >= p;
		default: 
			throw new AssertionError("Cannot happen.");
		}
	}

	public static PossibleSurpriseCase combine(boolean isSurprise,int score, PossibleSurpriseCase other) {
		PossibleSurpriseCase r = new PossibleSurpriseCase(other.getLength()+1);
		r.surprises[0] = isSurprise;
		r.scores[0] = score;
		for(int i=0; i<other.getLength(); i++){
			r.surprises[i+1] = other.surprises[i];
			r.scores[i+1] = other.scores[i];
		}
		return r;
	}


	private int getLength() {
		return surprises.length;
	}

	public static PossibleSurpriseCase trivial() {
		return new PossibleSurpriseCase(0);
	}

	public String toString(){
		StringBuilder r = new StringBuilder();
		for(int i=0; i<scores.length; i++){
			r.append(scores[i]);
			if (surprises[i]) r.append("*");
			r.append(" ");
		}
		return r.toString();
	}
	
}
