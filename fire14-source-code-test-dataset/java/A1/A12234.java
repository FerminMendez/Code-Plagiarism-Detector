package mar2012;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class ProblemB {

	public static void main(String[] args) throws Exception {
		PrintStream out = new PrintStream(new File(
				"/Users/asingh/Desktop/gcj2012/prob.b.out.txt"));
		ProblemB prob = new ProblemB();
		String input = "/Users/asingh/Desktop/gcj2012/prob.b.in.txt";
		InputStream in = new FileInputStream(new File(input));
		 prob.solveAll(in, out);
		// prob.solveTestCase(1, 3, 1, 5, new int[] { 15, 13, 11 }, out);
		// 3 0 8 23 22 21
		// prob.solveTestCase(2, 3, 0, 8, new int[] { 23, 22, 21 }, out);

		// 2 1 1 8 0
		// prob.solveTestCase(3, 2, 1, 1, new int[] { 8, 0 }, out);

		// 6 2 8 29 20 8 18 18 21
		// prob.solveTestCase(4, 6, 2, 8, new int[] { 29, 20, 8, 18, 18, 21 },
		// out);
	}

	private void solveAll(InputStream in, PrintStream out) throws Exception {
		Scanner scanner = new Scanner(in);
		int numTestCases = Integer.parseInt(scanner.nextLine());

		for (int i = 0; i < numTestCases; i++) {
			int numParticipants = scanner.nextInt();
			int numSurprisingScores = scanner.nextInt();
			int bestResult = scanner.nextInt();
			int[] scores = new int[numParticipants];
			for (int c = 0; c < numParticipants; c++) {
				scores[c] = scanner.nextInt();
			}
			if (i < numTestCases - 1)
				scanner.nextLine();
			solveTestCase(i + 1, numParticipants, numSurprisingScores,
					bestResult, scores, out);
		}
	}

	private void solveTestCase(int testCaseId, int numParticipants,
			int numSurprisingScores, int bestResult, int[] totalPoints,
			PrintStream out) {
		// System.out.println("testCaseId: " + testCaseId +
		// ", numParticipants: "
		// + numParticipants + ", numSurprisingScores: "
		// + numSurprisingScores + ", bestResult: " + bestResult
		// + ", scores: " + Arrays.toString(totalPoints));

		List<Set<TripletScore>> possibleScores = new ArrayList<Set<TripletScore>>();
		for (int total : totalPoints) {
			Set<TripletScore> set = AllPossibleScores
					.getPossibleScoresForTotalPoint(total).toSet();
			possibleScores.add(set);
			// System.out.println("Score: " + total + " => " + set);
		}

		// choose as many scores that >= bestResult
		// but numSurprise == numSurprisingScores
		ChosenScores chosen = chooseBestScores(numParticipants,
				numSurprisingScores, bestResult, possibleScores);
		String result = "Case #" + testCaseId + ": "
				+ chosen.getNumParticipantsCrossingBestResult();
		System.out.println(result);
		out.println(result);

	}

	private ChosenScores chooseBestScores(int numParticipants,
			int numSurprisingScores, int bestResult,
			List<Set<TripletScore>> possibleScores) {
		ChosenScores chosen = new ChosenScores(numParticipants,
				numSurprisingScores, bestResult);
		AtomicReference<ChosenScores> best = new AtomicReference<ProblemB.ChosenScores>();
		chooseBest(0, possibleScores.get(0).iterator(), possibleScores, chosen,
				best);
		return best.get();
	}

	private void chooseBest(int index, Iterator<TripletScore> iterator,
			List<Set<TripletScore>> possibleScores, ChosenScores chosen,
			AtomicReference<ChosenScores> bestChosen) {

		while (iterator.hasNext()) {
			TripletScore next = iterator.next();
			if (chosen.add(next)) {
				if (index < possibleScores.size() - 1) {
					chooseBest(index + 1, possibleScores.get(index + 1)
							.iterator(), possibleScores, chosen, bestChosen);
					if (chosen.isMaxPossibleResult()) {
						return;
					}
				} else {
					updateBetter(chosen, bestChosen);
				}
				chosen.remove(next);
			}
		}
	}

	private void updateBetter(ChosenScores chosen,
			AtomicReference<ChosenScores> bestChosen) {
		if (chosen.satisfiesSurprises()) {
			ChosenScores best = bestChosen.get();
			if (best == null) {
				bestChosen.set(chosen.clone());
				return;
			}
			if (chosen.getNumParticipantsCrossingBestResult() > best
					.getNumParticipantsCrossingBestResult()) {
				ChosenScores newBest = chosen.clone();
				// System.out.println("==>> Found better: currentBest: "
				// + bestChosen.get() + ", updating to new: " + newBest);
				bestChosen.set(newBest);
			}
		}
	}

	private static class ChosenScores {
		private final Set<TripletScore> scores;
		private final int maxNumSurprises;
		private final int maxNumParticipants;
		private final int leastBestResult;
		private int numParticipantsCrossingBestResult;
		private int numSurpriseScores;

		protected ChosenScores(ChosenScores copy) {
			this.maxNumParticipants = copy.maxNumParticipants;
			this.maxNumSurprises = copy.maxNumSurprises;
			this.leastBestResult = copy.leastBestResult;
			this.numParticipantsCrossingBestResult = copy.numParticipantsCrossingBestResult;
			this.numSurpriseScores = copy.numSurpriseScores;
			this.scores = new LinkedHashSet<ProblemB.TripletScore>(copy.scores);
		}

		public ChosenScores(int maxNumParticipants, int maxNumSurprises,
				int leastBestResult) {
			this.maxNumParticipants = maxNumParticipants;
			this.maxNumSurprises = maxNumSurprises;
			this.leastBestResult = leastBestResult;
			this.scores = new LinkedHashSet<ProblemB.TripletScore>();
		}

		public boolean add(TripletScore score) {
			if (score.isSurprisingScore()
					&& numSurpriseScores + 1 > maxNumSurprises) {
				return false;
			}
			if (score.isSurprisingScore()) {
				numSurpriseScores++;
			}
			if (score.getBestResult() >= leastBestResult) {
				numParticipantsCrossingBestResult++;
			}
			scores.add(score);
			return true;
		}

		public void remove(TripletScore score) {
			if (score.isSurprisingScore()) {
				numSurpriseScores--;
			}
			if (score.getBestResult() >= leastBestResult) {
				numParticipantsCrossingBestResult--;
			}
			scores.remove(score);
		}

		public boolean isMaxPossibleResult() {
			return numParticipantsCrossingBestResult == maxNumParticipants;
		}

		public int getNumParticipantsCrossingBestResult() {
			return numParticipantsCrossingBestResult;
		}

		public boolean satisfiesSurprises() {
			return numSurpriseScores == maxNumSurprises;
		}

		public ChosenScores clone() {
			return new ChosenScores(this);
		}

		@Override
		public String toString() {
			return "ChosenScores [numSurpriseScores=" + numSurpriseScores
					+ ", scores=" + scores
					+ ", numParticipantsCrossingBestResult="
					+ numParticipantsCrossingBestResult + "]";
		}

	}

	private static class TripletScore {
		private final int a;
		private final int b;
		private final int c;
		private final int distance;
		private final int bestResult;
		private final int totalPoints;
		private final boolean surprisingScore;

		public TripletScore(int a, int b, int c) {
			int[] sortedArray = { a, b, c };
			Arrays.sort(sortedArray);
			this.a = sortedArray[0];
			this.b = sortedArray[1];
			this.c = sortedArray[2];
			this.bestResult = Math.max(a, Math.max(b, c));
			this.distance = bestResult - Math.min(a, Math.min(b, c));
			this.totalPoints = a + b + c;
			surprisingScore = distance == 2;
		}

		public boolean isSurprisingScore() {
			return surprisingScore;
		}

		public int getTotalPoints() {
			return totalPoints;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + a;
			result = prime * result + b;
			result = prime * result + c;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			TripletScore other = (TripletScore) obj;
			if (a != other.a)
				return false;
			if (b != other.b)
				return false;
			if (c != other.c)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "{" + a + ", " + b + ", " + c + " (" + bestResult + ", "
					+ (surprisingScore ? "S" : "X") + ")}";
		}

		public int getBestResult() {
			return bestResult;
		}

		public boolean isValid() {
			return distance <= 2;
		}
	}

	private static class TripletScoreSet {
		private final Set<TripletScore> sortedSet;
		private final int numSurprisingScores;

		// private final int bestResult;

		public TripletScoreSet(Set<TripletScore> set) {
			this.sortedSet = set;
			this.sortedSet.addAll(set);
			int c = 0;
			for (TripletScore score : set) {
				if (score.isSurprisingScore()) {
					c++;
				}
			}
			numSurprisingScores = c;
			// bestResult = this.sortedSet.last().getBestResult();
		}

		// public int getBestResult() {
		// return bestResult;
		// }

		public Set<TripletScore> toSet() {
			return Collections.unmodifiableSet(sortedSet);
		}

		@Override
		public String toString() {
			return "{" + sortedSet + ", numSurprisingScores: "
					+ numSurprisingScores + "}";
		}

	}

	private static class AllPossibleScores {

		private final static Map<Integer, TripletScoreSet> possibleScores;

		static {
			Map<Integer, Set<TripletScore>> tmpMap = new HashMap<Integer, Set<TripletScore>>();
			for (int a = 0; a <= 10; a++) {
				final int mid = a;
				for (int b = mid - 2; b <= mid + 2; b++) {
					for (int c = mid - 2; c <= mid + 2; c++) {
						if (betweenInclusive(a, 0, 10)
								&& betweenInclusive(b, 0, 10)
								&& betweenInclusive(c, 0, 10)) {
							TripletScore score = new TripletScore(a, b, c);
							if (score.isValid()) {
								Set<TripletScore> list = tmpMap.get(score
										.getTotalPoints());
								if (list == null) {
									list = new LinkedHashSet<TripletScore>();
								}
								list.add(score);
								tmpMap.put(score.getTotalPoints(), list);
								if (!score.isValid()) {
									System.out.println("WRONG - " + score);
									System.exit(1);
								}
							}
						}
					}
				}
			}
			possibleScores = new HashMap<Integer, ProblemB.TripletScoreSet>();
			for (Entry<Integer, Set<TripletScore>> e : tmpMap.entrySet()) {
				possibleScores.put(e.getKey(),
						new TripletScoreSet(e.getValue()));
			}

			// for (int i = 0; i <= 30; i++) {
			// TripletScoreSet scores = AllPossibleScores
			// .getPossibleScoresForTotalPoint(i);
			// System.out.println("Total point: " + i + ", scores: " + scores);
			// }
		}

		private static boolean betweenInclusive(int num, int min, int max) {
			return num >= min && num <= max;
		}

		public static TripletScoreSet getPossibleScoresForTotalPoint(
				int totalPoint) {
			return possibleScores.get(totalPoint);
		}

	}

}
