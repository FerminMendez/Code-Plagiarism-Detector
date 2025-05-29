package qualif.problem3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class RecycledNumbers extends ProblemClass{

	public RecycledNumbers(Scanner input) {
		super(input);
	}

	protected String processLine(String line) {
		String[] inputs = line.split(" ");
		
		Integer lowNumber = new Integer(inputs[0]);
		Integer highNumber = new Integer(inputs[1]);
		
		Integer total = findRecycledNumberBetween(lowNumber,highNumber);
		return total.toString();
	}
	
	private Integer findRecycledNumberBetween(Integer lowNumber,Integer highNumber){
		
		int highNumberDigitsNumber = highNumber.toString().split("(?<=.)").length;
		Integer totalRecycled =0;

		lowNumber = Math.max(lowNumber, 10);
		for(Integer currentNumber=lowNumber ; currentNumber < highNumber ; currentNumber++  ){

			String[] digits = currentNumber.toString().split("(?<=.)");

			if(allDigitsTheSame(digits)){
				continue;
			}

			ArrayList<Integer> alreadyCheck = new ArrayList<Integer>();
			for(int permut = 1 ; permut<digits.length ; permut++){
				Integer newNumber  = createPermutation(digits,permut);
				if(newNumber!= null && !alreadyCheck.contains(newNumber) && currentNumber<newNumber && newNumber <= highNumber){
					totalRecycled+=1;
				}
				if(alreadyCheck.contains(newNumber) && newNumber!=null && currentNumber!=newNumber){
					//System.out.println(newNumber);
				}
				alreadyCheck.add(newNumber);
			}
		}

		return totalRecycled;
	}
//	
//	private int calculateNumberOfCorrectPerm(String[] digits) {
//		int nbOfPerm = digits.length-1;
//		int nbOfZero = 0;
//		int patern = 0;
//		for(String digit:digits){
//			if(digit.equals("0")){
//				nbOfZero+=1;
//			}
//		}
//		
//		if(digits.length%2==0){
//			
//			patern = 1;
//		}
//		return nbOfPerm - nbOfZero - patern;
//	}

	private boolean allDigitsTheSame(String[] digits){
		String value = digits[0];
		for(String item:digits){
			if(!value.equals(item)){
				return false;
			}
		}
		return true;
	}
	private Integer createPermutation(String[] digits,int permut){
		
		int lengh = digits.length;
		String newDigits = new String();
		for(int i = 0 ; i < lengh ; i ++){
			int newIndex = (i+permut)%lengh;
			if(i==0 && digits[newIndex].equals("0")){
				return null;
			}
			newDigits +=digits[newIndex];
		}

		return new Integer(newDigits);
	}
}
