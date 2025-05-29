import java.util.*;

public class Dancing {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt(), N, S, p, total;
		int[] scores;
		String output = "";

		for (int i = 0; i < T; i++) {
			N = in.nextInt();
			S = in.nextInt();
			p = in.nextInt();
			
			scores = new int[N];
			for (int j = 0; j < N; j++)
				scores[j] = in.nextInt();
			Arrays.sort(scores);
			
			total = 0;
			for (int j = N-1; j >= 0; j--) {
				if (p == 0)
					total++;
				else if (scores[j] == 0)
					continue;
				else if (scores[j]/3 >= p || (scores[j]/3 == p - 1 && scores[j]%3 > 0))
					total++;
				else if (S > 0 && (scores[j]/3 == p - 1 || (scores[j]/3 == p - 2 && scores[j]%3 == 2))) {
					S--;
					total++;
				}
			}
			if (p > 10)
				total = 0;
			output += "Case #" + (i+1) + ": " + total + "\n";
		}
		System.out.print(output);
	}
}
