package qualifications2012;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class GoogleDancers {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("input.txt"));
		BufferedWriter out = null;
		try {
			FileWriter fstream = new FileWriter("out.txt");
			out = new BufferedWriter(fstream);
			int cases = in.nextInt();
			for (int i = 0; i < (cases); i++) {
				int result = 0;
				int n = in.nextInt();
				int s = in.nextInt();
				int tempS = s;
				int possSup = 0;
				int p = in.nextInt();
				for (int j = 0; j < n; j++) {
					int current = in.nextInt();
					int div = current / 3;
					int mod = current % 3;
					switch (mod) {
					case 0:
						if (div >= p) {
							result++;
							if (div + 1 < 11)
								possSup++;
						} else if (div != 0 && div + 1 >= p) {
							result++;
							tempS--;
						} else if (div != 0) {
							possSup++;
						}
						break;
					case 1:
						if (div + 1 >= p) {
							result++;
						}
						possSup++;
						break;
					case 2:
						if (div + 1 >= p) {
							result++;
							if (div + 2 < 11)
								possSup++;
						} else if (div + 2 >= p) {
							result++;
							tempS--;
						} else
							possSup++;
						break;
					default:
						break;
					}
				}
				if (tempS < 0) {
					result = result + tempS;
				} else if (tempS > 0) {
					if (possSup < tempS)
						result = result - (tempS - possSup);
				}
				System.out.println(result);
				out.write("Case #" + (i + 1) + ": " + result + "\n");
			}
			out.close();
		} catch (Exception e) {// Catch exception if any
			e.printStackTrace();
			System.err.println("Error: " + e.getMessage());
		}
	}
}
