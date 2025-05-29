package jam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class CodeJam2012Q2 {
	public static void main(String [] args){
		final String FILE_NAME="B-small-attempt0.in";
		StringTokenizer st;
		
		//IOUsage Variables
		String lineIn="";
		int numCases=0;
		
		//Index Variables
		
		//Contest Vars
		int numGooglers = 0;
		int numSurprising = 0;
		int atLeastResult = 0;
		int[] googlerScores;
		
		int numGP = 0;
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
			lineIn = br.readLine();
			numCases = Integer.parseInt(lineIn);
			for(int i=0; i<numCases; i++)
			{
				lineIn = br.readLine();
				st = new StringTokenizer(lineIn);
				numGooglers = Integer.parseInt(st.nextToken());
				numSurprising = Integer.parseInt(st.nextToken());
				atLeastResult = Integer.parseInt(st.nextToken());
				googlerScores = new int[numGooglers];
				
				for(int j=0; j<numGooglers; j++)
				{
					googlerScores[j] = Integer.parseInt(st.nextToken());
				}
				
				for(int j=0; j<numGooglers; j++)
				{
					if(googlerScores[j]==0)
					{
						if(atLeastResult==0)
						{
							numGP++;
						}
					}
					else if(googlerScores[j]==1)
					{
						if(atLeastResult==0 || atLeastResult==1)
						{
							numGP++;
						}
					}
					else if(googlerScores[j]==2)
					{
						if(atLeastResult==0 || atLeastResult==1)
						{
							numGP++;
						}
						else if(atLeastResult==2)
						{
							if(numSurprising>0)
							{
								numGP++;
								numSurprising--;
							}
						}
					}
					else
					{
						if((googlerScores[j] % 3) == 0)
						{
							if((googlerScores[j]/3) - atLeastResult > -1 )
							{
								numGP++;
							}
							else if((((googlerScores[j]/3) - atLeastResult) == -1) && numSurprising>0)
							{
								numGP++;
								numSurprising--;
							}
						}
						else if((googlerScores[j] % 3) == 1)
						{
							if (((googlerScores[j]/3)+1) - atLeastResult >= 0)
							{
								numGP++;
							}
						}
						else if((googlerScores[j] % 3) == 2)
						{
							if((googlerScores[j]/3) - atLeastResult + 1 > -1 )
							{
								numGP++;
							}
							else if((((googlerScores[j]/3) - atLeastResult + 1) == -1) && numSurprising>0)
							{
								numGP++;
								numSurprising--;
							}
						}
					}
				}
				System.out.println("Case #"+(i+1)+": "+numGP);
				
				numGP=0;
			}
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		
		
	}
}
