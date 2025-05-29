import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;


public class ProblemB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner input = new Scanner(new FileReader("B-small-attempt1.in"));
			PrintWriter output = new PrintWriter(new FileWriter("output2.txt"));

			int numberCases = input.nextInt();
			String data = input.nextLine();

			for (int i = 0; i < numberCases; i++) {
				output.print("Case #" + (i + 1) + ": ");

				data = input.nextLine();
				String[] intS = Pattern.compile(" ").split(data);
				int[] numbers = new int[intS.length];
				for (int j = 0; j < intS.length; j++) {
					numbers[j] = Integer.parseInt(intS[j]);
				}

				int numberGooglers = numbers[0];
				int surprising = numbers[1];
				int p = numbers[2];

				int count = 0;
				//System.out.print("N ");
				for (int j = 0; j < numberGooglers; j++) {
					if (((numbers[j + 3] / 3.0)) > (p - 1)) {
						//System.out.print(numbers[j + 3] + " ");
						count++;
					}
				}

				//System.out.print("S ");
				if (surprising > 0) {
					for (int j = 0; j < numberGooglers && surprising != 0; j++) {
						if ((numbers[j + 3] / 3.0) <= (p - 1) &&
								(numbers[j + 3] / 3.0) >= (p - 2)) {
							if (Math.floor(((numbers[j + 3] - p) / 2.0)) >= (p - 2) && 
									(numbers[j + 3] - p) >= 0) {
									//System.out.print(numbers[j + 3] + " ");
									count++;
									surprising--;
								}
						}
					}
				}
				//System.out.println("Counter " + count);
				output.print(count);
				output.print("\n");
			}
			output.flush();
			output.close();
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}