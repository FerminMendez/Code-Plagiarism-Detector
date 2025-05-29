package QualificationRound.recyclednumbers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class RecycledNumbers {
	private List<String> inputLines = new ArrayList<String>();
	private List<String> outputLines = new ArrayList<String>();
	private static final String INPUT_FILE_NAME = "C-small-attempt0.in";
	private static final String OUTPUT_FILE_NAME = "output.txt";
	
	private List<SingleCase> cases = new ArrayList<RecycledNumbers.SingleCase>();
	
	public static void main(String[] args) {
		RecycledNumbers r = new RecycledNumbers();
		r.readLines();
		r.parseLines();
		r.generateOutput();
		r.outputLines();
	}
	
	
	private void readLines() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE_NAME));

			String line = reader.readLine();
			
			line = reader.readLine();
			while (line != null) {
				inputLines.add(line);
				line = reader.readLine();
			}
			
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void parseLines() {
		for (String line : inputLines) {
			String[] split = line.split(" ");
			SingleCase singleCase = new SingleCase();
			singleCase.start = Integer.parseInt(split[0]);
			singleCase.end = Integer.parseInt(split[1]);
			cases.add(singleCase);
		}
	}
	
	
	private void generateOutput() {
		int caseNumber = 1;
		for (SingleCase singleCase : cases) {
			outputLines.add(getOutputPrefix(caseNumber++) + singleCase.getResult());
		}
	}
	
	
	private String getOutputPrefix(int number) {
		return "Case #" + number + ": ";
	}
	
	
	private void outputLines() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME, false));
			
			for (String line : outputLines) {
				writer.write(line);
				if (!line.equals(outputLines.get(outputLines.size() - 1))) {
					 writer.write("\n");
				}
			}
			
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private class SingleCase {
		private int start = 0;
		private int end = 0;
		
		private int getResult() {
			int result = 0;
			
			List<Integer> numbersBetween = new ArrayList<Integer>();
			for (int i = start; i <= end; i++) {
				numbersBetween.add(i);
			}
			for (int i = start; i <= end; i++) {
				List<Integer> resultNumbers = new ArrayList<Integer>();
				String numberString = ""+i;
				for (int c = 1; c < numberString.length(); c++) {
					String recycledString = numberString.substring(c) + numberString.substring(0, c);
					Integer recycledNumber = Integer.parseInt(recycledString);
					if (recycledNumber > i 
							&& numbersBetween.contains(recycledNumber) 
							&& !resultNumbers.contains(recycledNumber)) {
						result++;
						resultNumbers.add(recycledNumber);
					}
				}
			}
			return result;
		}
	}
}
