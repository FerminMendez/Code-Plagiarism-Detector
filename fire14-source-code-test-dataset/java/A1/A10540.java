import java.util.*;
import java.io.*;

public class DancingGooglers {

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
			
			// N, the number of Googlers
			int n = input.nextInt();
			// System.err.println(i + " N: " + n); 
			
			// S, the number of surprising triplets of scores
			int s = input.nextInt();
			// System.err.println(i + " S: " + s); 
			
			// p, the value of the best result for a googler
			int p = input.nextInt();
			// System.err.println(i + " P: " + p); 
			
			// y is the maximum number of Googlers who could have had a best result of greater than or equal to p. 
			int y = 0;
		
			for(int j = 0; j < n; j++) {
		
				int totalScore = input.nextInt();
				int remainder = totalScore - 3 * p;
				
				if(remainder >= 0 || ((p - 1) >= 0 && remainder >= -2))
					y++;
				
				else if(((p - 2) >= 0 && remainder >= -4) && s > 0) {
					y++;
					s--;			
				}
								
				// System.err.println(i + " Y: " + y); 
		
			}
			
			output.println(y);
			
			if(input.hasNextLine())
				input.nextLine();
			
		}
	
		output.flush();
	
	}

}