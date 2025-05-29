import java.util.Scanner;


public class A {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T,no1,no2,k=0;
		A obj=new A();	
		T=sc.nextInt();
		int cnt=0;
		while(T>0)
		{	cnt++;
			no1=sc.nextInt();
			no2=sc.nextInt();
			k=0;
			for(int i=no1;i<=no2;i++)
			{
				for(int j=no1;j<=no2;j++)
				{
						if(i!=j)
						{
							k+=obj.chk(i,j);
							
							
						}
					
				}
				
			}
			System.out.println("Case #"+cnt+": "+k/2);
			T--;
		}
	}
	char ip1[]=new char[10];
	char ip2[]=new char[10];
	int length1(int n)
	{int i=0;
		while(n>0)
		{
			n=n/10;
			i++;
		}
		return i;
	}
	public int chk(int a,int b)
	{
		int l1,tn=1;
		l1=length1(a);
		
		
		//System.out.println("n1:"+a+" n2:"+b);

		for(int i=1;i<l1;i++)
		{int at=a,at2,at1;
		tn=1;
			for(int j=1;j<=i;j++)
			{
				tn*=10;
			}
				at1=at%tn;
				//System.out.println("at:"+at1);
				at2=at/tn;
				
				//System.out.println("at:"+at2);
				tn=1;
				for(int j=1;j<=length1(at2);j++)
				{
					tn*=10;
				}	
			int atmp=at1*tn+at2;
			//System.out.println("atmp:"+atmp);

			if(atmp==b)
				return 1;
			
		}
		return 0;
	}


}
