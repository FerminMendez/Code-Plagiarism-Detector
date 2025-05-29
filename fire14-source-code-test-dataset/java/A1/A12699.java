package GoogleDance;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GoogleDance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			String userDir = System.getProperty("user.dir"); //get working directory
			userDir.replaceAll("['\']", "\\"); // replace all chars '\' with '\\' in the string
			File file = new File(System.getProperty("user.dir") + "\\QualificationRound\\GoogleDance\\in-out\\B-small-attempt0.in");
	        Scanner fileScanner = new Scanner(file);
	        //delimiter is how input text is set up in this case it's the new line char
	        fileScanner.useDelimiter(System.getProperty("line.separator")); 
	        //declared for file writing
	        BufferedWriter outFile = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\QualificationRound\\GoogleDance\\in-out\\B-small.out"));
			int counter, inCounter, deepCounter, masterCounter, numCases, startIndex, numPpl, suprisingScores, minScore, currentNum, maxH, result;
			int judgeHigh, judgeLow;
			ArrayList<Integer> intList = new ArrayList<Integer>();
			int [] judgeScores = new int[3];
			String inputText;
			boolean suprisingScoresReal;
			numCases = Integer.parseInt(fileScanner.nextLine());
			for(masterCounter = 1; masterCounter <= numCases; masterCounter++){
				inputText = fileScanner.nextLine();
				startIndex = 0;
				result = 0;
				for( counter = 0; counter < inputText.length(); counter ++){
					if (inputText.charAt(counter) == ' ') 
					{
						intList.add(Integer.parseInt(inputText.substring(startIndex, counter))); 
						startIndex = counter + 1;
					}    			
				}
				intList.add(Integer.parseInt(inputText.substring(startIndex, counter))); 
				numPpl = intList.get(0);
				suprisingScores = intList.get(1);
				minScore = intList.get(2);
				intList.remove(0);
				intList.remove(0);
				intList.remove(0);
				if(suprisingScores == 0)
					suprisingScoresReal = false;
				else
					suprisingScoresReal = true;
				for(counter = 0; counter < intList.size(); counter++){
					if(intList.get(counter) <= 2){
						for(inCounter = 0; inCounter < intList.get(counter); inCounter++)
							judgeScores[inCounter] = 1;
						for(deepCounter = inCounter; deepCounter < 3; deepCounter++)
							judgeScores[deepCounter] = 0;
						maxH = 0;
					}
					else{
						currentNum = intList.get(counter) / 3;
						judgeScores[0] = currentNum;
						judgeScores[1] = currentNum;
						judgeScores[2] = currentNum;
						maxH = intList.get(counter) - (currentNum + currentNum + currentNum);
					}
					deepCounter = 0;
					if(maxH > 0)
						for(inCounter = 0; inCounter < maxH; inCounter++){//distribute extra points (from /3)
							judgeScores[deepCounter] = judgeScores[deepCounter] + 1;
							deepCounter++;
							if(deepCounter >= 3)
								deepCounter = 0;
						}
					Arrays.sort(judgeScores); //sorted from low (position[0]) to high (position[2])
					
					if(judgeScores[2] >= minScore)
						result++;
					else if(suprisingScoresReal == true && judgeScores[2] != 0){
						if(judgeScores[2] == judgeScores[1] && suprisingScores != 0 && judgeScores[2] + 1 >= minScore){
						result++;
						suprisingScores--;
						}
					}
				}
				//System.out.println("suprisingScores :" + suprisingScores);
				//outFile.write("suprisingScores :" + suprisingScores + "\n");
			System.out.println("Case #" + masterCounter + ": " + result);
        	outFile.write("Case #" + masterCounter + ": " + result + "\n");
        	intList.clear();
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
