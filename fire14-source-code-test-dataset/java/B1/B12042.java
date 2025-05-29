import java.util.*;
import java.io.*;
import java.math.*;


public class Recycle {
	public static void main(String args[]) throws Exception
	{
		BufferedReader in = new BufferedReader(new FileReader(new File("recycle.in")));
		FileWriter out = new FileWriter(new File("recycle.out"));
		
		int n = Integer.parseInt(in.readLine());
		for (int i = 1; i <= n; i++) {
			String s = in.readLine();
			StringTokenizer st = new StringTokenizer(s);
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			long count = 0;
			
			for (int k = A; k < B; k++)
			{
				int num = k;
				int size = (num + "").length();
				for (int e = 0; e < size - 1; e++)
				{
					int f = num / ((int) Math.round(Math.pow(10, size-1)));
					num = num % ((int) Math.round(Math.pow(10, size-1)));
					num *= 10;
					num += f;
					if (num > k && num <= B) count++;
				}
			}
			
			
			out.write("Case #" + i + ": " + count + "\n");
		}
		in.close();
		out.close();
		
	}
}
