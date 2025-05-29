import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Num {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String fname = "C-small-attempt0";
			FileInputStream fstream = new FileInputStream(fname + ".in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			int numCase = 0;
			int i = 0;
			while ((strLine = br.readLine()) != null) {
				if (numCase == 0)
					numCase = Integer.valueOf(strLine);
				else if (strLine.length() > 0)
					runCase(strLine, ++i);
			}
			in.close();
		} catch (Exception e) {// Catch exception if any
			e.printStackTrace();
		}
	}

	static void runCase(String line, int caseNum) {
		String[] borders = line.split(" ");
		int length = borders[0].length();
		int a = Integer.valueOf(borders[0]);
		int b = Integer.valueOf(borders[1]);
		HashSet<String> pairs = new HashSet<String>();
		for (int i = a; i <= b; i++) {
			for (int j = 1; j < length; j++) {
				int pos = (int) Math.pow(10, j);
				int pair = i / pos + (i % pos) * (int) Math.pow(10, length - j);
				if (pair >= a && pair <= b && pair != i) {
					if (i < pair)
						pairs.add(i + "," + pair);
					else
						pairs.add(pair + "," + i);
				}
			}
		}
		System.out.println("Case #" + caseNum + ": " + pairs.size());
	}
}
