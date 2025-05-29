import java.util.Scanner;

public class QualC
{
	public static void main(String args[])
	{
		Scanner kb = new Scanner(System.in);
		int ntc = kb.nextInt();
		
		for(int tc=0;tc<ntc;tc++)
		{
			int out = 0;
			int a = kb.nextInt();
			int b = kb.nextInt();
			
			for(int n=a;n<b;n++)
			{
				int temp = n;
				int nn = 0;
				while(temp>0)
				{
					nn++;
					temp/=10;
				}
				
				int chk[] = new int[nn];
				for(int q=1;q<nn;q++)
				{
					int f = 0;
					int m = n%((int)Math.pow(10,nn-q)) * (int)Math.pow(10,q) + n/((int)Math.pow(10,nn-q));
					chk[q] = m;
					for(int z=1;z<q;z++)
					{
						if(m == chk[z])
						{
							f = 1;
							break;
						}
					}
					if(n<m && m>=a && m<=b && m/(int)Math.pow(10,nn-1)>0 && f==0)
					{
						out++;
					}
				}
			}
			
			System.out.println("Case #" + (tc+1) + ": " + out);
		}
	}
}
