import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class RecycledNumbers {
	
	public static class permNum
	{
		public permNum(int num, int len, int p1, int p2)
		{
			n = num; 
			l = len;
			a = p1;
			b = p2;
			getnum();
			
			
		}
		public void getnum()
		{
			list= new TreeSet<Integer> ();
			String s = Integer.toString(n);
			//System.out.println(s);
			for(int i = 0; i < l; i++)
			{
				if( Integer.valueOf(s) >= a && Integer.valueOf(s) <= b )
				{
					list.add(new Integer(s));
					
				}
				s = s.substring(1)+s.charAt(0);
				System.out.println(s);
			}
			
			//System.out.println(list.size());
		}
		
		
		
		public int n;
		public int l;
		public int a; 
		public int b;
		public Set<Integer> list;
		public int[] getList() {
			Integer[] ans1 = new Integer[list.size()];
			int[] ans = new int[list.size()];
			ans1 = list.toArray(ans1);
			//System.out.println(ans1.length);
			for(int i = 0; i < ans.length; i++)
			{
				ans[i] = ans1[i].intValue();
				//System.out.println(ans[i]);
			}
			return ans;
			
		}
		
		
		
	}
	
	public static void main(String args[]) throws IOException
	{
		BufferedReader in = new BufferedReader(new FileReader("C-small-attempt0.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("rnum2.out")));
		StringTokenizer st;
		int n = Integer.parseInt(in.readLine());
		for(int i = 0; i < n;i++)
		{
			st= new StringTokenizer(in.readLine());
			out.println("Case #" +(1+i)+": " +Recycle(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()) ) );
			
		}
		
		
		in.close();
		out.close();
		
	}

	

	public static int Recycle(int p1, int p2) {
		int len = Integer.toString(p1).length();
		int ans = 0;
		
		System.out.println("New case p1 = " + p1 +" New case p2 = " + p2);
		if(len <= 1)
		{
			ans = 0;
		}
		else
		{
			int j = p2-p1+1;
			boolean[] y = new boolean[j];
			ArrayList<permNum> a = new ArrayList<permNum>();
			java.util.Arrays.fill(y, true);
			int[] q; 
			for(int i = p1; i <= p2 ; i++)
			{
				if(y[i-p1] )
				{	
					a.add(new permNum( i,  len,p1,p2));
					q = a.get(a.size()-1).getList();
					System.out.println((i)+"  "+q.length);
					if(q.length>1)
					{
						ans += (q.length-1)*(q.length)/2;
						for(int k = 0; k < q.length;k++)
						{
							if(q[k] >= p1 && q[k] <= p2&& q.length>1)
							{
								//System.out.println(q[k]);
								y[q[k]-p1] = false;
							}
						}
					}
				}
				
			}
			
		}
		return ans;
	}
}
