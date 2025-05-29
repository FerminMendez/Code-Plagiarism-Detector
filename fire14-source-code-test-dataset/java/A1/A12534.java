import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.Vector;


public class Dancers
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		BufferedReader fin;
		try
		{
			BufferedWriter fout = new BufferedWriter(new FileWriter("C:\\Users\\Nick\\Desktop\\CodeJam2012\\BSmall-2-output.txt"));
			fin = new BufferedReader(new FileReader(args[0]));
			int tests = Integer.parseInt(fin.readLine());
			for(int t = 0; t < tests; t++)
			{
				String line = fin.readLine();
				String[] splitLine = line.split(" ");
				int numScores = Integer.parseInt(splitLine[0]);
				int numSurprises = Integer.parseInt(splitLine[1]);
				int targetScore = Integer.parseInt(splitLine[2]);
				int numAboveScore = 0;
				Vector<Integer> scores = new Vector<Integer>();
				for(int s = 0; s < numScores;s++)
					scores.add(Integer.parseInt(splitLine[s + 3]));
				//Fix score of 0 cases
				if(targetScore > 0)
					while(scores.contains(0))
						scores.remove(new Integer(0));
				//Get all possible >= target score without surprises
				for(int s = 0; s < scores.size(); s++)
				{
					if((scores.get(s) % 3 == 0 && scores.get(s) / 3 >= targetScore) || 
							(scores.get(s) % 3 == 1 && scores.get(s) / 3 + 1 >= targetScore) || 
							(scores.get(s) % 3 == 2 && scores.get(s) / 3 + 1 >= targetScore))
					{
						numAboveScore++;
						scores.remove(s);
						s--;
					}
				}
				//Now add in surprises >= target score
				for(int s = 0; s < scores.size() && numSurprises > 0; s++)
				{
					if((scores.get(s) % 3 == 0 && scores.get(s) / 3 + 1 >= targetScore) || 
							(scores.get(s) % 3 == 1 && scores.get(s) / 3 + 1 >= targetScore) || 
							(scores.get(s) % 3 == 2 && scores.get(s) / 3 + 2 >= targetScore))
					{
						numAboveScore++;
						numSurprises--;
					}
				}
				
				//Print output
				fout.write("Case #" + (t+1) + ": " + numAboveScore);
				fout.newLine();
			}
			fout.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
