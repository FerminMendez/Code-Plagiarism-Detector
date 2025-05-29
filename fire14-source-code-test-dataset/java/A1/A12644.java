package jp.ne.sakura.yuki2006.CodeJam;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CodeJam {
	private FileWriter file;
	static int caseNumber = 0;
	private Scanner stdIn;

	private void write(String data) {
		caseNumber++;

		try {
			file.append("Case #");
			file.append(String.valueOf(caseNumber));
			file.append(": ");
			file.append(data);
			file.append("\n");
			file.flush();

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	public CodeJam(ITestCase test, String fileName) {
		try {
			file = new FileWriter(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		stdIn = new Scanner(System.in);
		stdIn.nextLine();
		while (stdIn.hasNext()) {

			write(test.testCase(stdIn));
		}
	}

}
