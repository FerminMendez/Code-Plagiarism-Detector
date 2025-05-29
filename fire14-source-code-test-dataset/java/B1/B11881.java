import java.util.*;
import java.io.*;
import java.math.*;

public class C {

	private static String INPUT_FILE = "C-small-attempt0.in"; 
	private static String OUTPUT_FILE = "c.out";
	private static Map<Integer, Integer> listLengthToPairs = new HashMap<Integer, Integer>();

	public static void main(String args[]) {

		listLengthToPairs.put(1, 0);
		listLengthToPairs.put(2, 1);
		listLengthToPairs.put(3, 3);
		listLengthToPairs.put(4, 6);
		listLengthToPairs.put(5, 10);
		listLengthToPairs.put(6, 15);
		listLengthToPairs.put(7, 21);

		Scanner input = null;
		PrintStream output = null;
		try {	
			input = new Scanner(new File(INPUT_FILE));
			output = new PrintStream(OUTPUT_FILE);
		} catch (Exception e) {
			System.out.println(e);		
		}
		
		int testCases = Integer.parseInt(input.nextLine());
		int count = 1;
		
		String curArgs;
		int lowerBound;
		int upperBound;

		while(input.hasNextLine()) {
			output.print("Case #" + count + ": ");
			String spl = input.nextLine();
			lowerBound = Integer.parseInt(spl.split(" ")[0]);
			upperBound = Integer.parseInt(spl.split(" ")[1]);
			
			int totalViablePairs = 0;
			Set<Integer> numbersSeen = new HashSet<Integer>();

			for (int i=lowerBound; i<=upperBound; i++) {
				if (!numbersSeen.contains(i)) {
					int viable = permuteNum(i, lowerBound, upperBound, numbersSeen);
					totalViablePairs += viable;
				}
				
			}
			
			if (count != testCases) {
				output.println(totalViablePairs);
			} else {
				output.print(totalViablePairs);			
			}
			count++;
		}
	
	
	
	}

	private static int permuteNum(int num, int lower, int upper, Set seen) {
		String s = num + "";
		int length = s.length();
		int viablecount = 1;
		
		// add initial to seen set
		seen.add(num);
		
		for (int i=0; i<length; i++) {
			int leastsig = num % 10;
			int restof = num / 10;
			int newnum = leastsig * (int)Math.pow(10, length-1) + restof;
			
			if (newnum >= lower && newnum <= upper && !seen.contains(newnum)) {
				//System.out.println(newnum);
				viablecount++;
			
				// add found number to seen set
				seen.add(newnum);	
				//System.out.println("just added: " + newnum);
			}
			
			num = newnum;

		}
		
		return listLengthToPairs.get(viablecount);
	}


}