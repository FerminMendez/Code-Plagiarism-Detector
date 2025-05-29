package contest.googlejam;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import contest.ContestProblem;
import contest.Input;

// http://code.google.com/codejam/africa_arabia/contests.html

public class Qualifier2012 {
	public static void main(String[] args) {
		ContestProblem problem = codeJam2012_Qualification_B;
		File folder = new File("C:\\Users\\Admin\\Desktop\\GoogleJam Tests\\2012\\Qualification Round\\");

		File test = new File(folder, "test.txt");
		File small = new File(folder, "B-small-attempt0.in");
		File large = new File(folder, "");

		// ContestProblem.runProblem(problem.setInputFile(test).calcOutputFromInput());
		ContestProblem.runProblem(problem.setInputFile(small).calcOutputFromInput());
		// ContestProblem.runProblem(problem.setInputFile(large).calcOutputFromInput());
	}

	// Problem B. Dancing With the Googlers
	static ContestProblem codeJam2012_Qualification_B = new ContestProblem() {
		final int maxDiff = 2;

		@Override
		public void parseInput(Input in, PrintWriter out) {
			int cases = in.readInt();
			for (int caseNum = 1; caseNum <= cases; caseNum++) {
				List<Integer> input = in.readIntList();
				int numGooglers = input.get(0);
				int numSurprises = input.get(1);
				int p = input.get(2);
				List<Integer> totalPoints = input.subList(3, 3 + numGooglers);

				int goodScore = 0;
				int onlySurprises = 0;
				for (Integer total : totalPoints) {
					int avg = total / 3;
					int normal = 0;
					int surprises = 0;
					for (int a = avg - maxDiff; a <= avg + maxDiff; a++) {
						for (int b = avg - maxDiff; b <= avg + maxDiff; b++) {
							for (int c = avg - maxDiff; c <= avg + maxDiff; c++) {
								if (a + b + c != total) {
									// System.out.format("%d + %d + %d != %d%n", a, b, c, total);
									continue;
								}

								int min = Math.min(Math.min(a, b), c);
								int max = Math.max(Math.max(a, b), c);

								if (min < 0)
									continue;

								if (max >= p) {
									int diff = max - min;
									if (diff == 2) {
										surprises++;
										System.out.format("%d + %d + %d = %d (Surprise)%n", a, b, c, total);
									} else if (diff == 0 || diff == 1) {
										normal++;
										System.out.format("%d + %d + %d = %d%n", a, b, c, total);
									} else {
										// System.out.format("diff (%d + %d + %d) > %d%n", a, b, c, maxDiff);
									}
								} else {
									// System.out.format("max (%d + %d + %d) < %d%n", a, b, c, p);
								}
							}
						}
					}

					if (normal == 0 && surprises > 0) {
						onlySurprises++;
						System.out.format("    %d is onlySurprise%n", total);
					} else if (normal > 0) {
						goodScore++;
					} else {
						System.out.format("    %d failed%n", total);
					}

				}

				System.out.format("goodScores = %d%n", goodScore);
				System.out.format("onlySurprises = %d%n", onlySurprises);
				System.out.format("numSurprises = %d%n", numSurprises);
				int maxPossible = goodScore;
				if (numSurprises > onlySurprises) {
					maxPossible += onlySurprises;
				} else {
					maxPossible += Math.min(numSurprises, onlySurprises);
				}

				out.print(String.format("Case #%d: %s%n", caseNum, maxPossible));
			}
		}

	};

	// Problem A. Speaking in Tongues
	static ContestProblem codeJam2012_Qualification_A = new ContestProblem() {
		Map<Character, Character> charMap = new HashMap<>();

		@Override
		public void parseInput(Input in, PrintWriter out) {
			charMap.put(' ', ' ');
			charMap.put('a', 'y');
			charMap.put('b', 'h');
			charMap.put('c', 'e');
			charMap.put('d', 's');
			charMap.put('e', 'o');
			charMap.put('f', 'c');
			charMap.put('g', 'v');
			charMap.put('h', 'x');
			charMap.put('i', 'd');
			charMap.put('j', 'u');
			charMap.put('k', 'i');
			charMap.put('l', 'g');
			charMap.put('m', 'l');
			charMap.put('n', 'b');
			charMap.put('o', 'k');
			charMap.put('p', 'r');
			charMap.put('q', 'z');
			charMap.put('r', 't');
			charMap.put('s', 'n');
			charMap.put('t', 'w');
			charMap.put('u', 'j');
			charMap.put('v', 'p');
			charMap.put('w', 'f');
			charMap.put('x', 'm');
			charMap.put('y', 'a');
			charMap.put('z', 'q');

			int cases = in.readInt();
			for (int caseNum = 1; caseNum <= cases; caseNum++) {
				String input = in.readStr();
				String output = "";

				for (int i = 0; i < input.length(); i++) {
					output += charMap.get(input.charAt(i));
				}

				out.print(String.format("Case #%d: %s%n", caseNum, output));
			}
		}

	};
}
