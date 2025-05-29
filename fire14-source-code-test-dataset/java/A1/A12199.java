package round1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dancing {

	private int noCases;
	private ArrayList<Case> cases = new ArrayList<Case>();

	private void readFile(String filepath) {
		try {
			Scanner sc = new Scanner(new FileInputStream(new File(filepath)));
			noCases = Integer.parseInt(sc.nextLine());
			for (int i = 1; i <= noCases; i++) {
				String[] line = sc.nextLine().split(" ");
				int N = Integer.parseInt(line[0]);
				int S = Integer.parseInt(line[1]);
				int p = Integer.parseInt(line[2]);
				int[] t = new int[N];
				for (int n = 3; n < line.length; n++) {
					t[n - 3] = Integer.parseInt(line[n]);
				}
				cases.add(new Case(i, S, p, t));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {

		Dancing d = new Dancing();
		d.readFile(args[0]);
		for (Case c : d.cases) {
			System.out.println(c);
		}
	}

	private class Case {
		private int caseID;
		private int noSurprising;
		private int minScore;
		private ArrayList<Score> scores = new ArrayList<Dancing.Case.Score>();

		public Case(int caseID, int noSurprising, int minScore,
				int[] scores) {
			this.caseID = caseID;
			this.noSurprising = noSurprising;
			this.minScore = minScore;

			for (int sc : scores) {
				this.scores.add(new Score(sc));
			}
		}

		private int answer() {
			int ans = 0;
			for (Score sc : scores) {
				if (sc.unsurprising >= minScore) {
					ans++;
					sc.visited = true;
				}
			}
			for (Score sc : scores) {
				if (noSurprising == 0) {
					break;
				}
				if (!sc.visited) {
					if (sc.surprising >= minScore) {
						ans++;
						sc.visited = true;
						noSurprising--;
					}
				}
			}
			return ans;
		}

		@Override
		public String toString() {
			return "Case #" + this.caseID + ": " + this.answer();
		}
		
		private class Score {
			int surprising;
			int unsurprising;
			boolean visited = false;
			
			public Score(int sc) {
				switch(sc % 3) {
				case 0:
					unsurprising = sc / 3;
					surprising = sc / 3 + 1;
					break;
				case 1:
					unsurprising = sc / 3 + 1;
					surprising = sc / 3 + 1;
					break;
				case 2:
					unsurprising = sc / 3 + 1;
					surprising = sc / 3 + 2;
					break;
				}
				if (sc < 2 || sc > 28) {
					surprising = -1;
				}
			}
		}
	}
}