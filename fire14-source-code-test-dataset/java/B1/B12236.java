package gcj2012;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Gaurav Prabhu Gaonkar 
 * @date   Apr 13, 2012 
 *
 */
public class RecycledNumbers {

	public static void main(String[] args) {
		String inputDir = "C:\\GcjFiles\\2012\\Qualification";
		String fileName = "C-small-attempt0";
		
		File inputFile = new File(inputDir + "\\" + fileName + ".in");
		File outputFile = new File(inputDir + "\\" + fileName + ".out.txt");

		try
		{
			PrintWriter out = new PrintWriter(outputFile);			
			Scanner scanner = new Scanner(inputFile);			
			//Read the first line
			String metadata   = scanner.nextLine();
			int numOfCases = Integer.parseInt(metadata);
			//System.out.println(numOfCases);
			
			for(int i = 1; i <= numOfCases; i++)
			{
				String input = scanner.nextLine();
				//System.out.println(input);						
				String[] params = input.split(" ");
								
				int answer = solve(Integer.parseInt(params[0]), Integer.parseInt(params[1]));
				System.out.println("Case #"+i+": " + answer);
				out.println("Case #"+i+": " + answer);
			} // process next test case
			
			out.flush();
			out.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured: "  + e);
		}		
	}

	private static int solve(int a, int b) {
		int result = 0;
		
		if (a < 10) {
			a = 10;
		}
		
		Set<String> candidates = new HashSet<String>();		
		for (int i = a; i <= b; i++) {
			
			StringBuilder sb = new StringBuilder();
			sb.append(i).append(i);
			
			int len = sb.length()/2;
			
			String str = sb.toString();
			
			for (int j = 1; j <= len; j++) {
				candidates.add(str.substring(j,j+len));				
			}			
			for (String candidate : candidates) {
				int test = Integer.parseInt(candidate);
				if (test > i && (test >= a && test <= b)) {
					result++;
				}
			}
			candidates.clear();
		}
		
		return result;
	}
}
