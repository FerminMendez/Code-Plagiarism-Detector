import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;


public class MainImpl {

	public static int numberOfLines;
	
	public static int firstNumber;
	
	public static int secondNumber;
	
	public static ArrayList<String> eachLine = new ArrayList<String>();
	
	public static void main(String[] args) {

		readFile();
		for (int i = 1; i<= numberOfLines ; i++) {
			findSets(eachLine.get(i - 1), i);
		}
		System.out.print("Done with conversion");
	}
	
	public static void findSets(String line, int index) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Case #").append(index).append(": ");
		
		int totalUniqueCases = 0;
		String[] numbers = line.split(" ");
		
		String firstNumberString = numbers[0];
		String secondNumberString = numbers[0];
		
		firstNumber = Integer.parseInt(numbers[0]);
		secondNumber = Integer.parseInt(numbers[1]);
		
		if (firstNumber > secondNumber) {
			buffer.append(String.valueOf(totalUniqueCases));
			writeToFile(buffer.toString());
			return;
		}
		
		if (firstNumberString.length() == 1 && (secondNumberString.length() == 1)) {
			buffer.append(String.valueOf(totalUniqueCases));
			writeToFile(buffer.toString());
			return;
		}
		
		int numberBeingConsidered = firstNumber;
		
		int totalNumberOfSets = 0;
		
		while (numberBeingConsidered <= secondNumber) {
			
			totalNumberOfSets = totalNumberOfSets + findPermutations(numberBeingConsidered);
			numberBeingConsidered++;
		}
		buffer.append(String.valueOf(totalNumberOfSets));
		writeToFile(buffer.toString());
	}
	
	public static int findPermutations(int numberBeingConsidered) {
		
		int validPermutations = 0;
		
		String numberBeingConsideredString = String.valueOf(numberBeingConsidered);
		
		ArrayList<String> possiblePermutaions = new ArrayList<String>();
		
		for (int i = numberBeingConsideredString.length() - 1; i>=1; i--) {
			
			String permutationString = numberBeingConsideredString.substring(i) + numberBeingConsideredString.substring(0, i);
			
			if (!numberBeingConsideredString.equals(permutationString) && (!possiblePermutaions.contains(permutationString))) {
				
				int permutationNumber = Integer.parseInt(permutationString);
				
				if ((firstNumber <= numberBeingConsidered) && (numberBeingConsidered < permutationNumber) && (permutationNumber <= secondNumber)) {
					validPermutations++;
					possiblePermutaions.add(permutationString);
				}
				
			}
		}
		return validPermutations;
	}
	
	public static void readFile() {
		try {
			FileInputStream fstream = new FileInputStream("src/input.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			numberOfLines = Integer.parseInt(br.readLine());
			while ((strLine = br.readLine()) != null) {
				eachLine.add(strLine);
			}
			in.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	public static void writeToFile(String line) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
					"src/output.txt"), true));
			bw.write(line);
			bw.newLine();
			bw.close();
		} catch (Exception e) {
			System.out.println("Error occured " + e);
		}

	}
}
