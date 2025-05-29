import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class RecycledNumbers
{
	private static final String INPUT_FILE = "input.txt";
	private static final String OUTPUT_FILE = "output.txt";
	
	public int countSiblings(String lowerbound, String upperbound)
	{
		int n = lowerbound.length();
		int start = Integer.parseInt(lowerbound);
		int end = Integer.parseInt(upperbound);
		char[] upChars = upperbound.toCharArray();
		char[] lowChars = lowerbound.toCharArray();
		boolean[] hasSibling = new boolean[end - start + 1];
		int count = 0;
		for (int i = start; i <= end; i++)
		{
			if (hasSibling[i - start]) continue;
			
			char[] iChars = Integer.toString(i).toCharArray();
			int buf = 0;
			for (int j = 1; j < n; j++)
			{
				if (iChars[j] > upChars[0] || iChars[j] < lowChars[0]) continue;
				
				int tenpowj =  (int) Math.pow(10, n- j);
				int cycle = (int) (i / tenpowj + (i % tenpowj) * Math.pow(10, j)); 
				if (cycle > end || cycle < start || hasSibling[cycle - start]) continue;

				if (cycle <= i) continue;
				else
				{
					hasSibling[i - start] = true;
					hasSibling[cycle - start] = true;
					buf++;
				}	
			}
			count += (buf + 1) * buf /2;
		}
		return count;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		RecycledNumbers recycledNumbers = new RecycledNumbers();
		Parser parser = new Parser();
		String[] input = parser.readInput(INPUT_FILE);
		String[] result = new String[input.length];
		for (int i = 0; i < input.length; i++)
		{
			String[] data = input[i].split(" ");
			result[i] = Integer.toString(recycledNumbers.countSiblings(data[0], data[1]));
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

