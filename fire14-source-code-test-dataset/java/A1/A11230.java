package codejam2012;

import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class DancingWithTheGooglers {

	public static int testGoal(int value, int goal) {
		int modResult = value % 3;
		int divResult = value / 3;
		/*
		 * x%3=0:(NS)x/3,(S)x/3+1;x%3=1:(NS)x/3+1,(S)x/3+1;x%3=2:(NS)x/3+1,(S)x/3
		 * +2;
		 */
		int nonSurpriseMax = (modResult == 0) ? divResult : (divResult + 1);
		int surpriseMax = (modResult <= 1) ? (divResult + 1) : (divResult + 2);
		surpriseMax = Math.min(10, surpriseMax);
		// some special checking
		if (value <= 1) {
			// no surprise
			surpriseMax = 0;
		}
		int goalResult = 0;
		if (nonSurpriseMax >= goal)
			goalResult++;
		if (surpriseMax >= goal)
			goalResult++;
		System.out.println(value + " : " + goalResult);
		return goalResult;
	}

	public static int eval(int supprise, int goal, int[] scores) {
		System.out.println("=== G:" + goal + " S:" + supprise + " - "
				+ Arrays.toString(scores));
		int[] goalTesting = new int[3];
		for (int score : scores) {
			goalTesting[testGoal(score, goal)]++;
		}
		System.out.println("--- " + Arrays.toString(goalTesting) + " => "
				+ (goalTesting[2] + Math.min(supprise, goalTesting[1])));
		return goalTesting[2] + Math.min(supprise, goalTesting[1]);
	}

	public static void main(String[] args) throws Exception {
		PrintWriter output = new PrintWriter("output2.txt");
		Scanner scanner = new Scanner(new File("input2.txt"));
		try {
			int input_T = scanner.nextInt();
			for (int i = 0; i < input_T; i++) {
				int input_N = scanner.nextInt();
				int input_S = scanner.nextInt();
				int input_p = scanner.nextInt();
				int[] scores = new int[input_N];
				for (int j = 0; j < input_N; j++) {
					scores[j] = scanner.nextInt();
				}
				output.printf("Case #%d: %d\n", i + 1,
						eval(input_S, input_p, scores));
			}
		} finally {
			output.close();
			scanner.close();
		}
	}

}
