import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class DancingWithTheGoogler {

	public static void main(String[] args) {

		try {

			FileInputStream fstream = new FileInputStream(args[0]);

			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;

			int count = 0;
			int noCases = 0;
			while ((strLine = br.readLine()) != null) {
				if (count > noCases)
					break;

				if (count == 0) {
					noCases = Integer.valueOf(strLine);
				} else {
					compute(count, strLine);
				}
				count++;
			}

			in.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	private static void compute(int caseNo, String str) {

		String[] tokens = str.split(" ");
		int N = Integer.valueOf(tokens[0]);
		int S = Integer.valueOf(tokens[1]);
		int P = Integer.valueOf(tokens[2]);

		int count = 0;

		for (int i = 3; i < N + 3; i++) {
			int candidate = Integer.valueOf(tokens[i]);
			int top = getCommonDigit(candidate, false);
			if (top >= P) {
				count++;
			} else {
				if (S > 0) {
					if (getCommonDigit(candidate, true) >= P) {
						count++;
						S--;
					}
				}
			}
		}

		System.out.println(String.format("Case #%s: %s", caseNo, count));

	}

	private static int getCommonDigit(int no, boolean special) {

		if (no == 0)
			return 0;
		int initialDigits = no / 3;
		int toShare = no % 3;

		if (special == false) {
			if (toShare == 0)
				return initialDigits;
			else
				return initialDigits + 1;
		} else {
			if (toShare == 2)
				return initialDigits + 2;
			else {
				return initialDigits + 1;
			}
		}

	}
}
