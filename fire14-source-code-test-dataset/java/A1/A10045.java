import java.io.*;
import java.util.*;

class B
{
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner in = new Scanner(new File(args[0]));

		int t;

		t = Integer.parseInt(in.nextLine());

		for (int i=0; i<t; i++)
		{
			int n = in.nextInt();
			int s = in.nextInt();
			int p = in.nextInt();
			int m = 0;

			int ti[] = new int[n];
			for (int j=0; j<n; j++)
			{
				ti[j] = in.nextInt();
			}

			for (int j=0; j<n; j++)
			{
				int d = ti[j]/3;
				int r = ti[j]%3;
				int x = p - d;

				if (x <= 0)
					m++;
				else if (x+d <= 10)
				{
					if (x==2 && r==2 && s>0)
					{
						m++;
						s--;
					}
					else if ( x == 1)
					{
						if (r==0 && d>0 && s>0)
						{
							m++;
							s--;
						}
						else if (r > 0)
							m++;
					}
				}
				if (m > n)
					m=n;
			}
			System.out.println("Case #" + (i+1) + ": " + m);
		}

	}
}
