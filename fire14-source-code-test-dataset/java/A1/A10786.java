import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;


public class Task2 {
	
	private int parseLine(Scanner scanner) throws IOException {
		int N = scanner.nextInt();
		int S = scanner.nextInt();
		int p = scanner.nextInt();
		int[] table = new int[31];
		for (int i = 0; i < N; i++) {
			table[scanner.nextInt()]++;
		}
		int retval = 0;
		if (p >= 2) {
			int e = table[3 * p - 4] + table[3 * p - 3];
			if (S > e) {
				retval += e;
			} else {
				retval += S;
			}
		}
		for (int i = 3 * p - 2; i <= 30; i++) {
			if (i >= 0) {
				retval += table[i];
			}
		}
		return retval;
	}
	
	public void run(Scanner scanner, Writer bw) throws IOException {
		int rowCnt = Integer.parseInt(scanner.next());
		for (int i = 0; i < rowCnt; i++) {
			bw.write("Case #" + (i + 1) + ": " + parseLine(scanner) + '\n');
		}
		bw.flush();
		bw.close();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			scanner.useDelimiter(" |\r\n|\n|\r");
			new Task2().run(new Scanner(System.in),
					new OutputStreamWriter(System.out));
		} catch (IOException e) {
			return;
		}
	}
}
