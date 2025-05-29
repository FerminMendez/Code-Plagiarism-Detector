import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class prob2 {
	public static void main(String[] args) {
		BufferedReader inputStream = null;
		try {
			inputStream = new BufferedReader(new FileReader(
					"C:/Users/vpamarty.SYMPHONY/Downloads/C-small-attempt1.in"));
			String lineRead = inputStream.readLine();

			int noCases = Integer.valueOf(lineRead).intValue();
			for (int i = 0; i < noCases; i++) {
				lineRead = inputStream.readLine();
				String[] splitString = lineRead.split(" ");
				int numA = Integer.valueOf(splitString[0]).intValue();
				int numB = Integer.valueOf(splitString[1]).intValue();

				int distinctRps = computeDisRps(numA, numB);
				System.out.println("Case #"+(i+1)+": "+distinctRps);
			}
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int computeDisRps(int num1, int num2) {
		int numPairs = 0;
		for (int numCons = num1; numCons < num2; numCons++) {
			int numLength = (String.valueOf(numCons)).length();
			ArrayList<String> numArr = new ArrayList<String>();
			numArr.add(String.valueOf(numCons));
			for (int i = 1; i < numLength; i++) {
				String numString = String.valueOf(numCons);
				String newNumString = numString.substring(numLength - i)
						+ numString.substring(0, numLength - i);
				if (!numArr.contains(newNumString)) {
					numArr.add(newNumString);
					if (Integer.valueOf(newNumString).intValue() > numCons
							&& Integer.valueOf(newNumString).intValue() <= num2)
						numPairs++;
				}
			}
		}
		return numPairs;

	}
}
