import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;


public class RecycledNumbers {


	public static void main(String[] args) throws Exception {
		RecycledNumbers recycledNumbers = new RecycledNumbers();
		// file name
		String fileName = "recycled_numbers";
		
		// file variable
		File inputFile = new File(fileName + ".in");
		File outputFile = new File(fileName + ".out");
		Scanner scanner = new Scanner(inputFile);
		FileWriter writer = new FileWriter(outputFile);


		// problem variable
		int totalCase;
	
		// get total case
		totalCase = Integer.parseInt(scanner.nextLine());
		System.out.println("Total case:"+totalCase);
		
		for (int caseIndex = 1; caseIndex <= totalCase; caseIndex++) {

			String lineDetail = scanner.nextLine();
			String[] inputArray = lineDetail.split(" ");
			String min =  inputArray[0];
			String max =  inputArray[1];
			
			int  possibleCases = 0;
			
			possibleCases = recycledNumbers.findPossibleCases(min, max);
			
			String output = "Case #" + caseIndex + ": " + possibleCases;		
			System.out.println(output);
			writer.write(output + "\n");
		}
		scanner.close();
		writer.close();
	}
	
	private int findPossibleCases(String min, String max){
		int possibleCases = 0;
		int startVal = Integer.parseInt(min);
		int endVal = Integer.parseInt(max);
		int n,m = 0;
		HashMap<String, String> usedPattern = new HashMap<String, String>();
		
		for(int i=startVal; i<endVal; i++){
			n = i;
			String inputStr = ""+i;
			String shiftStr = "";
			char[] charArr = inputStr.toCharArray();
		
			usedPattern = new HashMap<String, String>();
			
			//startAt
			for(int j= 0; j<charArr.length; j++){
				shiftStr = "";
				// loop to get shift data
				for(int k= j; k<charArr.length+j; k++){
					shiftStr += charArr[k%charArr.length];
				}
				m = Integer.parseInt(shiftStr);
				if( (m > n) && (m <=endVal)){
					if(!usedPattern.containsKey(shiftStr) ){
						possibleCases++;
					}
				}
				
				// keep the temp of shifting data
				usedPattern.put(shiftStr, shiftStr);
			}
			m = 0;

		}
		return possibleCases;
	}
}
