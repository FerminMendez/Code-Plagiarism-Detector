import java.util.Scanner;


public class B {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new B();
	}
	
	int[] notSurprising;
	int[] surprising;
	
	public B()
	{
		notSurprising = new int[31];
		surprising = new int[31];
		
		for(int i = 2; i <= 30; ++i)
		{
			notSurprising[i] = i / 3 + (i % 3 == 0 ? 0 : 1);
			surprising[i] = i / 3 + (i % 3 == 2 ? 2 : 1);
		}
		
		Scanner sc = new Scanner(System.in);
		
		int testCases = sc.nextInt();
		
		for(int testCase = 1; testCase <= testCases; ++testCase)
		{
			int N = sc.nextInt();
			int S = sc.nextInt();
			
			int p = sc.nextInt();
			
			int result = 0;
			
			for(int googler = 0; googler < N; ++googler)
			{
				int score = sc.nextInt();

				if(notSurprising[score] >= p)
				{
					result++;
				}
				else if(S > 0 && surprising[score] >= p)
				{
					result++;
					S--;
				}
			}
			
			System.out.printf("Case #%d: %d\n", testCase, result);
		}
	}
}
