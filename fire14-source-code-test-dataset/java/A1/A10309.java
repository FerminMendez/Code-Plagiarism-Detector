package org.cb.projectb.dancingwiththegooglers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Contest {
	
	public static void main(String[] args) throws FileNotFoundException {
		File input = new File(System.getProperty("user.dir") + "/" + "resources/projectB/B-small-attempt0.in");
		Scanner sc = new Scanner(input);

		List<DanceOff> contests = new ArrayList<DanceOff>();
		
		if (sc.hasNext()) {
			Integer.parseInt(sc.nextLine()); // number of cases - ignored
			while (sc.hasNext()) {
				String contestString = sc.nextLine();
				
				StringTokenizer contestTokenizer = new StringTokenizer(contestString);
				
				int contestants = Integer.parseInt(contestTokenizer.nextToken());
				int surprisingTriplets = Integer.parseInt(contestTokenizer.nextToken());
				int scoreWeCareAbout = Integer.parseInt(contestTokenizer.nextToken());
				List<Integer> scores = new ArrayList<Integer>();
				for(int i = 0; i < contestants; i ++) {
					scores.add(Integer.parseInt(contestTokenizer.nextToken()));
				}
				
				contests.add(new DanceOff(contestants, surprisingTriplets, scoreWeCareAbout, scores));
			}
		}
		
		for(int i = 1; i <= contests.size(); i ++) {
			DanceOff danceoff = contests.get(i-1);

			System.out.println("Case #" + i + ": " + danceoff.getNumberAllowedToBeImportant());
		}
	}
	
	private static class DanceOff {
		private final int contestants;
		private final int surprisingTriplets;
		private final int scoreWeCareAbout;
		private final List<Integer> contestantScores;
		private final int numberAllowedToBeImportant;
		
		public DanceOff(int contestants, int surprisingTriplets, int scoreWeCareAbout, List<Integer> contestantScores) {
			this.contestants = contestants;
			this.surprisingTriplets = surprisingTriplets;
			this.scoreWeCareAbout = scoreWeCareAbout;
			this.contestantScores = contestantScores;
			
			this.numberAllowedToBeImportant = fillInDetails();
		}

		private int fillInDetails() {
			int importantScores = 0;
			
			List<Integer[]> allProbableScores = new ArrayList<Integer[]>();
			
			for(Integer score: contestantScores) {
//				System.out.print(score + " - ");
				
				int baseScore = score / 3;
				int remaining = score % 3;
				Integer[] scoresArray = new Integer[]{baseScore, baseScore, baseScore};
				
				for(int i = 0; i < remaining; i++) {
					scoresArray[i] = scoresArray[i] + 1;
				}
				
//				System.out.print("Probable tripplet: [");
//				for(int i = 0; i < scoresArray.length; i++) {
//					System.out.print(scoresArray[i] + " ");
//				}
//				System.out.println("]");
				
				allProbableScores.add(scoresArray);
			}
			
			
			int freebeeImportantScores = 0;
			int ableToBeImportantIfSurprising = 0;
			for (Integer[] scoresList : allProbableScores) {
				// count how many in scores array are already important
				boolean isImportant = false;
				boolean canBeSurprising = false;
				
				for (Integer integer : scoresList) {
					if(integer >= this.scoreWeCareAbout) {
						isImportant = true;
						break;
					}
				}
				if(isImportant) {
					freebeeImportantScores++;
				} else {
					// see how many i can make 'surprising' to then care about
					if(scoresList[0] + 1 >= this.scoreWeCareAbout) {
						if(scoresList[0] == scoresList[1] && scoresList[0] != 0) {
							canBeSurprising = true;
						}
					}
					if(canBeSurprising) {
						ableToBeImportantIfSurprising++;
					}
				}
			}
			

			
			// take min of allowed surprising & how many could be surprised
			int numToMakeSpecial = Math.min(ableToBeImportantIfSurprising, this.surprisingTriplets);
			
			// add min to current important scores
			importantScores = freebeeImportantScores + numToMakeSpecial;
			
//			System.out.println("Freebee important: " + freebeeImportantScores);
//			System.out.println("Can be Made Important with surprising Score: " + ableToBeImportantIfSurprising);
//			System.out.println("Num Of Scores we are making surprising: " + numToMakeSpecial);
//			System.out.println("Max Special Scores: " + importantScores);
//			System.out.println();
			
			return importantScores;
		}
		
		public int getNumberAllowedToBeImportant() {
			return numberAllowedToBeImportant;
		}

		@Override
		public String toString() {
			return "DanceOff [contestants = " + contestants
					+ ", surprisingTriplets = " + surprisingTriplets
					+ ", scoreWeCareAbout = " + scoreWeCareAbout
					+ ", contestantScores = " + contestantScores + "]";
		}
	}

}
