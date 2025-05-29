import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class DancingWiththeGooglers 
{
	
	private static final String INPUT_FILE = "input.txt";
	private static final String OUTPUT_FILE = "output.txt";
	
	//but not surpising
	public boolean couldGetBest(int score, int best)
	{
		int average = best * 3;
		
		if (score >= average - 2) return true;
		
		return false;
	}
	
	public boolean couldGetBestIfSurprising(int score, int best)
	{
		int average = best * 3;
		
		if (score >= average - 4) return true;
		
		return false;
	}
	
	public int findMaxBest(int minBest, int[] dancersScore, int surprisingCount)
	{
		int result = 0 ;
		for (int i = 0; i < dancersScore.length; i++)
		{
			if (dancersScore[i] < minBest) continue; 
			if (couldGetBest(dancersScore[i], minBest))
			{ 
				result ++;  
				continue;
			}
			if (couldGetBestIfSurprising(dancersScore[i], minBest))
			{
				if (surprisingCount != 0)
				{	
					surprisingCount--;
					result++;
					continue;
				}
			}
					
		}
		return result;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		DancingWiththeGooglers danGooglers = new DancingWiththeGooglers();
		Parser parser = new Parser();
		String[] input = parser.readInput(INPUT_FILE);
		String[] result = new String[input.length];
		for (int i = 0; i < input.length; i++)
		{
			String[] data = input[i].split(" ");
			int dancersCount = Integer.parseInt(data[0]);
			int surprisingCount = Integer.parseInt(data[1]);
			int minBest = Integer.parseInt(data[2]);
			int[] dancersScores = new int[dancersCount];
			for (int j = 0; j < dancersCount; j++)
			{
				dancersScores[j] = Integer.parseInt(data[3 + j]);
			}
			result[i] = Integer.toString(danGooglers.findMaxBest(minBest, dancersScores, surprisingCount));
		}
		parser.writeOutput(result, OUTPUT_FILE);
	}
}

class Parser
{
	public String[] readInput(String fileName) throws NumberFormatException, IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		int numberOfCases = Integer.parseInt(reader.readLine());
		String[] input = new String[numberOfCases];
		for (int i = 0; i < numberOfCases; i++)
		{
			input[i] = reader.readLine();
		}
		reader.close();
		return input;
	}
	
	public void writeOutput(String[] result, String file) throws IOException
	{
		FileWriter writer = new FileWriter(file);
		BufferedWriter bufferedWriter = new BufferedWriter(writer);
		for (int i = 0; i < result.length; i++)
		{
			bufferedWriter.write("Case #" + (i+1) +": " + result[i]);
			bufferedWriter.newLine();
		}
		bufferedWriter.flush();
		bufferedWriter.close();
	}
}

