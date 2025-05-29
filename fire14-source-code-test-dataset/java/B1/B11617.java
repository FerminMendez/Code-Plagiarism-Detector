import java.util.*;
public class permute 
{
	static LinkedList<Integer>[] build;	
	public static void Permute()
	{
		build = new LinkedList[1001];
		for(int i=1 ; i<=1000 ; i++)
		{
			build[i] = new LinkedList();
			String str = new String(i+"");
			for(int j=0 ; j<str.length() ; j++)
			{
				char s2 = str.charAt(0);
				str = str+s2;
				str = str.substring(1);
				int num = new Integer(str);
				if(num>i && !build[i].contains(num))	build[i].add(num);
			}
		}
	}
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		Permute();
		int cnt = scan.nextInt();
		for(int c=1 ; c<=cnt ; c++)
		{
			int start = scan.nextInt(),end = scan.nextInt(),res = 0;
			for(int i=start ; i<=end ; i++)
				for(int j=0 ; j<build[i].size() ; j++)
					if(build[i].get(j)<=end)
						res ++;
			System.out.println("Case #"+c+": "+res);
		}
		
	}
}
