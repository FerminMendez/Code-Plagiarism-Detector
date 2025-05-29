import java.util.Scanner;


public class Dancing {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int C=1;C<=N;C++)
		{
			System.out.printf("Case #%d: ", C);
			int n = sc.nextInt();
			int s = sc.nextInt();
			int p = sc.nextInt();
			int count = 0;
			for (int i=0;i<n;i++)
			{
				int score = sc.nextInt();
				if (score/3>=p || (score/3==p-1 && score%3>0)) count ++;
				else if (((score/3==p-1) || (score/3==p-2 && score%3==2 && p-2>=0)) && s>0 && score/3-1>=0)
				{
					s--;
					count ++;
				}
			}
			System.out.println(count);
		}
	}
}
