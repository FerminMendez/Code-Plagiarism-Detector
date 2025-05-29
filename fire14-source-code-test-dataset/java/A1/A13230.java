package com.eevoskos.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DancingWithTheGooglers {
	
	static boolean DEBUG = false;
	
	class Googler implements Comparable<Googler> {
		List<Triplet> triplets;

		public Googler(List<Triplet> triplets) {
			Collections.sort(triplets);
			this.triplets = triplets;
		}

		List<Triplet> getSuprisingTriplets() {
			List<Triplet> surprising = new ArrayList<Triplet>();
			for (Triplet t : triplets) {
				if (t.isSurprising()) {
					surprising.add(t);
				}
			}
			return surprising;
		}

		Triplet bestScoreTriplet() {
			Collections.sort(triplets);
			return triplets.get(0);
		}

		@Override
		public int compareTo(Googler another) {
			return this.bestScoreTriplet().compareTo(another.bestScoreTriplet());
		}
		
		List<Triplet> tripletsWithBestScoreAtLeast(int p) {
			List<Triplet> list = new ArrayList<Triplet>();
			for (Triplet t : triplets) {
				if (t.bestResult() >= p) {
					list.add(t);
				}
			}
			return list;
		}
		
		int[] numOftripletsWithBestScoreAtLeast(int p) {
			// result[0]: number of triplets
			// result[1]: number of the triplets that are surprising
			int[] result = new int[2];
			result[0] = 0;
			result[1] = 0;
			for (Triplet t : triplets) {
				if (t.bestResult() >= p) {
					result[0]++;
					if (t.isSurprising()) {
						result[1]++;
					}
				}
			}
			return result;
		}
	}

	class Triplet implements Comparable<Triplet> {
		int x, y, z;

		Triplet(int x, int y, int z) {
			int[] n = new int[] { x, y, z };
			Arrays.sort(n);
			this.x = n[0];
			this.y = n[1];
			this.z = n[2];
		}

		int sum() {
			return x + y + z;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null)
				return false;

			if (!(obj instanceof Triplet))
				return false;

			return x == ((Triplet) obj).x 
					&& y == ((Triplet) obj).y
					&& z == ((Triplet) obj).z;
		}
		
		boolean isSurprising() {
			int[] n = new int[] {x, y, z};
			Arrays.sort(n);
			return n[2] - n[0] == 2;
		}
		
		@Override
		public String toString() {
			String s = x + " " + y + " " + z;
			if (isSurprising()) {
				s += " (*)";
			}
			return s;
		}
		
		int bestResult() {
			return z;
		}

		@Override
		public int compareTo(Triplet another) {
			if (this.bestResult() > another.bestResult()) {
				return 1;
			} else if (this.bestResult() < another.bestResult()) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	int solveCase(String input) {
		String[] args = input.split(" ");

		// Number of Googlers
		int N = Integer.valueOf(args[0]);

		// Number of surprising triplets
		int S = Integer.valueOf(args[1]);

		// Min best score
		int p = Integer.valueOf(args[2]);

		// Total points of Googlers
		int[] t = new int[args.length - 3];
		for (int i = 0; i < t.length; i++) {
			t[i] = Integer.valueOf(args[i + 3]);
		}

		if (DEBUG)
			printInput(N, S, p, t);

		return calcResult(N, S, p, t);
	}

	int calcResult(int N, int S, int p, int[] t) {
		int result = 0;

		List<Googler> googlers = new ArrayList<Googler>();
		
		// For each Googler
		for (int i = 0; i < N; i++) {
			// Calculate possible combinations of scores
			List<Triplet> triplets = getCombinations(t[i]);
			googlers.add(new Googler(triplets));
			if (DEBUG) {
				System.out.println("Googler #" + (i + 1));
				for (Triplet tri : triplets) {
					System.out.println(tri);
				}
				System.out.println("");
			}
		}
		
		// Sort by best score
		Collections.sort(googlers);
		
		int surprising = 0;
		
		for (Googler g : googlers) {
			List<Triplet> qt = g.tripletsWithBestScoreAtLeast(p);
			boolean finishThis = false;
			for (Triplet tri : qt) {
				if (finishThis) {
					continue;
				} else if (!tri.isSurprising()) {
					result++;
					finishThis = true;
					continue;
				} else {
					if (surprising >= S) {
						continue;
					} else {
						surprising++;
						result++;
						finishThis = true;
						continue;
					}
				}
			}
			
		}

		return result;
	}

	List<Triplet> getCombinations(int sum) {
		List<Triplet> triplets = new ArrayList<Triplet>();
		for (int x = 0; x <= 10; x++) {
			for (int y = 0; y <= 10; y++) {
				for (int z = 0; z <= 10; z++) {
					Triplet triplet = new Triplet(x, y, z);
					if (triplet.sum() == sum) {
						if (triplet.z - triplet.x > 2) {
							// Impossible case, skip
							continue;
						} else if(triplets.contains(triplet)) {
							// Don't add if duplicate
							continue;
						} else {
							triplets.add(triplet);
						}
					} else {
						// Sum is not proper, skip
						continue;
					}
				}
			}
		}
		return triplets;
	}

	static int factorial(int n) {
		if (n <= 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

	static void printInput(int N, int S, int p, int[] t) {
		String output = "\n";
		output += N + " Googlers, ";
		output += S + " surprising results. ";
		output += "How many had best score equal to or greater than " + p + "? ";
		output += "(scores: ";
		for (int i = 0; i < t.length; i++) {
			if (i != 0) {
				output += ", ";
			}
			output += t[i];
		}
		output += ")";
		System.out.println(output);
	}

	public static void main(String... args) {
		DancingWithTheGooglers dancing = new DancingWithTheGooglers();
		
		try {

			BufferedReader c = new BufferedReader(new InputStreamReader(System.in));

			// Number of test cases
			int T = Integer.valueOf(c.readLine());

			System.out.println();

			// Do, for each test case
			for (int i = 0; i < T; i++) {

				// Googlerese string
				String input = c.readLine();

				// Process input
				int output = dancing.solveCase(input);

				// Print the translated text
				System.out.println("Case #" + (i + 1) + ": " + output);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
