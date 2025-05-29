import java.util.Scanner;
public class Dancing {
	private static boolean isValidScore(int score) {
		return score >=0 && score <= 10;
	}
	private static boolean canReach (int tot, int p, boolean canSurprise) {
		int n = tot / 3;
		int a,b,c;
		a = n;
		b = n;
		c = tot - a - b;
		int max = -1;
		if (a==c) {
			//a-1, a, a+1
			if (isValidScore(a-1) && isValidScore(a) && isValidScore(a+1) && canSurprise) {
				max = a+1;
			}
			//a, a, a
			else if (isValidScore(a)) max = a;
		}
		if (a+1 == c) {
			//a, a, a+1
			if (isValidScore(a) && isValidScore(a+1)) max = a+1;
		}
		if (a+2 == c) {
			//a, a, a+2
			if (isValidScore(a) && isValidScore(a+2) && canSurprise) max = a+2;
			//a, a+1, a+1
			else if (isValidScore(a) && isValidScore(a+1)) max = a+1;
		}
		return max >= p;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i=0; i < T; i++) {
			int N = in.nextInt();
			int S = in.nextInt();
			int p = in.nextInt();
			int numCanReach = 0;
			for (int j=0; j < N; j++) {
				int tot = in.nextInt();
				if (canReach(tot, p, false)) numCanReach++;
				else if (canReach(tot,p, true) && S != 0) {
					numCanReach++;
					S--;
				}
			}
			System.out.println("Case #"+(i+1)+": "+numCanReach);
		}
	}
}
