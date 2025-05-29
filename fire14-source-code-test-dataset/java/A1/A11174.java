import java.util.*;

public class ProblemB {
	public static void main(String[] args) {
		System.out.println("Enter input for case:");
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		int[] nt = new int[T];
		int[] st = new int[T];
		int[] pt = new int[T];
		int[][] ni = new int[T][];
		for (int t = 0; t < T; t++) {
			nt[t] = sc.nextInt();
			st[t] = sc.nextInt();
			pt[t] = sc.nextInt();
			ni[t] = new int[nt[t]];
			for (int j = 0; j < nt[t]; j++)
				ni[t][j] = sc.nextInt();
			sc.nextLine();
		}
		
		
		for (int t = 1; t <= T; t++) {
			int n = nt[t-1]; //number of Googlers
			int s = st[t-1]; //number of surprising triplets of scores
			int p = pt[t-1]; //minimum best result
			int sUsedUp = 0;
			int result = 0;
			
			for (int totalPoints : ni[t-1]) {
				if (totalPoints >= p*3 - 2)
					result++;
				if (p > 1)
					if (totalPoints == p*3 - 4 || totalPoints == p*3 - 3)
						if (sUsedUp < s) {
							result++;
							sUsedUp++;
						}
			}
			
			System.out.println("Case #" + t +": " + result);
		}
		
		

	}

}
