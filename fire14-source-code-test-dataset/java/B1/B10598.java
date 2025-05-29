package codejam;
import java.io.*;
import java.util.*;

public class RecycledNumbers {

	public static void RecycledNumbersProcess() throws Exception
	{
	
		int t_cases= getT();
		for(int i = 1; i<=t_cases;i++)
		{
				String line = getG();
				long A, B;
				String[] charNUMBERS = line.split(" ");
						
				A = Long.parseLong(charNUMBERS[0]);
				B = Long.parseLong(charNUMBERS[1]);
	
				//Check no of digits
				int NoOfDigits = charNUMBERS[0].length();
				
				HashSet hsUnique = new HashSet();
				hsUnique.clear();
				
				long OutputCount;
				OutputCount = 0;
				
				for(long j=A; j<=B; j++)
				{
				
					long tempA = j;
							
					for(int k = 0; k<NoOfDigits-1; k++)
					{
						long Rem = tempA%10;
						long newA = tempA/10;
						newA = newA + Rem*new Double(Math.pow(10,NoOfDigits-1)).longValue();

						tempA = newA;
						
						//Check for satisfying condition
						if(newA > j && newA >= A && newA <= B)
						{
							OutputCount++;
							
							String jStr = String.valueOf(j);
							String newAStr = String.valueOf(newA);
							
							String pair = jStr + newAStr;

							hsUnique.add(pair);
						}
					}//for loop k
				}//for loop j
			
		
				//System.out.print("Case #" + i + ": " + hsUnique.size()+"\n");
				out.write("Case #" + i + ": " + hsUnique.size()+"\n");
				
				hsUnique = null;

		}
		
	}
	
	public static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	public static File input;
	public static FileReader inputreader;
	public static BufferedReader in;
	public static File output;
	public static FileWriter outputwriter;
	public static BufferedWriter out;
	public static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		
		input = new File("smallinputRN.in.txt");
		inputreader = new FileReader(input);
		in = new BufferedReader(inputreader);
		output = new File("smalloutputRN.out.txt");
		outputwriter = new FileWriter(output);
		out = new BufferedWriter(outputwriter);
		RecycledNumbersProcess();
		close();
	}
	
	
	public static void close() throws IOException {
		if(in!=null)in.close();
		if(inputreader!=null)inputreader.close();
		if(out!=null)out.flush();
		if(out!=null)out.close();
		if(outputwriter!=null)outputwriter.close();
	}
	
	// ************************** INPUT READING *****************
	static String LINE() throws IOException { return in.readLine();}
	static int getT() throws IOException {return Integer.parseInt(LINE());}
	static String getG() throws IOException {return LINE();}
	
}


