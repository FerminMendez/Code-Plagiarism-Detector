package er.dream.codejam.train;

import java.util.ArrayList;
import java.util.List;

import er.dream.codejam.helpers.ProblemSolver;

public class DancingWithGooglers extends ProblemSolver{
	
	public static void main(String[] args) {
		new DancingWithGooglers().execute();
	}

	@Override
	protected List<String> handleInput() {
		List<String> result = new ArrayList<String>();
		int[] settings = fileHandler.readIntArray();
		
		for(int i=0;i<settings[0];i++){
			int[] numbers = fileHandler.readIntArray();
			int surprises = numbers[1];
			int minScore = numbers[2];
			
			int minimumScoreForUnsurprising = Math.max(0,3*minScore-2);
			int minimumScoreForSurprising = Math.max(0, 3*minScore-4);
			
			int surprisesMax = 0;
			int unsuprising = 0;
			
			int score;
			for(int j=3;j<numbers.length;j++){
				
				score = numbers[j];
				if(score < minScore)
					continue;
				
				if(score >= minimumScoreForUnsurprising)
					unsuprising++;
				else if(score >= minimumScoreForSurprising)
					surprisesMax++;
			}
			int maxGooglers = unsuprising + Math.min(surprises,  surprisesMax);
			result.add(""+maxGooglers);
		}
		
		return result;
	}

}
