import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Google code jam.
 * Qualification Round 2012.
 * Problem B. Dancing With the Googlers
 * 
 * Usage: &lt;app&gt; &lt;input &gt;output
 * 
 * @author sombrabr@gmail.com
 *
 */
public class QualB {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int cases = new Integer(in.readLine());
		
		run(in, cases);
	}
	
	static void run(BufferedReader in, int cases) throws IOException {
		for(int i=0; i<cases; ++i) {
			String line = in.readLine();

			System.out.print("Case #" + (i+1) + ": ");
			
			String[] parts = line.split(" ");
			
			int j=0;
			int N = Integer.parseInt(parts[j++]); // Number of Googlers
			int S = Integer.parseInt(parts[j++]); // Surprising triplets
			int p = Integer.parseInt(parts[j++]); // Best result base
			
			int tripletScore = p+2*(Math.max(0, p-2)); // Triplet score
			int minimumScore = p+2*(Math.max(0, p-1)); // Minimum score not a triplet
			
			int surprisings = 0; // Total surprisings already found
			
			int googlers = 0; // Count of Googlers with p
			
			for(int k=0; k<N; ++k) {
				int t = Integer.parseInt(parts[j++]); // Total score
				
				if(t>=minimumScore) {
					googlers++;
				} else if(t>=tripletScore && surprisings<S) {
					surprisings++;
					googlers++;
				}
			}
			
			System.out.println(googlers);
		}
	}
}
