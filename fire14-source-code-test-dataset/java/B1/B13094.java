package RecycledNumbers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RecycledNumbers {
	public static void main(String[] args) {
		try {
			// lets get the data in
			FileInputStream fstream = new FileInputStream("E:/workspace_java/CodeJam12/src/RecycledNumbers/input.in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			
			// open file for writing
			FileWriter fwstream = new FileWriter("E:/workspace_java/CodeJam12/src/RecycledNumbers/output.out");
			BufferedWriter out = new BufferedWriter(fwstream);
			
			// declare variables
			int i,j,k;
			int numCases;
			String[] strArr;
			
			// get number of cases
			strLine = br.readLine();
			numCases = Integer.parseInt(strLine);
			
			// declare specific vars
			int low, high, n;
			int cur, len;
			int count;
			String ts, ns, a, b;
			ArrayList<String> found = new ArrayList<String>();
			
			// loop through cases
			for(i=0;i<numCases;i++){
				// read case
				strLine = br.readLine();
				strArr = strLine.split(" ");
				
				count = 0;
				
				low = Integer.parseInt(strArr[0]);
				high = Integer.parseInt(strArr[1]);
				
				for(j = low; j <= high; j++){
					cur = j;
					ts = new Integer(cur).toString();
					len = ts.length();
					//System.out.print(ts + " => ");
					for(k = len - 1; k >= 0; k--){
						a = ts.substring(k);
						b = ts.substring(0, k);
						n = Integer.parseInt(a + b);
						ns = new Integer(n).toString();
						if(n >= low && n <= high && n > cur && !(in_array(ns+ts, found))){
							count++;
							//System.out.print(ns + " ");
						}
					}
					//System.out.println();
				}
				
				
				/* final tests	
					if((one >= 0 && one <= 10) && (two >= 0 && two <= 10) && (three >= 0 && three <= 10)) { }
					else { System.out.println("Out of bounds on number"); }
					
					if(total != tempScore) { System.out.println("Score does not add up"); }
					
					if(surprisesTaken > numSurprises) { System.out.println("Too many surprises"); }
					*/
				
					
					
					//System.out.println(one + " " + two + " " + three);
				System.out.print("Case #"+(i+1)+": ");
				out.write("Case #"+(i+1)+": ");
				System.out.println(count);
				out.write(Integer.toString(count));
				out.newLine();
			}
			
			
			//System.out.print("Case #"+(i+1)+": ");
			//out.write("Case #"+(i+1)+": ");
			//System.out.println(seanP2sum);
			//out.write(Integer.toString(seanP2sum));
			//out.newLine();
			
			
			out.close();
			in.close();
			
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}

	}
	
	public static boolean in_array(String needle, ArrayList<String> haystack){
		boolean found = false;
		int i = 0;
		int len = haystack.size();
		
		for(i=0; i<len; i++){
			if(needle.equals(haystack.get(i))){
				found = true;
				System.out.println("found match of "+needle + " matching " + haystack.get(i) + " at index " + i);
			}
			
		}
		
		return found;
	}
}
