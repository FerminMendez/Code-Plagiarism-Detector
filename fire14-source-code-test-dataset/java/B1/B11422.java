package fun.codeslam.recycling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main
{
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		Integer testCaseCount = Integer.parseInt(reader.readLine());

		for (Integer testCaseNumber = 1; testCaseNumber <= testCaseCount; testCaseNumber++)
		{
			String[] elements = reader.readLine().split(" ");
			System.out.append("Case #" + testCaseNumber + ": ");
			System.out.append(numberOfReyclingsInRange(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]))
					.toString());
			System.out.append('\n');
		}
	}

	private static Integer numberOfReyclingsInRange(Integer min, Integer max)
	{
		Integer numberOfReyclings = 0;
		for (Integer number = min; number <= max; number++)
		{
			numberOfReyclings += numberOfReyclings(number, max);
		}
		return numberOfReyclings;
	}

	private static Integer numberOfReyclings(Integer number, Integer max)
	{
		Map<Integer, Boolean> isset = new HashMap<Integer, Boolean>();

		Integer numberOfReyclings = 0;
		Integer length = number.toString().length();

		for (Integer beginIndex = 1; beginIndex < length; beginIndex++)
		{
			String endPart = number.toString().substring(beginIndex);
			String frontPart = number.toString().substring(0, beginIndex);
			Integer newNumber = Integer.parseInt(endPart + frontPart);

			if (newNumber.toString().length() == number.toString().length() && number < newNumber && newNumber <= max
					&& isset.get(newNumber) == null)
			{
				isset.put(newNumber, true);
				numberOfReyclings++;
			}
		}

		return numberOfReyclings;
	}
}
