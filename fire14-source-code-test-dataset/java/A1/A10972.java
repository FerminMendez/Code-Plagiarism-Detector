import java.util.Scanner;

public class DancingWithTheGooglers
{
	public static void main(String[] args)
	{
		Scanner read = new Scanner(System.in);
		int[] scores = null;
		int cases = 0;
		int googlers = 0;
		int suprising = 0;
		int least = 0;
		int num = 0;

		cases = read.nextInt();
		for (int i = 0; i < cases; i++)
		{
			num = 0;
			googlers = read.nextInt();
			suprising = read.nextInt();
			least = read.nextInt();
			scores = new int[googlers];
			for (int j = 0; j < scores.length; j++)
				scores[j] = read.nextInt();

			if (least == 0)
				System.out.println("Case #" + (i + 1) + ": " + googlers);
			else
			{
				for (int j = 0; j < scores.length; j++)
				{
					if (scores[j] % 3 == 2)
					{
						if (scores[j] / 3 + 1 >= least)
							num++;
						else if (scores[j] / 3 + 2 >= least && suprising > 0)
						{
							num++;
							suprising--;
						}
					}
					else if (scores[j] % 3 == 1)
					{
						if (scores[j] / 3 + 1 >= least)
							num++;
					}
					else if (scores[j] != 0)
					{
						if (scores[j] / 3 >= least)
							num++;
						else if (scores[j] / 3 + 1 >= least && suprising > 0)
						{
							num++;
							suprising--;
						}
					}
				}
				System.out.println("Case #" + (i + 1) + ": " + num);
			}
		}
	}
}