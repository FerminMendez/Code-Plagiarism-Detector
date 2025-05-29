package y2012;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class QR3 {
	
	public static void main(String[] args) throws Exception {
		Scanner inputFile=new Scanner(new File(args[0]));
		PrintWriter outputFile=new PrintWriter(new File(args[1]));
			
		int t=Integer.parseInt(inputFile.nextLine());	
		for(int i=0;i<t;i++){
			HashMap<String, String> result = new HashMap<String, String>();
			
			String[] aCase = inputFile.nextLine().split(" ");
			
			int iFrom = Integer.parseInt(aCase[0]);
			int iTo = Integer.parseInt(aCase[1]);
			String sFrom = String.valueOf(iFrom);
			String sTo = String.valueOf(iTo);

			int numDigit = sFrom.length();
			
			if(numDigit != 1) {
				for(int curr = iFrom; curr < iTo; curr++) {
					String sCurr = String.valueOf(curr);

					for(int j=1; j<numDigit; j++) {
						int swapped = Integer.parseInt(sCurr.substring(j) + sCurr.substring(0, j));
						if(iFrom <= swapped && swapped <= iTo && swapped != curr) {
							if(curr < swapped)
								result.put(String.valueOf(curr)+","+String.valueOf(swapped), null);
							else
								result.put(String.valueOf(swapped)+","+String.valueOf(curr), null);
						}
					}
				}
			}
			
			outputFile.println("Case #"+(i+1)+": " + result.size());
			System.out.println("Case #"+(i+1)+": " + result.size());
		}

		inputFile.close();
		outputFile.close();
	}
}
