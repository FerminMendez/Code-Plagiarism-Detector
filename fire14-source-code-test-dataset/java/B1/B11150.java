package QualificationRound;

	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.ArrayList;
import java.util.Dictionary;
import java.util.regex.Pattern;

	public class C
	{
		public C()
		{

		}
		public int shiftNumber(int num,int NumOfDigints)
		{		
			int tempDigit = num % 10;
			num = num/10;
			for (int i=0;i<(NumOfDigints-1); i++)
			{
				tempDigit *= 10;
			}
			tempDigit += num;
			return tempDigit;
		}
		public int solveLine(String in)
		{
			String[] input = in.split(" ");
			int A = Integer.parseInt(input[0]); //N - number of googlers
			int B = Integer.parseInt(input[1]); //S - suprising results
			int numberOfRecycledNumbers = 0;
			for (int i=A; i<=B; i++)
			{
				int shifted = i;
				int tempNum = i;
				int NumOfDigints = 0;
				while (tempNum > 0)
				{
					NumOfDigints++;
					tempNum /= 10;
				}
				do
				{
					shifted = shiftNumber(shifted,NumOfDigints);
					if ((shifted > i)&& (shifted<=B))
					{
						numberOfRecycledNumbers++;
					}
				}while(shifted != i);
			}
			return numberOfRecycledNumbers;
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
		            C q3 = new C();
		            sentence = reader.readLine();
		       
		            	//Read the n test cases
		            	while ((sentence = reader.readLine()) != null) 
			            {
		            		System.out.println("Case #" + numOfLine++ + ": "+q3.solveLine(sentence));
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


