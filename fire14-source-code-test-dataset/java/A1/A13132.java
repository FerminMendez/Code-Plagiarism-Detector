import java.util.*;

public class B {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		int N, S, p;

		for (int x = 1; x <= T; x++) {
			N = in.nextInt();
			S = in.nextInt();
			p = in.nextInt();

			int[] t = new int[N];
			int y = 0;

			for (int i = 0; i < N; i++) {
				t[i] = in.nextInt();

				int k = t[i] / 3;
				int j1 = -1, j2 = -1, j3 = -1;
 
				// not surprising triplets
				if ((k + 1) + (k + 1) + k == t[i]) {
					j1 = k + 1;
					j2 = k + 1;
					j3 = k;
				}

				else if ((k + 1) + k + k == t[i]) {
					j1 = k + 1;
					j2 = k;
					j3 = k;
				}

				else if (3 * k == t[i]) {
					j1 = k;
					j2 = k;
					j3 = k;
				}

				if (j1 >= p || j2 >= p || j3 >= p) {
					y++;
					continue;
				}

				if(S==0) continue;
				
				// surprising triplets
				if (k != 9 && (k + 2) + k + k == t[i]) {
					j1 = k + 2;
					j2 = k;
					j3 = k;
				} else if (k != 0 && ((k + 1) + (k + 1) + (k - 1) == t[i])) {
					j1 = k + 1;
					j2 = k + 1;
					j3 = k - 1;
				} else if (k != 0 && ((k + 1) + k + (k - 1) == t[i])) {
					j1 = k + 1;
					j2 = k;
					j3 = k - 1;
				}
				
				if (j1 >= p || j2 >= p || j3 >= p) {
					y++;
					S--;
					continue;
				}

			}

			System.out.println("Case #" + x + ": " + y);
		}
	}
}
