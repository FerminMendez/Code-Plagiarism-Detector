import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;


public class ProblemC {

	public static void main(String[] args) {

		Scanner input;
		try {
			input = new Scanner(new FileReader("C-small-attempt0.in"));
			PrintWriter output = new PrintWriter(new FileWriter("output3.txt"));

			int numberCases = input.nextInt();
			String data = input.nextLine();

			for (int i = 0; i < numberCases; i++) {
				output.print("Case #" + (i + 1) + ": ");

				data = input.nextLine();
				String[] intS = Pattern.compile(" ").split(data);
				int[] numbers = new int[intS.length];
				for (int j = 0; j < intS.length; j++) {
					numbers[j] = Integer.parseInt(intS[j]);
				}

				int lowerBound = numbers[0];
				int upperBound = numbers[1];
				output.print(calculatePossibilities(lowerBound, upperBound));
				output.print("\n");
			}

			output.flush();
			output.close();
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int calculatePossibilities(int lowerBound, int upperBound) {

		Set allPossibilities = new HashSet();
		int numberDigits = (int) (Math.floor(Math.log10(lowerBound))) + 1;
		int currentNumber = 0;
		int lowPart = 0;
		int highPart = 0;
		//System.out.println("Digits " + numberDigits);
		for (int j = lowerBound; j <= upperBound; j++) { 
			Set permutations = new HashSet();
			for (int i = 1; i <= numberDigits - 1; i++) {
				lowPart = j % ((int) Math.pow(10, i));
				highPart = j / ((int) Math.pow(10, i));
				currentNumber = (lowPart * (int) Math.pow(10, numberDigits - i)) + highPart;
				//System.out.println(currentNumber + " <- j: " + j + " i:" + i + "  low " + lowPart + " high " + highPart);
				
				if (currentNumber >= lowerBound && currentNumber <= upperBound &&
						currentNumber > j) {
					permutations.add(currentNumber);

				}
				if (!permutations.isEmpty())
					allPossibilities.add(permutations);
			}
		}

		//System.out.println("A: " + allPossibilities.size());
		return allPossibilities.size();
	}
}
