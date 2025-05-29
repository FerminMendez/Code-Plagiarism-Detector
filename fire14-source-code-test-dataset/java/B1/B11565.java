import java.util.*;
import java.math.*;

public class recycledNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		int numStrings = scan.nextInt();
		
		for(int i =1; i <= numStrings; i++){
			
			int lowerBound = scan.nextInt();
			int upperBound = scan.nextInt();
			int numDigits = Integer.toString(lowerBound).length();
			int ten = 10;
			
			int count = 0;
			for(int j = lowerBound; j <= upperBound ; j++){
				int temp = j;
				for(int k = 1; k <= numDigits; k++){
					int temp_rem = temp % ten;
					int temp_quot = temp /ten;
					int temp1 = temp_quot + (int )(Math.pow(ten, numDigits-1))*temp_rem;
					if (temp1 > j && temp1 <= upperBound){
						count = count + 1;
					}	
					temp = temp1;
					//System.out.println("\n" + j + " " + temp + " " + upperBound + " " + count);
				}
			}
			//System.out.println("LowerBound: " + lowerBound + "\n");
			//System.out.println("UpperBound: " + upperBound + "\n");
			//System.out.println("numDigits: " + numDigits + "\n");
			System.out.format("Case #%d: %d\n", i, count);
			
		}

	}

}
