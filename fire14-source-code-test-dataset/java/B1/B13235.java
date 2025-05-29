import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;




public class recyclednumbers {

	public static void main(String [] args) throws Exception
	{
		BufferedReader reader = new BufferedReader (new FileReader("C:\\inputFile.txt"));
		
		int number_of_TestCases = (int) Integer.parseInt(reader.readLine());
		
		long testcases[] [] = new long [number_of_TestCases] [2];
		
		for(int i=0;i<number_of_TestCases; i++)
		{
			String testcase = reader.readLine();
			
			testcase = testcase.trim();
			
			String [] inputs = testcase.split(" ");
			
			testcases[i][0] = Long.parseLong(inputs[0]);
			testcases[i][1] = Long.parseLong(inputs[1]);
			
			long result = findDistinctPairs ( testcases [i][0], testcases[i][1]);
			writeResult(i+1, result);
		}	
	
		
	}
	
	private static long findDistinctPairs(long a, long b) 
	{
		long totalpairs_count = 0;
		
		while(a<=b)
		{
			long pairs_count = findPair(a,b);						
			a++;
			totalpairs_count += pairs_count;
		}
		return totalpairs_count;
	}
	
	private static void writeResult(int testcase, long result) throws Exception
	{
		FileWriter fout = new FileWriter("C:\\recycleout.txt", true);
		String output= "Case #"+testcase+": "+result+System.getProperty("line.separator");
		fout.write(output);
		fout.close();
	}
	
	private static long findPair(long a,long upperLimit)
	{
		long pairs_count =0;
		String a_str = Long.toString(a);
		String b = rotate(a_str);
		

		while(!b.equals(a_str))
		{
			long b_val = Long.parseLong(b);
			if(b_val<=upperLimit && b_val>a ) // also check for leading zero
			{
				pairs_count++;
			
			}
			b = rotate(b);
		}
		return pairs_count;
	}
	
	private static String rotate(String a)
	{
		String num = a;
		char[] digits= num.toCharArray();
		
		String newNum = ""+digits[digits.length-1];
		
		for(int i=0;i<digits.length-1;i++)
			newNum = newNum+digits[i];
		
		return newNum;
	}
}
