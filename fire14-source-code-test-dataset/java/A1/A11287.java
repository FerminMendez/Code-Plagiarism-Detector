import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class QualB
{
	

	public void run()throws IOException
	{
		Scanner in = new Scanner(new File("b.in"));
		PrintWriter out = new PrintWriter("b.out");
		int nt = in.nextInt();
		in.nextLine();
		for(int it = 1;it <= nt; it++)
		{
			int n = in.nextInt();
			int s = in.nextInt();
			int p = in.nextInt();
			int [] a = new int[n];
			for(int i=0;i<n;i++)
				a[i] = in.nextInt();
			
			int ret = 0;
			for(int i=0;i<n;i++)
			{
				int q = a[i] % 3;
				int max = a[i] / 3;
				if(q != 0)
					max++;
				if(max >= p)
					ret++;
				else
				{
					max = a[i] / 3;
					if(a[i] != 0)
						max++;
					if(q == 2)
						max++;
					if(max >= p && s > 0)
					{
						ret++;
						s--;
					}
				}
			}
			
			out.println("Case #" + it + ": " + ret);
		}
		out.close();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException
	{
		new QualB().run();
	}

}
