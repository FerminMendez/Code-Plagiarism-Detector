package jam;

import java.util.Scanner;

public class Main_B {
	static int[] results;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tests = Integer.valueOf(scan.nextLine());
		results = new int[tests];
		int c = 0;
		while(c < tests)
		{
			solve(scan.nextLine(), c);
			c++;
		}
		//print results
		System.out.println("Output");
		for (int i = 0; i < results.length; i++) {
			System.out.println("Case #" + (i+1) + ": " + results[i]);
		}
		
	}
	//N S P {numbers separated by spaces}
	public static void solve(String s, int on)
	{
		String[] parts = s.split(" ");
		//int num = Integer.valueOf(parts[0]);
		int surp = Integer.valueOf(parts[1]);
		int max = Integer.valueOf(parts[2]);
		int high = 3*max - 2;
		int high_w_surp = 3*max - 4;
		int[] vals = gather(parts);
		int num_pep = 0;
		
		for (int i = 0; i < vals.length; i++) {
			if(vals[i] >= Math.max(high, max))
			{
				num_pep++;
			}
			else if(vals[i] >= Math.max(high_w_surp, max) && surp > 0)
			{
				surp--;
				num_pep++;
			}
		}
		results[on] = num_pep;
		
	}
	
	public static int[] gather(String[] vals)
	{
		int[] nums = new int[vals.length-3];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.valueOf(vals[i+3]);
		}
		return nums;
	}
}
