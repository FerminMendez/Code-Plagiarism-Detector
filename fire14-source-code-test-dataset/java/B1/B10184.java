import java.util.*;
import java.io.*;

public class C
{
	public static int roll (int i, int a, int b)
	{
		int found = 0;
		int digits = (""+i).length();
		
		int[] vit = new int[digits];
		
		int magic;
		
		int keep, move,done;
		
		
		for (int d = 1; d < digits; d++)
		{
			magic = (int)Math.pow(10, d);
			keep = i/magic;
			move = i%magic;
			magic = (int)Math.pow(10, digits-d);
			done = keep + (move * magic);
		
			
			if (a <= done && done <= b && done < i)
			{
				vit[found] = done;
				found++;
			}
		}
		
		if (found > 1) 
		{
			Arrays.sort(vit);
			for (int j = 0; j < vit.length - 1; j++)
				if (vit[j] != 0 && vit[j] == vit[j+1])
					found--;
		}
		return found;
	}

	public static void main(String... args) throws Exception
	{
		BufferedReader in = new BufferedReader (new FileReader( "C-small-attempt0.in" ));
		
		String line;
		in.readLine(); 
		int casenum = 1;

		int a,b;
			
		String[] nums;
		while ( (line = in.readLine()) != null)
		{
			nums = line.split(" ");
			
			a = Integer.valueOf(nums[0]);
			b = Integer.valueOf(nums[1]);
			
			int result = 0;
			for (int m = a; m <= b; m++)
				result += roll(m,a,b);
	
			System.out.println("Case #" + casenum + ": " + (result));
			casenum++;
		}
	}
}