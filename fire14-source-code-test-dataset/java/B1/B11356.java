package ponder.CodeJamQualify;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @author: sg  Date: 15.04.12
 */
public class TaskC
{
	static Set<Integer> rotations(int x, int min, int max)
	{
		Set<Integer> rotations = new HashSet<Integer>();
		String s = Integer.toString(x);
		for (int i = 1; i < s.length(); i++)
		{
			String s2 = s.substring(i) + s.substring(0, i);
			if (s2.charAt(0) == '0')
				continue;

			Integer r = Integer.valueOf(s2);
			if ((x < r) && (r <= max))
				rotations.add(r);
		}
		return rotations;
	}

	static int calcMinMax(final int min, final int max)
	{
		int count = 0;
		for (int i = Math.max(min, 11); i < max; i++)
		{
			count += rotations(i, min, max).size();
		}
		return count;
	}

	public static void main(String[] args) throws IOException
	{
//		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("taskC.out")));
//		BufferedReader reader = new BufferedReader(new FileReader("taskC.in"));
//		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("C-small-attempt0.out")));
//		BufferedReader reader = new BufferedReader(new FileReader("C-small-attempt0.in"));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("C-small-attempt1.out")));
		BufferedReader reader = new BufferedReader(new FileReader("C-small-attempt1.in"));
		String inLine;
		int caseIndex = 0;
		inLine = reader.readLine();
		while (null != (inLine = reader.readLine()))
		{
			StringTokenizer st = new StringTokenizer(inLine);
			int min = Integer.parseInt(st.nextToken());
			int max = Integer.parseInt(st.nextToken());
			int count = calcMinMax(min, max);
			caseIndex++;
			writer.printf("Case #%d: %d\r\n", caseIndex, count);
		}
		writer.close();
	}
}
