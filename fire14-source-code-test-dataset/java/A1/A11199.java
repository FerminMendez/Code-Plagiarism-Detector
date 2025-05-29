import java.io.FileReader;
import java.util.Scanner;


public class Scores {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			scan = new Scanner(new FileReader("B-small-attempt0.in"));
		} catch (Exception e) {
			System.out.println("poop");
		}
		int inputSize = Integer.parseInt(scan.nextLine());
		int i = 0;
		while (scan.hasNextLine() && i < inputSize) {
			i++;
			String line = scan.nextLine();
			String[] strings = line.split(" ");
			int googlers = Integer.parseInt(strings[0]);
			int surprises = Integer.parseInt(strings[1]);
			int atLeast = Integer.parseInt(strings[2]);
			int j = 0;
			int output = 0;
			int surprisesSoFar = 0;
			for (String s : strings) {
				if (j > 2) {
					int total = Integer.parseInt(s);
					if (total == 0) {
						if (atLeast == 0) output++;
					} else if (atLeast + atLeast + atLeast - 2 <= total) {
						output++;
					} else if ((surprisesSoFar < surprises) &&
							atLeast + atLeast + atLeast -4 <= total) {
						output++;
						surprisesSoFar++;
					}
				}
				j++;
			}
//			System.out.println(line);
			System.out.println("Case #" + i + ": " + output);
		}
	}
}
