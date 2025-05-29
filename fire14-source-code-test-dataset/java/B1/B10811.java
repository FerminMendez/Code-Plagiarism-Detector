import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Task3 {
	private int parseLine(Scanner scanner) throws IOException {
		int A = scanner.nextInt();
		int B = scanner.nextInt();
		int c = ("" + A).length();
		int pow = (int) Math.pow(10, c - 1);
		int count = 0;
		for (int m = A; m < B; m++) {
			int tmpN = m;
			Set<Integer> set = new HashSet<Integer>();
			for (int j = 0; j < c - 1; j++) {
				tmpN = tmpN / 10 + (tmpN % 10) * pow;
				if (m < tmpN && tmpN <= B && !set.contains(tmpN)) {
					set.add(tmpN);
					count++;
				}
			}
		}
		return count;
	}
	
	public void run(Scanner scanner, Writer bw) throws IOException {
		int rowCnt = scanner.nextInt();
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
			new Task3().run(new Scanner(System.in),
					new OutputStreamWriter(System.out));
		} catch (IOException e) {
			return;
		}
	}
}
