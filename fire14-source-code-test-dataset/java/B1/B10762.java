import java.util.*;
class xyz
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
	int p=sc.nextInt();
	int t=1;
	while(p!=0)
	{
		int a= sc.nextInt();
		int b=sc.nextInt();
		int cnt=0;
		for(int i=a;i<=b;i++)
		{
			String s=""+i;

			int n=Integer.parseInt(s);
			char c[]=s.toCharArray();
			for(int j=1;j<(c.length);j++)
			{
				char temp;
				temp=c[0];

				for(int k=0;k<(c.length-1);k++)
				{


					c[k]=c[k+1];



				}
				c[c.length-1]=temp;
				String s1=new String(c);
				int w=Integer.parseInt(s1);
				if((w>n)&&(w>=a)&&(w<=b))
					cnt++;


			}
		}
		System.out.println("Case #"+t+": "+cnt);
		t++;
	p--;
	}
	}
}