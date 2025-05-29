import java.util.Scanner;
import java.io.BufferedInputStream;
import java.util.HashSet;
public class C
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(new BufferedInputStream(System.in));
		
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++)
		{
			int count = 0;
			int low = scanner.nextInt();
			int high = scanner.nextInt();
			for (int j = low; j < high; j++)
			{
				String s = Integer.toString(j);
				String s2;
				int len = s.length();
				HashSet<Integer> set = new HashSet<Integer>();
				
				for (int k = 0; k < len-1; k++)
				{
					s2 = s.substring(len-k-1, len) + s.substring(0, len-k-1);
					int num = Integer.parseInt(s2);
					//System.out.println(num);
					if (num >= low && num <= high && num > j && !set.contains(num))
					{
						count++;
						set.add(num);
					}
				}
			}
			System.out.println("Case #" + (i+1) + ": " + count);
		}
	}
}
