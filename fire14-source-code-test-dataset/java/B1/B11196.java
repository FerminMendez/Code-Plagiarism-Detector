import java.io.*;
import java.util.*;

public class C implements Runnable
{	
	//private String IFILE = "input.txt";
	private String IFILE = "C-small-attempt0.in";
	 
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
			int a = in.nextInt();
			int b = in.nextInt();
			int result = 0;
			for(int i = a; i <= b; i++)
			{
				int z = 1;
				while (z * 10 <= i)
					z *= 10;
				int ii = i;
				while (true)
				{
					ii = ii / 10 + (ii % 10) * z;
					if (ii == i)
						break;
					if (ii % z > 0 && i < ii && ii <= b)
						result++;
				}
			}
			out.println(result);
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
		new C().Run();
		//new Thread(new XXX()).start();
	}

}
