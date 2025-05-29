import java.util.Scanner;

public class C {
	public static void main (String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int a, b;
		int[] list;
		for (int i = 1; i <= n; i++)
		{
			a = scan.nextInt();
			if (a < 10)
				a = 10;
			b = scan.nextInt();
			int count = 0;
			for (int j = a; j < b; j++)
			{
				String str = "" + j;
				int len = str.length();
				list = new int[len];
				int lp = 0;
				for (int k = 1; k < len; k++)
				{
					String str2 = str.substring(len-k) + str.substring(0, len-k);
					int res = Integer.valueOf(str2);
					if (str2.charAt(0) != '0' && res > j && res <= b)
					{
						if (!contains(list, lp, res))
						{
							list[lp] = res;
							lp++;
							//System.out.println(j + " " + res);
							count++;
						}
					}
				}
			}
			System.out.println("Case #" + i + ": " + count);
		}
	}
	private static boolean contains(int[] list, int lp, int res)
	{
		for (int i = 0; i < lp; i++)
			if (list[i] == res)
				return true;
		return false;
	}
}
