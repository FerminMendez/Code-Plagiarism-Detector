import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class RecycledNumbers {

	public static FileReader fileReader;
	public static BufferedReader reader;
	public static FileWriter fileWriter;
	public static BufferedWriter writer;

	public void executeLogic() throws Exception {

		String newLine;

		newLine = reader.readLine();
		int increment = 1;

		while ((newLine = reader.readLine()) != null) {
			int totalNumberCount = 0;
			String stringToArray[] = newLine.split("\\s");
			int A = Integer.parseInt(stringToArray[0]);
			int B = Integer.parseInt(stringToArray[1]);

			for (int i = A; i <= B; i++) {
				int n = i;
				String stringValueOfA = Integer.toString(n);
				int numberOfDigitsInA = stringValueOfA.length();
				int backIndex = numberOfDigitsInA - 1;
				String tempStringValueOfA = stringValueOfA;
				while (backIndex > 0) {

					String first = tempStringValueOfA.substring(0, backIndex);
					String second = tempStringValueOfA.substring(backIndex,
							numberOfDigitsInA);
					stringValueOfA = second + first;
					int m = Integer.parseInt(stringValueOfA);
					if ((m <= B && m > n)
							&& !stringValueOfA.startsWith("0")
							&& (Integer.toString(n).length()) == stringValueOfA
									.length())
						totalNumberCount++;

					backIndex--;

				}
			}

			writer.write("Case #" + increment++ + ": " + totalNumberCount
					+ "\n");

		}
		writer.close();
		fileWriter.close();

	}

	public static void main(String[] args) throws Exception

	{
		RecycledNumbers recycledNumbers = new RecycledNumbers();

		String inputFilePath = "C:\\CodeJamFiles\\Small2.in";
		String outputFilePath = "C:\\CodeJamFiles\\Small2.out";

		fileReader = new FileReader(inputFilePath);
		reader = new BufferedReader(fileReader);
		fileWriter = new FileWriter(outputFilePath, false);
		writer = new BufferedWriter(fileWriter);

		recycledNumbers.executeLogic();

	}

}
