import java.util.*;
public class Recycled {
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int cases=in.nextInt();
		for(int i=1; i<=cases; i++)
		{
			int a=in.nextInt(), b=in.nextInt();
			long ans=0;
			for(int x=a; x<=b; x++)
			{
				for(int y=x+1; y<=b; y++)
				{
					String one=Integer.toString(x), two=Integer.toString(y);
					if(one.length()!=two.length())
						break;
					for(int s=1; s<two.length(); s++)
					{
						String temp=two.substring(s)+two.substring(0, s);
						if(temp.equals(one))
						{
							ans++;
							break;
						}
					}
				}
			}
			System.out.printf("Case #%d: %d%n",i,ans);
		}
	}
}
