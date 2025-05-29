package er.dream.codejam.qual;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import er.dream.codejam.helpers.ProblemSolver;

public class RecycledNumbers extends ProblemSolver{
	
	public static void main(String[] args) {
		new RecycledNumbers().execute();
	}

	@Override
	protected List<String> handleInput() {
		List<String> result = new ArrayList<String>();
		int[] settings = fileHandler.readIntArray();
		
		for(int line = 0;line<settings[0];line++){
			int transformations = 0;
			
			int[] fromTo = fileHandler.readIntArray();
			int from = fromTo[0];
			int to = fromTo[1];
			for(int i=from;i<=to;i++)
				transformations += getRecycledNumbers(i, to);
			
			result.add(""+transformations);
		}
		
		return result;
	}
	
	private int getRecycledNumbers(int number, int max){
		int transformations = 0;
		
		String numberString = ""+number;
		int stringLength = numberString.length();
		String newString; int transformedNumber;
		Set<Integer> foundTransformations = new HashSet<Integer>();
		for(int i=stringLength-1;i>0;i--){
			newString = numberString.substring(i)+numberString.substring(0, i);
			transformedNumber = Integer.parseInt(newString);
			if(transformedNumber > number && transformedNumber <= max && !foundTransformations.contains(transformedNumber)){
				transformations++;
				foundTransformations.add(transformedNumber);
			}
		}
		return transformations;
	}

}
