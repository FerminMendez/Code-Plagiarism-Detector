import java.util.Scanner;


public class B {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T ; i++)
		{
			int N = sc.nextInt();
			int S = sc.nextInt();
			int P = sc.nextInt();
			int tCounter = 0;
			int tCount = 0;

			for (int j = 0; j < N; j++)
			{
				int num = sc.nextInt();
				if (num >= P * 3 -2 )
				{
					tCount ++;
				} 
				else if ((P * 3)-num > 4)
				{				
					continue;
				}
				else
				{
					if(num == 0 || tCounter == S)
						continue;
					else
					{
						tCount ++;
						tCounter ++;
					}
				}
			}
			System.out.format("Case #%d: %d\n",i+1,tCount);
		}

	}

}
