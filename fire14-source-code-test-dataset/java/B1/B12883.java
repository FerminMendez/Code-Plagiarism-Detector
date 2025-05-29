import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

class MyPair
{
	public int one = 0;
	public int two = 0;
};

public class ProblemC 
{
	
	
	public static boolean has(int one, int two, LinkedList<MyPair> list)
	{
		for (int i = 0; i < list.size(); i += 1)
		{
			MyPair p = list.get(i);
			
			if (p.one == one && p.two == two) return true;			
		}
		return false;
	}
	public static void add(int one, int two, LinkedList<MyPair> list)
	{
		MyPair p = new MyPair();
		
		p.one = one;
		p.two = two;
		
		list.add(p);
	}
	public static LinkedList<String> strswp(int b)
	{
		String str = b+"";
		LinkedList<String> q = new LinkedList<String>();
		LinkedList<Character> ch = new LinkedList<Character>();
		
		for(int i = 0 ; i < str.length() ; i+=1)
		{
			ch.add(str.charAt(i)) ;
		}
		for(int i = 0 ; i < str.length()-1 ; i+=1)
		{
			String kp = "";
			ch.addFirst(ch.pollLast());
			
			for(int j = 0 ; j < ch.size() ; j++)
			{
				kp += ch.get(j);
			}
			if(kp.charAt(0) != '0' && !kp.equals(str))
			{
				q.add(kp);
			}
			
		}
		
		return q;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("C:\\C-small-attempt1.in"));
		//Scanner sc = new Scanner(new File("C:\\toy.txt"));
		PrintWriter pw = new PrintWriter(new File("C:\\out"));
		int nl = Integer.parseInt(sc.next());
		for(int n = 0 ; n < nl ; n+=1)
		{
			int a = Integer.parseInt(sc.next());
			int b = Integer.parseInt(sc.next());
			int cnt = 0 ;
			LinkedList<String> listcmp = new LinkedList<String>();
			LinkedList<MyPair> mem = new LinkedList<MyPair>();
			
			for(int i = a ; i <= b ; i+=1)
			{
				listcmp = strswp(i);
				
				for(int j = 0 ; j < listcmp.size() ; j+=1)
				{
					int c = Integer.parseInt(listcmp.get(j));
					
					boolean hasss = i < c ? has(i, c, mem) : has(c, i, mem);
					if(c >= a && c<=b && i >= a && i <= b && !hasss)
					{					
						cnt ++;
						//System.out.println(" a = " + i + ", b = " + c);
						if(i<c)
						{
							add(i, c, mem);
						}
						else
						{
							add(c,i,mem);
						}
						//break;
					}
				}
			}

			pw.println("Case #"+(n+1)+": "+cnt);
			pw.flush();
			
			System.out.println("Case #"+(n+1)+": "+cnt);
		
		}
		pw.close();
	}
}
