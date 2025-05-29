import java.util.*;
import java.io.*;

class B
{
	public static void main(String[]args)
	{
		try
		{
			Scanner sc=new Scanner(new File("C-small-attempt0.in"));
			
			int count=sc.nextInt();
			String blank=sc.nextLine();
			
			PrintWriter pr=new PrintWriter(new FileWriter("BAnswer0.in"));
			
			for(int i=1; i<=count; i++)
			{
				int a=sc.nextInt();
				int b=sc.nextInt();
				
				int possible=0;
				
				for (int m=a; m<b; m++)
				{
					for(int n=m+1; n<=b; n++)
					{
						String strM=""+m;
						String strN=""+n;
						
						int lenM=strM.length();
						int lenN=strN.length();
						
						boolean test=false;
						
						if(m!=n&&m<n&&lenM==lenN)
						{
							String[]check=new String [lenM*lenM];
							int checkCount=0;
							
							for(int y=0; y<lenM; y++)//start pos
							{				
								String strTest="";//m arranged
								
								for(int z=y; z<y+lenM; z++)//new pos
								{
									int pos=z;
									
									while(pos>=lenM)
										pos-=lenM;
										
									strTest=strTest+strM.charAt(pos);
								}
								
								if(strTest.equals(strN))
								{
									boolean boolCheck=true;
									
									for(int c=0; c<checkCount; c++)
									{
										if(strTest.equals(check[c]))
											boolCheck=false;
									}
									
									if(boolCheck)
									{
										check[checkCount]=strTest;
										checkCount++;
										possible++;
									}
									
									
								}
								
							}
						}
					}
				}
				
				pr.println("Case #"+i+": "+possible);
			}
			
			pr.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println(e);
		}
		
		catch(IOException f)
		{
			System.out.println(f);
		}	
	}
	
	public static boolean checkRecycle(int m, int n)
	{
		String strM=""+m;
		String strN=""+n;
		
		int lenM=strM.length();
		int lenN=strN.length();
		
		boolean test=false;
		
		if(m!=n&&m<n&&lenM==lenN)
		{
			for(int y=0; y<lenM; y++)//start pos
			{				
				String strTest="";//m arranged
				
				for(int z=y; z<y+lenM; z++)
				{
					int pos=z;
					
					while(pos>=lenM)
						pos-=lenM;
						
					strTest=strTest+strM.charAt(pos);
				}
				
				if(strTest.equals(strN))
				{
					test= true;
				//	System.out.println(strTest+" "+strM+" "+strN);
				}
						else
							test= false;
				
			}
		}else
			test= false;
			
			return test;
	}
}