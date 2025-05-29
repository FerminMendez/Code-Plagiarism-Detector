import java.util.Scanner;


public class B {

	static Scanner in = new Scanner(System.in);

	int solve() {
		int N = in.nextInt();
		int S = in.nextInt();
		int p = in.nextInt();
		
		int yesLimit = p + 2 * Math.max(0, p-1);
		int maybeLimit = p + 2 * Math.max(0, p-2);
		
		int yes = 0;
		int maybe = 0;

		for (int i=0; i<N; ++i) {
			int totalPoints = in.nextInt();
			if (totalPoints >= yesLimit) {
				++yes;
			} else if (totalPoints >= maybeLimit) {
				++maybe;
			}
		}
		
		return yes + Math.min(S, maybe);
	}
	
	
	public static void main(String[] args) {
		int T = in.nextInt();
		for (int i=1; i<=T; ++i) {
			int ans = new B().solve();
			System.out.println("Case #" + i + ": " + ans);
		}

	}

}
