package qualification.taskC;

import Parser.MyReader;
import Parser.MyWriter;

public class Main {
	private final static int n = 20000001;

	public static void main(String[] args) {
		MyReader myReader = new MyReader(
				"/Users/shami13/Downloads/C-small-attempt0.in");
		MyWriter myWriter = new MyWriter(
				"/Users/shami13/Downloads/C-small-attempt0.out");

		boolean[][] table = new boolean[n][n];

		for (int i = 1; i < n; i++) {
			for (int p = 1; p < n; p++) {
				table[i][p] = isRecycled(i, p);
			}
		}

		int taskLength = Integer.parseInt(myReader.read());
		for (int i = 1; i <= taskLength; i++) {
			String[] taskString = myReader.read().split(" ");
			Task task = new Task(Integer.parseInt(taskString[0]),
					Integer.parseInt(taskString[1]), table);
			String result = task.execute();
			myWriter.writeString("Case #" + i + ": " + result);
			System.out.println("Case #" + i + ": " + result);
		}
		myWriter.close();
	}

	public static boolean isRecycled(int a, int b) {
		if (a != b) {

			String bString = "" + b;

			for (int i = 0; i < bString.length(); i++) {
				int temp = b % 10;
				b /= 10;
				for(int p = 1; p < bString.length(); p ++){
					temp *= 10;
				}
				b += temp;
				if (a == b) {
					return true;
				}
			}
		}
		return false;
	}
}
