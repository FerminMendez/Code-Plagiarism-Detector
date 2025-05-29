package qualification;

import java.util.ArrayList;

import utils.IOHelper;
import utils.Pair;

public class RecycledNumbers
{
	public static void main(String[] args)
	{
		try
		{
			String[] input = IOHelper.readFile(args[0]);
			int[] results = new int[input.length];

			for (int line = 0; line < input.length; line++)
			{
				String curLine = input[line];
				String[] token = curLine.split(" ");

				int a = Integer.parseInt(token[0]);
				int b = Integer.parseInt(token[1]);
				ArrayList<Pair<Integer, Integer>> recycledNumbers = new ArrayList<Pair<Integer, Integer>>();

				for (int i = a; i < b; i++)
				{
					String number = Integer.toString(i);
					for (int j = 1; j < number.length(); j++)
					{
						String candidate = number.substring(j) + number.substring(0, j);
						int candidateAsNumber = Integer.parseInt(candidate);

						if (candidateAsNumber > i && candidateAsNumber <= b)
						{
							Integer recycledNumber = new Integer(candidateAsNumber);
							if (!recycledNumbers.contains(recycledNumber))
							{
								recycledNumbers.add(new Pair(i, recycledNumber));
							}
						}
					}
				}

				for (Pair<Integer, Integer> pair : recycledNumbers)
				{
					System.err.println(a + " <= " + pair.a + " < " + pair.b + " <= " + b);
				}

				results[line] = recycledNumbers.size();
			}

			IOHelper.writeFile(args[0].replace(".in", ".out"), results);
		}
		catch (IndexOutOfBoundsException e)
		{

		}
	}
}
