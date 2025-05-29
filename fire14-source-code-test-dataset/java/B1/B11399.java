import java.awt.Point;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


public class RecycledNumbers {

	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		int t = 0;
		FileInputStream fstream = new FileInputStream(new File(args[0]));
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line = br.readLine();
		t = Integer.parseInt(line);
		System.out.println(t);
		String output;
		FileWriter fw = new FileWriter(new File("C-small-attempt0.out"));
		HashSet<Point> points = new HashSet<Point>();
		
		for(int i = 0; i < t; i++) {
			int counter = 0;
			line = br.readLine();
			
			String[] parameters = line.split(" ");
			int a = Integer.parseInt(parameters[0]);
			System.out.println("a: " + a);
			int number = a;
			int possibleRecycled = 0;
			int b = Integer.parseInt(parameters[1]);
			System.out.println("b: " + b);
			int numberOfDigits = 1;
			while(a/(int)Math.pow(10, numberOfDigits) != 0){
				numberOfDigits++;
			}
		
			while(number <= b){
				int[] digits = new int[numberOfDigits - 1];
				int holder = number;
				int j = 0;
				while (j < numberOfDigits - 1){
					digits[j] = holder % 10;
					holder = holder / 10;
					j++;
				}
				boolean next = true;
				for(int k = 0; k < digits.length && next ; k++){
					if(digits[k] * Math.pow(10, numberOfDigits - 1) < b){
						next = false;
					}
				}
				if(!next){
					int digitStep = 1;
					int lastDigit = 0;
					possibleRecycled = number;
					while(digitStep < numberOfDigits){
						lastDigit = possibleRecycled % 10;
						possibleRecycled = (int) (lastDigit * Math.pow(10, numberOfDigits - 1) + ( possibleRecycled / 10));
						if(possibleRecycled > number && possibleRecycled <= b && !points.contains(new Point(number,possibleRecycled))){
							points.add(new Point(number,possibleRecycled));
							counter++;
//							System.out.println(number + "   " + possibleRecycled );
						}
						digitStep++;
					}
				}
				number++;
			}
			
			output = "Case #" + (i + 1) + ": " + counter + "\n";		
			fw.write(output);
			points.clear();
		}
		fw.flush();
		fw.close();
	}

}
