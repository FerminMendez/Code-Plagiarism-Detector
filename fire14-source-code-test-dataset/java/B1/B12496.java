import java.io.*;
class ProbC
{
	String calculate(int low,int up)
	{	String ans="";
		int anscount=0;
		int l=low;
		int u=up;
		for(int i=l;i<=u;i++)
		{
				String num=Integer.toString(i);
				for(int j=1;j<num.length();j++)
				{
					String first=num.substring(0,j);
					String second=num.substring(j,num.length());
					String now=second+first;
					//System.out.println(now);
					if(now.charAt(0)=='0')
					{
						
					}
					else
					{
						int comp=Integer.parseInt(now);
						if(comp<=up&&i<comp)
						{
							anscount=anscount+1;
						}
					}
			}
		}
	
				return Integer.toString(anscount);
	}

	public static void main(String args[]) 
	throws IOException 
	{
		ProbC obj=new ProbC();
		
		File ii = new File ("C-small-attempt0.in");
		FileInputStream fis = new FileInputStream(ii);
		BufferedReader  br = new BufferedReader(new InputStreamReader (fis));
		int cases = Integer.parseInt(br.readLine());
		FileOutputStream fout = new FileOutputStream ("ProbCoutputsmall.txt");
		DataOutputStream dout = new DataOutputStream (fout);
		
		for(int i=0;i<cases;i++)
		{
			String temp1 = br.readLine();
			String parts [] = temp1.split(" ");
			
			int low=Integer.parseInt(parts[0]);
			int up=Integer.parseInt(parts[1]);
			int uc=0,lc=0;
			int temp=low;
			while(temp>0)
			{
				int a=temp%10;
				temp=temp/10;
				uc++;
			}
			temp=low;
			while(temp>0)
			{
				int a=temp%10;
				temp=temp/10;
				lc++;
			}
			if(uc==lc)
			{
				System.out.println("A and B have same number of digits");
				String result=obj.calculate(low,up);
				String finalans="Case #"+(i+1)+":  "+result+System.getProperty("line.separator");
				dout.writeBytes(finalans);
			}
			else
			{
				System.out.println("A and B do not have same number of digits");
			}
		
		}
	}
}