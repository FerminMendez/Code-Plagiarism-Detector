package mgg.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author manolo
 * @date 13/04/12
 */
public class CombinatoryUtils {

	public static List<Integer> findAddingCombination(int total, 
			List<Integer> listOfNumbers) {

		ArrayList<Integer> solution = new ArrayList<Integer>();

		for (int i = 0; i < listOfNumbers.size(); i++){
			for (int j = 0; j < listOfNumbers.size(); j++){

				if( (i != j) &&
						(listOfNumbers.get(i) + listOfNumbers.get(j) == total) ){
					solution.add(listOfNumbers.get(i));
					solution.add(listOfNumbers.get(j));
					return solution;
				}

			}
		}
		return null;
	}

	public static List<Integer> findAddingCombinationIndices(int total, 
			List<Integer> listOfNumbers) {

		ArrayList<Integer> solution = new ArrayList<Integer>();

		for (int i = 0; i < listOfNumbers.size(); i++){
			for (int j = 0; j < listOfNumbers.size(); j++){

				if( (i != j) &&
						(listOfNumbers.get(i) + listOfNumbers.get(j) == total) ){
					solution.add(i);
					solution.add(j);
					return solution;
				}

			}
		}
		return null;
	}

	public static List<Integer> findAddingCombinationIndicesBase1(int total, 
			List<Integer> listOfNumbers) {

		ArrayList<Integer> solution = new ArrayList<Integer>();

		for (int i = 0; i < listOfNumbers.size(); i++){
			for (int j = 0; j < listOfNumbers.size(); j++){

				if( (i != j) &&
						(listOfNumbers.get(i) + listOfNumbers.get(j) == total) ){
					solution.add(i+1);
					solution.add(j+1);
					return solution;
				}

			}
		}
		return null;
	}

	public static List<Triplet> possibleTriplets(int score) {
		List<Triplet> listOfTriplets = new ArrayList<Triplet>();
		
		for(Triplet t : allPossibleTriplets){
			if(t.sum() == score){
				listOfTriplets.add(t);
			}
		}
		
		return listOfTriplets;
	}
	
	private final static List<Triplet> allPossibleTriplets = allPossibleTriplets();
	
	private static List<Triplet> allPossibleTriplets() {

		HashSet<Triplet> set = new HashSet<Triplet>();
		
//		int cont = 0;
		for (int i = 0; i <= 10; i++) {
			for (int j = 0; j <= 10; j++) {
				if(Math.abs(i-j) <= 2){
					for (int k = 0; k <= 10; k++) {
						if((Math.abs(i-k) <= 2) && (Math.abs(j-k) <= 2)){
//							cont++;
//							System.out.println("(" + i + ", " + j + ", " + k + ")\t\tcont = " + cont);7
							set.add(new Triplet(i, j, k));
							
						}
					}
				}
			}	
		}
		
		return new ArrayList<Triplet>(set);

	}

}
