import java.util.Scanner;

public class Q2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int ncases = Integer.parseInt(in.nextLine());
		for(int q = 1; q <= ncases; q++) {
			System.out.print("Case #" + q + ": ");
			int n = in.nextInt();
			int s = in.nextInt();
			int p = in.nextInt();
			int total = 0;
			for(int i = 0; i < n; i++) {
				int t = in.nextInt();
				int noSurprise = (int) Math.ceil((double) t / 3);
				if(noSurprise >= p) {
					total++;
					continue;
				}
				if(s > 0 && (t != 0) && (t < 28) && (t % 3 == 0 || t % 3 == 2)) {
					if(noSurprise + 1 >= p) {
						total++;
						s--;
						continue;
					}
				}
			}
			System.out.println(total);
		}
	}
}
