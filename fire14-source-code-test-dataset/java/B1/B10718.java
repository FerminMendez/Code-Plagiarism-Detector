import java.util.*;

public class C {
		
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		in.nextLine();
		
		for(int line = 1; line <= T; line++){ // loop through lines
			String numbers = in.nextLine();
			int spaceIndex = numbers.indexOf(' ');
			int lowerLimit = Integer.parseInt(numbers.substring(0, spaceIndex));
			int upperLimit = Integer.parseInt(numbers.substring(spaceIndex + 1));
			int numberOfDigits = spaceIndex;
			
			int pairs = 0;
			for(int swooper = lowerLimit; swooper < upperLimit; swooper++){
				for(int cycler = swooper + 1; cycler <= upperLimit; cycler++){
					// Convert to char array for manipulation
					char[] digits = Integer.toString(cycler).toCharArray();
					for(int offset = 1; offset < numberOfDigits; offset++){
						// Rotate
						char firstElement = digits[0];
						for(int i = 0; i < numberOfDigits - 1; i++){
							digits[i] = digits[i+1];
						}
						digits[numberOfDigits - 1] = firstElement;
						// Convert back to an int and compare
						int cycledCycler = Integer.parseInt(new String(digits));
						if(cycledCycler == swooper){
							//System.out.format("A match! %d and %d!\n", swooper, cycler);
							pairs++;
							break;
						}
					}
				}
			}
			
			System.out.format("Case #%d: %d\n", line, pairs);
		}
	}
}
