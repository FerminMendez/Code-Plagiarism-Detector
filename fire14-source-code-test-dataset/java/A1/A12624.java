import java.io.*;

class Dance
{	
	public static void main(String a[]) throws Exception
	{
		BufferedReader br=new BufferedReader( new InputStreamReader(System.in) );
		int testCases=Integer.parseInt(br.readLine());
		String str;
		int count=0;
		for(int i=0;i<testCases;i++)
		{
				str=br.readLine();
				String[] cases=str.split(" ");
				int arr[]=new int[cases.length];
				for(int ii=0;ii<arr.length;ii++)
				{
					arr[ii]=Integer.parseInt(cases[ii]);
				}
				int answer=0;
				if(arr[0]==0)
				{
					answer=0;
				}
				else
				{
					int n=arr[0];
					int s=arr[1];
					int p=arr[2];
					int surprising=0;
					int valid;
					if(p==0)
					{
						for(int iii=3;iii<arr.length;iii++)
						{
							if(arr[iii]>=0)
							{
								answer++;
							}
						}
					}
					else
					{
						if(p==1)
						{
							for(int iii=3;iii<arr.length;iii++)
							{
								valid=1;
								if(arr[iii]>=valid)
								{
									answer++;
								}
							}			
						}
						else
						{
							valid=p*3-4;
							for(int j=3;j<arr.length;j++)
							{
								if(arr[j]>(valid+1))
								{
									answer++;
								}
								else
								{
									if(((arr[j]==valid)||(arr[j]==(valid+1)))&&(surprising<s))
									{
										surprising++;
										answer++;
									}
								}
							}
						}
					}
					System.out.println("Case #"+(++count)+": "+answer);
				}	
		}
	}
}