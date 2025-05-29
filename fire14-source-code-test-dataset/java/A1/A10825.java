import java.io.*;
import java.util.*;

public class GCJ_Q_B
{
//	public static String 
//	public static int 
//	ArrayList list = new ArrayList();
//	HashMap map = new HashMap();
//	HashSet set = new HashSet();
	
//	for(int i=0;i<;i++)
	
//	for(int j=0;j<;j++)
	
//	for(int k=0;k<;k++)
	
//	System.out.println();
//	System.out.print();
//	System.out.printf("", new Object{});
//	System.out.printf("", new Integer{});
//	System.out.printf("", new Long{});
	
	public static void main(String[] args) throws Exception
	{
	//	Scanner scanner = new Scanner(new FileInputStream("B.txt"));
		Scanner scanner = new Scanner(new FileInputStream("B-small-attempt0.in"));
		//	Scanner scanner = new Scanner(new FileInputStream("B-large.in"));
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("B.out"));
		
		int N = scanner.nextInt();
		//	scanner.nextLine();
		for(int q=1;q<=N;q++)
		{
			int n = scanner.nextInt();
			int s = scanner.nextInt();
			int p = scanner.nextInt();
			int[] t = new int[n];
			for(int i=0;i<n;i++)
				t[i] = scanner.nextInt();
			String ans = answer(s, p, t);
			System.out.println("Case #"+q+": "+ans);
			writer.write("Case #"+q+": "+ans);
			writer.newLine();
		}
		
		writer.close();
		scanner.close();
	}
	
	public static String answer(int s, int p, int[] t) throws Exception
	{
		int c = 0;
		if(p==1)
		{
			for(int i=0;i<t.length;i++)
				if(t[i] >= 1)
					c++;
		}
		else
		{
			int min = p*3-4;
			int ok = p*3-2;
			for(int i=0;i<t.length;i++)
				if(t[i] >= min)
				{
					if(t[i] >= ok)
						c++;
					else if(s>0)
					{
						s--;
						c++;
					}
				}
		}
		
		return c+"";
	}
	
	
	
	// 素因数分解
	static boolean[] primeList = null;
	
	public static int[] dividePrime(int num)
	{
		if(primeList==null)
			primeList = primeListOfEratosthenes(10000);
		
		if(primeList[num] || num==1)
			return new int[]{num};
		
		ArrayList list1 = new ArrayList();
		for(int i=2;true;i++)
		{
			if(num==1)
				break;
			
			if(num%i==0)
			{
				list1.add(new Integer(i));
				num /= i;
				i--;
			}
		}
		
		int[] ret = new int[list1.size()];
		for(int i=0;i<ret.length;i++)
			ret[i] = ((Integer)list1.get(i)).intValue();
		
		return ret;
	}
	
	// 整数分解   1 2 12 3 ...
	public static int[] splitInteger(String s)
	{
		StringTokenizer st = new StringTokenizer(s, " ");
		int[] ret = new int[st.countTokens()];
		for(int i=0;i<ret.length;i++)
			ret[i] = Integer.parseInt(st.nextToken());
		
		return ret;
	}
	
	// 素数リスト
	public static boolean[] primeListOfEratosthenes(int max)
	{
		boolean[] list = new boolean[max+1];
		
		for(int i=2;i<list.length;i++)
		{
			if(!list[i])
			{
				for(int j=i*2;j<=max;j+=i)
					list[j] = true;
			}
		}
		
		for(int i=0;i<list.length;i++)
			list[i] = !list[i];	
		
		list[0] = list[1] = false;
		
		return list;
	}
}
