
public class DeTerminator {

	public DeTerminator(){ }

	public int determine(String[] inputArray){
		int numGooglers = Integer.parseInt(inputArray[0]);
		int allowableSurprising = Integer.parseInt(inputArray[1]);
		int bestScore = Integer.parseInt(inputArray[2]);
		int surprising = 0;
		int notSurprising = 0;

		int total = 0;

		for(int i = 3; i < (numGooglers+3); i++){
			total = Integer.parseInt(inputArray[i]);
			int comparisonScore = (bestScore - 1)*2 + bestScore;
			int comparisonScoreMinus2 = comparisonScore-2;
			if(bestScore == 1) comparisonScore = comparisonScoreMinus2 = 1;
			if(bestScore == 0) comparisonScore = comparisonScoreMinus2 = 0;
			if(total >= comparisonScore) notSurprising++;
			if((total >= (comparisonScoreMinus2)) && (total < (comparisonScore))) surprising++;
			if(surprising >= allowableSurprising) surprising = allowableSurprising;
		}
		return notSurprising + surprising;
	}

}
