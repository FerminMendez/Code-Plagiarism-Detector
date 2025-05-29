package proba;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ProblemB {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		Map<Integer, Set<Score>> map = new HashMap<Integer, Set<Score>>();
		Map<Integer, Set<Score>> surprises = new HashMap<Integer, Set<Score>>();
		for (int j1 = 0; j1 <= 10; j1++) {
			for (int j2 = 0; j2 <= 10; j2++) {
				for (int j3 = 0; j3 <= 10; j3++) {
					if (Math.abs(j1 - j2) > 2 || Math.abs(j2 - j3) > 2
							|| Math.abs(j1 - j3) > 2) {
						continue;
					}
					int sum = j1 + j2 + j3;
					if (Math.abs(j1 - j2) == 2 || Math.abs(j2 - j3) == 2
							|| Math.abs(j1 - j3) == 2) {
						if (!surprises.containsKey(sum)) {
							Set<Score> list = new HashSet<Score>();
							Score score = new Score(j1, j2, j3);
							list.add(score);
							surprises.put(sum, list);
						} else {
							Set<Score> list = surprises.get(sum);
							Score score = new Score(j1, j2, j3);
							list.add(score);
							surprises.put(sum, list);
						}
					} else {
						if (!map.containsKey(sum)) {
							Set<Score> list = new HashSet<Score>();
							Score score = new Score(j1, j2, j3);
							list.add(score);
							map.put(sum, list);
						} else {
							Set<Score> list = map.get(sum);
							Score score = new Score(j1, j2, j3);
							list.add(score);
							map.put(sum, list);
						}
					}
				}
			}
		}
		Scanner s = new Scanner(new FileInputStream("B-small-attempt0.in"));
		int cases = s.nextInt();
		s.nextLine();

		for (int i = 0; i < cases; i++) {
			int N = s.nextInt();
			int S = s.nextInt();
			int p = s.nextInt();
			int[] scores = new int[N];
			int answer = 0;
			int noOfSurprises = 0;
			for (int j = 0; j < N; j++) {
				scores[j] = s.nextInt();
			}
			if (s.hasNextLine())
				s.nextLine();
			for (int j = 0; j < N; j++) {
				Set<Score> normal = map.get(scores[j]);
				Set<Score> surps = surprises.get(scores[j]);
				boolean foundInNormal = false;
				for (Score score1 : normal) {
					if (score1.isScoreAbove(p)) {
						answer++;
						foundInNormal = true;
					}
				}
				if (!foundInNormal) {
					if (surps != null && noOfSurprises < S ) {
						for (Score score1 : surps) {
							if (score1.isScoreAbove(p)) {
								answer++;
								noOfSurprises++;
							}
						}
					}
				}
				/*
				else if (surps != null && noOfSurprises < S
						&& surps.size() > S) {
					// for()
					// comb1(combstr);

					Map<Integer, Set<Score>> best = new HashMap<Integer, Set<Score>>();
					for (Score score1 : surps) {
						int subanswer = 0;
						if (score1.isScoreAbove(p)) {
							answer++;
							foundInNormal = true;
						}
						if (!best.containsKey(subanswer)) {
							Set<Score> list = new HashSet<Score>();
							list.add(score1);
							best.put(subanswer, list);
						} else {
							Set<Score> list = map.get(subanswer);
							list.add(score1);
							best.put(subanswer, list);
						}
					}
					Set<Integer> bests = best.keySet();
					List<Integer> bestList = new ArrayList<Integer>(bests);
					Collections.sort(bestList);
					for (int n = 0; n < S; n++) {
						Integer h = bestList.get(bestList.size() - (1 + n));
						answer = answer + h;
					}
					for (Score score : normal) {
						if (score.isScoreAbove(p)) {
							answer++;
						}
					}

				} else {
					for (Score score : normal) {
						if (score.isScoreAbove(p)) {
							answer++;
							googlers[j] = new Googler(score, scores[j]);
						}
					}
				}*/
			}
			System.out.println("Case #" + (i + 1) + ": " + answer);
		}

	}

	private static class Score {
		int a;
		int b;
		int c;

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
			Score other = (Score) obj;
			if (a != other.a)
				return false;
			if (b != other.b)
				return false;
			if (c != other.c)
				return false;
			return true;
		}

		public Score(int a, int b, int c) {
			super();
			int[] arr = { a, b, c };
			Arrays.sort(arr);
			this.a = arr[0];
			this.b = arr[1];
			this.c = arr[2];
		}

		public boolean isScoreAbove(int p) {
			if (a >= p || b >= p || c >= p)
				return true;
			return false;
		}

		@Override
		public String toString() {
			return "[" + a + ", " + b + ", " + c + "]";
		}

	}

}
