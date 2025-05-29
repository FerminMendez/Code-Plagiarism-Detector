import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dancer {
	
	public static void main (String [] args) throws Exception {
		FileInputStream fstreamIn = new FileInputStream ("B-small-attempt0.in");		
		DataInputStream in  = new DataInputStream (fstreamIn);
		BufferedReader is = new BufferedReader (new InputStreamReader(in));

		FileWriter fstreamOut = new FileWriter ("dancer-output.out");
		BufferedWriter out = new BufferedWriter (fstreamOut);
		
		String line = is.readLine();
		int num = Integer.parseInt(line);
		
		for (int i = 0; i < num; i++) { 
			String str = is.readLine();
			StringTokenizer st = new StringTokenizer (str);
			int n = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int max = 0;
			for (int j = 0; j < n; j++) {
				int totalScore = Integer.parseInt(st.nextToken());
				
				if (totalScore == 0) {
					if (p == 0) {
						max += 1;
					} 
					continue;
				}
				
				if (totalScore == 1) {
					if (p <= 1) {
						max += 1;
					}
					continue;
				}
				
				
				if (totalScore / 3 >= p) {
					max += 1;
				} else if (totalScore / 3 < (p-2)) {
					continue;
				} else {
					int sumOfTwo = totalScore - p;
					
					int rest = sumOfTwo - (p-1);
					if (rest > p-2) {
						max += 1;
						continue;	
					} 
					
					rest = sumOfTwo - (p-2);
					if (rest >= p-2) {
						if (s != 0) {
							max += 1;
							s -= 1;
						}
					} 
				}
			}
			out.write("Case #" + (i+1) + ": " + max + "\n");
			
		}
		out.close();
		
		

		
	}
	
			
}