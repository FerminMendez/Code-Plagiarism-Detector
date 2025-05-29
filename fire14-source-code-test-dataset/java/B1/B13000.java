package mgg.problems;

import java.util.ArrayList;
import java.util.List;

import mgg.utils.CombinatoryUtils;
import mgg.utils.FileUtil;
import mgg.utils.StringUtils;
import mgg.utils.Triplet;

/**
 * @author manolo
 * @date 14/04/12
 */
public class ProblemB {

	public final static String EXAMPLE_IN = "B-example.in";
	public final static String EXAMPLE_OUT = "B-example.out";

	public final static String B_SMALL_IN = "B-small-practice.in";
	public final static String B_SMALL_OUT = "B-small-practice.out";

	public final static String B_LARGE_IN = "B-large-practice.in";
	public final static String B_LARGE_OUT = "B-large-practice.out";

	public final static String delim = " ";

	public static String solve(FileUtil util) {
		
		String line = util.getLine();
		List<Integer> listOfArgs = StringUtils.stringWithIntegersToList(line, delim);
		//System.out.println("\tArgs = " + listOfArgs);
		
		int googlers = listOfArgs.get(0);
		System.out.println("\tGooglers = " + googlers);
		
		int surprisingScores = listOfArgs.get(1);
		System.out.println("\tSurprising scores = " + surprisingScores);
		
		int leastScore = listOfArgs.get(2);
		System.out.println("\tMinimum = " + leastScore);
		
		List<Integer> listOfScores = listOfArgs.subList(3, listOfArgs.size());
		System.out.println("\tScores = " + listOfScores);
		
		List<Triplet> listOfTriplets;
		List<List<Triplet>> listOfListOfTriplets = new ArrayList<List<Triplet>>();
		for(int score : listOfScores){
			
			listOfListOfTriplets.add(CombinatoryUtils.possibleTriplets(score));
		}
		
		System.out.println("\tPossible triplets: " + listOfListOfTriplets);
		
		List<List<Triplet>> scenarios = calculateScenarios(listOfListOfTriplets, surprisingScores);
		
		System.out.println("\tPossible scenarios: " + scenarios);

		return null;
	}

	private static List<List<Triplet>> calculateScenarios(
			List<List<Triplet>> listOfListOfTriplets, int surprisingScores) {
		
		return null;
	}

}
