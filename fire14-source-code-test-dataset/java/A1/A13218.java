import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class dancers {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("problem.in"));
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++)
		{
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line, " ");
			int len = Integer.parseInt(st.nextToken());
			int surp = Integer.parseInt(st.nextToken());
			int want = Integer.parseInt(st.nextToken());
			int count = 0;
			int[] vals = new int[len];
			for (int j = 0; j < len; j++)
			{
				vals[j] = Integer.parseInt(st.nextToken());
			}
			for (int k: vals)
			{
				k -= want;
				if (k <0)
					continue;
				else
				{
					if (k >= 2 * want - 2)
					{
						count++;
					}
					else if (k >= 2 * want - 4)
					{
						if (surp == 0)
							continue;
						else
						{
							surp--;
							count++;
						}
					}
				}
			}
			System.out.println("Case #" + i + ": " + count);
			
		}
	}

}
