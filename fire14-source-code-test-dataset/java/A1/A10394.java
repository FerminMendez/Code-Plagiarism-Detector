package googleCodeJam;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ProblemB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			// Open the file that is the first 
			// command line parameter
			FileInputStream fstream = new FileInputStream("input.txt");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			br.readLine();
			int counter = 1;
			//Read File Line By Line
			while ((strLine = br.readLine()) != null)   {
				String values[] = strLine.split(" ");
				
				int surprisingScores = Integer.parseInt(values[1]);
				
				int pValue = Integer.parseInt(values[2]);
				
				int nearP = 0;
				int aboveP = 0;
				
				for (int i = 3; i < values.length; i++)
				{
					int score = Integer.parseInt(values[i]);
					
					int maxScore = 0;
					int maxSurprisingScore = 0;
					
					if (score > 0)
					{
						maxScore = (score - 1) / 3 + 1;
						maxSurprisingScore = (score + 1) / 3 + 1;
					}
					
					if (maxScore > 10)
					{
						maxScore = 10;
					}
					
					if (maxSurprisingScore > 10)
					{
						maxSurprisingScore = 10;
					}
					
					if (maxScore >= pValue)
					{
						aboveP ++;
					}
					else if (maxSurprisingScore >= pValue)
					{
						nearP ++;
					}
				}
				
				int result = aboveP;
				
				if (nearP < surprisingScores)
				{
					result += nearP;
				}
				else
				{
					result += surprisingScores;
				}
				
				System.out.println("Case #" + counter + ": " + result);
				
				counter ++;
			}
			//Close the input stream
			in.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

}
