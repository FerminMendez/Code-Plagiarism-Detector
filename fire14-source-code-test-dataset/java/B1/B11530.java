package c;
import java.io.*;
/**
 * Google Code Jam C
 * @author hang
 *
 */

public class Main {
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n_str = br.readLine();
		int n_int = Integer.parseInt(n_str);
		int min, max;
		for(int i = 1;i<=n_int;i++)
		{
			String []s = br.readLine().split("\\s");
			int length = s[0].length();
			min = Integer.parseInt(s[0]);
			max = Integer.parseInt(s[1]);
			if(max<10)
			{
				System.out.println("Case #" + i + ": " + 0);
				continue;
			}
		    
			int number = 0;
			
			int multiple_base = 1;
			for(int j = 1;j<length;j++)
				multiple_base*=10;
			for(int k = min;k<max;k++)
			{
				int multiple_increase = 1;
				int multiple_decrease = multiple_base;
				for(int j = 1;j<=length-1;j++)
				{
					multiple_increase*=10;
					int new_number = (k/multiple_increase) + (k%multiple_increase)*multiple_decrease;
					if(new_number>k&&new_number<=max)
						number++;
					multiple_decrease/=10;
				}
			}
			System.out.println("Case #" + i + ": " + number);
			
		}
	}
}
