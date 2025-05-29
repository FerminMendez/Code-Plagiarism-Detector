package B;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class DancingWithTheGooglers {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		/* Input File */
		BufferedReader reader = new BufferedReader(new FileReader("G:/projects/CodeJam12/src/B/in.txt"));
		
		/* Output File */
		PrintWriter writer = new PrintWriter(new FileWriter("G:/projects/CodeJam12/src/B/out.txt"));
		
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
			int iElements [] = new int[elements.length];
			
			/* Parsing elements to integer */
			for ( int j=0; j<elements.length; j++ ){
				iElements[j] = Integer.parseInt(elements[j]);
			}
			
			/* Assigning Values */
			int noOfGooglers = iElements[0];
			int noOfSuprisingTriplets = iElements[1];
			int bestResultP = iElements[2];
			
			System.out.println("No of Googlers : "+noOfGooglers);
			System.out.println("No of Surprising Triplets : "+noOfSuprisingTriplets);
			System.out.println("Best Result P : "+bestResultP);

			/* from 3 to < iElements.length is total scores elements of googlers */
			int maxGooglersWithBestResultP = 0;
			
			for ( int j=3; j<elements.length; j++ ){
				
				System.out.println("Total Marks of Googler "+(j-2)+" : "+iElements[j]);
				int avgCeilMarks = ( int ) Math.ceil( (double) iElements[j] / 3 );
				
				System.out.println("Avg Ceil Marks of Googler "+(j-2)+" : "+avgCeilMarks);
				
				// If equal or more than best result increment counter
				if ( avgCeilMarks >= bestResultP ) {
					maxGooglersWithBestResultP++;
				
				// Check for surprising triplet 
				}else if ( noOfSuprisingTriplets > 0
						&& (iElements[j] % 3 ) != 1
						&& (avgCeilMarks + 1) <= iElements[j] 
				        && (avgCeilMarks + 1) >= bestResultP ){
					
					maxGooglersWithBestResultP++;
					noOfSuprisingTriplets --;
				}
			}
			
			System.out.println("No of Surprising Triplets Left ( In-effective Surprising Triplets ) : "+noOfSuprisingTriplets);

			/* print output */
			System.out.println("Case #"+i+": "+maxGooglersWithBestResultP);
			writer.println("Case #"+i+": "+maxGooglersWithBestResultP);
		}

		/* closing streams */
		System.out.println("\n\nClosing streams...");
		writer.close();
		reader.close();
		System.out.println("Streams closed.");
	}
}
