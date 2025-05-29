import java.io.*;
import java.util.*;

public class recycled
{

	public static void main(String[] args)
	{
		try
		{
			FileReader fread = new FileReader(new File("C-small-attempt0.in"));
			BufferedReader br = new BufferedReader(fread);
			FileWriter fwrite = new FileWriter(new File("output.txt"));
			PrintWriter pw = new PrintWriter(fwrite);
			int cases = new Integer(br.readLine());
			for (int i = 1; i <= cases; i++)
			{
				String line = br.readLine();
				StringTokenizer st = new StringTokenizer(line);
				String temp = st.nextToken();
				if (temp.length() == 1)
				{
					pw.println("Case #" + i + ": 0");
					System.out.println("Case #" + i + ": 0");
				}
				else
				{
					int min = new Integer(temp);
					int max = new Integer(st.nextToken());

					int count = 0;

					for (int j = min; j <= max; j++)
					{
						String current = "" + j;
						String changing = current;
						HashSet<Integer> seen = new HashSet<Integer>();
						for (int k = current.length() - 1; k > 0; k--)
						{
							changing = changing.substring(1) + changing.charAt(0);
							int intchanging = new Integer(changing);
							if ((intchanging > new Integer(current)) && (intchanging <= max) && (!seen.contains(intchanging)))
							{
								count++;
								seen.add(intchanging);
							}
						}
					}
					/*
					 * int end = max / 10; System.out.println(end);
					 * System.out.println(tens); for (int j = min; j <= max;
					 * j++) { int ref = j / 10; int mod = j % 10; boolean found
					 * = false; while (ref > 0) { int check = ref % 10; if
					 * (check != mod) { found = true; break; } ref /= 10; } if
					 * (found) { if (((j % tens) < end)&&((j % tens) >=
					 * (tens/10))) { if ((j / tens) < (j % tens)) {
					 * System.out.print(j +" "); count++; } } } }
					 */
					pw.println("Case #" + i + ": " + count);
					System.out.println("Case #" + i + ": " + count);
				}
			}
			pw.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
