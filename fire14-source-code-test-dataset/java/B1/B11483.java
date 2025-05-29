import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class RecycledNumbers {

	public static int outputLine(String inputLine){
		int count = 0;
		String[] inputArray = inputLine.split(" ");
		ArrayList line = new ArrayList(Arrays.asList(inputArray));
		int min = Integer.parseInt((String) line.get(0));
		int max = Integer.parseInt((String) line.get(1));
		
		
		for (int k = min; k <= max; k++) {
			
			for (int j = min; j <= max; j++) {
				int numbDigits = String.valueOf(min).length();
				for (int x = 0; x <numbDigits; x++) {
					if ((String.valueOf(j).substring(numbDigits - (x+1), numbDigits) + String.valueOf(j).substring(0,numbDigits - (x+1))).equals(String.valueOf(k))) {
						if (k < j) {
						count++;
						}
					}
				}
			}
		}
			
		return  count;
	}
	
	
	public static void main (String [] args) {
		ArrayList answers = new ArrayList();
		System.out.println("Insert a number.");
		int i;
		Scanner scan = new Scanner(System.in);
		i = Integer.parseInt(scan.nextLine());
		
		for (int j = 0; j< i; j++) {
			String inputLine = scan.nextLine();
			answers.add(outputLine(inputLine));
			}
		
		for (int j = 0; j < answers.size(); j++){
			System.out.println("Case #" + (j+1) + ": " + (answers.get(j)));
		}
	}		
}
