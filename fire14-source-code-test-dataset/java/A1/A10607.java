import java.util.Scanner;


public class B {

	void run() {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t=1; t<=T; t++) {
			int N = in.nextInt();
			int S = in.nextInt();
			int p = in.nextInt();
			int[][] dp = new int[N+1][N+1];
			for (int i=0; i<N; i++) {
				int pt = in.nextInt();
				int sup, nsup;
				boolean supflg = true;
				if (pt >= 29 || pt <= 1) supflg = false;
				/*if (pt >= p*3) {
					nsup = 3;
				} else if (pt >= p*3-1) {
					nsup = 2;
				} else*/ if (pt >= p*3-2) {
					nsup = 1;
				} else {
					nsup = 0;
				}
				/*if (pt >= p*3+2) {
					sup = 3;
				} else if (pt >= p*3-2) {
					sup = 2;
				} else*/ if (pt >= p*3-4) {
					sup = 1;
				} else {
					sup = 0;
				}
				for (int j=0; j<=i; j++) {
					dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j] + nsup);
					if (supflg)
						dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j] + sup);
				}
			}
			System.out.println("Case #" + t + ": " + dp[N][S]);
		}
	}

	public static void main(String[] args) {
		B obj = new B();
		obj.run();
	}
}
