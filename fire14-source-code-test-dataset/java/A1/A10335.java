import java.io.*;
import java.util.*;

public class GoogleDancer {
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(new FileReader("Dancer.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("Dancer.out"), true);
		int T = sc.nextInt();
		for (int c = 1; c<=T; c++)
		{
			int N = sc.nextInt();
			int S = sc.nextInt();
			int p = sc.nextInt();
			int[] points = new int[N];
			for (int d = 0; d < N; d++)
			{
				points[d] = sc.nextInt();
			}
			int num = calc(N, S, p, points);
			String x = String.format("Case #%d: %d", c, num);
			pw.println(x);
		}
		
		
		pw.close();
	}
	public static int calc(int N, int S, int p, int[] points)
	{
		int total = 0;
		int min = ((p-2)<0? 0 : p-2)*2 + p;
		for (Integer n : points)
		{
			
			if (n < min) continue;
			int avg = n/3;
			if (n%3 == 0)
			{
				if (avg >= p) total++;
				else if ((avg+1) >= p && S>0)
				{
					total++;
					S--;
				}
			}else if (n%3 == 1)
			{
				if ((avg+1) >= p)total++;
			}else
			{
				if ((avg+1) >= p) total++;
				else if ((avg+2)>= p && S > 0)
				{
					total++;
					S--;
				}
			}
		}
		return total;
	}
}
