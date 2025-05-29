import java.util.Scanner;
public class mishe {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int cnt = scan.nextInt();
		for(int c=1 ; c<=cnt ; c++)
		{
			int[] nums = new int[scan.nextInt()];
			int sup = scan.nextInt();
			int max = scan.nextInt();
			int MINSUP = max+2*((max>=2)?(max-2):0),MINNSUP = max+2*((max>=1)?(max-1):0),res = 0;
			for(int i=0 ; i<nums.length ; i++)
				nums[i] = scan.nextInt();
			for(int i=0 ; i<nums.length ; i++)
			{
				if(nums[i]<MINSUP)	continue;
				if(nums[i]>=MINSUP && nums[i]<MINNSUP)	
				{
					if(sup>0)
						res++;
					sup--;
				}
				else if(nums[i]>=MINNSUP)	res++;
			}
			System.out.println("Case #"+c+": "+res);
		}
	}

}
