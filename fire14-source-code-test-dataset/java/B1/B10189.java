import java.util.Scanner;
import java.util.TreeSet;


public class C {
	static TreeSet<Integer> s;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int t = kb.nextInt();
		int c = 1;
		int cnt, a, b;
		while(t-- > 0)
		{
			cnt = 0;
			a = kb.nextInt();
			b = kb.nextInt();
			for(int i=a; i<b; i++)
			{
				String x = ""+i;
				String tmp = x;
				s = new TreeSet<Integer>();
				for(int r=0; r<x.length()-1; r++)
				{
					tmp = rotate(tmp);
					
					if(tmp.charAt(0) == '0') continue;
					int xInt = Integer.parseInt(x);
					int tmpInt = Integer.parseInt(tmp);
					if(tmpInt<=b && tmpInt > xInt) 
					{
						if(!s.contains(tmpInt))
						{
							cnt++;
							s.add(tmpInt);
						}
//						System.out.println("("+x+","+tmp+")");
					}
				}
			}
			System.out.println("Case #"+c+++": "+cnt);
//			for(int k=0; k<cnt; k++)
//			{
//				MPair q = ans[k];
//				for(int l = k+1; l<cnt; l++)
//				{
//					MPair w = ans[l];
//					if(q.a == w.a && q.b == w.b) System.out.println("**"+q.a+" "+q.b);
//				}
//			}
		}
	}
	
	private static String rotate(String n)
	{
		String tmp = ""+n.charAt(n.length()-1);
		for(int i=0; i<n.length()-1; i++)
		{
			tmp += (""+n.charAt(i));
		}
		return tmp;
	}
}