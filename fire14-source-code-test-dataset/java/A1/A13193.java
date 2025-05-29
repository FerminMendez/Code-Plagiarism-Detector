package classes;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Dancing
{
	public static void main(String[] args)
	{
		try
		{
			FileInputStream fstream = new FileInputStream("/Users/jleibsly2002/B-small-attempt0.in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine = br.readLine();
			int N = Integer.parseInt(strLine);
			
			for(int i = 0; i < N; i++)
			{
				String[] integers = br.readLine().split(" ");
				int num = Integer.parseInt(integers[0]);
				int S = Integer.parseInt(integers[1]);
				int p = Integer.parseInt(integers[2]);
				int[] scores = new int[num];
				for(int j = 3; j < num+3; j++)
				{
					scores[j-3] = Integer.parseInt(integers[j]);
				}
				
				int count = 0;
				
				for(int score : scores)
				{
					if(score==0)
					{
						if(p==0)
						{
							count++;
						}
					}
					else
					{
						int rem = score%3;
						if(rem>0)
						{
							if(rem == 1)
							{
								int noSurprise = (score/3)+1;
								if(noSurprise>=10)
									noSurprise=10;
								if(noSurprise>=p)
								{
									count++;
								}
							}
							else if(rem == 2)
							{
								int noSurprise = (score/3)+1;
								if(noSurprise>=10)
									noSurprise=10;
								if(noSurprise>=p)
								{
									count++;
								}
								else if(S>0)
								{
									int surprise = noSurprise+1;
									if(surprise>=p)
									{
										count++;
										S--;
									}
								}
							}
						}
						else
						{
							int noSurprise = score/3;
							if(noSurprise>=10)
								noSurprise=10;
							if(noSurprise>=p)
							{
								count++;
							}
							else if(S>0)
							{
								int surprise = noSurprise+1;
								if(surprise>=p)
								{
									count++;
									S--;
								}
							}
						}
					}
				}
				
				System.out.println("Case #" + (i+1) + ": " + count);
			}
			
			in.close();
		}
		catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}
	}
}
