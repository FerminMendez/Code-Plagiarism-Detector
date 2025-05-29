import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Q3 {

	public static void main (String[] args)
	{
		Scanner s = new Scanner(System.in);
		int numTests = s.nextInt();
		for (int test = 0; test < numTests; test++)
		{
			int a = s.nextInt();
			int b = s.nextInt();
			int count = 0;
			for (int i = a; i < b; i++)
			{
				String si = String.valueOf(i);
				Set<Integer> found = new HashSet<Integer>();
				for (int j = 0; j < si.length(); j++)
				{
					String sj = si.substring(j) + si.substring(0, j);
					int other = Integer.parseInt(sj);
					if (!found.contains(other) && other > i && other <= b)
					{
						found.add(other);
						count++;
					}
				}
			}
			System.out.println("Case #" + (test+1) + ": " + count);
		}
	}
	
}
