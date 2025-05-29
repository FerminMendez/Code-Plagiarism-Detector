import java.io.*;
import java.util.*;

public class dancers
{
	public static void main(String[] args)
	{
		ArrayList<HashSet<triple>> list = new ArrayList<HashSet<triple>>();
		for (int i = 0; i <= 30; i++)
		{
			HashSet<triple> temp = new HashSet<triple>();
			list.add(temp);
		}
		for (int i = 0; i <= 10; i++)
			for (int j = 0; j <= 10; j++)
				for (int k = 0; k <= 10; k++)
				{
					if (!((Math.abs(i - j) > 2) || (Math.abs(i - k) > 2) || (Math.abs(j - k) > 2)))
					{
						triple temp = new triple(i, j, k);
						HashSet<triple> temp2 = list.get(temp.total);
						boolean found = false;
						for (triple t : temp2)
						{
							if (t.theset.equals(temp.theset))
							{
								found = true;
								break;
							}
						}
						if (!found) temp2.add(temp);
						list.set(temp.total, temp2);
					}
				}

		/*
		 * //System.out.println(list); for (HashSet<triple> h : list) {
		 * //System.out.println(h.size()); }
		 */

		try
		{
			FileReader fread = new FileReader(new File("B-small-attempt4.in"));
			BufferedReader br = new BufferedReader(fread);
			FileWriter fwrite = new FileWriter(new File("output.txt"));
			PrintWriter pw = new PrintWriter(fwrite);
			int cases = new Integer(br.readLine());
			for (int i = 1; i <= cases; i++)
			{
				String line = br.readLine();
				StringTokenizer st = new StringTokenizer(line);

				int googlers = new Integer(st.nextToken());
				int s = new Integer(st.nextToken());
				int p = new Integer(st.nextToken());

				int[] googlerscores = new int[googlers];

				for (int j = 0; j < googlers; j++)
				{
					googlerscores[j] = new Integer(st.nextToken());
				}

				// for (int a : googlerscores)
				// System.out.println(a);

				int fors[] = new int[googlers];
				int fornos[] = new int[googlers];

				for (int j = 0; j < googlers; j++)
				{
					fors[j] = 0;
					fornos[j] = 0;
				}

				int counts = 0;
				int countnos = 0;
				for (int j = 0; j < googlers; j++)
				{
					HashSet<triple> scores = list.get(googlerscores[j]);
					for (triple s1 : scores)
					{
						// System.out.println(s1);
						if (s1.p >= p)
						{
							if (s1.state == 2)
							{
								fors[j] = s1.p;
								counts++;
								// //System.out.println("counts=" + counts);
							}
							else
							{
								fornos[j] = s1.p;
								countnos++;
								// //System.out.println("countnos=" + countnos);
							}
						}
					}
				}
				// System.out.println("s=" + s);
				for (int d : fors)
				{
					// System.out.print(d + ",");
				}
				// System.out.println();

				for (int d : fornos)
				{
					// System.out.print(d + ",");
				}
				// System.out.println();
				int count = 0;
				
				if ((s == 3) && (counts == 3)) count = 3;
				else if (s == 2)
				{
					if ((googlers == 2) && (counts == 2)) count = 2;
					else if ((googlers == 3) && (counts >= 2))
					{
						int check = 0;
						if (fors[0] > 0 && fors[1] > 0)
						{
							check = 2;
							if (fornos[2] > 0) check = 3;
						}
						// 12

						if (fors[1] > 0 && fors[2] > 0)
						{
							check = Math.max(check, 2);
							if (fornos[0] > 0) check = Math.max(check, 3);
						}

						// 23
						if (fors[0] > 0 && fors[2] > 0)
						{
							check = Math.max(check, 2);
							if (fornos[1] > 0) check = Math.max(check, 3);
						}

						// 13
						count = check;
					}
				}
				else if (s == 1)
				{
					if (counts >= 1)
					{
						if (googlers == 1)
						{
							count = 1;
						}
						else if (googlers == 2)
						{
							if (fors[0] > 0)
							{
								count = 1;
								if (fornos[1] > 0) count = 2;
							}
							if (fors[1] > 0)
							{
								count = Math.max(count, 1);
								if (fornos[0] > 0) count = Math.max(count, 2);
							}
						}
						else if (googlers == 3)
						{
							if (fors[0] > 0)
							{
								int check = 1;
								if (fornos[1] > 0) check++;
								if (fornos[2] > 0) check++;
								count = Math.max(count, check);
							}
							if (fors[1] > 0)
							{
								int check = 1;
								if (fornos[0] > 0) check++;
								if (fornos[2] > 0) check++;
								count = Math.max(count, check);
							}
							if (fors[2] > 0)
							{
								// System.out.println("in here");
								int check = 1;
								if (fornos[0] > 0) check++;
								if (fornos[1] > 0) check++;
								count = Math.max(count, check);
							}

						}
					}
				}
				else
				{
					count = countnos;
				}
				pw.println("Case #" + i + ": " + count);
				// System.out.println("Case #" + i + ": " + count);
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
