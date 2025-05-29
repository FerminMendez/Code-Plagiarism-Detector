import java.util.Scanner;

public class C {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt(); in.nextLine();		
		
		//for each test case
		for (int i = 1; i <= T; i++)
		{
			int A = in.nextInt();
			int B = in.nextInt();
			
			int result = 0;
			
			for (int n = A; n <= B - 1; n++)
				for (int m = n + 1; m <= B; m++)
					if (isRecycledPair(n, m))
						result++;
			
			System.out.format("Case #%d: %d\n", i, result);
		}
	}
	
	private static boolean isRecycledPair(int n, int m) {
		
		String strN = "" + n;
		String strM = "" + m;
		
		int length = strN.length();
		
		for (int i = 0; i < length; i++)
		{
			boolean good = true;
			for (int j = 0; j < length; j++)
			{
				if (strN.charAt(j) != strM.charAt((i + j) % length))
				{
					good = false;
					break;
				}
			}
			if (good)
				return true;
		}
		
		return false;
	}
}