import java.io.*;
import java.util.*;

public class Init {

	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		try {
		// ----------------------------------------------------- //
		
			BufferedReader br = new BufferedReader(new FileReader("C:\\input.in"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\output.out"));
			
			int testcases = Integer.parseInt(br.readLine());
			
			// For each test case
			for(int i = 0; i < testcases; i++){
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				int low = Integer.parseInt(st.nextToken());
				int high = Integer.parseInt(st.nextToken());
				int recycled = 0;
				
				// Loop through all numbers in the range
				for (int j = low; j <= high; j++) {
					String currentval = Integer.toString(j);
					
					// Test each arrangement of the current number to see if its a recycled pair
					for (int k = 1; k < currentval.length(); k++) {
						String newvalue = currentval.substring(k) + currentval.substring(0,k);
						if(newvalue.charAt(0) == '0') continue; // Check for leading 0
						int newval = Integer.parseInt(newvalue);
						if(j < newval && newval <= high){
							System.out.print(j);
							System.out.print(" ");
							System.out.println(newval);
							recycled++;
						}
					}
				}
				
				bw.write("Case #"+Integer.toString(i+1)+": "+Integer.toString(recycled));
				bw.newLine();
			}
			
			bw.flush();
			bw.close();
		// ----------------------------------------------------- //
		}
	
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
