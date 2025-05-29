import java.util.Scanner;


public class Dancing {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++)
		{
			int N = sc.nextInt();
			int S = sc.nextInt();
			int p = sc.nextInt();
			// int [] score = new int[N];
			int numPass = 0;
			for(int j=0; j<N; j++)
			{
				int score = sc.nextInt();
				int normalMax = (score + 2) / 3;
				if (normalMax >= p) numPass++;
				else if(normalMax + 1 == p)
				{
					if(S > 0 && ((score % 3) != 1) && score != 0)
					{
						S--;
						numPass++;
					}
				}
			}

			System.out.println("Case #" + (i+1) + ": " + numPass);
		}
	}
}
