import java.util.*;
import java.io.*;

public class Dancing {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();

		for (int i = 1; i<=cases; i++) {
			int n = in.nextInt(); // number of googlers
			int s = in.nextInt(); // number of surprising triplets
			int p = in.nextInt(); // ??
			
			int[] points = new int[n];
			for (int j = 0; j<n; j++)
				points[j] = in.nextInt();

			// lowest possible unsurprising triplet:
			// p, p-1, p-1

			// lowest possible surprising triplet:
			// p, p-2, p-2

			int answer = 0;
			int possible = 0;
			int lowUn = lowestUnsurprising(p);
			int lowSu = lowestSurprising(p);
			for (int j = 0; j<n; j++) {
				if (points[j] >= lowUn) answer++;
				else if (points[j] >= lowSu) possible++;
			}

			answer += Math.min(possible, s);
			System.out.println("Case #"+i+": "+answer);
		}
	}

	public static int lowestUnsurprising(int p) {
		return p + (Math.max(p-1, 0))*2;
	}

	public static int lowestSurprising(int p) {
		return p + (Math.max(p-2, 0))*2;
	}
}
