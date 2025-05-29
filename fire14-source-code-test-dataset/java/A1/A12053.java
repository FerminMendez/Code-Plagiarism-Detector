import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Googlers {

	
	public static void main(String[] args) {
		
		try{
			
			File dance = new File("C:\\Users\\Moeen\\Documents\\0 ECLIPSE\\IO Folder\\Input\\B-small-attempt0.in");
			FileWriter outFile = new FileWriter("C:\\Users\\Moeen\\Documents\\0 ECLIPSE\\IO Folder\\Output\\B-small-attempt0.out");
			PrintWriter dancePrint = new PrintWriter(outFile);
			
			Scanner scan = new Scanner(dance);
			String inputString = new String();
			ArrayList<Integer> numbersArray = new ArrayList<Integer>();
			
			inputString = scan.nextLine();
			int totalNoCases = Integer.parseInt(inputString);
			System.out.println("Total Number of Cases: " + totalNoCases);
			
			for (int caseNo = 1; caseNo <= totalNoCases; caseNo++){
				System.out.println("Case #" + caseNo + ": ");
				dancePrint.print("Case #" + caseNo + ": ");
				
				inputString = scan.nextLine();
				
				int startIndex = 0;
				for (int itemCounter = 0; itemCounter < inputString.length(); itemCounter++){
					if (inputString.charAt(itemCounter) == ' '){
						numbersArray.add(Integer.parseInt(inputString.substring(startIndex, itemCounter)));
						startIndex = (itemCounter +1);
					}
				}
				numbersArray.add(Integer.parseInt(inputString.substring(startIndex)));
				
				int nGooglers = numbersArray.get(0);
				int sSurprising = numbersArray.get(1);
				int pBestResult = numbersArray.get(2);
				int bestCounter = 0;
				

				numbersArray.remove(0);
				numbersArray.remove(0);
				numbersArray.remove(0);

				int [] tripArray = new int[3];
				
				for (int scores = 0; scores < nGooglers; scores++){
					
					//System.out.println(numbersArray.get(scores));
					int tripScores = numbersArray.get(scores)/3;
					tripArray[0] = tripScores;
					tripArray[1] = tripScores;
					tripArray[2] = tripScores;
					
					int remainder = (numbersArray.get(scores) - (tripScores*3));
					
					if (remainder > 0){
						for (int i = 0; i < remainder; i++){
							tripArray[i]++;
						}
					}
					Arrays.sort(tripArray);
					
					if (tripArray[2] >= pBestResult){
						bestCounter++;
					}
					else if( sSurprising != 0 && tripArray[2] != 0){
						if(tripArray[2] +1 >= pBestResult){
							bestCounter++;
							sSurprising--;
						}
					}

				}
				
				System.out.println(bestCounter);
				dancePrint.println(bestCounter);
				numbersArray.clear();
			}
			
			scan.close();
			dancePrint.close();
			
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e1){
			System.out.println("Error" + e1);
		}


	}

}
