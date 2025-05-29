
import java.io.BufferedReader;
import java.util.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class program {

	/**
	 * @param args
	 * 
	 * Reads the input file for test cases.
	 */
	//main method for Problem A.
/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File inFile = new File("/home/kolive/Programming/GoogleCodeJam_2012/in");
		
		
		try {
			BufferedReader myReader = new BufferedReader(new FileReader(inFile));
			String tmp = "";
			int i = 1;
			tmp = myReader.readLine();
			while( (tmp = myReader.readLine()) != null)
			{
				
				System.out.print("\nCase #" + i + ": " + ProblemA.translateString(tmp));
				i++;
			}


		} catch (IOException e) {
			System.out.println("Exception Caught: " + e);
		}
	}
*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File inFile = new File("/home/kolive/Programming/GoogleCodeJam_2012/in");
		
		
		try {
			BufferedReader myReader = new BufferedReader(new FileReader(inFile));
			String tmp = "";
			int i = 1;
			tmp = myReader.readLine();
			while( (tmp = myReader.readLine()) != null)
			{
				String arguments[] = tmp.split(" ");
				
				
				System.out.print("\nCase #" + i + ": " + GenerateMaxP(Integer.parseInt(arguments[2]), 
						Arrays.copyOfRange(arguments, 3, arguments.length), 
						Integer.parseInt(arguments[1])));
				i++;
			}


		} catch (IOException e) {
			System.out.println("Exception Caught: " + e);
		}
	}
	
	public static int GenerateMaxP(int p, String[] totalScores, int numSuprising) {
		boolean containsP[] = new boolean[totalScores.length];
		int totalScoresI[] = new int[totalScores.length];
		
		for(int i = 0; i < totalScores.length;i++)
		{
			totalScoresI[i] = Integer.parseInt(totalScores[i]);
		}
		for(int i = 0; i < totalScores.length; i++)
		{
			int[] tmp = ProblemB.generateTriplet(totalScoresI[i]);
			int[] dupe = Arrays.copyOf(tmp, tmp.length);
			
			if (tmp[0] < p)
			{
				containsP[i] = false;
				while(tmp[0] < p && numSuprising > 0)
				{					
					//see if the surprising config has p
					
					
					
					//decrease the next biggest and increase tmp[0], if there's something to borrow from
					if(tmp[1] > tmp[2] && tmp[2] > 0)
					{
						tmp[1]--;
						//start by increasing tmp[0]
						tmp[0] ++;
					}
					else if (tmp[2] > 0)
					{
						tmp[2]--;
						//start by increasing tmp[0]
						tmp[0] ++;
					}else
					{
						//System.out.println( dupe[0] + "," + dupe[1] + "," + dupe[2]);
						break;
					}
					
					//confirm that it's not yet suprising
					if((tmp[0] - tmp[1]) >= 2 || (tmp[0] - tmp[2]) >= 2)
					{
						//if now suprising, and max is included. Accept this result, decrease suprising count
						if(tmp[0] >= p && (tmp[0] - tmp[1]) <= 2 && (tmp[0] - tmp[2]) <= 2)
						{
							containsP[i] = true;
							numSuprising--;
							
							//System.out.println( tmp[0] + "," + tmp[1] + "," + tmp[2] + "*");
							break;
						}
						else
						{
							containsP[i] = false;
							

							//System.out.println( dupe[0] + "," + dupe[1] + "," + dupe[2]);
							break;
						}
					
					}else if(tmp[0] >= p)
					{
						//if not yet suprising, but we've gotten a p, set contains p to true, move on.
						containsP[i] = true;

						//System.out.println( tmp[0] + "," + tmp[1] + "," + tmp[2]);
						break;
					}
					
				}
			}else
			{
				containsP[i] = true;

				//System.out.println( dupe[0] + "," + dupe[1] + "," + dupe[2]);
			}
			
			
			
		}
		int count = 0;
		for(int i = 0; i < containsP.length; i++)
		{
			if(containsP[i])
				count++;
		}
		
		return(count);
	}
	
}
