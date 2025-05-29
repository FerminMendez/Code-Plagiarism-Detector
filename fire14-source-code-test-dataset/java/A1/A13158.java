import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class GoogleTriplet {
	public static void main(String[] args) {
		runTestCase();
	}

	public static void runTestCase() {
		String fileName = "B-small-attempt0.in";// input file
		String outFileName = "outputFile.txt";// output file

		try {
			FileInputStream fStream = new FileInputStream(fileName);
			FileOutputStream fOutStream = new FileOutputStream(outFileName);

			BufferedReader bf = new BufferedReader(new InputStreamReader(
					fStream));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
					fOutStream));
			int i = 0;
			int testSize = Integer.parseInt(bf.readLine());
			while (i < testSize) {
				String in = bf.readLine();
				if (in.length() > 100) {
					throw new Exception();
				}
				bw.write(findTriplets(in, ++i));
				bw.newLine();
			}
			// close the two files.
			bf.close();
			bw.close();
		} catch (Exception e) {
			System.err.println("There was a error : " + e.toString());
		}
	}

	public static String findTriplets(String inputData, int testCase) {
		StringBuffer temp = new StringBuffer();
		temp.append("Case #" + testCase + ": ");

		String[] split = inputData.split(" ");
		int noOfGooglers = Integer.parseInt(split[0]);
		int surprise = Integer.parseInt(split[1]);
		int p = Integer.parseInt(split[2]);

		List<Integer> scores = new ArrayList<Integer>();

		for (int i = 3; i < 3 + noOfGooglers; i++) {
			int score = Integer.parseInt(split[i]);
			if (score > 3 * p - 5) {
				if (score >= 3 * p - 4 && score < 3 * p - 2 && surprise > 0) {
					if (3 * p - 4 > 0) {
						scores.add(score);
						surprise--;
					}
				} else if (score >= 3 * p - 2 || p == 0) {
					scores.add(score);
				}
			}
		}
		temp.append(scores.size());
		return temp.toString();
	}
}
