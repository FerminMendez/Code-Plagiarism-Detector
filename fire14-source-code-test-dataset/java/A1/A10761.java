import java.io.*;
import java.util.*;


public class Dancing {
	public static void main(String[] args) throws FileNotFoundException {
	
		Scanner console = new Scanner(System.in);
		
		// gets the filename to work with
		Scanner input = getInput(console);
		// gets the name of file to output to
		PrintStream output = getOutput(console);
		
		int numOfCases = input.nextInt();
		
		for (int i = 1; i <= numOfCases; i++) {
			int numOfDancers = input.nextInt();
			int surprisingScore = input.nextInt();
			int passingMark = input.nextInt();
			
			int lowestPassingScore = passingMark * 3 - 2;
			if (lowestPassingScore < 0) {
				lowestPassingScore = 0;
			}
			
			int lowestAidedPassingScore = passingMark * 3 - 4;
			if (lowestAidedPassingScore < 0 ) {
				lowestAidedPassingScore = 0;
			}
			
			//output.println(lowestPassingScore + ":" + lowestAidedPassingScore);
			
			int passingDancers = 0;
			
			for (int dancer = 0; dancer < numOfDancers; dancer++) {
				int dancerScore = input.nextInt();
				
				
				if (dancerScore >= lowestPassingScore) {
					// passes without surprising score
					passingDancers++;
				} else if (dancerScore == 0) {
					// do nothing
				} else if (dancerScore == 1) {
				    // do nothing
				} else if (dancerScore >= lowestAidedPassingScore) {
				
					// needs surprising score to pass
					if (surprisingScore > 0) {
						// uses up a surprising score to pass
						surprisingScore--;
						passingDancers++;
					}
				}
			}
			output.println("Case #" + i +": " + passingDancers);
		}
	}
	
	public static int lineSearcher(String sentence, String welcomeString) {
		if (welcomeString.length() == 0) {
			return 1;
		} else if (sentence.length() == 0) {
			return 0;
		} else {
			if (sentence.substring(0,1).equals(welcomeString.substring(0,1))){
				return lineSearcher(sentence.substring(1), welcomeString.substring(1))
							+ lineSearcher(sentence.substring(1), welcomeString);
			} else {
				return lineSearcher(sentence.substring(1), welcomeString);
			}
		}
	}
	
	public static Scanner getInput(Scanner console) {
		Scanner input = null;
		while(input == null) {
			System.out.print("Input file name: ");
			String name = console.nextLine();
			try {
				input = new Scanner(new File(name));
			} catch (FileNotFoundException e) {
			}
		}
		return input;
	}
	
	// gets the filename to output to (if blank, outputs to console)
	public static PrintStream getOutput(Scanner console) throws FileNotFoundException{
		System.out.print("Output file name: ");
		String output = console.nextLine();
		if (output.equals("")) {
			return new PrintStream(System.out);
		} else {
			return new PrintStream(new File(output));
		}
	}
}