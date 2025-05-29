
public class Dancing
{
	public static void main(String[] args)
	{
		int T = StdIn.readInt();

		for (int tr = 1; tr <= T; tr++)
		{
			int N = StdIn.readInt();
			int S = StdIn.readInt();
			int p = StdIn.readInt();

			int numP = 0;
			int numS = 0;

			for (int i = 0; i < N; i++)
			{
				int tripSum = StdIn.readInt();
				int doubSum = tripSum - p;

				if(p == 0)
				{
					numP++;
					continue;
				}


				if (doubSum >= 2*(p-1))
					numP++;
				else if (doubSum >= 2*(p-2) && p > 1)
					numS++;
			}

			int total = numP + Math.min(numS, S);

			StdOut.println("Case #" + tr + ": " + total);
		}
	}
}
