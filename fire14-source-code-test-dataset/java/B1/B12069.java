/*
 * Google Code Jam 2012 - Qualification Round (14.04.2012)
 * Thomas "ThmX" Denoréaz - thomas.denoreaz@gmail.com
 */

package codejam._2012.qualif;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

public class C {
	
	static final String FILENAME = "C-small-attempt0";

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader(FILENAME + ".in"));
		PrintWriter writer = new PrintWriter(FILENAME + ".out");
		
		int N = Integer.valueOf(reader.readLine());
		for (int i=1; i<=N; i++) {
			
			String[] nums = reader.readLine().split(" "); // -> A B
			int A = Integer.valueOf(nums[0]);
			int B = Integer.valueOf(nums[1]);
			
			
			HashSet<String> set = new HashSet<String>();
			
			for (int n = A; n <= B; n++) {
				String nStr = String.valueOf(n);
				
				int nLen = nStr.length();
				for (int j = 1; j <= nLen-1; j++) {					
					String mStr = String.valueOf( Integer.valueOf( nStr.substring(nLen-j) + nStr.substring(0, nLen-j) ) );
					
					int m = Integer.valueOf(mStr);
					if ((mStr.length() == nStr.length()) && (n < m) && (m <= B)) {
						set.add(n + ":" + m);
					}
				}
				
			}
			
			writer.println("Case #" + i + ": " + set.size());
		}
		
		writer.flush();
		writer.close();
		reader.close();
	}

}
