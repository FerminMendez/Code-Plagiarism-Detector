import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
	
public class CodeJamB {
	
	public static int[][] matrix;
	public static boolean[][] had;
	public static boolean[][] down;
	public static char[][] result;
	public static int height;
	public static int width;
	
	public static void readLoop(File dataInput) throws Exception{
		Scanner scan = new Scanner(dataInput);
		
		int caseNumber = 0;
		int cases = 0;

		if (scan.hasNext()){
			cases = scan.nextInt();
		}

		while (scan.hasNext()) { 
			caseNumber++;
			int result = 0;
			int googlers = scan.nextInt();
			int surprising = scan.nextInt();
			int leastP = scan.nextInt();
			int minS = leastP*3-4;
			if (minS<2)
				minS=2;
			int min = leastP*3-2;
			for (int i = 0; i < googlers; i++){
				int score = scan.nextInt();
				if (score>=min){
					result++;
				} else if (surprising>0 && score>=minS){
					surprising--;
					result++;
				}
			}
			printAnswer(caseNumber, ""+result);
		}
		scan.close();
	}

	public static void main (String args[]) {
		// check arguments and grab input files
		if (args.length==1) {
			// check if the filenames in the arguments exist
			File dataInput = new File(args[0]);
			if (dataInput.exists()) {
				try {
					readLoop(dataInput);
				} catch (Exception e) {
					println("An error occurred");
					println(e.toString());
				}
			} else {
				println("File does not exist");
			}
		} else {
			println("Incorrect number of arguments");
		}
	}

	public static void printAnswer(int caseNumber, String answer){
		System.out.println("Case #"+caseNumber+": "+answer);
	}

	public static void println(String out){
		System.out.println(out);
	}
}
