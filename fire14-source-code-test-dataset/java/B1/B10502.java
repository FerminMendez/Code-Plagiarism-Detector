import java.io.*;
import java.util.*;

public class Q3
{
	public static boolean isPermut (int a, int b)
	{
		String str = String.valueOf (a);
		for (int i = 1; i < str.length(); i++)
		{
			str = str.charAt (str.length() - 1) + str.substring (0, str.length() - 1);
			if (Integer.parseInt (str) == b)
			{
				return true;
			}
		}
		return false;
	}
	
	public static void main (String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader (new FileReader ("input-q3.txt"));
		PrintWriter writer = new PrintWriter ("output-q3.txt");
		String line = reader.readLine();
		int nb = Integer.parseInt (line);
		for (int i = 0; i < nb; i++)
		{
			line = reader.readLine();
			String[] tokens = line.split (" ");
			int min = Integer.parseInt (tokens[0]);
			int max = Integer.parseInt (tokens[1]);
			
//			System.out.printf ("\nmin %d, max %d\n", min, max);
			
			// Try all rotations
			int counter = 0;
			
			Set<Integer> set = new HashSet<Integer>();
			
			for (int val = min; val < max; val++)
			{
				String str = String.valueOf (val);
				int nbDigits = str.length();
//				System.out.println("Val : " + val + " with " + nbDigits + " digits");
				int major = String.valueOf (max).charAt (0) - '0';
				set.clear();
				
				for (int j = 1; j < nbDigits; j++)
				{
					char last = str.charAt (nbDigits - 1);
					str = str.charAt (nbDigits - 1) + str.substring (0, nbDigits - 1);
					if (last != '0' && (last - '0') <= major)
					{
//						System.out.println ("  Trying " + str);
						int res = Integer.valueOf (str);
						if (res <= max && res > val && ! set.contains (res))
						{
//							System.out.printf ("    (%d, %d)\n", val, res);
							set.add (res);
							if (! (val != res && val < res && val >= min && res <= max && isPermut (res, val)))
							{
								System.out.println("ERROR");
							}
							counter++;
						}
					}
				}
			}
//			System.out.println ("Counter : " + counter);
			writer.println ("Case #" + (i + 1) + ": " + counter);
		}
		writer.close();
		reader.close();
	}
}