import java.util.ArrayList;

public class Recycled
{
	public static void main(String[] args)
	{
		int T = StdIn.readInt();

		for(int tr = 1; tr <= T; tr++)
		{
			int A = StdIn.readInt();
			int B = StdIn.readInt();

			//total num of recycled
			int num = 0;

			for (int i = A; i <= B; i++)
			{
				//converts to string
				String temp = Integer.toString(i);

				//list of recycled numbers given m = i
				ArrayList<Integer> reNum = new ArrayList<Integer>();

				//for each shift
				for(int ind = 1; ind < temp.length(); ind++)
				{
					String first = temp.substring(0,ind);
					String last = temp.substring(ind);

					String shift = last + first;
					int shiftNum = Integer.parseInt(shift);

					if (shiftNum <= i || shiftNum > B)
						continue;

					if (reNum.indexOf(shiftNum) < 0)
					{
						reNum.add(shiftNum);
					}
				}

				num += reNum.size();
			}

			StdOut.println("Case #" + tr + ": " + num);
		}
	}
}
