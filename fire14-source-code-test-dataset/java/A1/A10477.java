import java.io.*;
import java.util.*;

public class Q2
{
	private static int max (int a, int b, int c)
	{
		return Math.max (a, Math.max (b, c));
	}
	
	public static void main (String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader (new FileReader ("input-q2.txt"));
		PrintWriter writer = new PrintWriter ("output-q2.txt");
		String line = reader.readLine();
		int nb = Integer.parseInt (line);
		for (int i = 0; i < nb; i++)
		{
			line = reader.readLine();
			String[] tokens = line.split (" ");
			int[] googlers = new int[Integer.parseInt (tokens[0])];
			int s = Integer.parseInt (tokens[1]);
			int p = Integer.parseInt (tokens[2]);
			for (int j = 0; j < googlers.length; j++)
			{
				googlers[j] = Integer.parseInt (tokens[3 + j]);
			}
			
			System.out.printf ("\ns : %d,  p : %d, googlers : %s\n", s, p, Arrays.toString (googlers));
			
			// For each googler
			int counter = 0;
			for (int j = 0; j < googlers.length; j++)
			{
				System.out.print ("Googler " + googlers[j] + " :");
				int a = 0, b = 0, c = 0;
				
				if ((googlers[j] - 2) % 3 == 0)
				{
					a = b = (googlers[j] - 2) / 3;
					c = (googlers[j] - 2) / 3 + 2;
					
					if (max (a, b + 1, c - 1) >= p || c <= 1 || max (a, b, c) < p)
					{
						System.out.printf ("  (%d %d %d)\n", a, b + 1, c - 1);
						if (max (a, b + 1, c - 1) >= p)
						{
							counter++;
						}
						continue;
					}
					else if (s > 0)
					{
						s--;
						if (max (a, b, c) >= p)
						{
							counter++;
						}
						System.out.printf ("  (%d %d %d) *\n", a, b, c);
						continue;
					}
					else
					{
						System.out.println ("ERROR");
					}
				}
				
				if ((googlers[j] - 1) % 3 == 0)
				{
					a = b = (googlers[j] - 1) / 3;
					c = (googlers[j] - 1) / 3 + 1;
					
					if (max (a, b, c) >= p)
					{
						counter++;
					}
					System.out.printf ("  (%d %d %d)\n", a, b, c);
					continue;
				}
				
				if (googlers[j] % 3 == 0)
				{
					a = b = c = googlers[j] / 3;
					
					if (max (a, b, c) >= p || b <= 1 || max (a, b - 1, c + 1) < p || s == 0)
					{
						System.out.printf ("  (%d %d %d)\n", a, b, c);
						if (max (a, b, c) >= p)
						{
							counter++;
						}
						continue;
					}
					else if (s > 0)
					{
						s--;
						if (max (a, b - 1, c + 1) >= p)
						{
							counter++;
						}
						System.out.printf ("  (%d %d %d) *\n", a, b - 1, c + 1);
						continue;
					}
					else
					{
						System.out.println ("ERROR");
					}
				}
			}
			System.out.println ("Counter : " + counter);
			writer.println ("Case #" + (i + 1) + ": " + counter);
		}
		writer.close();
		reader.close();
	}
}