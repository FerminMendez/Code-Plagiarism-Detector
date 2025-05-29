import java.io.*;


public class B
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String[] line;
		int N,S,p;
		int[][] tuple = new int[1000][3];
		int[][] stuple = new int[1000][3];
		int count = 0;
		int scount = 0;

		for(int i=10;i>=0;i--)
		{
			for(int j=i-2;j<=i+2;j++)
			{
				if(j<0 || j>10) continue;
				for(int k=i-2;k<=i+2;k++)
				{
					if(k<0 || k>10) continue;
					if(j-k >2 || k-j > 2)
						continue;
					int a = (i-j > 0) ? i-j : j-i;
					int b = (i-k > 0) ? i-k : k-i;
					int c = (k-j > 0) ? k-j : j-k;

					if(a==2 || b==2 || c==2)
					{
						stuple[scount][0] = i;
						stuple[scount][1] = j;
						stuple[scount++][2] = k;
						continue;
					}
					tuple[count][0] = i;
					tuple[count][1] = j;
					tuple[count++][2] = k;
				}
			}
		}
			

		for(int i=1;i<=T;i++)
		{
			line = br.readLine().split("\\W+");
			N = Integer.parseInt(line[0]);
			S = Integer.parseInt(line[1]);
			p = Integer.parseInt(line[2]);
			int[] score = new int[N];

			for(int j=0;j<N;j++)
				score[j] = Integer.parseInt(line[3+j]);

			int ret = 0;
			for(int j=0;j<N;j++)
			{
				boolean found = false;

				for(int k=0;k<count;k++)
				{
					if((tuple[k][0] + tuple[k][1] + tuple[k][2]) == score[j])
					{
						if(tuple[k][0] >= p || tuple[k][1] >= p || tuple[k][2] >= p)
						{
							found = true;
							ret++;
							break;
						}
					}
				}
				if(!found && S!=0)
				{
					for(int k=0;k<scount;k++)
					{
						if((stuple[k][0] + stuple[k][1] + stuple[k][2]) == score[j])
						{
							if(stuple[k][0] >= p || stuple[k][1] >= p || stuple[k][2] >= p)
							{
								found = true;
								S--;
								ret++;
								break;
							}
						}
					}
				}
			}

			System.out.println("Case #"+i+": "+ret);
		}
	}
}
