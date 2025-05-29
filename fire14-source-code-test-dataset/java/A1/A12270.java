import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
	static final boolean DBG = false;

	// x x x s= 3x
	// x x x+1 s= 3x +1
	// x x x-1 s= 3x -1
	// x x+1 x+1 s= 3x +2
	// x x-1 x-1 s= 3x-2

	public static void main(String[] args) {

		AllNormal allNormal = new AllNormal();
		AllSurprising allSurprising = new AllSurprising();

		Scanner sc = new Scanner(System.in);
		long dStart = System.currentTimeMillis();
		StringBuilder sbout = new StringBuilder();

		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			Task one = new Task(sc, allNormal, allSurprising);
			int res = one.getSolution();
			sbout.append("Case #");
			sbout.append(i);
			sbout.append(": ");
			sbout.append(res);
			sbout.append('\n');
		}

		if (DBG) {
			sbout.append("time :");
			sbout.append(System.currentTimeMillis() - dStart);
		}
		System.out.print(sbout.toString());

	}

	static class Task {
		int N; // number of people
		int S; // Surprising Triplets;
		int p; // ? of N with best result >= p

		ArrayList<OnePerson> persons = new ArrayList<OnePerson>();
		String original = "";

		public Task(Scanner sc, AllNormal allNormal, AllSurprising allSurprising) {
			N = sc.nextInt();
			S = sc.nextInt();
			p = sc.nextInt();

			original = N + " " + S + " " + p + ", ";
			for (int i = 0; i < N; i++) {
				OnePerson one = new OnePerson(sc.nextInt());
				one.setHowItCan(allNormal, allSurprising, p);
				persons.add(one);
				original += " " + one.sum;
			}
		}

		int getSolution() {
			int canNormal = 0;
			int canWithSurprising = 0;
			for (OnePerson one : persons) {
				if (one.canHaveWithNormal) {
					canNormal++;
				} else {
					if (one.canWithSurprising)
						canWithSurprising++;
				}
			}

			return canNormal + Math.min(canWithSurprising, S);
		}
	}

	static class OnePerson {
		int sum = 0;
		boolean canHaveWithNormal = false; // can have best >= p without
											// surprising rating

		boolean canWithSurprising = false;

		public OnePerson(int sum) {
			this.sum = sum;
		}

		void setHowItCan(AllNormal allNormal, AllSurprising allSurprising, int p) {
			canHaveWithNormal = (allNormal.all.get(this.sum).best >= p);
			canWithSurprising = allSurprising.canBeSurprisingWithBestGreater(
					this.sum, p);
		}

	}

	static class AllNormal {
		HashMap<Integer, NormalRating> all = new HashMap<Integer, Solution.NormalRating>();

		public AllNormal() {
			for (int i = 0; i <= 10; i++) {
				addOne(new NormalRating(3 * i, i, i));
				addOne(new NormalRating(3 * i + 1, i + 1, i));
				addOne(new NormalRating(3 * i - 1, i, i - 1));
				addOne(new NormalRating(3 * i + 2, i + 1, i));
				addOne(new NormalRating(3 * i - 2, i, i - 1));
			}
		}

		void addOne(NormalRating one) {
			if (one.isValid() && !all.containsKey(one.sum)) {
				all.put(one.sum, one);
			}
		}

		void printAll() {
			ArrayList<NormalRating> vals = new ArrayList<Solution.NormalRating>();
			vals.addAll(all.values());
			Collections.sort(vals);
			for (NormalRating one : vals) {
				one.printLn();
			}
		}
	}

	static class NormalRating implements Comparable<NormalRating> {
		int sum = 0;
		int best = 0;
		int min = 0;

		public NormalRating(int sum, int best, int min) {
			this.sum = sum;
			this.best = best;
			this.min = min;
		}

		boolean isValid() {
			return (sum >= 0) && (best >= 0) && (min >= 0) && (best <= 10);
		}

		void printLn() {
			System.out.println("s: " + sum + "  b: " + best + " m: " + min);
		}

		@Override
		public int compareTo(NormalRating other) {
			return (new Integer(sum)).compareTo(new Integer(other.sum));
		}

	}

	static class AllSurprising {
		ArrayList<SurprisingRating> items = new ArrayList<Solution.SurprisingRating>();

		public AllSurprising() {
			for (int i = 0; i <= 8; i++) {
				addOne(new SurprisingRating(3 * i + 2, i + 2));
				addOne(new SurprisingRating(3 * i + 3, i + 2));
				addOne(new SurprisingRating(3 * i + 4, i + 2));

			}
		}

		void addOne(SurprisingRating one) {
			items.add(one);
		}

		boolean canBeSurprisingWithBestGreater(int withsum, int p) {
			for (SurprisingRating rating : items) {
				if (rating.sum == withsum) {
					return (rating.best >= p);
				}
			}

			return false;
		}
	}

	// x x+2 x = 3x +2
	// x x+2 x+1 = 3x +3
	// x x+2 x+2 = 3x +4
	static class SurprisingRating {
		int sum = 0;
		int best = 0;

		public SurprisingRating(int sum, int best) {
			this.sum = sum;
			this.best = best;
		}
	}
}
