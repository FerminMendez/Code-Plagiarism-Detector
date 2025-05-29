import java.util.Scanner;

/*
 * Google Code Jam 2012
 * Program by Tommy Ludwig
 * Problem: Dancing With the Googlers
 * Date: 2012-04-13
 */


public class dancing {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T, N, S, p;
		T = in.nextInt();
		
		for (int i = 1; i <= T; i++) {
			int y = 0;
			N = in.nextInt();
			S = in.nextInt();
			p = in.nextInt();
			int [] t = new int[N];
			
			for (int j = 0; j < N; j++) 
				t[j] = in.nextInt();
			
			//minimum number with surprise case
			int minNumS = (3 * p) - 4;
			if (minNumS < 2) minNumS = 2;
			//minimum number without surprise case
			int minNum = (3 * p) - 2;
			//if (minNum < 0) minNum = 0;
			
			for (int j = 0; j < N; j++) {
				if (t[j] >= minNum)
					y++;
				else if (t[j] >= minNumS && S > 0) {
					y++;
					S--;
				}
			}
			System.out.printf("Case #%d: %d\n", i, y);
		}
	}

}
