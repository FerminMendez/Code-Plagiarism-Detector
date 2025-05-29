package google.codejam2012.awanish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GooglersDance {
	private static int count = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner inputScan = new Scanner(System.in);
		int noOfCases = Integer.parseInt(inputScan.nextLine());
		String cases;
		int noOfGooglers;
		int noOfSurprisingTrip;
		int topScore;
		
		for (int i = 1; i <= noOfCases; i++) {
			cases = inputScan.nextLine();
			count = 0;
			ArrayList totalScores = new ArrayList();
			StringTokenizer st = new StringTokenizer(cases, " ");
			noOfGooglers = Integer.parseInt(st.nextToken());
			noOfSurprisingTrip = Integer.parseInt(st.nextToken());
			topScore = Integer.parseInt(st.nextToken());
			while (st.hasMoreTokens()) {
				totalScores.add(st.nextToken());
			}
			int total;
			int triplet;
			int remainder;
			ArrayList<Number> triplets;
			ArrayList<ArrayList<Number>> dancers = new ArrayList<ArrayList<Number>>();
			int c = 0;
			for (Object t : totalScores) {
				triplets = new ArrayList<Number>();
				total = Integer.parseInt(t.toString());
				triplet = total / 3;
				remainder = total % 3;
				triplets.add(triplet);
				if (remainder == 2) {
					triplets.add(triplet + 1);
					triplets.add(total - (triplet * 2 + 1));
				} else {
					triplets.add(triplet);
					triplets.add(total - triplet * 2);
				}
				dancers.add(triplets);
			}
//			System.out.println(dancers);

			analyzeSurprises(dancers, noOfSurprisingTrip, topScore);

			System.out.println("Case #" + i + ": " + count);

		}

	}

	private static void analyzeSurprises(ArrayList<ArrayList<Number>> dancers,
			int noOfSurprisingTrip, int topScore) {
		// TODO Auto-generated method stub

		for (ArrayList<Number> list : dancers) {

			if (max(list) >= topScore) {
				count++;
			} else if (noOfSurprisingTrip > 0 && checkForSurprise(list,topScore)) {
				noOfSurprisingTrip--;
				count++;

			}
		}

	}

	private static boolean checkForSurprise(ArrayList<Number> list, int topScore) {
		// TODO Auto-generated method stub
		int topScoreCount = 0;
		for (Number n : list) {
			if (n.intValue()==topScore-1){
				topScoreCount++;	
			}
		}
		if (topScoreCount>=2 && topScore!=1)
		{
			return true;
		}
		
		return false;
	}

	private static int max(ArrayList<Number> list) {
		// TODO Auto-generated method stub
		int max = 0;
		for (Number n : list) {
			if (n.intValue() > max) {
				max = n.intValue();
			}
		}
		return max;
	}

}
