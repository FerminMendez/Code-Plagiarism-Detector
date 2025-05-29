import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;


public class B {
	
	private static final String NAME = "B-small.txt";
	private static final File input = new File("in", NAME);
	private static final File output = new File("out", NAME);
	
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(input);
		scanner.useDelimiter("[\\s\\n\\r]+");
		
		FileWriter writer = new FileWriter(output);
		int numberOfTests = scanner.nextInt();
		for (int test = 0; test < numberOfTests; test++) {
			int n = scanner.nextInt();
			int s = scanner.nextInt();
			int p = scanner.nextInt();
			int[] totals = new int[n];
			for (int i = 0; i < n; i++) {
				totals[i] = scanner.nextInt();
			}
			String result = calculate(p * 3 - 4, p * 3 - 2, s, totals);
			String line = String.format("Case #%d: %s\n", test + 1, result);
			writer.append(line);
			System.out.print(line);
		}
		writer.close();
	}
	
	private static String calculate(int low, int high, int surprising, int[] totals) {
		int result = 0;
		for (int total : totals) {
			if (total >= high) {
				result++;
			}
			else if (total >= low && total > 1) {
				if (surprising > 0) {
					surprising--;
					result++;
				}
			}
		}
		return Integer.toString(result);
	}
}
