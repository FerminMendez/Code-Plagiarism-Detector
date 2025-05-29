import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class RecycledNumber {

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
		String[] AB = str.split(" ");
		int A = Integer.valueOf(AB[0]);
		int B = Integer.valueOf(AB[1]);

		int meetsCriteria = 0;

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		while (A < B) {
			hm = new HashMap<Integer, Integer>();
			int n = A;

			String nStr = String.valueOf(n);
			int nLen = nStr.length();

			for (int j = 0; j < nLen - 1; j++) {

				nStr = nStr.charAt(nLen - 1) + nStr.substring(0, nLen - 1);
				int m = Integer.valueOf(nStr);

				if (Integer.valueOf(AB[0]) <= n && n < m && m <= B) {

					if (!hm.containsKey(m)) {
						hm.put(m, m);
						meetsCriteria++;
					}

				}
			}

			A++;
		}

		System.out
				.println(String.format("Case #%s: %s", caseNo, meetsCriteria));

	}
}
