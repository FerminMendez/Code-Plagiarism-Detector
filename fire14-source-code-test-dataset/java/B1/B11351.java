import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;


public class QualC
{
	
	private int [] ten = new int[]{
			1,
			10,
			100,
			1000,
			10000,
			100000,
			1000000,
			10000000,
			100000000,
			1000000000
	};

	public void run()throws IOException
	{
		Scanner in = new Scanner(new File("c.in"));
		PrintWriter out = new PrintWriter("c.out");
		int nt = in.nextInt();
		in.nextLine();
		for(int it = 1;it <= nt; it++)
		{
			int a = in.nextInt();
			int b = in.nextInt();
			HashMap<String, Integer> mapPair = new HashMap<String, Integer>();
			
			int n = ("" + a).length();
			for(int i=a;i<=b;i++)
			{
				int c = i;
				
				for(int j=0;j<n - 1;j++)
				{
					c = (c % 10) * ten[n - 1] + c / 10;
					if(c > i && c <= b)
					{
						//System.err.println(i + " " + c);
						//if(mapPair.containsKey(i + " " + c))
						//	System.err.println(i + " " + c);
						mapPair.put(i + " " + c, 1);
						//ret++;
					}
				}
			}
			//System.err.println(mapPair.size());
			out.println("Case #" + it + ": " + mapPair.size());
		}
		out.close();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException
	{
		new QualC().run();
	}

}
