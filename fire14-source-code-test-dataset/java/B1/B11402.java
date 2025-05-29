package Round1;

/*
 ID: kevinle7
 LANG: JAVA
 TASK: recycled
 */
import java.io.*;
import java.util.*;

class recycled
{	
	public static int[] pow = {1,10,100,1000,10000,100000,1000000,10000000,100000000};
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("recycled.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("recycled.out")));
		int t = Integer.parseInt(f.readLine());
		for (int i = 0 ; i < t; i++)
		{
			StringTokenizer st = new StringTokenizer(f.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = (int) Math.log10(a);
			int count = 0;
			for (int n = a; n < b; n++)
			{
				HashSet<Integer> set = new HashSet<Integer>();
				set.add(n);
				int temp = n;
				temp = temp/10 + (temp%10)*pow[d];
				while (!set.contains(temp))
				{
					set.add(temp);
					if (temp > n && temp <= b)
						count++;
					temp = temp/10 + (temp%10)*pow[d];
				}
			}
			out.println("Case #" + (i+1) + ": "  + count);
		}
		out.close();
		System.exit(0);
	}
	
}