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

	public final static String B_SMALL_IN = "B-small-attempt0.in";
	public final static String B_SMALL_OUT = "B-small-attempt0.out";

	public final static String B_LARGE_IN = "B-largein";
	public final static String B_LARGE_OUT = "B-large.out";

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

		List<Triplet> listOfTriplets, newListOfTriplets = new ArrayList<Triplet>();
		int surprisingScoresLeft = surprisingScores;
//		int [] withTriplets = new int[3];
//		withTriplets[0] = 0;
//		withTriplets[1] = 0;
//		withTriplets[2] = 0;
		
		int greatGooglers = 0;
		for(int score : listOfScores){

			listOfTriplets = CombinatoryUtils.possibleTriplets(score);
			//System.out.println("\tPossible triplets: " + listOfTriplets);

			newListOfTriplets = new ArrayList<Triplet>();
			for(Triplet t : listOfTriplets){
				if (t.max() >= leastScore){
					newListOfTriplets.add(t);
				}
			}
			System.out.println("\tNew possible triplets: " + newListOfTriplets);
			
//			withTriplets[newListOfTriplets.size()]++;
			
			if(newListOfTriplets.size() == 2){
				greatGooglers++;
			}
			if(newListOfTriplets.size() == 1){
				if(newListOfTriplets.get(0).isSurprising() && surprisingScoresLeft > 0){
					greatGooglers++;
					surprisingScoresLeft--;
				}
				if(!newListOfTriplets.get(0).isSurprising()){
					greatGooglers++;
				}
			}
			
		}
		
		return "" + greatGooglers;
		
//		System.out.println("\t" + withTriplets[0] + " with 0 triples");
//		System.out.println("\t" + withTriplets[1] + " with 1 triples");
//		System.out.println("\t" + withTriplets[2] + " with 2 triples");
//		
//		if((surprisingScores == 0) && (withTriplets[1] > 0)){
//			return "0";
//		}
//		if(surprisingScores > withTriplets[1]){
//			return "0";
//		}
//		else {
//			return "" + (withTriplets[1] + withTriplets[2]);  
//		}
	}

	private static Triplet takeMax(List<Triplet> listOfTriplets) {

		Triplet max_t = new Triplet(-1, -1, -1); 
		for(Triplet t : listOfTriplets){
			if(!max_t.isSurprising()){
				if(t.isSurprising()){
					max_t = t;
				}
				else if(t.max() > max_t.max()){
					max_t = t;
				}
			}


		}
		return max_t;

	}

}
