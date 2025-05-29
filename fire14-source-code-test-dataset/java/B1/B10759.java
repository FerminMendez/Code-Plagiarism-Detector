package google.jam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class RecycledNumbers {
	
	public static void main (String[] args){
		System.out.println("Please, type your input:");
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		boolean checkLines = false;
		int numLines = 0, linesCounter = 0;
		String line;
		String output = "";
		try {
			while((line = stdIn.readLine()) != null){
				if(!checkLines){
					numLines = Integer.parseInt(line);
					checkLines = true;
				}else{
					linesCounter++;
					output += inputToOutput(line, String.valueOf(linesCounter));
				}
				if(linesCounter >= numLines)
					break;
			}	
			System.out.println(output);
		} catch (IOException e) {
			System.out.println("Something went wrong with your input.");
			e.printStackTrace();
		}
	}
	
	public static String inputToOutput(String input, String lineNum){
		TreeSet<String> set = new TreeSet<String>();
		String[] numbers = input.split(" ");
		
		if(numbers.length != 2)
			return "Case #" + lineNum + ": 0\n";
		
		int start = Integer.parseInt(numbers[0]);
		int end = Integer.parseInt(numbers[1]);
		if(start >= end)
			return "Case #" + lineNum + ": 0\n";
		
		int cur = start;
		while(cur <= end){
			for(int i=String.valueOf(cur).length()-1; i>0; i--){
				String number = String.valueOf(cur);
				if(number.charAt(i) == '0')
					continue;
				String newNum = number.substring(i) + number.substring(0, i);
				int newInt = Integer.parseInt(newNum);
				if( newInt > end || newInt < start || newNum.equals(number) )
					continue;
				set.add( (number.compareTo(newNum) < 0)?(newNum+number):(number+newNum) );
			}
			cur++;
		}
		
		return "Case #" + lineNum + ": " + set.size() + "\n";
	}

}
