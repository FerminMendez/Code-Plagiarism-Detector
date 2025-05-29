import java.util.Scanner;

public class Test2
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		int num = Integer.parseInt(keyboard.nextLine());
		String[] input = new String[num];
		String tmp = "";

		int N = 0;
		int S = 0;
		int P = 0;

		int[] out = new int[num];

		for (int i = 0; i < num; i++)
		{
			input[i] = keyboard.nextLine();
			String[] split = input[i].split(" ");
			N = Integer.parseInt(split[0]); // numbers
			S = Integer.parseInt(split[1]); // surprise
			P = Integer.parseInt(split[2]); // at least
			int[] nums = new int[N];
			for (int j = 0; j < N; j++)
			{
				nums[j] = Integer.parseInt(split[j + 3]);
			}
			int count = 0;
			for (int j = 0; j < N; j++)
			{
				if (P == 0)
				{
					count++;
				}
				else if (nums[j] >= (P * 3 - 2))
				{
					count++;
				}
				else if(nums[j] > 0)
				{
					if (P == 1 && nums[j] >= 3)
					{
						count++;
					}
					else if ((nums[j] - P) >= ((P - 2) * 2))
					{
						if (S > 0)
						{
							S--;
							count++;
						}
					}
				}
			}
			out[i] = count;
		}
		// for(int j=0;j<N;j++)
		// System.out.print(nums[j]+ " ");
		// System.out.println();
		for (int i = 0; i < out.length; i++)
		{
			System.out.println("Case #" + (i + 1) + ": " + out[i]);
		}
	}
}
