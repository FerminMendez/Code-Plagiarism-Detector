package duyonggang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class DancingWithGooglers {

	public static int analyze(String line)
	{
		// parse
		String[] strs = line.split(" ");
		
		int count = Integer.parseInt(strs[0]);
		int surprisingNum = Integer.parseInt(strs[1]);
		int p = Integer.parseInt(strs[2]);
		int[] data = new int[count];

		// analyze
		int commonCounter = 0;
		int surprisingCounter = 0;
		for(int i = 0; i < count; i++)
		{
			data[i] = Integer.parseInt(strs[3 + i]);
			
			if((data[i] > 1 && data[i] >= (3 * p - 2)) || (data[i] == 0 && p == 0) || (data[i] == 1 && p <= 1))
				commonCounter++;
			else if(data[i] > 1 && data[i] >= (3 * p -4))
				surprisingCounter++;
		}
		return commonCounter + 
			(surprisingCounter > surprisingNum ? surprisingNum : surprisingCounter);
	}
	
	public static void main(String[] args) throws Exception
	{
		File input = new File("b.txt");
		FileReader fr = new FileReader(input);
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		line = br.readLine();
		int count = Integer.parseInt(line);
		for(int i = 0; i < count; i++)
		{
			line = br.readLine();
			System.out.println("Case #" + (i + 1) + ": " + DancingWithGooglers.analyze(line));
		}
	}
}
