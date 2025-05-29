import java.io.*;

class GoogleDance{
	
	
	public static int isSurprise(int total, int p)
	{
		int mod = total % 3;
		if(p>total)
		{
			return 2;
		}
		if(mod==0)
		{
			if(p<=total/3)
			{
				return 0;
			}
			else if(p==total/3+1)
			{
				return 1;
			}
		}
		else if(mod==1)
		{
			if(p<=total/3+1)
			{
				return 0;
			}
			
		}
		else if(mod==2)
		{
			if(p<=total/3+1)
			{
				return 0;
				
			}
			else if(p==total/3+2)
			{
				return 1;
			}
		}
		return 2;
	}
	
	public static void main(String[] args) throws IOException
	{
		String filename ="dancers.txt";
		FileReader fr = new FileReader("B-small-attempt0.in");
		BufferedReader br = new BufferedReader(fr);
		FileWriter fstream = new FileWriter("output.txt");
		BufferedWriter out = new BufferedWriter(fstream);
		
		int testcases = Integer.parseInt(br.readLine());
		
		for (int i=1;i<=testcases;i++)
		{
			String line = br.readLine();
			
			int N = Integer.parseInt(line.substring(0, line.indexOf(' ')));
			line = line.substring(line.indexOf(' ')+1);
			int S = Integer.parseInt(line.substring(0, line.indexOf(' ')));
			line = line.substring(line.indexOf(' ')+1);
			
			int p = Integer.parseInt(line.substring(0, line.indexOf(' ')));
			line = line.substring(line.indexOf(' ')+1);
			
			int[] dancers = new int[N];
			for(int k=0;k<N-1;k++)
			{
				int x = Integer.parseInt(line.substring(0, line.indexOf(' ')));
				line = line.substring(line.indexOf(' ')+1);
				dancers[k]=x;
				
			}
			dancers[N-1]=Integer.parseInt(line);
			
			int count = 0;
			for(int l = 0; l<N;l++)
			{
				int check = isSurprise(dancers[l], p);
				if(check==0)
				{
					count++;
				}
				else if(check==1&&S>0)
				{
					count++;
					S--;
				}
				
			}
			
			out.write("Case #"+i+": "+count);
			if(i!=testcases)
			{
				out.write("\n");
			}
		}
		br.close();
		out.close();
	}
}