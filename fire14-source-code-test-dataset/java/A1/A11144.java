import java.io.*;
import java.util.*;

public class B implements Runnable
{	
	//private String IFILE = "input.txt";
	private String IFILE = "B-small-attempt0.in";	 
	private Scanner in;
	private PrintWriter out;
	
	public void Run() throws IOException
	{
		in = new Scanner(new File(IFILE));
		out = new PrintWriter("output.txt");
		
		int ntest = in.nextInt();
		for(int test = 1; test <= ntest; test++)
		{
			out.print("Case #" + test + ": ");
			int n = in.nextInt();
			int m = in.nextInt();
			int p = in.nextInt();
			int[] mas = new int[n];
			for(int i = 0; i < n; i++)
				mas[i] = in.nextInt();

			int[] max1 = new int[31];
			for(int i = 1; i <= 10; i++)
				max1[Math.max(0, Math.min(30, 3 * i - 2))] = i; 
			int[] max2 = new int[31];
			for(int i = 1; i <= 10; i++)
				max2[Math.max(1, Math.min(30, 3 * i - 4))] = i;
			for(int i = 1; i <= 30; i++)
				max1[i] = Math.max(max1[i], max1[i - 1]);
			for(int i = 1; i <= 30; i++)
				max2[i] = Math.max(max2[i], max2[i - 1]);
			
			int n1 = 0;
			int n2 = 0;
			for(int i = 0; i < n; i++)
			{
				if (max1[mas[i]] >= p)
					n1++;
				else if (max2[mas[i]] >= p)
					n2++;
			}
			
			out.println(n1 + Math.min(n2, m));
		}
		
		in.close();
		out.close();
	}
	
	public void run()
	{
		try		
		{
			Run();
		}
		catch(IOException e)
		{
			
		}
	}

	public static void main(String[] args) throws IOException
	{
		new B().Run();
		//new Thread(new XXX()).start();
	}

}
