import java.util.Scanner;

public class Dancing {
	private static Scanner stdIn = new Scanner(System.in);
	
	public static void getMax(int arr[])
	{
		for (int i = 0; i < arr.length; i++)
		{
			int t = arr[i];
			if ((t % 3) == 0)
			{
				arr[i] = t / 3;
			} else
			{
				arr[i] = (t / 3) + 1;
			}
		}
	}

	public static int howMany(int scores[], int surprising, int p)
	{
		int total = 0;
		
		getMax(scores);
		
		for (int i = 0; i < scores.length; i++)
		{
			int t = scores[i];
			
			if (t >= p)
			{
				total++;
			} else if ((surprising > 0) && (t == (p - 1)) && (t > 0))
			{
				total++;
				surprising--;
			}
		}

		return total;
	}

	public static void main(String args[])
	{
		int T; // number of test cases
		int caseNo = 1; // number of current case

		// scan number of test cases
		T = stdIn.nextInt();

		// while there's cases to process
		while (T-- != 0)
		{
			// case variables
			int N, S, p;
			int scores[]; // array to hold scores

			// read variables
			N = stdIn.nextInt();
			S = stdIn.nextInt();
			p = stdIn.nextInt();
			scores = new int[N];

			// read scores
			for (int i = 0; i < N; i++)
			{
				scores[i] = stdIn.nextInt();
			}					

			// print results
			System.out.println("Case #" + caseNo++ + ": " + howMany(scores, S, p));
		}
	}
}
