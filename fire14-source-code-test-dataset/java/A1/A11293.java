package ponder.CodeJamQualify;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author: sg  Date: 15.04.12
 */
public class TaskB
{
	static int calc(final int p, final int strangeOrig, final int[] marks)
	{
		int cnt = 0;
		int strange = strangeOrig;
		for (int total : marks)
		{
			int max = total / 3;
			if ((total % 3) != 0)
				max += 1;

			if (max >= p)
			{
				cnt++;
				continue;
			}

			if (total <= 1)
				continue;

			if (((total % 3) != 1) && (strange > 0) && (max == p - 1))
			{
				cnt++;
				strange--;
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException
	{
		final long start = System.currentTimeMillis();

//		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("taskB.out")));
//		BufferedReader reader = new BufferedReader(new FileReader("taskB.in"));

		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("B-small-attempt0.out")));
		BufferedReader reader = new BufferedReader(new FileReader("B-small-attempt0.in"));

		String inLine;
		int caseIndex = 0;
		inLine = reader.readLine();
		while (null != (inLine = reader.readLine()))
		{
			StringTokenizer st = new StringTokenizer(inLine);
			final int n = Integer.parseInt(st.nextToken());
			final int s = Integer.parseInt(st.nextToken());
			final int p = Integer.parseInt(st.nextToken());
			int[] marks = new int[n];
			for (int i = 0; i < n; i++)
				marks[i] = Integer.parseInt(st.nextToken());
			caseIndex++;
			int cnt = calc(p, s, marks);
			writer.printf("Case #%d: %d\r\n", caseIndex, cnt);
		}

		writer.close();


		final long finish = System.currentTimeMillis();
		final long dur = finish - start;
		System.err.println(dur);
	}
}
