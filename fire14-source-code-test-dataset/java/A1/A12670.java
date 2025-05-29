import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import Triple.Triple;

public class Dancing
{

	/*@formatter:off*/
	/**
	 * Problem B. Dancing With the Googlers
	 * Problem:
	 * 
	 * You're watching a show where Googlers (employees of Google) dance, and
	 * then each dancer is given a triplet of scores by three judges. Each
	 * triplet of scores consists of three integer scores from 0 to 10
	 * inclusive. The judges have very similar standards, so it's surprising if
	 * a triplet of scores contains two scores that are 2 apart. No triplet of
	 * scores contains scores that are more than 2 apart.
	 * 
	 * For example: (8, 8, 8) and (7, 8, 7) are not surprising. (6, 7, 8) and
	 * (6, 8, 8) are surprising. (7, 6, 9) will never happen.
	 * 
	 * The total points for a Googler is the sum of the three scores in that
	 * Googler's triplet of scores. The best result for a Googler is the maximum
	 * of the three scores in that Googler's triplet of scores. Given the total
	 * points for each Googler, as well as the number of surprising triplets of
	 * scores, what is the maximum number of Googlers that could have had a best
	 * result of at least p?
	 * 
	 * For example, suppose there were 6 Googlers, and they had the following
	 * total points: 29, 20, 8, 18, 18, 21. You remember that there were 2
	 * surprising triplets of scores, and you want to know how many Googlers
	 * could have gotten a best result of 8 or better.
	 * 
	 * With those total points, and knowing that two of the triplets were
	 * surprising, the triplets of scores could have been:
	 * 
	 * 10 9 10
	 * 6 6 8 (*)
	 * 2 3 3
	 * 6 6 6
	 * 6 6 6
	 * 6 7 8 (*)
	 * The cases marked with a (*) are the surprising cases. This gives us 3 Googlers who got at least one
	 * score of 8 or better. There's no series of triplets of scores that would
	 * give us a higher number than 3, so the answer is 3. Input
	 * 
	 * The first line of the input gives the number of test cases, T. T test
	 * cases follow. Each test case consists of a single line containing
	 * integers separated by single spaces. The first integer will be N, the
	 * number of Googlers, and the second integer will be S, the number of
	 * surprising triplets of scores. The third integer will be p, as described
	 * above. Next will be N integers ti: the total points of the Googlers.
	 * 
	 * Output
	 * 
	 * For each test case, output one line containing "Case #x: y", where x is
	 * the case number (starting from 1) and y is the maximum number of Googlers
	 * who could have had a best result of greater than or equal to p.
	 * 
	 * Limits
	 * 
	 * 1 <= T <= 100.
	 * 0 <= S <= N.
	 * 0 <= p <= 10.
	 * 0 <= ti <= 30.
	 * At least S of the ti values will be between 2 and 28, inclusive.
	 * Small dataset
	 * 1 <= N <= 3. 
	 * Large dataset
	 * 1 <= N <= 100. 
	 * Sample 
	 * Input
	 * 4
	 * 3 1 5 15 13 11
	 * 3 0 8 23 22 21
	 * 2 1 1 8 0
	 * 6 2 8 29 20 8 18 18 21
	 * 
	 * Output
	 * Case #1: 3
	 * Case #2: 2
	 * Case #3: 1
	 * Case #4: 3
	 */
	/*@formatter:on*/

	private static String CASE = "Case #";

	public static void main(String[] args)
	{
		Scanner in = null;
		PrintWriter out = null;
		int T = 0; // number of test cases
		int N = 0; // number of contestants in current test case
		int S = 0; // number of surprising triplets in current test case
		int p = 0; // individual judge's score threshold for current test case

		if (args.length < 2)
		{
			System.out.println("Syntax: java Dancing \"infile\" \"outfile\"");
			System.exit(1);
		}

		// Opening infile
		try
		{
			in = new Scanner(new File(args[0]));
		} catch (Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}

		// Opening outfile
		try
		{
			out = new PrintWriter(new FileWriter(args[1]));
		} catch (Exception e1)
		{
			e1.printStackTrace();
			System.exit(1);
		}

		try
		{
			T = in.nextInt();
			//System.out.println(T);

			for (int i = 0; i < T; i++)
			{
				int k = 0;
				int higher = 0;
				Triple t = null;

				N = in.nextInt();
				S = in.nextInt();
				p = in.nextInt();
				//System.out.println("N=" + N + ", S=" + S + ", p=" + p);
				for (int j = 0; j < N; j++)
				{
					k = in.nextInt();
					t = new Triple(k);
					//System.out.print(k + ": ");
					if (t.isHigher(p))
					{
						//System.out.print(t + "[!] ");
						higher += 1;
					} else if ((t.couldBeHigher(p)) && (S > 0))
					{
						//System.out.print(t + "->");
						t.Unusify();
						S -= 1;
						//System.out.print(t + "[*] ");
						higher += 1;
					} else
					{
						//System.out.print(t + " ");
					}
				}
				//System.out.println("; Total = " + higher);
				out.println(CASE + (i + 1) + ": " + higher);
				System.out.println(CASE + (i + 1) + ": " + higher);
			}
			out.close();
		} catch (Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}

}
