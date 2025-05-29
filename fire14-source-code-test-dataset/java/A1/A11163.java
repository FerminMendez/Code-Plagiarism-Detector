import java.io.*;
import java.util.*;

public class ProblemB {

    private static final int[] bestSurprise = new int[31];
    private static final int[] bestBoring = new int[31];

    private static void seed() {
	Arrays.fill(bestSurprise, -1);
	Arrays.fill(bestBoring, -1);
	for (int i = 0; i <= 10; i++) {
	    for (int j = Math.max(0, i - 2); (j <= i + 2) && (j <= 10); j++) {
		for (int k = Math.max(0, i - 2); (k <= i + 2) && (k <= 10); k++) {
		    if (Math.abs(k - i) > 2 || Math.abs(k - j) > 2 || Math.abs(i - j) > 2) {
			continue;
		    }
		    int total = i + j + k;
		    int max = Math.max(i, Math.max(j, k));
		    if (Math.abs(k - i) == 2 || Math.abs(k - j) == 2 || Math.abs(i - j) == 2) {
			bestSurprise[total] = Math.max(bestSurprise[total], max);
		    } else {
			bestBoring[total] = Math.max(bestBoring[total], max);
		    }
		}
	    }
	}
    }


    public static int solve(int[] scores, int S, int P) {
	int[][] history = new int[scores.length + 1][S + 1];
	for (int[] cases : history) {
	    Arrays.fill(cases, -1);
	}
	return solve(scores, 0, S, P, history);
    }

    private static int solve(int[] scores, int index, int S, int P, int[][] history) {
	if (index >= scores.length) {
	    if (S > 0) {
		return -1;
	    } else {
		return 0;
	    }
	} else if (S < 0) {
	    return -1;
	} else if (history[index][S] != -1) {
	    return history[index][S];
	}
	int best = -1;
	if (S > 0 && bestSurprise[scores[index]] != -1) {
	    int surpriseAttempt = solve(scores, index + 1, S - 1, P, history);
	    if (surpriseAttempt != -1) {
		best = Math.max(best, surpriseAttempt + (bestSurprise[scores[index]] >= P ? 1 : 0));
	    }
	}
	if (bestBoring[scores[index]] != -1) {
	    int boringAttempt = solve(scores, index + 1, S, P, history);
	    if (boringAttempt != -1) {
		best = Math.max(best, boringAttempt + (bestBoring[scores[index]] >= P ? 1 : 0));
	    }
	}
	history[index][S] = best;
	return best;
    }

    public static void main(String[] args) throws Exception {
	seed();
	Scanner input = new Scanner(System.in);
	int T = Integer.parseInt(input.nextLine().trim());
	for (int i = 0; i < T; i++) {
	    String[] tokens = input.nextLine().split(" ");
	    int N = Integer.parseInt(tokens[0].trim());
	    int S = Integer.parseInt(tokens[1].trim());
	    int P = Integer.parseInt(tokens[2].trim());
	    int[] scores = new int[N];
	    for (int j = 0; j < N; j++) {
		scores[j] = Integer.parseInt(tokens[3 + j].trim());
	    }
	    System.out.println("Case #" + (i+1) + ": " + solve(scores, S, P));
	}
    }
}