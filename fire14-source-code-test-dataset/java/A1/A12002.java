import java.util.*;
import java.io.*;


public class Dance {
	public static void main(String args[]) throws Exception
	{
		BufferedReader in = new BufferedReader(new FileReader(new File("dance.in")));
		FileWriter out = new FileWriter(new File("dance.out"));
		
		int n = Integer.parseInt(in.readLine());
		for (int i = 1; i <= n; i++) {
			String s = in.readLine();
			StringTokenizer st = new StringTokenizer(s);
			
			int N = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			int max = 0;
			for (int j = 0; j < N; j++)
			{
				int g = Integer.parseInt(st.nextToken());
				if (g < 2) {
					if (g >= p) max++;
				}
				else if ((g + 2) / 3 >= p) max++;
				else if ((g+4) / 3 >= p && S > 0) {
					S--;
					max++;
				}
			}
			
			
			out.write("Case #" + i + ": " + max + "\n");
		}
		in.close();
		out.close();
		
	}
}
