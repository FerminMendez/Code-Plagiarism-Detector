
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DancingWithGooglers {
	
	public static int outputLine(String inputLine){
		int count = 0;
		String[] inputArray = inputLine.split(" ");
		ArrayList line = new ArrayList(Arrays.asList(inputArray));
		int surprises = Integer.parseInt((String) line.get(1));
		int key = Integer.parseInt((String) line.get(2));
		int minCompare = key + key - 2 + key -2;
		if (minCompare < 0)
			minCompare =0;
		int autoYes = key + key - 1 + key -1;
		for (int k = 3; k < line.size(); k++) {
			if (Integer.parseInt((String) line.get(k)) == 0 && key ==0)
				count++;
			else if (Integer.parseInt((String) line.get(k)) <= 0)
				count = count;
			else if (Integer.parseInt((String) line.get(k)) >= autoYes) {
				count++;
			}
			else if (Integer.parseInt((String) line.get(k)) >= minCompare && surprises > 0) {
				count ++;
				surprises --;
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
			
			
/*
			String output = "";
			int length = inputArray.get(j).length();
			for (int k = 0; k < length; k++) {
				output += convertLetter(inputArray.get(j).substring(k,k+1));
			}
			System.out.println ("Case #" + (j+1) + ": "+ output);
			*/
			} 
			
	}