import java.util.Scanner;

public class CodeJam3
{
	public static void main(String[] args) 
	{
		Scanner kb=new Scanner(System.in);
		int testCases=kb.nextInt();
		for(int i=0;i<testCases;i++)
		{
			long countValue=0;
			long x1=kb.nextInt();
			long x2=kb.nextInt();
			for(long k=x1;k<x2;k++)
			{
				String s1=new Long(k).toString();
				long lastValue=0;
				long nextValue=0;
				for(int j=1;j<s1.length();j++)
				{ 
					String u=s1.substring(j)+s1.substring(0,j);
					long u1=Long.parseLong(u);
					nextValue=u1;
					if(x1<=k && k<u1 && u1<=x2)
					{
						if(nextValue!=lastValue)
						{
							countValue++;
						}
						lastValue=nextValue;											
					}
				}					
			}
			System.out.println("Case #"+(i+1)+": "+countValue);
		}
		

	}

}
