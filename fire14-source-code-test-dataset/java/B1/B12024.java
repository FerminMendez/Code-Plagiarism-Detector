import java.io.File;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class CodejamC {

	public static final String TEST = "test.in", SMALL = "C-small-attempt0.in", LARGE = "C-large.in";
	public static final String OUTPUT = "out.txt";
	
	static int count = 0;
	
	public static void main(String[] args) throws Exception
	{
		
		solve(SMALL);
	}

	public static void solve(String filename) throws Exception
	{
		Scanner in = new Scanner(new File(filename));
		
		int cases = in.nextInt();
		in.nextLine();
		
		PrintWriter out = new PrintWriter(new File(OUTPUT));
		
		for(int num = 1; num <= cases; num++)
		{
			int a = in.nextInt();
			int b = in.nextInt();
			count = 0;
			in.nextLine();
			int result = 0;
			Set<Pair> perms = new HashSet<Pair>();
			for(int i = a; i <= b; i++)
			{
				String str = String.valueOf(i);
				for(int j = 0; j < str.length(); j++)
				{
					String newStr = str.substring(str.length() - j, str.length()) + str.substring(0, str.length() - j);
					int val = Integer.parseInt(newStr);
					if(val >= a && val <= b && !newStr.equals(str) && newStr.charAt(0)!='0')
					{
						perms.add(new Pair(str, newStr));
					}
				}
				//perms.remove(str);
			}
			result = perms.size();
			out.println("Case #"+num+": "+result);
			System.out.println("Case #"+num+": "+result);
		}
		
		out.close();
	}
}

class Pair
{
	String n, m;
	
	public Pair(String str, String newStr) {
		n = str;
		m = newStr;
	}

	@Override
	public boolean equals(Object o)
	{
		Pair other = (Pair) o;
		return (n.equals(other.n)&& m.equals(other.m)) || (m.equals(other.n) && n.equals(other.m));
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return n.hashCode() + m.hashCode();
	}
	
	
}
