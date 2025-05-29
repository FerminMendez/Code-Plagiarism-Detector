import java.util.*;
import java.io.*;
import java.lang.Number;

public class number {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner fileReader = new Scanner(new File("C-small-attempt0.in"));
		PrintStream output = new PrintStream(new File("outputAwesome2.txt"));
		

		// Process file
		int repetitions = fileReader.nextInt();
		for(int i = 1; i <= repetitions; i++) {
			output.print("Case #" + i + ": ");
			int start = fileReader.nextInt();
			int stop = fileReader.nextInt();
			
			if (start < 10 || stop < 10) {
				output.println("0");
			} else {
				int digits = 0;
				int foo = start;
				while (foo != 0) {
					foo = foo / 10;
					digits++;
				}
				
				int count = 0;

				for(int j = start; j <= stop; j++) {
					String number = j + "";
					for(int k = 1; k < digits; k++) {
						// number = 10, k = 2
						String stuff = number.substring(1) + number.charAt(0);
						if(!stuff.equals(number)) {
							number = stuff;
							//System.out.println(number);
							if(Integer.parseInt(number) <= stop && Integer.parseInt(number) >= start){
								//System.out.println("yes");
								count++;
							}
						}
					}
				}
				output.println(count / 2);
			}
		}
	}
}