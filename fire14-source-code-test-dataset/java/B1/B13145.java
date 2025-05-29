package codejam.contest;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ProblemC
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
					int intLowLimit = Integer.parseInt(strLine.split(" ")[0]);
					int intSupLimit = Integer.parseInt(strLine.split(" ")[1]);

					System.out.println("Case #" + i + ": " + getResult(intLowLimit, intSupLimit));
				}

				i++;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private static int getResult(int intLowLimit, int intSupLimit)
	{
		int result = 0;

		for (int numberN = intLowLimit; numberN <= intSupLimit; numberN++)
		{
			for (int numberM = numberN + 1; numberM <= intSupLimit; numberM++)
			{
				if (recycledPair(Integer.toString(numberN), Integer.toString(numberM)))
					result++;
			}
		}
		return result;
	}

	private static boolean recycledPair(String n, String m)
	{
		boolean result = false;

		for (int i = 1; i < m.length(); i++)
		{
			String strAux = m.substring(i);
			strAux = strAux + m.substring(0, i);
			if (strAux.equals(n))
				result = true;
		}

		return result;
	}
}
