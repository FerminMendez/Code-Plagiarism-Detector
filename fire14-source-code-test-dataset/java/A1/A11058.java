import java.util.Scanner;
public class rab1
{
	public static void main(String[] aesdfwer)
	{
		Scanner sc= new Scanner (System.in);
		int t=sc.nextInt();
		int o;
		int n,s,p,pt;
		int a,r;
		
		for(int c=1;c<=t;c++)
		{
			n=sc.nextInt();
			s=sc.nextInt();
			p=sc.nextInt();
			o=0;
			
			for(int i=0;i<n;i++)
			{
				pt=sc.nextInt();
				r=pt%3;
				a=pt/3;
				if(a>=p)
				{
					o++;
				}
				else if(r==0)
				{
					if(a+1>=p && a>0 && s>0)
					{
						o++;
						s--;
						//System.out.println(pt+" kasus spesial! sisa "+s);
					}
					
				}
				else if(r==1)
				{
					if(a+1>=p)
					{
						o++;
					}
				}
				else
				{
					if(a+1>=p)
					{
						o++;
					}
					else if(a+2>=p && s>0)
					{
						o++;
						s--;
						//System.out.println(pt+" kasus spesial! sisa "+s);
					}
				}
				//System.out.println(pt+" "+r+" "+a+" "+s+" "+p);
				
			}
			
			System.out.println("Case #"+c+": "+o);
		}
	}
}