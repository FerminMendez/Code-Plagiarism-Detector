import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
public class Main
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(new FileInputStream(args[0]));
		BufferedWriter bw=new BufferedWriter(new FileWriter(args[1]));
		int testCases=sc.nextInt();
		for(int i=0;i<testCases;i++)
		{	
			int cnt1=0;	
			int best=0;
			int n=sc.nextInt();
			int a1[]=new int[n];
			int surprise=sc.nextInt();
			int limit=sc.nextInt();
			for(int j=0;j<n;j++)
			{
				a1[j]=sc.nextInt();
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
						if(cnt1<surprise)
						{
							cnt1++;
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
			bw.write("Case #"+(i+1)+": " +best);
		bw.newLine();
		bw.flush();
		 
		}
		bw.close();

	}

}
