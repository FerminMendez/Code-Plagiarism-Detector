import java.io.*;
import java.util.Scanner;


public class DancingGoogler {

	static String outputFile, inputFile;
	public static void main(String[] args) throws IOException  {
		if (args.length != 2)
			return;
		inputFile = args[0];
		outputFile = args[1];

		// Create FileReader Object
		FileReader inputFileReader = new FileReader(inputFile);
		FileWriter outputFileReader = new FileWriter(outputFile);

		// Create Buffered/PrintWriter Objects
		BufferedReader inputStream = new BufferedReader(inputFileReader);
		PrintWriter outputStream = new PrintWriter(outputFileReader);
		
		Scanner scanner;
		String inLine = null;
		int cases = Integer.parseInt(inputStream.readLine().trim());
		
		int num, surprising, score;
		int[] scores;
		for (int i = 1; i < cases + 1; i++) {
			inLine = inputStream.readLine().trim();
			scanner = new Scanner(inLine);
			num = scanner.nextInt();
			surprising = scanner.nextInt();
			score = scanner.nextInt();
			scores = new int[num];
			for (int j=0; j<num; j++){
				scores[j] = scanner.nextInt();
			}
			outputStream.println("Case #"+i+": "+getBestDancers(scores, surprising, score));
		}
		
		outputStream.close();

	}
	
	private static int getBestDancers(int[] scores, int surprising, int targetSc ){
		int totalTarget = 3*targetSc;
		int numBest = 0;
		if (totalTarget==0) return scores.length;
		
		for (int i=0; i<scores.length; i++){
			if (scores[i]>= totalTarget-2) numBest++;
			else if (totalTarget > 3 && scores[i] >= totalTarget-4 ) {
				if (surprising>0){
					numBest++;
					surprising--;
				}
			}
		}
		return numBest;
	}

}
