import java.util.Scanner;


public class DancingWiththeGooglers {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		int r[] = new int[T];
		
		for (int i = 0; i < T; i++) {		
			int N = sc.nextInt();
			int S = sc.nextInt();
			int p = sc.nextInt();
			for (int j = 0; j < N; j++) {
				int total = sc.nextInt();
				if (total >= p) {
					if ((p*3 - 2) <= total) {
						r[i]++;
					} else if ((p*3 - 4) <= total && S > 0) {
						S--;
						r[i]++;
					}
				}
			}
		}
		
		for (int i = 0; i < r.length; i++) {
			System.out.println("Case #" + (i + 1) + ": " + r[i]);
		}
	}
}