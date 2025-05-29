import java.io.*;
import java.util.*;

class Recycled
{
	int n;
	int m;

	Recycled (int a, int b)
	{
		n=a;
		m=b;
	}

	boolean isEqual(int a, int b)
	{
		if (n == a && m == b)
			return true;
		else
			return false;
	}
}

class C
{
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner in = new Scanner(new File(args[0]));

		int t;

		t = Integer.parseInt(in.nextLine());

		for (int i=0; i<t; i++)
		{
			int a = in.nextInt();
			int b = in.nextInt();
			int s = 0;
			ArrayList<Recycled> recs = new ArrayList<Recycled>();

			for (int n=a; n<b; n++)
			{
				String x = String.valueOf(n);
				String y = new String();
				for (int j=0; j<x.length()-1; j++)
				{
					y = x.substring(j+1) + x.substring(0,j+1);
					int m = Integer.parseInt(y);
					if ( n < m && m <= b)
					{
						boolean distinct = true;
						for (Recycled rec: recs)
						{
							if (rec.isEqual(n,m))
							{
								distinct = false;
								break;
							}	
						}

						if (distinct)
						{
							recs.add(new Recycled(n,m));
							s++;
						}
					}
				}

			}
			
			System.out.println("Case #" + (i+1) + ": " + s);
		}

	}
}
