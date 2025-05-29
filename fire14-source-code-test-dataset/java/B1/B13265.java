import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RecycledNumbers {

	private long low;
	private long high;
	private Map<Long, Boolean> map = new HashMap<Long, Boolean>();
	private int recycycled = 0;

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		File file = new File("C:\\Users\\xebia\\Downloads\\C-small-attempt0.in");

		FileInputStream fis = new FileInputStream(file);
		DataInputStream in = new DataInputStream(fis);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		int numberOfTestCases = new Integer(br.readLine());
		for (int j = 0; j < numberOfTestCases; j++) {

			RecycledNumbers re = new RecycledNumbers();
			String[] strings = br.readLine().split(" ");
			String s = strings[0];
			String s2 = strings[1];
			long high = new Long(s2);
			long low = new Long(s);
			int numberOfDigits = s.length();
			for (long i = low; i <= high; i++) {
				int roundOffFigure = 1;
				for (int k = 0; k < numberOfDigits - 1; k++) {
					roundOffFigure = roundOffFigure * 10;
					long lastDigit = (long) (i % roundOffFigure);
					String str = "" + lastDigit;

					if (str.length() == k + 1) {

						long startingCombination = (long) (i / roundOffFigure);
						if (lastDigit == 0) {
							continue;
						}
						long number = (long) (lastDigit
								* (Math.pow(10, numberOfDigits - str.length())) + startingCombination);

						if (number >= low && number <= high) {
							if (number != i) {
								Boolean bool = re.map.get(number * i);
								if (bool == null) {
									re.map.put(number * i, true);
									re.recycycled++;
								}

							}
						}
					}
				}

			}
			System.out.println("Case #" + (j + 1) + ": " + re.recycycled);
		}
	}

	public void setLow(long low) {
		this.low = low;
	}

	public long getLow() {
		return low;
	}

	public void setHigh(long high) {
		this.high = high;
	}

	public long getHigh() {
		return high;
	}

	public void setRecycycled(int recycycled) {
		this.recycycled = recycycled;
	}

	public int getRecycycled() {
		return recycycled;
	}

}
