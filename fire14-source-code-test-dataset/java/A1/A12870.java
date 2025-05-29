import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

public class GCJ2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GCJ2 g = new GCJ2();

//		int i1 = g.calculate(3, 1, 3, 6, 6, 3);
//		System.out.println(i1);
		
//		int i1 = g.calculate(3, 1, 5, 15, 13, 11);
//		int i2 = g.calculate(3, 0, 8, 23, 22, 21);
//		int i3 = g.calculate(2, 1, 1, 8, 0);
//		int i4 = g.calculate(6, 2, 8, 29, 20, 8, 18, 18, 21);
//
//		System.out.println(i1);
//		System.out.println(i2);
//		System.out.println(i3);
//		System.out.println(i4);

		try {
			// Open the file that is the first
			// command line parameter
			FileInputStream fstream = new FileInputStream(
					"C:/PROG/java/work/tc/src/gcj2.txt");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			// Read File Line By Line
			int lineNum = 1;
			br.readLine();

			while ((strLine = br.readLine()) != null) {
				// Print the content on the console
				

//				System.out.print(strLine+"\t");
				String[] val = strLine.split("\\s");
				int[] valI = new int[val.length-3];
				for (int i = 3; i < val.length; i++) {

					valI[i-3] = Integer.valueOf(val[i]);

					// System.out.print(val[i]+"_"+valI[i]);

				}
				System.out.print("Case #" + lineNum + ": ");
				System.out
						.println(g.calculate(Integer.valueOf(val[0]),
								Integer.valueOf(val[1]),
								Integer.valueOf(val[2]), valI));
//				 System.out.println();

				// System.out.println(strLine.charAt(0));
				lineNum++;
			}
			// Close the input stream
			in.close();
		} catch (Exception e) {// Catch exception if any
			e.printStackTrace();
		}
	}

	public int calculate(int n, int surprises, int p, int... tArray) {

		int counterGreaterThanP = 0;
		int surpriseRemaining = surprises;

		for (int t : tArray) {

			int d = t / 3;
			int r = t % 3;
			int max = 0;
			int maxS = 0;

			if (t == 0) {
				max = 0;
				maxS = 0;
			} else if (t == 30) {
				max = 10;
				maxS = 10;
			} else if (t == 1) {
				max = 1;
				maxS = 1;
			} else if (t == 2) {
				max = 1;
				maxS = 2;
			} else {

				if (r == 0) {
					max = d;
					maxS = d + 1;
				} else if (r == 1) {
					max = d + 1;
					maxS = d + 1;
				} else if (r == 2) {
					max = d + 1;
					maxS = d + 2;
				}

			}
			if (max >= p) {
				counterGreaterThanP++;
			} else if (maxS >= p && surpriseRemaining > 0) {
				counterGreaterThanP++;
				surpriseRemaining--;
			}
		}

		return counterGreaterThanP;
	}

}
