import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {
		String file = "B-small-attempt0";
		File inputFile = new File("C:\\Users\\Harutsedo\\Workspace\\Google Code Jam\\input\\2012\\QR\\" + file + ".in");
		File outputFile = new File("C:\\Users\\Harutsedo\\Workspace\\Google Code Jam\\input\\2012\\QR\\" + file + ".out");
		outputFile.createNewFile();
		Scanner scanner = new Scanner(inputFile);
		FileWriter writer = new FileWriter(outputFile);
		
		int T = scanner.nextInt();

		for (int c = 0; c < T; c++) {
			int N = scanner.nextInt();
			int S = scanner.nextInt();
			int p = scanner.nextInt();
			
			int[] scores = new int[N];
			for (int i = 0; i < N; i++) {
				scores[i] = scanner.nextInt();
			}
							
			String solution = solveCase(S, p, scores);
				
			StringBuffer s = new StringBuffer("Case #" + (c + 1) + ":");
			System.out.println(s + " " + solution);
			writer.write(s +  " " + solution);
			if (c != N - 1) {
				writer.write("\n");
			}
			
		}
		writer.close();
	}
	
	public static String solveCase(int S, int p, int[] scores) {
		int max = 0;
		for (int i = 0; i < scores.length; i++) {
			if ((scores[i] - p) >= 2 * p || ((scores[i] - p) >= 2 * p - 2 && p >= 1)) {
				max++;
			} else if ((scores[i] - p) >= 2 * p - 4 && S > 0 && p >= 2) {
				max++;
				S--;
			}
		}
		return String.valueOf(max);
	}

}
