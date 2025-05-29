import java.io.*;
import java.util.*;

public class recycle
{

	public static StringTokenizer st;

	public static void main(String[] args)
	{
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C-small-attempt0.in")));
			PrintWriter pw = new PrintWriter(new FileWriter("output.out"));
			int T = Integer.parseInt(br.readLine());
			int t = 1;
			while (t <= T)
			{
				st = new StringTokenizer(br.readLine(), " ", false);
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				boolean[] arr = new boolean[B-A+1];
				int order = 0;
				for (int i = A; i <= B; i++) if (!arr[i-A])
					order += cycleOrder(i, A, B, arr);
				pw.println("Case #"+t+": "+order);
				t++;
			}
			pw.flush();
			pw.close();
			br.close();
		}
		catch (IOException ie)
		{
			ie.printStackTrace();
		}
	}
	
	public static int cycleOrder(int i, int A, int B, boolean[] arr)
	{
		arr[i-A] = true;
		String s = i+"";
		int order = 1;
		for (int j = 1; j < s.length(); j++)
		{
			String s2 = s.substring(j,s.length())+s.substring(0,j);
			if (s2.equals(s)) break;
			if (!s2.startsWith("0"))
			{
				int j2 = Integer.parseInt(s2);
				if (j2 >= A && j2 <= B)
				{
					order++;
					arr[j2-A] = true;
				}
			}
		}
		return order*(order-1)/2;
	}

}