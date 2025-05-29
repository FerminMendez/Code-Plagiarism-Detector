import java.io.*;
import java.util.*;

public class dancing
{
	public static void main(String[] args)throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader("dancing.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("dancing.out")));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine() + " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int count = 0;
			for(int k = a; k <= b; k++)
			{
				if(k == 1000) continue;
				if(k / 10 == 0) continue;
				if(k / 100 == 0)
				{
					String s = "" + (k % 10) + "" + (k / 10);
					int si = Integer.parseInt(s);
					if(si < k && si >= a) count++;
					continue;
				}
				if(k / 1000 == 0)
				{
					String s1 = "" + (k%100) + "" + (k/100);
					int i1 = Integer.parseInt(s1);
					if(i1 >= a && i1 < k) count++;
					
					String s2 = "" + (k%10) + "" + (k/10);
					int i2 = Integer.parseInt(s2);
					if(i2 < k && i2 >= a) count++;
				}
				
			}
			pw.println("Case #" + (i+1) + ": " + count);
		}
		pw.close();
		System.exit(0);
		
	}
}
