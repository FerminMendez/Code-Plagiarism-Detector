package dancingwiththegooglers;

import java.util.ArrayList;
import java.util.List;

public class TestCase {
	int numberOfGooglers;
	public int getNumberOfGooglers() {
		return numberOfGooglers;
	}
	public int getSurprisingScores() {
		return surprisingScores;
	}
	public int getBestResult() {
		return bestResult;
	}
	int surprisingScores;
	int bestResult;
	
	List<Integer> scores = null;
	
	public TestCase(int numberOfGooglers, int surprisingScores, int bestResult, List<Integer> scores){
		this.numberOfGooglers = numberOfGooglers;
		this.surprisingScores = surprisingScores;
		this.bestResult = bestResult;
		this.scores = new ArrayList<Integer>(scores);		
	}
	
	public int execute(){
		int bestScorers = 0;
		for(int score : this.scores){
			if(canItBeTheBestScorer(score, bestResult))
				bestScorers++;			
		}
		return bestScorers;
	}
	private boolean canItBeTheBestScorer(int score, int bestResult2) {
		if(score < bestResult2)
			return false;
		if(bestResult2 == 0)
			return true;
		if(bestResult2 == 1)
			if(score > 0)
				return true;
			else
				return false;
		if(score >= (bestResult2 * 3) - 2){
			return true;
		}else if(score >= (bestResult2 * 3) - 4){
			if(this.surprisingScores > 0){
				this.surprisingScores--;
				return true;
			}
			return false;
		}
		return false;
	}
	
}
