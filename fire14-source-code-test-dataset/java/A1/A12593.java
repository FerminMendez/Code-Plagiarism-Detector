import java.util.Scanner;

public class B {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt(); in.nextLine();		
		
		//build auxiliary arrays
		int[] without = new int[31];
		int[] with = new int[31];
		for (int i = 0; i <= 30; i++)
		{
			without[i] = (int)Math.ceil((double)i/3.0);
			
			if (i == 0) with[i] = 0;
			else with[i] = (int)Math.min(10, Math.ceil(((double)i+2.0)/3.0));
		}	
		
		//for each test case
		for (int i = 1; i <= T; i++)
		{
			int N = in.nextInt();
			int S = in.nextInt();
			int p = in.nextInt();
			
			int result = 0;
			
			for (int j = 0; j < N; j++)
			{
				int tp = in.nextInt();
				
				if (without[tp] >= p) result++;
				else if (with[tp] >= p && S > 0)
				{
					result++;
					S--;
				}
			}			
			
			System.out.format("Case #%d: %d\n", i, result);
		}
	}
}