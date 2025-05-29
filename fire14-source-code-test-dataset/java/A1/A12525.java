

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;


public class Googlers {

	public static void main(String args[]) throws IOException
	{
		int totalValid;
		int surp, numGooglers, maxNum, calcSurp;
		try
		{ 
			PrintWriter wt= new PrintWriter("C:\\Documents and Settings\\windows\\workspace\\test\\src\\file.out.txt");
			Scanner I = new Scanner(new File("C:\\Documents and Settings\\windows\\workspace\\test\\src\\B-small-attempt2.in"));
			String num = I.nextLine();
			int numTests = Integer.parseInt(num);

			for(int x=0; x<numTests; x++)
			{

				int i = 0;
				String[] str = I.nextLine().split(" ");
				int inputs[] = new int[150];
				for(int y = 0; y <str.length; y++ )
				{  
					inputs[y] = Integer.parseInt(str[y]);
				}

				numGooglers = inputs[0];
				surp = inputs[1];
				maxNum = inputs[2];
				totalValid = 0;
				calcSurp = 0;
				for( i = 3; i < numGooglers + 3 ; i++)
				{
					if (isGoogler(inputs[i], maxNum) == 1)
					{
						totalValid++; 
					}
					else if(isGoogler(inputs[i], maxNum) == 2)
					{
						calcSurp++;
					}	
					else
					{}
				}
				
				// match surp numbers
				 if (calcSurp > surp)
				 {	totalValid = totalValid + surp; 
				 }
				 else 
				 {
					totalValid = totalValid + calcSurp;
				 }
				//logic to write totalValid to file
				String finalResult = "Case #"+(x+1)+": "+totalValid;
				
				wt.println(finalResult);
				finalResult = "";
			}
			wt.close();
			I.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}

		catch(IOException e)
		{
			System.out.println(e);
		}
	}


	// Replacement algorithm
	public static int isGoogler (int num,int max)
	{  
		if (max == 0 && max <= num)
			return 1;
	    else if (num <= 0)
	    	return 0;
    	else if (num >= ((max * 3)-2 ))
		 return 1;
		else if (num >= ((max * 3)-4 ))
		 return 2;
		else return 0;
		}
}		 




