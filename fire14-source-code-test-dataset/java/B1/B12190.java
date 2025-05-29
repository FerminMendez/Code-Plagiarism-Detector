package luis.miguel.serrano.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import luis.miguel.serrano.settings.GlobalSettings;

/**
 * Data class for processing input and generating output
 * @author Luis Miguel Serrano
 *
 */
public class DataC {

	private File inputFile;
	private File outputFile;

	public DataC(String inputFilePath, String outputFilePath) {
		this.inputFile = new File(inputFilePath);
		outputFile = new File(outputFilePath);
	}

	public DataC(File inputFile) {
		this.inputFile = inputFile;
		outputFile = new File(GlobalSettings.OUTPUT_FILE_PATH);
	}

	/**
	 * Processes the file passed as argument in the constructor
	 * @throws FileNotFoundException
	 */
	public void processFile() throws FileNotFoundException {
		if(outputFile.exists())
			outputFile.delete();

		Scanner scanner = new Scanner(inputFile);

		final int casesNumber = scanner.nextInt();
		scanner.nextLine();

		for(int i = 0; i!=casesNumber; ++i)
			processCase(scanner, i);

		System.out.println("Done processing file: "+inputFile);
	}

	//Format-specific
	private void processCase(Scanner scanner, int caseNumber) {
		//System.out.println("New Case");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		
		int solution;
		solution = getSolution(a, b);

		//Write solution to file
		try {
			FileWriter fw = new FileWriter(outputFile, true);
			fw.write("Case #"+(caseNumber+1)+": "+solution+"\r\n");	
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	//Problem-specific
	private int getSolution(int a, int b){
		int solution = 0;

		for(int i = b; i!=a; --i) {
			for(int j = a; j<i; ++j) {
				if(isRecycled(j, i))
					++solution;
			}
		}

		return solution;
	}

	private boolean isRecycled(int n, int m) {
		String number = n+"";
		String recycled;
		
		//For each index of the string counting from the end, try switching it around in multiple attempts to obtain "m"
		for(int i = number.length()-1; i!=0; --i){
			recycled = number.substring(i)+number.substring(0, i);
			if(Integer.parseInt(recycled) == m)
				return true;
		}
		
		return false;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//DataC dataSample = new DataC(GlobalSettings.PROJECT_PATH+"\\input\\input_sample.in", GlobalSettings.PROJECT_PATH+"\\output\\input_sample.out");
		DataC dataSmall = new DataC(GlobalSettings.PROJECT_PATH+"\\input\\C-small-attempt0.in", GlobalSettings.PROJECT_PATH+"\\output\\C-small-attempt0.out");
		//DataB dataLarge = new DataB(GlobalSettings.PROJECT_PATH+"\\input\\B-large.in", GlobalSettings.PROJECT_PATH+"\\output\\B-large.out");

		try {
			//dataSample.processFile();
			dataSmall.processFile();
			//dataLarge.processFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("Finished processing all input!");
	}

}
