import java.io.*;
import java.util.*;

public class BDancingGooglers {
	public static void main(String[] args) throws IOException {
		// parsing file
		Scanner scanner = new Scanner(new File("B-small-attempt0.in"));
		int cases = Integer.parseInt(scanner.nextLine());
		int[][] lineArray = new int[cases][];
		int index = 0;
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] split = line.split("\\s");
			lineArray[index] = new int[split.length];
			for (int i = 0; i < split.length; i++) {
				lineArray[index][i] = Integer.parseInt(split[i]);
			}

			// printing parsed information
			for (int i = 0; i < split.length; i++) {
//				System.out.print(lineArray[index][i] + " ");
			}
//			System.out.println();
			//

			index++; // DON'T DELETE
		}

		// doing computation by case
		FileWriter fw = new FileWriter("outputb.txt");
		for (int i = 0; i < lineArray.length; i++) {
			int count = 0;
			// int googlers = lineArray[i][0];
			int surprises = lineArray[i][1];
			int p = lineArray[i][2];
//			System.out.println("p is " + p + ", surprises is " + surprises);
			int base1 = Math.max(3 * p - 2, 0);
			int base2 = Math.max(3 * p - 4, 0);
			for (int j = 3; j < lineArray[i].length; j++) {
				if (p == 0) {
					count++;
				}
				else if (lineArray[i][j] == 0) {
					
				}
				else if (base1 <= lineArray[i][j]) {
					count++;
//					System.out.println("\tscore " + lineArray[i][j] + ", count " + count);
				} else if (base2 <= lineArray[i][j] && surprises != 0) {
					count++;
					surprises--;
//					System.out.println("\t2score " + lineArray[i][j] + ", count " + count + ", surprises left " + surprises);
				} else {
//					System.out.println("\t3score " + lineArray[i][j]);
				}
			}
			fw.write("Case #" + (i + 1) + ": " + count + "\n");
//			System.out.println("Case #" + (i + 1) + ": " + count);
//			System.out.println();
		}
		fw.close();
	}

}
