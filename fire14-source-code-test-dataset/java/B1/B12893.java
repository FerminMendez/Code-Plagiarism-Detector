import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;


public class QRC 
{
	// Basics for all problems
	private static final String LARGE = "large";
	private static final String SMALL = "small";
	private static final String IN = ".in";
	private static final String OUT = ".out";
	private static String SET;
	
	// Problem specific Globals
	private static Set<Pair> mPairs;
	
	public static void main(String[] args) throws Exception
	{
		SET = SMALL; // Which set id being evaluated
		readInputFile(SET+IN);
	}
	
	private static void readInputFile(String in) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader(new File(SET+IN)));
		String line = null;
		int caseCount = 1;
		
		br.readLine();
		while ( (line = br.readLine()) != null )
		{
			String[] input = line.split(" ");
			final int A = Integer.parseInt(input[0]);
			final int B = Integer.parseInt(input[1]);
			mPairs = new HashSet<Pair>();
			for (int n = A; n < B; n++ )
			{
				String rotation = String.valueOf(n);
				int digitCount = rotation.length();
				for ( int i = 0; i < digitCount; i++ )
				{
					rotation = rotateN(rotation);
					int m = Integer.parseInt(rotation);
					if ( m > n && m <= B )
					{	
						mPairs.add(new Pair(n,m));
						//System.out.println(" --> ("+n+", "+m+") @ "+mPairs.size());
					}
				}
			}
			writeOutputLine(String.format("Case #%d: %d", caseCount, mPairs.size()));
			caseCount++;
		}
		
		br.close();
	}
	
	private static String rotateN(String nAsString)
	{	
		String bulk = nAsString.substring(0,nAsString.length()-1);
		char jumper = nAsString.charAt(nAsString.length()-1); 
		return jumper+bulk;
	}
	
	private static void writeOutputLine(String line) throws Exception
	{
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(SET+OUT),true));
		bw.append(line);
		bw.newLine();
		bw.flush();
		bw.close();
	}
}
