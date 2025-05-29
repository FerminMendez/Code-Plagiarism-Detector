

import java.util.Scanner;

public class B {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int S = sc.nextInt();
			int p = sc.nextInt();
			int t[] = new int[N];
			for (int j = 0; j < N; j++) {
				t[j] = sc.nextInt();
			}
			
			int count = 0;
			for (int j = 0; j < N; j++) {
				int r = t[j] - p;
				if(r >= 2*Math.max(0, p-1))
					++count;
				else if(S > 0 && r >= 2*Math.max(0, p-2)) {
					++count;
					--S;
				}
			}
			System.out.println("Case #" + i + ": " + count);
		}
	}

}
