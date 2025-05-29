package run;
import java.io.*;

public class Main 
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = Integer.parseInt(s);
		for(int i = 1;i<=n;i++)
		{
			s = br.readLine();
			String []s_arr = s.split(" ");
			
			int n_googler = Integer.parseInt(s_arr[0]);
			int n_surprise = Integer.parseInt(s_arr[1]);
			int threshold = Integer.parseInt(s_arr[2]);
			int number = 0;
			for(int j = 0;j<n_googler;j++)
			{
				int score = Integer.parseInt(s_arr[j+3]);
				
				if(threshold==0||threshold==1)
				{
					if(score>=1)
						number++;
				}
				
				else if(threshold*3-2<=score)
				{
					number++;
				}
				
				else if(threshold*3-4<=score&&n_surprise>0)
				{
					number++;
					n_surprise--;
				}
				else
					continue;
			}
			
			System.out.println("Case #" + i + ": " + number);
		}
	}
}
