import java.io.*;
import java.util.*;
import java.lang.*;
class Source2 
{
	public static void main(String[] args) throws IOException 
	{
		String s,word,buffer;
		 FileReader input = new FileReader("C-small.in");
		 BufferedReader in = new BufferedReader(input);
		File file = new File("C-small.out");
		BufferedWriter out = new BufferedWriter(new FileWriter(file));

			s = in.readLine();
		int count= Integer.parseInt(s);

		int i=1;
		 while ((s = in.readLine()) != null && s.length() != 0)
		{
			 out.write("Case #"+(i++)+": ");
				Scanner scan =new Scanner(s);
				buffer="";
			
			
				long A =Integer.parseInt(scan.next());
				long B = Integer.parseInt(scan.next());
			
				
				long ans = calculatemn(A,B);


				out.write(ans+"\n");
		}


		 out.close();
	}


	public static long calculatemn(long A,long B)
	{
		long[][] recyclepair =new long[2000000][2];
		long count=0;
		boolean check=false;
		int re_i=0;

		for(long n=A ;n<=B;n++)
		{
			check=true;
			String stn =n+"";
			String stm =n+"";
			int length =stn.length();

			for(int i=1;i<length;i++)
			{
				stm = recycle(stn,i);
				
				
				long N= Long.parseLong(stn);
				long M =Long.parseLong(stm);

			
				if(M>N&&M<=B)
				{
					boolean pass =true;
					for(int j=0;j<re_i;j++)
					{
						if(recyclepair[j][0]==N&&recyclepair[j][1]==M)
						{
							pass=false;
						}
					}




					if(pass)
					{
					count++;

					recyclepair[re_i][0] =N;
					recyclepair[re_i][1] =M;
					re_i++;
					check=false;
					}
				}
			}

		}
		return count;
	}

	public static String recycle(String stn,int num)
	{

		String last = stn.substring(stn.length()-num,stn.length());

		String first =  stn.substring(0,stn.length()-num);

		return last+first;
	}
}
