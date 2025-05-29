import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class CodeJam2012C
{
	public static void main(String [] args) throws FileNotFoundException
	{
		new CodeJam2012C().go();
	}
	
	public void go() throws FileNotFoundException
	{
		PrintWriter writer = new PrintWriter(new File("output.txt"));
		Scanner in = new Scanner(new File("C-small-attempt0.in"));
//		Scanner in = new Scanner(System.in);
		int iterations = in.nextInt();
		for (int i = 0; i < iterations; i++)
		{
			int A = in.nextInt();
			int B = in.nextInt();
			int counter = 0;
			for (int j = 0; j < (B - A); j++)
			{
				String s = (j + A) + "";
				for (int k = 0; k < s.length() - 1; k++)
				{
					s = s.substring(1) + s.charAt(0);
					int temp = Integer.parseInt(s);
					if (temp <= B && (j + A) < temp)
						counter++;
				}
			}
//			System.out.println("Case #" + (i + 1) + ": " + counter);
			writer.write("Case #" + (i + 1) + ": " + counter + "\n");
		}
		writer.flush();
		writer.close();
	}
}
