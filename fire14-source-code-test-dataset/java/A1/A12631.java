import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B {
	public static void main (String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		int n, s, p;
		for (int i = 1; i <= c; i++)
		{
			n = scan.nextInt();
			s = scan.nextInt();
			p = scan.nextInt();
			ArrayList<Integer> ti = new ArrayList<Integer>();
			for (int j = 0; j < n; j++)
				ti.add(new Integer(scan.nextInt()));
			Collections.sort(ti);
			int count = 0;
			for (int j = ti.size()-1; j >= 0; j--)
			{
				int t = ti.get(j).intValue();
				if ((t+2)/3 >= p)
					count++;
				else if ((3*p - 4) <= t && s > 0 && t > 3)
				{
					count++;
					s--;
				}
			}
			System.out.println("Case #" + i + ": " + count);
		}
	}
}
