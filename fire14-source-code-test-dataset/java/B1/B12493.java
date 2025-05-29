import java.util.*;
import java.io.*;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class q_b {
	
	public static void main(String [] args) {		
		
		// Open files
		try {
			// Open input file
			FileInputStream iStream = new FileInputStream("Sample.in");
			// Get the DataInputStream object
			DataInputStream in = new DataInputStream(iStream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			System.out.println("Input file opened");
			
			// Create output file 
			FileWriter oStream = new FileWriter("Sample.out");
			BufferedWriter out = new BufferedWriter(oStream);
			
			System.out.println("Output file opened");
			
			// Read File Line By Line (and read first line)
			String strLine = br.readLine();
			int testN = Integer.parseInt(strLine);
			int caseN = 1;
			while ((strLine = br.readLine()) != null) {
 
				String[] nums = strLine.split(" ");
				
				int a = Integer.parseInt(nums[0]);
				int b = Integer.parseInt(nums[1]);
				
				int nDigits = nums[0].length();

				out.write("Case #" + caseN + ": ");
				System.out.println(a+" "+b+"             \tCase #" + caseN + ": ");
				
				if (nDigits < 2) {
					out.write("0");
					out.newLine();
					System.out.println("0");
					caseN++;
					continue;
				}
				
				int pow = 1;
				for(int i=0;i<nDigits-1;i++) pow = pow *10;
				
				int nPairs = 0;
					
				for (int i=a; i <= b; i++) {			
					
					int j = i;			
					int k = j;
					System.out.print(j+" ");
					int m = 0;

					for(int z=1; z<nDigits; z++) {
						m = j % 10;
						
						j = j/10 + m*pow;
						
						System.out.print(j+" ");
						if (j <= i || m == 0 || j > b || j == k) continue;
						nPairs++;
						System.out.print("*** ");
						k = j;
					}
					System.out.println();
				}

				String result = Integer.toString(nPairs);
				System.out.println(result);
				out.write(result);
				if (caseN != testN) out.newLine();
				caseN++;
			}
			// Close the streams
			in.close();
			out.close();
		}catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}		
	}

}