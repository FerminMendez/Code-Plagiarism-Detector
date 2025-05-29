import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	private static boolean [] used;
	public static int cnt(int a)
	{
		int res = 0;
		while(a != 0)
		{
			a/=10;
			res++;
		}
		return res;
	}
	
	public static int tenMult(int n)
	{
		int res = 1;
		for(int i = 0; i < n -1; i++)
			res *= 10;
		return res;
	}
 
	public static int solve(int n, int limit)
	{
		int res = 0;
		int c = cnt(n);
		int tmp = n;
		used = new boolean[2000000];
		for(int i = 0; i < c-1; i++)
		{
			int rem = tmp%10;
			tmp /= 10;
			
			tmp += tenMult(c) * rem;
			if(tmp <= 2000000 && tmp > n && tmp <= limit && used[tmp] == false)
				{
				used[tmp] = true;
				//System.out.println("for " + n + " = " + tmp);
				res++;}
		}
		return res;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input"));
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		//used = new boolean[2000000];
		for(int j = 1; j <= n; j++)
		{
			
			int A = s.nextInt();
			int B = s.nextInt();
			int res = 0;
			for(int i = A; i <= B; i++)
			{
				res += solve(i,B);
			}
			System.out.println("Case #" + j + ": " + res);
		}
	}

}
