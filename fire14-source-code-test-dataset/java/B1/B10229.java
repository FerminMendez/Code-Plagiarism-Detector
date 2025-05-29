import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int vp[][];
	static int no_vp=0;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t,i;
		t=Integer.parseInt(br.readLine());
		
		for(i=0;i<t;i++)
		{
			st=new StringTokenizer(br.readLine());
			int a,b;
			int result=0;
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			
			no_vp=0;
			vp=new int[1000][2]; // Will not work for Large Input
			boolean ex1=true,ex2=true,ex3=true;
			
			if(b<=10)
			{
				if(b!=10)
				{
					ex1=false;
					ex2=false;
					ex3=false;
					result=0;
				}
				else
				{
					if(a==1)
					{
						ex1=false;
						ex2=false;
						ex3=false;
						result=1;
					}
					
				}
			}
			else if(b<=100)
			{
				if(b!=100)
				{
					ex1=true;
					ex2=false;
					ex3=false;
					result=0;
				}
				else
				{
					if(a==1)
					{
						//Extracting 2 digits from 100 will give 1
						ex1=true;
						ex2=false;
						ex3=false;
						result=1;
					}
				}
			}
			else if(b<=1000)
			{
				if(b!=1000)
				{
					ex1=true;
					ex2=true;
					ex3=false;
					result=0;
				}
				else
				{
					if(a==1)
					{
						//Extracting 3 digits from 1000 will give 1
						ex1=true;
						ex2=true;
						ex3=false;
						result=1;
					}
				}
			}
			else
			{
				ex1=true;
				ex2=true;
				ex3=true;
			}
			
			if(ex1==true)
			{
				int j;
				for(j=a;j<=b;j++)
				{
					int last=j%10;
					int rem=j/10;
					int num=-1;
					if(rem!=0)
					{
						if(rem<10)
						{
							num=last*10+rem;
						}
						else if(rem<100)
						{
							num=last*100+rem;
						}
						else if(rem<1000)
						{
							num=last*1000+rem;
						}
						else
						{
							System.out.println("Not a Valid Case for Small Input");
						}
						if(num>=a && num<=b && j!=num)
						{
							if(j<=num)
							{
								if(add(j,num))
									result++;
							}
							else
							{
								if(add(num,j))
									result++;
							}
						}
					}
					

				}
			}
			if(ex2==true)
			{
				//Do Nothing
			}
			if(ex3==true)
			{
				//Do Nothing
			}
			System.out.println("Case #"+(i+1)+": "+result);

		}
	}
	static boolean add(int m,int n)
	{
		//Pass such that m<n
		boolean uniq_pair=true;
		int i;
		
		for(i=0;i<no_vp;i++)
		{
			int a=vp[i][0];
			int b=vp[i][1];
			if((a==m && b==n) || (b==m && a==n))
				return false;
		}
		vp[no_vp][0]=m;
		vp[no_vp][1]=n;
		no_vp++;
		return uniq_pair;
	}
}

