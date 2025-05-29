import java.util.*;
public class CodeJam2
{
	public static void main(String[] args) 
	{
		Scanner bc=new Scanner(System.in);
		int testCases=bc.nextInt();
		for(int i=0;i<testCases;i++)
		{	
			int count1=0;	
			int best=0;
			int n=bc.nextInt();
			int a1[]=new int[n];
			int surprise=bc.nextInt();
			int limit=bc.nextInt();
			for(int j=0;j<n;j++)
			{
				a1[j]=bc.nextInt();
			}
			for(int  q=0;q<n;q++)
			{
				/*System.out.println("The value of array is "+a1[q]);
				*/
			}
			int array1[][]=new int[n][3];
			for(int j=0;j<n;j++)
			{
				array1[j][0]=a1[j]/3;
				int t=a1[j]-array1[j][0];
				int data1=t/2;
				int data2=t-data1;
				if(a1[j]!=0)
				{
				if(data1-data2==0)
				{
					if(limit-data1==1)
					{
						if(count1<surprise)
						{
							count1++;
							best++;
							array1[j][1]=data1--;
							array1[j][2]=data2++;
						}
						else
						{
							array1[j][1]=data1;
							array1[j][2]=data2;
						}
					}
					else if (limit-data1==0)
					{
						array1[j][1]=data1;
						array1[j][2]=data2;
						best++;
					}
					else if(limit-data1>1)
					{
						array1[j][1]=data1;
						array1[j][2]=data2;
					}
					else if(limit-data1<0)
					{
						array1[j][1]=data1;
						array1[j][2]=data2;
						best++;
					}
				}
				
				else if((data2-data1)==1)
				{
					if(limit<=data2)
					{
						array1[j][1]=data1;
						array1[j][2]=data2;
						best++;
					}
					else 
					{
						array1[j][1]=data1;
						array1[j][2]=data2;
					}
				}
				}
				else{
					if(limit==0)
					{
						best++;
					}
				}
			}
			System.out.println("Case #"+(i+1)+": " +best);
		}

	}

}
