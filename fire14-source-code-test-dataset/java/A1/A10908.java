package problemB.dancingwithgooglers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Dancers {
	
	private static final String INPUT_FILE = "/Users/sbhadour/dev/googlecodejam/test/B-small-attempt0.in";
	
	private static final String OUTPUT_FILE = "/Users/sbhadour/dev/googlecodejam/test/dancers-output.txt";
	
	class Triplet {
		
		private int googlerId;
		
		private int valueA;
		private int valueB;
		private int valueC;
		
		public Triplet(int googlerId) {
			this.googlerId = googlerId;
		}
	}

	/**
	 * Writes the results to the output file
	 * 
	 * @param results
	 */
	public void writeResults(String results) {
		try {
			Writer writer = new BufferedWriter(new FileWriter(OUTPUT_FILE));
			try {
				writer.write(results);
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
			finally {
				writer.close();
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Reads the input file and returns result. 
	 * 
	 * @return
	 */
	public String getResultsForInputFile() {
		StringBuilder result = new StringBuilder();
		
		try {
			BufferedReader input = new BufferedReader(new FileReader(INPUT_FILE));
			try {
				// first line is the number of test cases
				int numTestCases = Integer.parseInt(input.readLine());
				
				for (int i = 1; i <= numTestCases; i++) {
					result.append("Case #" + i + ": ");
					StringTokenizer words = new StringTokenizer(input.readLine(), " ");
					int totalGooglers = Integer.parseInt(words.nextToken());
					int surprisingTriplets = Integer.parseInt(words.nextToken());
					int minIndivScore = Integer.parseInt(words.nextToken());
					
					List<Triplet> allTriplets = new ArrayList<Dancers.Triplet>();
					for (int j = 1; j <= totalGooglers; j++) {
						List<Triplet> googlerTriplets = findAllTriplets(j,Integer.parseInt(words.nextToken()));
						allTriplets.addAll(googlerTriplets);
					}
					
					//printTriplets(allTriplets);
					result.append(findMaxGooglersWithIndivScore(allTriplets, surprisingTriplets, minIndivScore, totalGooglers));
					
					result.append(System.getProperty("line.separator"));
				}
				
			}
			catch (NumberFormatException nex) {
				nex.printStackTrace();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return result.toString();
	}
	
	/**
	 * Returns unique triplets assuming individual score can differ by at most 2
	 * 
	 * @param totalScore
	 * @return
	 */
	private List<Triplet> findAllTriplets (int googlerId, int totalScore) {
		List<Triplet> triplets = new ArrayList<Triplet>();
		
		// first triplet is the easiest 
		// since there are 3 judges, divide by 3 and make the result as first 2 values and 3rd as the difference of total - sum of val1+2
		int baseVal = totalScore/3;
		Triplet triplet = new Triplet(googlerId);
		triplet.valueA = baseVal;
		triplet.valueB = baseVal;
		triplet.valueC = totalScore - baseVal - baseVal;
		
		if (triplet.valueC > 10) {
			triplet.valueA += 1;
			triplet.valueC -= 1;
		}
		
		triplets.add(triplet);
		
		// a <= c always
		if (triplet.valueA == triplet.valueC && triplet.valueA != 10 && triplet.valueA != 0) {
			Triplet triplet2 = new Triplet(googlerId);
			triplet2.valueA = triplet.valueA + 1;
			triplet2.valueB = baseVal;
			triplet2.valueC = triplet.valueC - 1;
			
			triplets.add(triplet2);
		}
		// this is the case when a < c since a !> c
		else if (triplet.valueC - triplet.valueA == 2) {
			Triplet triplet3 = new Triplet(googlerId);
			triplet3.valueB = baseVal;
			triplet3.valueA = triplet.valueA + 1;
			triplet3.valueC = triplet.valueC -1;

			triplets.add(triplet3);
		}
		
		return triplets;
	}
	
	private int findMaxGooglersWithIndivScore (List<Triplet> allTriplets, int allowedSurprises, int minIndivScore, int totalGooglers) {
		
		Set<Integer> googlersWithTripletMatch = new HashSet<Integer>();
		
		List<Triplet> surprisingTripletsWithMatch = new ArrayList<Dancers.Triplet>();
		
		for (Triplet triplet : allTriplets) {
			// filter all non matched triplets
			// only add googlers with non surprising match first
			if (triplet.valueA >= minIndivScore || triplet.valueB >= minIndivScore || triplet.valueC >= minIndivScore) {
				if (Math.abs(triplet.valueA - triplet.valueC) == 2) {
					surprisingTripletsWithMatch.add(triplet);
				}
				else {
					googlersWithTripletMatch.add(triplet.googlerId);
				}
			}
		}
		
		// first drop triplets of googlers already counted.
		List<Triplet> tempList = new ArrayList<Dancers.Triplet>(surprisingTripletsWithMatch);

		for (int i = 0; i < tempList.size(); i++) {
			Triplet trip = tempList.get(i);

			if (googlersWithTripletMatch.contains(trip.googlerId)) {
				surprisingTripletsWithMatch.remove(trip);
			}
		}

		// if the surprising triplet still bigger than allowed
		if (surprisingTripletsWithMatch.size() > allowedSurprises) {
			// filter remaining  till size match restriction achieved.
			tempList = new ArrayList<Dancers.Triplet>(surprisingTripletsWithMatch);
			for (int i = 0, prevGooglerId = 0; surprisingTripletsWithMatch.size() > allowedSurprises && i < tempList.size(); i++) {
				Triplet trip = tempList.get(i);
				
				// don't remove triplets of the same  googler.
				if (prevGooglerId != trip.googlerId) {
					surprisingTripletsWithMatch.remove(trip);
				}
				prevGooglerId = trip.googlerId;
			}
		}

		// add the remaning guys back to the list
		for (Triplet matchedTrip : surprisingTripletsWithMatch) {
			googlersWithTripletMatch.add(matchedTrip.googlerId);
		}
		
		return googlersWithTripletMatch.size();
	}
	
	public void printTriplets (List<Triplet> triplets) {
		System.out.println("Triplet size: " + triplets.size());
		for (Triplet triplet : triplets) {
			System.out.println("Tripplet for googler id: " + triplet.googlerId + " -> {" + triplet.valueA +  "," + triplet.valueB + "," + triplet.valueC + "}");
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dancers probB = new Dancers();
		long startTime = System.currentTimeMillis();
		String results = probB.getResultsForInputFile();
		probB.writeResults(results);
		long endTime = System.currentTimeMillis();
		
		System.out.println("Compute Time: " + (endTime - startTime) + " milliseconds");
	}

}
