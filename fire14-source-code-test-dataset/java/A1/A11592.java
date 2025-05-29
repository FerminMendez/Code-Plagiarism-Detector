import java.util.*;
import java.io.*;

public class B {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new FileReader(args[0]));
		in.readLine();
		
		String[] segments;
		int[] scores;
		int numCase = 0;
		while (in.ready()) {
			segments = in.readLine().split(" ");
			scores = new int[segments.length - 3];
			for (int i = 0; i < scores.length; ++i) {
				scores[i] = Integer.parseInt(segments[i + 3]);
			}
			solve(++numCase, Integer.parseInt(segments[1]), Integer.parseInt(segments[2]), scores);
		}
	}
	
	private static void solve(int caseNum, int s, int p, int[] scores) {
		int max = 0;
		
		if (p == 0) {
			max = scores.length;
		} else if (p == 1) {
			for (int i = 0; i < scores.length; ++i) {
				if (scores[i] >= 1) {
					++max;
				}
			}
		} else {
			int limit1 = (p - 2) * 3 + 2;
			int limit2 = limit1 + 1;
			
			int needS = 0;
			
			int score;
			for (int i = 0; i < scores.length; ++i) {
				score = scores[i];
				if (score < limit1) {
					continue;
				}
				
				if (score <= limit2) {
					++ needS;
					continue;
				}
				
				++max;
			}
			
			max += Math.min(needS, s);
		}
		
		System.out.printf("Case #%d: %d\n", caseNum, max);
	}
}