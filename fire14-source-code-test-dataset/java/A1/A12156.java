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
public class DataB {

	private File inputFile;
	private File outputFile;

	public DataB(String inputFilePath, String outputFilePath) {
		this.inputFile = new File(inputFilePath);
		outputFile = new File(outputFilePath);
	}

	public DataB(File inputFile) {
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
		int numberGooglers = scanner.nextInt();
		int numberSurprisingTripletScores = scanner.nextInt();
		int p = scanner.nextInt();
		int[] totalScores = new int[numberGooglers];
		for(int i = 0; i!=numberGooglers; ++i)
			totalScores[i] = scanner.nextInt();


		int solution;
		solution = getSolution(numberGooglers, numberSurprisingTripletScores, p, totalScores);

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
	private int getSolution(int numberGooglers, int numberSurprisingTripletScores, int p, int[] totalScores){
		int solution = 0;

		int[][] triplets = new int[numberGooglers][3];

		//Generate Score Triplets
		int surprisingTripletsRemaining = numberSurprisingTripletScores;
		for(int i = 0; i!= triplets.length; ++i) {
			int baseValue = totalScores[i]/3;
			int rest = totalScores[i]%3;

			if(rest == 2)
			{
				int max = baseValue+2;

				//If it is "worth it" spending one surprising triplet to make this one count for "the most"
				if(p == max && surprisingTripletsRemaining != 0)
					--surprisingTripletsRemaining;
				else {
					++baseValue;
					rest -= 3;
				}
			}

			for(int j = 0; j!=triplets[i].length; ++j){
				if(j == 0) {
					triplets[i][j] = baseValue+rest;
				}				
				else {
					triplets[i][j] = baseValue;
				}					
			}

			//Integrity Check
			int total = 0;
			for(int j = 0; j!=triplets[i].length; ++j)
				total += triplets[i][j];
			if(total != totalScores[i])
				System.out.println("Total Scores Mismatch ERROR!");
		}


		//If there are remaining triplets to spend, try to spend them in cases in which rest was = 0
		for(int i = 0; i!=triplets.length; ++i)
			if(surprisingTripletsRemaining != 0){
				if(triplets[i][0] == triplets[i][1] && triplets[i][0] == triplets[i][2] && triplets[i][0] + 1 == p && triplets[i][0] != 0) {
					triplets[i][0] += 1;
					triplets[i][1] -= 1;
					--surprisingTripletsRemaining;
				}
			}
			else
				break;



//		//Print (DEBUG)
//		for(int i = 0; i!=triplets.length; ++i)
//			for(int j = 0; j!= triplets[i].length; ++j)
//				System.out.println("triplets["+i+"]["+j+"] = "+triplets[i][j]);

		//Find solution
		for(int i = 0; i!=triplets.length; ++i){
			for(int j = 0; j!= triplets[i].length; ++j)
			{
				if(triplets[i][j] >= p){
					++solution;
					break;
				}					
			}
		}

		return solution;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//DataB dataSample = new DataB(GlobalSettings.PROJECT_PATH+"\\input\\input_sample.in", GlobalSettings.PROJECT_PATH+"\\output\\input_sample.out");
		DataB dataSmall = new DataB(GlobalSettings.PROJECT_PATH+"\\input\\B-small-attempt0.in", GlobalSettings.PROJECT_PATH+"\\output\\B-small-attempt0.out");
		//Data dataLarge = new Data(GlobalSettings.PROJECT_PATH+"\\input\\A-large-practice.in", GlobalSettings.PROJECT_PATH+"\\output\\A-large-practice.out");

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
