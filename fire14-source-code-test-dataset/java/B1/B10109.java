import java.util.*;
class pqr 
{
	public static void main(String arf[])
	{
		int a;
		Scanner sc=new Scanner(System.in);
		a=sc.nextInt();
		int m=1;
		while(a!=0)
		{
			int p=sc.nextInt();
			int q=sc.nextInt();
			
				int max=0;//the answer
					for(int i=p;i<=q;i++)
					{
						
						int count=0;
						int z=i;
						int t=i;
						
						while(z!=0)
						{
						count++;//no of digits
						z=z/10;
						}
		
					
						for(int j=0;j<count-1;j++)
							{
							String s="";
							s=i%(int)(Math.pow(10,(j+1)))+""+i/(int)(Math.pow(10,(j+1)));
							int y=Integer.parseInt(s);
									if(y<=q && y>=t && y>i)	
									{	
									max++;
									}
			//					System.out.println(max);
								
							}
		
					}
					System.out.println("Case #"+m+": "+max);
		a--;	
			m++;		
		}
	}
}
