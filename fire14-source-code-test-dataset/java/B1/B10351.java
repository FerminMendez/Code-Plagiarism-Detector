import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RecycledPairs {

	
	public static void main(String args[]) throws IOException {
		BufferedWriter resultWriter = new BufferedWriter(new FileWriter("C:\\Users\\Andriy\\workspaces\\codejam\\RecycledPairs\\src\\datasetOutput"));
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Andriy\\Downloads\\C-small-attempt0.in"));
		int totalCases = Integer.parseInt(reader.readLine());
		int caseNumber = 0;
		while (++caseNumber <= totalCases) {
			String[] numbers = reader.readLine().split(" ");
			if (numbers.length != 2 || numbers[0].length() == 1) {
				resultWriter.write(String.format("Case #%d: %d\n", caseNumber, 0));
				continue;
			}
			int a = Integer.parseInt(numbers[0]);
			int b = Integer.parseInt(numbers[1]);
			int recycles = 0;
			
			final char[] buffer = new char[numbers[0].length()];
			for (int m = a+1; m <= b; m++) {
				final char[] mChar = String.valueOf(m).toCharArray();
				for (int n=a; n < m; n++) {
					final char[] nChar = String.valueOf(n).toCharArray();
					int length = 0;
					while (++length < mChar.length) {
						// skip leading zeros
						final int pivotPos = nChar.length - length;
						if (pivotPos == '0') {
							continue;
						}
						System.arraycopy(nChar, pivotPos, buffer, 0, length);
						System.arraycopy(nChar, 0, buffer, length, pivotPos);
						
						if (Arrays.equals(buffer, mChar)) {
							recycles++;
							break;
						}
					}
				}
			}
			resultWriter.write(String.format("Case #%d: %d\n", caseNumber, recycles));
		}
		resultWriter.flush();
		resultWriter.close();
	}
}
