import java.io.*;
import java.util.Scanner;

public class DancingWithTheGooglers
{
	public static void main (String[] args)
	{
		File f = getFile();
		decodeAndWrite(f);
	}
	
	public static File getFile ()
	{
		Scanner in = new Scanner (System.in);
		System.out.print("Please enter the name of the file to be decoded (include extension!) -> ");
		String s = in.next();
		return new File(s);	
	}
	
	public static void decodeAndWrite (File f)
	{
		Scanner inf = null;
		PrintWriter outf = null;
		
		try
		{
			inf = new Scanner(f);
			outf = new PrintWriter(new File("dancing_results.txt"));
		}
		catch (FileNotFoundException e)
		{
			System.err.println("That is not a valid filename. Please re-run the program with a valid filename");
			System.exit(1);
		}
		
		int T = inf.nextInt(), N = 0, S = 0, p = 0, ti = 0, count = 0, scount = 0;
		
		for (int i = 1; i <= T; i++)
		{
			scount = count = 0;
			N = inf.nextInt();
			S = inf.nextInt();
			p = inf.nextInt();
			for (int j = 0; j < N; j++)
			{
				ti = inf.nextInt();
				if (ti >= (3 * p) - 2)
					count++;
				else if ((3 * p) - 4 >= 0 && ti >= (3 * p) - 4 && scount < S)
					scount++;
			}
			count += scount;
			System.out.println("Case #" + i + ": " + count);
			outf.println("Case #" + i + ": " + count);
		}
		
		inf.close();
		outf.close();
	}
}

