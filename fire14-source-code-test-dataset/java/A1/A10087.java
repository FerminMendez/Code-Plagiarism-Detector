import java.util.Scanner;
public class ProblemB {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		scan.nextLine();
		
		for (int k = 1; k <= T; k++) {
			int N = scan.nextInt();
			int S = scan.nextInt(); //number of surprising triplets
			int p = scan.nextInt(); //target high score
			int solution = 0; //number of high scores over the target
			for (int i = 0; i < N; i++) {
				int t = scan.nextInt();
				if (t >= 3*p - 2) {
					solution++;
				} else if (t >= 3*p - 4 && t > 2 && S > 0) {
					solution++;
					S--;
				}
			}
			System.out.println("Case #" + k + ": " + solution);
		}
	}

}
