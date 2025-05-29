package jam2012;
import java.io.*;
import java.util.*;

// Marian G Olteanu
public class QB
{
	public static void main(String[] args)
	throws Exception
	{
		BufferedReader inputFile = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
		int cases = Integer.parseInt(inputFile.readLine());
		
		PrintStream outFile = new PrintStream(new FileOutputStream(args[1]));
		for (int i = 1; i <= cases; i++)
		{
			String lineT[] = tokenize(inputFile.readLine());
			int N = Integer.parseInt(lineT[0]);
			int S = Integer.parseInt(lineT[1]);
			int p = Integer.parseInt(lineT[2]);
			
			int thresholdAlways = 3 * p - 2;
			int thresholdSurprise = Math.max(1, 3 * p - 4);// if p = 1, score of 0 is not good for surprise
			
			int cntAlways = 0;
			int cntNeedSurprise = 0;
			for (int j = 3; j < lineT.length; j++)
			{
				int value = Integer.parseInt(lineT[j]);
				if (value >= thresholdAlways)
					cntAlways++;
				else if (value >= thresholdSurprise)
					cntNeedSurprise++;
			}
			
			int out = cntAlways + Math.min(S, cntNeedSurprise);
			
			outFile.println("Case #" + i + ": " + out);
		}
		
		
		outFile.close();
		inputFile.close();
	}
	
	
	
	
	public static String[] tokenize(String input)
	{
		StringTokenizer st = new StringTokenizer(input);
		String[] k = new String[st.countTokens()];
		for (int i = 0; i < k.length; i++)
			k[i] = st.nextToken();
		return k;
	}
	public static String[] tokenize(String input, String sep)
	{
		StringTokenizer st = new StringTokenizer(input , sep);
		String[] k = new String[st.countTokens()];
		for (int i = 0; i < k.length; i++)
			k[i] = st.nextToken();
		return k;
	}
	
}

