import java.util.Scanner;

public class CodeJam1 {

	
	public static void main(String[] args) 
	{
		Scanner kb=new Scanner(System.in);
		int cases=kb.nextInt();
		for(int i=0;i<cases;i++)
		{
			int countSurprise=0;
			int countBest=0;
			int n=kb.nextInt();
			int values[]=new int[n];
			int surprise=kb.nextInt();
			int p=kb.nextInt();
			for(int j=0;j<n;j++)
			{
				values[j]=kb.nextInt();
			}
			
			int arr[][]=new int[n][3];
			for(int j=0;j<n;j++)
			{
				arr[j][0]=values[j]/3;
				int temp=values[j]-arr[j][0];
				int value1=temp/2;
				int value2=temp-value1;
				if(values[j]!=0)
				{
				if(value1-value2==0)
				{
					if(p-value1==1)
					{
						if(countSurprise<surprise)
						{
							countSurprise++;
							countBest++;
							arr[j][1]=value1--;
							arr[j][2]=value2++;
						}
						else
						{
							arr[j][1]=value1;
							arr[j][2]=value2;
						}
					}
					else if (p-value1==0)
					{
						arr[j][1]=value1;
						arr[j][2]=value2;
						countBest++;
					}
					else if(p-value1>1)
					{
						arr[j][1]=value1;
						arr[j][2]=value2;
					}
					else if(p-value1<0)
					{
						arr[j][1]=value1;
						arr[j][2]=value2;
						countBest++;
					}
				}
				
				else if((value2-value1)==1)
				{
					if(p<=value2)
					{
						arr[j][1]=value1;
						arr[j][2]=value2;
						countBest++;
					}
					else 
					{
						arr[j][1]=value1;
						arr[j][2]=value2;
					}
				}
				}
				else{
					if(p==0)
					{
						countBest++;
					}
				}
			}
			System.out.println("Case #"+(i+1)+": " +countBest);
		}

	}

}
