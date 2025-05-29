import java.util.Scanner;


public class Recycled {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		for (int c = 1; c <= cases; c++)
		{
			int a = input.nextInt();
			int b = input.nextInt();
			int matches = 0;
			for (int n = a; n <= b; n++)
			{
				String strN = String.valueOf(n);
				for (int m = n + 1; m <= b; m++)
				{
					String strM = String.valueOf(m);
					if (check(strN, strM))
						matches++;
				}
			}
			System.out.println("Case #" + c + ": " + matches);
		}
	}

	private static boolean check(String a, String b) {
		for (int k = 1; k < a.length(); k++)
		{
			if ((a.substring(k, a.length()) + a.substring(0, k)).equals(b))
				return true;
		}
		return false;
	}
}
