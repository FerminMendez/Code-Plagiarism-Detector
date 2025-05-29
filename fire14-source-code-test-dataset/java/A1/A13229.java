
import java.io.*;
import java.util.Scanner;

public class DancingWithTheGooglers {
	private static final String FILE_IN = "C:\\Users\\BC_limited\\Documents\\School\\IB Computer Science SL\\" +
			"Code Jam 2012\\Dancing With The Googlers\\B-small-attempt1.in";
	private static final String FILE_OUT = "C:\\Users\\BC_limited\\Documents\\School\\IB Computer Science SL\\" +
			"Code Jam 2012\\Dancing With The Googlers\\B-small-attempt1-out.txt";
	
	public static Scanner scanIn;
	
	public static void main(String[] args) {
		System.out.println("Setting scanner to file");
		try {
			File inFile = new File(FILE_IN);
			scanIn = new Scanner(inFile);
		} //end try
		catch(IOException e) {
			System.out.println("Error setting scanner to file - " + e);
		} //end catch
		
		int testCases = inputValue("testCases");
		scanIn.nextLine(); //moves to next line
		
		int[] solutions = new int[testCases];
		
		for(int i = 0; i < testCases; i++) {
			int[] googlerScores = new int[scanIn.nextInt()];
			int surprisingScores = scanIn.nextInt();
			int topScore = scanIn.nextInt();
			for(int j = 0; j < googlerScores.length; j++)
				googlerScores[j] = scanIn.nextInt();
			solutions[i] = writeSolution(googlerScores, surprisingScores, topScore);
		} //end for
		
		writeSolutionsToFile(solutions);
	} //end main
	
	public static int inputValue(String variable) {
		System.out.println("Reading " + variable);
		try {
			if(scanIn.hasNext())
				return scanIn.nextInt();
		} //end try
		catch(Exception e) {
			System.out.println("Error reading from file - " + e);
		} //end catch
		return -1; //exceptional case
	} //end getTestCases
	
	public static int writeSolution(int[] googlers, int surprises, int bound) {
		int max = 0;
		for(int i = 0; i < googlers.length; i++) {
			if(googlers[i] - (3 * bound) >= -2)
				max++;
			else if(surprises > 0 && googlers[i] > 1 && googlers[i] - (3 * bound) >= -4) {
				max++;
				surprises--;
			} //end else if
		} //end for
		return max;
	} //end writeSolution
	
	public static void writeSolutionsToFile(int[] solutionsArray) {
		System.out.println("Writing solutions to file");
		
		try {
			PrintWriter pw = new PrintWriter(FILE_OUT);
			for(int i = 0; i < solutionsArray.length; i++)
				if(i < solutionsArray.length - 1)
					pw.println("Case #" + (i + 1) + ": " + solutionsArray[i]);
				else
					pw.print("Case #" + (i + 1) + ": " + solutionsArray[i]);
			pw.close();
		} //end try
		catch(IOException e) {
			System.out.println("Error writing to file - " + e);
		} //end catch
	} //end writeSolutionsToFile
} //end DancingWithTheGooglers