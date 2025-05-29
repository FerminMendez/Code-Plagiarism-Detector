import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class C
{
	public static void main(String[] args)
	{
		try 
		{
			Scanner reader = new Scanner(new File("c:\\codejam\\Csmall.txt"));
			PrintWriter writer = new PrintWriter(new File("c:\\codejam\\Csmallout"));
			int numCases = Integer.parseInt(reader.next());
			for(int caseNum=0;caseNum<numCases;caseNum++)
			{

				String begin = reader.next();
				String end = reader.next();
				int a = Integer.parseInt(begin);
				int b = Integer.parseInt(end);

				int numLen = begin.length();

				int total = 0;
				for(int current=a;current<=b;current++)
				{
					HashMap<Integer,Integer> candidates = new HashMap<Integer,Integer>();
					new C().getCandidates(current,numLen,candidates);
					for(Integer key : candidates.keySet()) {
						int value = candidates.get(key);
						if(current<value && value<=b)
							total++;
					}
				}
				writer.println("Case #" + (1+caseNum) +": "+total);
			}

			writer.close();

		}

		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}

	public HashMap<Integer,Integer> getCandidates(int current, int length, HashMap<Integer, Integer> candidates) {
		String numStr = String.valueOf(current);
		Integer value;
		for(int loop=1;loop<length;loop++)
		{
			value = Integer.parseInt(numStr.substring(loop)+numStr.substring(0,loop));
			candidates.put(value,value);
		}
		return candidates;
	}
}
