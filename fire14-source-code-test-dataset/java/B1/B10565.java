import java.util.*;
import java.io.*;

public class RecycledNumbers {

	private static int numTest;
	private static Scanner input;
	private static PrintWriter output;
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
	
		// Initialization of Input/Output streams
		input = new Scanner(new File(args[0]));
		output = new PrintWriter(new File("output"));
		
		// Reads char by char the input dimension
		numTest = input.nextInt();
		input.nextLine(); // reads the \n character
		
		// Solves the problem
		for(int i = 1; i <= numTest; i++) {

			output.print("Case #" + i + ": ");
			
			int a = input.nextInt();
			int b = input.nextInt();			
			//System.err.println(i + " A: " + a);
			//System.err.println(i + " B: " + b);
		
			int numRecycled = 0;
		
			int n = a;
			int m = 0;
			while(n <= b) {
								
				String nString = n + "";
				int nDigits = nString.length();
			
				
				/* the HashMap prevents to count moore times couples like <1212, 2121>
				 * generated using 2 ++ 121 or 121 ++ 2
				 */
				HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
				
				// extracts different substrings from the tail and count them
				for(int j = 1; j < nDigits; j++) {
				
					String head = nString.substring(0, j);
					String tail = nString.substring(j, nDigits);
					
					// System.err.print(i + " n: " + n);
					
					if(!tail.startsWith("0")) {
						
						m = Integer.parseInt(tail + head);			
						// System.err.print(" m: " + m);
						
						if(m > n && m <= b) {
							map.put(m, n);
							// System.err.print(" *");
						}
					
					}
					
					// System.err.println();

				}
				numRecycled += map.size();
				n++;
				
			}
			
			output.println(numRecycled);
			
			if(input.hasNextLine())
				input.nextLine();
			
		}
	
		output.flush();
	
	}

}