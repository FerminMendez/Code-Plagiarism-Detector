import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;


public class RecycledNumbers {		
	
	public static void main(String[] args) throws NumberFormatException, IOException {				
		FileInputStream inFile = new FileInputStream(new File("resources/codejam/RecycledNumbers.in"));			
		DataInputStream in = new DataInputStream(inFile);

		FileOutputStream outFile = new FileOutputStream(new File("resources/codejam/RecycledNumbers.out"));
		DataOutputStream out = new DataOutputStream(outFile);

		int cases = Integer.parseInt(in.readLine());
		
		for(int i=0;i<cases;i++) {
			doCase(i+1, in, out);
			if(i != cases - 1) {
				out.writeBytes("\n");
			}
		}
	}

	private static void doCase(int caseNo, DataInputStream in, DataOutputStream out) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("Case #");
		sb.append(caseNo);
		sb.append(": ");
		
		int recycles = 0;
		
		Scanner s = new Scanner(in.readLine());
		int a = s.nextInt();
		int b = s.nextInt();
		for(int i = a; i <= b; i++) {
			String numbers = String.valueOf(i);
			int len = numbers.length();
			if(len > 1) {								
				//check for recycles
				String firstStr = String.valueOf(numbers.charAt(0));
				int firstNo = Integer.parseInt(firstStr);
				HashSet<Integer> record = new HashSet<Integer>();
				for(int j = 1; j < len; j++) {
					int currNo = Integer.parseInt(String.valueOf(numbers.charAt(j)));
					if(currNo > firstNo || currNo == 0) {
						continue;
					}					
					String newNo = numbers.substring(j) + numbers.substring(0, j);  
																					
					Integer newVal = Integer.valueOf(newNo);
					if(newVal < i && newVal >= a) {												
						record.add(newVal);
					} 
				}	
				recycles+= record.size();
			}					
		}						
		sb.append(recycles);				
		out.writeBytes(sb.toString());
		
	}

	
}
