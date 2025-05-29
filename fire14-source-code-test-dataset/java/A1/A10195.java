import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Q2 {

	public static void main (String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int numTests = s.nextInt();
		for (int test = 0; test < numTests; test++)
		{
			int googlers = s.nextInt();
			int surprises = s.nextInt();
			int threshold = s.nextInt();
			List<Integer> scores = new ArrayList<Integer>(googlers);
			for (int i = 0; i < googlers; i++)
			{
				scores.add(s.nextInt());
			}
			Collections.sort(scores);
			Collections.reverse(scores);
			
			int numAboveThreshold = 0;
			for (int i = 0; i < googlers; i++)
			{
				int score = scores.get(i);
				if (score >= 29)
				{
					//cannot possibly be surprise (10/10/9)
					numAboveThreshold ++;
					continue;
				}
				if (score < threshold)
				{
					//no way we get there
					continue;
				}
				if (3 * threshold - 2 <= score)
				{
					//no need to use a surprise
					numAboveThreshold ++;
					continue;
				}
				if (3 * threshold - 4 <= score && surprises > 0)
				{
					numAboveThreshold ++;
					surprises --;
					continue;
				}
			}
			
			System.out.println("Case #" + (test+1) + ": " + numAboveThreshold);
		}
	}
	
}
