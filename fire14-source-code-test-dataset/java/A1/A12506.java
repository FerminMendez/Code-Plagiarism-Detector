import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;


public class MaxBestResult {

	public static void main(String[] args) throws FileNotFoundException {
		File input = new File("B-small-attempt0.in");
		Scanner data = new Scanner(input);
		PrintStream output = new PrintStream(new File("B-small-attempt0.out"));
		int times = data.nextInt();
		
		for(int i = 1; i <= times; i++){
			String text = data.next() + data.nextLine();
			Scanner line = new Scanner(text);
			Round temp = new Round(line);
			output.println("Case #" + i + ": " + temp.calculate());
		}
	}

}
