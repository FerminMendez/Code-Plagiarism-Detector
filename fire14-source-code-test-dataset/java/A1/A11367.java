package fun.codeslam.dancers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		Integer testCaseCount = Integer.parseInt(reader.readLine());

		for (Integer testCaseNumber = 1; testCaseNumber <= testCaseCount; testCaseNumber++) {
			System.out.append("Case #" + testCaseNumber + ": ");
			System.out.append(new Result(new TestCase(reader.readLine())).toString());
			System.out.append('\n');
		}
	}
}
