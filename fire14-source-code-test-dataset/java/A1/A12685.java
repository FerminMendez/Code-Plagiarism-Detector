import java.util.Scanner;


public class B_Dancing {

	static boolean enoughNonSurprising(int p, int score) {
		return score >= 3*p-2;
	}
	static boolean enoughSurprising(int p, int score) {
		return score >= 3*p-4;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		boolean firstline = true;
		for (int cas = 1; cas <= T; cas++) {
			int N = in.nextInt();
			int S = in.nextInt();
			int p = in.nextInt();
			int enoughNS = 0;
			int enoughS = 0;
			for (int i = 0; i < N; i++) {
				int score = in.nextInt();
				if (enoughNonSurprising(p,score))
					enoughNS++;
				else if (p > 1 && enoughS < S && enoughSurprising(p,score))
					enoughS++;
			}
			if (firstline)
				firstline = false;
			else
				System.out.println();
			System.out.print("Case #"+cas+": "+(enoughNS+enoughS));
		}
	}

}
