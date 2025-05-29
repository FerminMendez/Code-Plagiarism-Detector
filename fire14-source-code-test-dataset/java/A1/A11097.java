package QualificationRound;

	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.ArrayList;
import java.util.Dictionary;
import java.util.regex.Pattern;

	public class B
	{
		public B()
		{

		}
		public int solveLine(String in)
		{
			String[] input = in.split(" ");
			int N = Integer.parseInt(input[0]); //N - number of googlers
			int S = Integer.parseInt(input[1]); //S - suprising results
			int P = Integer.parseInt(input[2]); //P - at lest best result criteria
			int P3 = P * 3;
			int Pmin = P3-3;
			int Sleft = S;
			int totalPoints = 0;
			int maxNumOfGooglerDancers = 0;
			if (Pmin == 0)
			{
				Pmin = 2;
			}
			for (int i=0; i<N; i++)
			{
				totalPoints = Integer.parseInt(input[3 + i]);
				if (totalPoints < P3 ) //if the totalScore is less we need to check for special cases 
				{
					if ( totalPoints > Pmin)
					{
						maxNumOfGooglerDancers++;
					}
					else
					if (((totalPoints == Pmin)||((totalPoints == (Pmin-1)))) && (Sleft > 0))
					{
						maxNumOfGooglerDancers++;
						Sleft--;
					}
					
				}
				else
				{
					maxNumOfGooglerDancers++;
				}
			}
			return maxNumOfGooglerDancers;
		}
		
		
				
		public static void calcFromFile(String fileName)
		{
		      
				File file = new File(fileName);
		        BufferedReader reader = null;

		        try {
		            reader = new BufferedReader(new FileReader(file));
		            String sentence = null;
		            // repeat until all lines is read
		            int numOfLine = 1;
		            B q2 = new B();
		            sentence = reader.readLine();
		       
		            	//Read the n test cases
		            	while ((sentence = reader.readLine()) != null) 
			            {
		            		System.out.println("Case #" + numOfLine++ + ": "+q2.solveLine(sentence));
			            }

		            	

		        } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        } finally {
		            try {
		                if (reader != null) {
		                    reader.close();
		                }
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }
		}
	}


