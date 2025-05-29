import java.util.Scanner;


public class RN {
	
	static int A,B;
	static int[] chuso = new int[11];
	static int result = 0;
	public static void RN(int n, int B)
	{
		String ns = Integer.toString(n);
		int nl = ns.length();
		for (int i = 1; i < nl; i++)
		{
			String tmp = ns.substring(i);
			String tmp1 = ns.substring(0, i);
			String new_num = tmp + tmp1;
			int m = Integer.parseInt(new_num);
			if (m > n && m <= B)
				{
					//System.out.println(m + " " + n);
					result ++;
				}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int k = 0; k<T; k++)
		{
		A = sc.nextInt();
		B = sc.nextInt();
		result = 0;
		for (int i = A; i<=B; i++)
			RN(i,B);
		//RN(12);
		System.out.println("Case #" + (k+1) + ": " + result);
	
		}
	}

}
