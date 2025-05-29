package C;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class RecycledNumbers {
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		/* Input File */
		BufferedReader reader = new BufferedReader(new FileReader("G:/projects/CodeJam12/src/C/in.txt"));
		
		/* Output File */
		PrintWriter writer = new PrintWriter(new FileWriter("G:/projects/CodeJam12/src/C/out.txt"));
		
		/* Getting number of test cases */
		int noOfTestCases = Integer.parseInt(reader.readLine());
		System.out.println("No of Test Cases : "+noOfTestCases);
		
		/* Iterating for every test case */
		for ( int i=1; i <= noOfTestCases;i++){

			/* Getting input test case line */
			String ipline = reader.readLine();
			System.out.println("\n\nTest Case "+i+" : "+ipline);
			
			/* Split the test case string */
			String elements []= ipline.split(" ");
			
			/* Parsing elements to integer */
			int lower_limit = Integer.parseInt(elements[0]);
			int upper_limit = Integer.parseInt(elements[1]);
			
			int count = 0;
			ArrayList<String> processed = new ArrayList<String>();

			/* Recycling numbers and counting them */
			
			if ( upper_limit > 10 ){
			
				for ( int x=lower_limit; x <= upper_limit;x++ ){
					
					String sx = new Integer(x).toString();
					
					for ( int j=1; j < sx.length(); j++){
					
						String sr = sx.substring(sx.length()-j,sx.length()) + sx.substring(0, sx.length()-j);
						Integer r = Integer.parseInt(sr);
						System.out.println("Number : "+x+", Recycled : "+r);
						
						if ( sr.charAt(0)=='0' ){
							System.out.println("As first character should be nonzero... : "+sr);
							continue;
						}
						
						//if ( x < r && r > lower_limit && r < upper_limit ) {
						if ( x != r && r > lower_limit && r < upper_limit ) {
							if ( processed.contains(sx+"#"+sr) || processed.contains(sr+"#"+sx) ){
								System.out.println("Already in recycled pair : Number : "+x+", Recycled : "+r);
							}else{
								System.out.println("Number : "+x+", Recycled : "+r);
								count++;
								System.out.println("Number of recycled pairs : "+count);
								processed.add(sx+"#"+sr);
								processed.add(sr+"#"+sx);
							}
						}
					}
				}
			}
				
			System.out.println("processed.length : "+processed.size());
		
			/* printing output */
			System.out.println("Number of recycled pairs : "+count);
			System.out.println("Case #"+i+": "+count);
			writer.println("Case #"+i+": "+count);
			
		} // for loop ends here
		
		/* closing streams */
		System.out.println("Closing streams...");
		writer.close();
		reader.close();
		System.out.println("Streams closed.");
	}
}
