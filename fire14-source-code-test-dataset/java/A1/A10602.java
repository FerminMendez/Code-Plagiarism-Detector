import java.io.*;
import java.util.StringTokenizer;
public class Dancing
{
	public static void main(String[] args)
	{
		    
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		int tc,data[],result[],nog,sc,exno;
		int av,rem,count;
		String s,s1;
		StringTokenizer st;
		
		try
		{
			tc=Integer.parseInt(br.readLine());
			result=new int[tc];
			for(int i=0;i<tc;i++)
			{
				int j=0;
				s=br.readLine();
				st=new StringTokenizer(s," ");
				data=new int[st.countTokens()+1];

				while(st.hasMoreTokens())
				{
					s1=st.nextToken();
					data[j]=Integer.parseInt(s1);
					j++;
					
				}
				
				nog=data[0];
				sc=data[1];
				exno=data[2];
				count=0;
				for(int k=3;k<nog+3;k++)
				{
					
					
					av=data[k]/3;
					rem=(data[k])%3;

					if(av>=exno)
					{
						count++;
						continue;
					}
					
					if(rem==0&&sc!=0&&av+1>=exno&&data[k]>exno)
					{
						sc--;
						count++;
						continue;
					}

					if(rem==1&&(av+rem)>=exno)
					{
						count++;
						continue;
					}
					
					if(rem==2)
					{
						if(av+1>=exno)
						{
							count++;
							continue;
						}
						if(sc!=0&&av+2>=exno)
						{	
							count++;
							sc--;
						}
					}
					
						
				}
				
				result[i]=count;
				
				
			}
			
			for(int i=0;i<tc;i++)
				System.out.println("Case #"+(i+1)+": "+result[i]);			

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

	}
}