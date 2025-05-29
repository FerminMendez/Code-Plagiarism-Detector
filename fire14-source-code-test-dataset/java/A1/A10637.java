import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

//Importing Java.io package classes to perform file management operations

//DANCE OF GOOGLERS

public class DanceOfGooglers
{	
	DanceOfGooglers()
	{
		Combinations combinations[] = new Combinations[31];
		for(int i = 0 ; i < 31 ; i++)
		{
			combinations[i] = new Combinations();
		}
	}

	static void doSort(int G[] , int N)
	{
		for(int i = 0 ; i < (N-1) ; i++)
		{
			int min = i;

			for(int j = (i + 1) ; j < N ; j++)
			{
				if(G[j] < G[min])
				{
					min = j;
				}
			}

			if(min != i)
			{
				int temp = G[min];
				G[min] = G[i];
				G[i] = temp;
			}
		}
	}

	public static void main(String[] args)
	{
		int limit = 30;
		int maxInt = 10;

		//Since there are total 31 Numbers 0-30 (Inclusive)
		Combinations combinations [] = new Combinations[31];

		for(int l = 0 ; l < 31 ; l++)
		{
			combinations[l] = new Combinations();
		}

		for(int sum = 0 ; sum <= limit ; sum++)
		{
			for(int i = 0 ; i <= maxInt ; i++)
			{
				for(int j = 0 ; j <= maxInt ; j++)
				{
					for(int k = 0 ; k <= maxInt ; k++)
					{
						if((i + j + k) > sum)
						{
							break;
						}

						if((i + j + k) == sum)
						{
							combinations[sum].populateSets(i, j, k);
							break;
						}
					}
				}
			}			
		}

		try
		{
			// Open the input file
			FileInputStream fistream = new FileInputStream("B-small-attempt0.in");
			
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fistream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			
			//Create output file
			File file = new File("output.out");
			boolean exist = file.createNewFile();
			
			if (!exist)
			{
				System.out.println("File already exists.");
				System.exit(0);
			}
			
			FileWriter fostream = new FileWriter("output.out");
			BufferedWriter out = new BufferedWriter(fostream);
			
			int counter = 0;		//Counter purpose
			
			//Read File Line By Line
			int totalNumberOfCases = 0;
			while ((strLine = br.readLine()) != null)
			{
				if(counter == 0)
				{
					//Ignore the first Line for Conversion
					totalNumberOfCases = Integer.parseInt(strLine);
					counter++;
					continue;
				}
				
				String[] results = strLine.split(" ");
				
				int N = Integer.parseInt(results[0]);
				int S = Integer.parseInt(results[1]);
				int P = Integer.parseInt(results[2]);
				int G[] = new int[N];
				
				//int suprisesRemaining = 0;
				int maxBestResult = 0;
				
				for (int i = 0 ; i < N ; i++)
				{
					G[i] = Integer.parseInt(results[i+3]);
				}
				
				doSort(G , N);
				
				//System.out.println(combinations[G[0]].bestResult[0] + " " + combinations[G[0]].bestResult[1]);
				
				for(int i = 0 ; i < N ; i++)
				{
					if(combinations[G[i]].bestResult[1] < P)	//Non Surprising 
					{
						if(combinations[G[i]].bestResult[0] < P || combinations[G[i]].bestResult[0] == 1000)	//Surprising
						{
							//Ignore
							continue;
						}
						else
						{
							if(S != 0)
							{
								maxBestResult++;
								S--;
							}
						}
					}
					else
					{
						maxBestResult++;			
					}
				}
				
				// Print the content in the output file
				out.write("Case #" + counter + ": " + maxBestResult);
				
				
				//System.out.println(N + " " + S + " " + P + " " + G[0] + " " + G[1] + " " + G[2]);
				/*
				System.out.println("Displaying Combinations");
				System.out.println("=======================");
				
				for(int i = 0 ; i < 31 ; i++)
				{
					combinations[i].displayCombinations(i);
				}
				*/
				
				if(counter < totalNumberOfCases)
				{
					out.write("\n");
				}
				counter++;
			}

			//Close the input stream
			in.close();

			//Close the output Stream
			out.close();

		}
		catch(Exception e)
		{
			//Catch exception if any
			System.err.println("Error: " + e.getMessage() + " : " + e);
		}
	}
}