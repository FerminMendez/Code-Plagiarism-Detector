import java.util.*;
import java.io.*;

public class B
{
	public static int test (int i, int target)
	{
		int n = i/3;
		
		if (i == 0)
		{
			if (target == 0) return 1;
			return 0;
		}	
		if (i == 1)
		{
			if (target <= 1) return 1;
			return 0;
		}
		
		if (i == 2)
		{
			if (target <= 1) return 1;
			if (target <= 2) return 2;
			return 0;
		}
		
		
		if (n >= (target - (i%3 == 0 ? 0 : 1)))
			return 1;

		if (n >= (target - (i%3 == 2 ? 2 : 1)))
			return 2;
		
		return 0;
	}

	public static void main(String... args) throws Exception
	{
		BufferedReader in = new BufferedReader (new FileReader( "B-small-attempt0.in" ));
		
		String line;
		in.readLine(); 
		int casenum = 1;

		String[] nums;
		while ( (line = in.readLine()) != null)
		{
			nums = line.split(" ");

			int target = Integer.valueOf(nums[2]);
			int surprising = Integer.valueOf(nums[1]);
			
			int a = 0, b = 0;
			
			for (int i = 3; i < nums.length; i++)
			{
				//System.out.println( "DEBUG: " + nums[i] + " -> " + test(Integer.valueOf(nums[i]),target));
				switch (test(Integer.valueOf(nums[i]),target))
				{
					case 0: break;
					case 1: a++; break;
					case 2: b++; break;
				}
			}
			int result = a + Math.min(b,surprising);
			System.out.println("Case #" + casenum + ": " + result);
			casenum++;
		}
	}
}