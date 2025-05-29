package codejam.contest;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Vector;

public class ProblemB
{
	public static void main(String[]arg)
	{
		try
		{
			FileInputStream fInputStream = new FileInputStream(arg[0]);
			DataInputStream in = new DataInputStream(fInputStream);
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String strLine;
			int i = 0;
			while ((strLine = reader.readLine()) != null)
			{

				if (i > 0)
				{
					String[] arrString = strLine.split(" ");

					System.out.println("Case #" + i + ": " + getResult(arrString));
				}

				i++;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private static int getResult(String[] arrValues)
	{
		int result = 0;
		int numGooglers = Integer.parseInt(arrValues[0]);
		int numSurprise = Integer.parseInt(arrValues[1]);
		int numResult   = Integer.parseInt(arrValues[2]);

		Vector vctScores = new Vector();
		for (int i = 3; i < arrValues.length; i++)
 		{
			int score = Integer.parseInt(arrValues[i]);
			vctScores.add(getSubScores(score));
		}

		result = getBestResult(vctScores, numSurprise, numResult);

		return result;
	}

	private static Vector getSubScores(int value)
	{
		int score1 = value / 3;
		int score2 = value / 3;
		int score3 = value / 3;

		if (value % 3 == 1)
			score1++;
		else if (value % 3 == 2)
		{
			score1++;
			score2++;
		}

		Vector vctResult = new Vector();
		vctResult.add(score1);
		vctResult.add(score2);
		vctResult.add(score3);

		return vctResult;
	}

	private static int getBestResult(Vector vct, int numSurp, int numScore)
	{
		int result = 0;

		for (int i = 0; i < vct.size(); i++)
		{
			Vector score = (Vector) vct.elementAt(i);
			int elem1 = (Integer) score.elementAt(0);
			int elem2 = (Integer) score.elementAt(1);
			int elem3 = (Integer) score.elementAt(2);

			if (numScore == 0)
				result++;
			else if (elem1 != 0)
			{
				if (((elem1 == numScore - 1 && numSurp > 0) && ((elem2 != elem3) || ((elem1 == elem2) && (elem2 == elem3)))))
				{
					numSurp--;
					result++;
				}
				else if (elem1 >= numScore)
					result++;
			}
		}

		return result;
	}
}
