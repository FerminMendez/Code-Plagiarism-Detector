import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Google code jam.
 * Qualification Round 2012.
 * Problem C. Recycled Numbers
 * 
 * Usage: &lt;app&gt; &lt;input &gt;output
 * 
 * @author sombrabr@gmail.com
 *
 */
public class QualC {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int cases = new Integer(in.readLine());
		
		for(int i=0; i<cases; ++i) {
			String line = in.readLine();
			System.out.print("Case #" + (i+1) + ": ");
			run(line);
		}
	}

	private static void run(String line) {
		String[] parts = line.split(" ");
		
		int digits = parts[0].length();
		
		int A = Integer.parseInt(parts[0]);
		int B = Integer.parseInt(parts[1]);
		
		int count = 0;
		
		for(int n=A; n<=B; ++n) { // n is the number to recycle
			String strN = Integer.toString(n);
			
			if(strN.length()!=digits)
				continue;
			
			HashSet<Integer> numbers = new HashSet<Integer>();
			
			for(int i=1; i<digits; ++i) {
				Pattern p = Pattern.compile("(\\d*)(\\d{" + i + "})");
				Matcher m = p.matcher(strN);
				
				if(!m.matches()) {
					System.err.println("BUG: " + strN + " for " + i + " digits");
					return;
				}
				
				String strNewN = m.group(2) + m.group(1);
				if(strNewN.length() != digits) {
					System.err.println("BUG: " + strN + " for " + i + " digits with " + strNewN);
					return;
				}
				
				int newN = Integer.parseInt(strNewN);
				
				if(n < newN && newN <= B && ! numbers.contains(newN)) {
					count++;
					numbers.add(newN);
				}
			}
		}
		
		System.out.println(count);
	}
}
