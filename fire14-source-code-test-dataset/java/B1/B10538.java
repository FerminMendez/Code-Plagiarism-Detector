import java.util.*;
public class C {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 1; t <= T; ++t)
		{
			int A = in.nextInt();
			int B = in.nextInt();
			
			HashSet<Integer> set = new HashSet<Integer>();
			int ans = 0;
			for (int i = A; i <= B; ++i)
			{
				String val = Integer.toString(i);
				HashSet<Integer> set2 = new HashSet<Integer>();
				for (int j = 0; j < val.length()-1; ++j)
				{
					val = val.charAt(val.length()-1) + val.substring(0, val.length()-1);
					if (set2.contains(Integer.parseInt(val))) continue;
					if (set.contains(Integer.parseInt(val))) ++ans;
					set2.add(Integer.parseInt(val));
				}
				
				set.add(i);
			}
			
			System.out.printf("Case #%d: %d\n", t, ans);
		}
	}
}

/*

4
1 9
10 40
100 500
1111 2222

*/
