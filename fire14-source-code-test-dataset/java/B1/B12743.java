package RecycledNumbers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RecycledNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			String userDir = System.getProperty("user.dir"); //get working directory
			userDir.replaceAll("['\']", "\\"); // replace all chars '\' with '\\' in the string
			File file = new File(System.getProperty("user.dir") + "\\QualificationRound\\RecycledNumbers\\in-out\\C-small-attempt0.in");
	        Scanner fileScanner = new Scanner(file);
	        //delimiter is how input text is set up in this case it's the new line char
	        fileScanner.useDelimiter(System.getProperty("line.separator")); 
	        //declared for file writing
	        BufferedWriter outFile = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\QualificationRound\\RecycledNumbers\\in-out\\C-small.out"));
			int counter, inCounter, masterCounter, numCases, startIndex, result, Amin, Bmax, numLength, ininCounter, deepCounter, passInt;
			String inputText;
			Amin = 0;
			Bmax = 0;
			String numConv;
			numCases = Integer.parseInt(fileScanner.nextLine());
			ArrayList<Integer> intList = new ArrayList<Integer>();
			ArrayList<Integer> intList2 = new ArrayList<Integer>();
			for(masterCounter = 1; masterCounter <= numCases; masterCounter++){
				inputText = fileScanner.nextLine();
				startIndex = 0;
				result = 0;
				for( counter = 0; counter < inputText.length(); counter ++){//parse A n B
					if (inputText.charAt(counter) == ' ') 
					{
						Amin = Integer.parseInt(inputText.substring(startIndex, counter)); 
						startIndex = counter + 1;
					}    			
				}
				Bmax = Integer.parseInt(inputText.substring(startIndex, counter)); 
				//get current length of numbers
				numLength = String.valueOf(Amin).length();
				for(counter = Amin; counter < Bmax; counter++){
					for(inCounter = counter + 1; inCounter <= Bmax; inCounter++){
						passInt = inCounter;
						while(passInt > 0){
								intList.add(passInt % 10); //get modulous
								passInt = passInt / 10;//div by 10
							}
						for(ininCounter = 0; ininCounter < numLength; ininCounter++){
							
							for(deepCounter = 0; deepCounter < intList.size() -1; deepCounter++)
								intList2.add(intList.get(deepCounter+1));
							
							intList2.add(intList.get(0));
							numConv = "";
							for(deepCounter = 0; deepCounter < intList2.size(); deepCounter++){
								numConv = intList2.get(deepCounter) + numConv;
							}
							passInt = Integer.parseInt(numConv);
							if(counter == passInt){
								result++; 
								//if(masterCounter == 4)
									//System.out.println(counter + " = " + passInt + " Actual #: " + inCounter);
							}
							intList = (ArrayList<Integer>) intList2.clone();
							intList2.clear();
						}
						intList.clear();
					}
				}
			
			System.out.println("Case #" + masterCounter + ": " + result);
        	outFile.write("Case #" + masterCounter + ": " + result + "\n");
			}
			
	        fileScanner.close();
	        outFile.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found"); e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("IOException");
		}

	}

}
