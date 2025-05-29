import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class Scores 
{
	public static void main(String[] args) throws IOException 
	{
		Scanner scan = new Scanner(new File("B-small-attempt0.in"));
		FileWriter strm = new FileWriter("out2.txt");
		BufferedWriter out = new BufferedWriter(strm);
		int cases = scan.nextInt();
		scan.nextLine();
		int count = 1;
		while(count - 1 < cases)
		{
			int n = scan.nextInt();
			int s = scan.nextInt();
			int p = scan.nextInt();
			int[] tots = new int[n];
			for(int i = 0;i<n;i++)
			{
				tots[i] = scan.nextInt();
			}
			out.write("Case #" + count + ": " + calc(s,p,tots) + "\n");
			count++;
		}
		out.close();
	}
	private static int calc(int s, int p, int[] tots)
	{
		Arrays.sort(tots);
		int surp = 0;
		int max = 0;
		for(int i = 0;i<tots.length;i++)
		{
			if(possible(p,tots[i]))
			{
				boolean surprise = surp(p,tots[i]);
				if(surprise)
					surp++;
				if(surp<=s || !surprise)
					max++;
			}
		}
		return max;
	}
	private static boolean possible(int max, int total)
	{
		if(max == 0)
			return true;
		if(total / max >= 3.0)
			return true;
		if(total < max)
			return false;
		total -= max;
		return Math.abs(total / 2.0 - max) <= 2.0;
	}
	private static boolean surp(int max, int total)
	{
		if(max == 0)
			return false;
		if(total / max >= 3.0)
			return false;
		total -= max;
		return Math.abs(total / 2.0 - max) >= 1.5;
	}
}
