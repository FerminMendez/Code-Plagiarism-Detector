import java.util.*;
public class B {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		for (int t = 1; t <= T; ++t)
		{
			int N = in.nextInt();
			int S = in.nextInt();
			int P = in.nextInt();
			
			int withoutS = 0;		// those that got it without an S
			int withS = 0;			// those that need an S
			for (int n = 0; n < N; ++n)
			{
				int val = in.nextInt();
				if (val/3 >= P || (val/3 == P-1 && val%3 != 0)) ++withoutS;
				else if (!(val/3 == 0 && val%3 <= 1) && ((val/3 == P-1 && val%3 == 0) || (val/3 == P-2 && val%3 == 2))) ++withS;
			}
			
			int ans = withoutS + Math.min(withS, S);
			System.out.printf("Case #%d: %d\n", t, ans);
		}
	}
}

/*

4
3 1 5 15 13 11
3 0 8 23 22 21
2 1 1 8 0
6 2 8 29 20 8 18 18 21

*/
