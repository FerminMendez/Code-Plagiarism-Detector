import java.util.Scanner;


public class C {

	public static class N
	{
		public static int[] m_num;
		public static int m_first;
		public static int length;
		
		public static void set(int n)
		{
			String s = Integer.toString(n);
			char[] c = s.toCharArray();
			m_num = new int[c.length];
			m_first = 0;
			for(int i = 0; i < c.length; i++)
			{
				m_num[m_num.length - i - 1] = Character.digit(c[i], 10);
			}
			length = m_num.length;
		}
		
		
		public static int nextNum()
		{
			m_first = (m_first + 1) % m_num.length;
			int ret = 0;
			int mult = 1;
			for(int i = 0; i < m_num.length; i++)
			{
				ret += (mult*m_num[(i+m_first)%m_num.length]);
				mult *= 10;
			}
			return ret;
		}
		
	}
	
	
	public static int[] binom = {0, 0, 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 66, 78, 91, 105};
	
	public static void main(String[] args)
	{
	
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		
		for(int t = 1; t <= T; t++)
		{
			int A = in.nextInt();
			int B = in.nextInt();
			System.out.println("Case #" + t + ": " + foo(A, B));
		}
	}
	
	public static int foo(int lower, int upper)
	{
		if(upper < 10) return 0;
		
		int counter = 0;
		
		boolean[] checked = new boolean[upper - lower + 1];
		
		for(int i = lower; i <= upper; i++)
		{
			if(checked[i-lower]) continue;
			
			N.set(i);
			
			int items = 0;
			
			for(int j = 0; j < N.length; j++)
			{
				int num = N.nextNum();
				
				if(num < lower || num > upper || checked[num-lower]) continue;
				
				checked[num-lower] = true;
				
				items++;
			}
			
			counter += binom[items];
		}
		
		return counter;
	}
}
