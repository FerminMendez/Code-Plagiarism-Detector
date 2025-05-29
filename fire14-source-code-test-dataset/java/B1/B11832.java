import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CopyOfCopyOfMain {

	static int ndigits(int n) {
		return (int) (Math.log10(n) + 1);
	}

	static int rot(int n, int dig) {
		return (int) ((n % 10) * Math.pow(10, dig - 1)) + (int) (n / 10);
	}

	public static void main(String[] args) throws FileNotFoundException {
		String file = "C-small-attempt0";
		Scanner in = new Scanner(new File(file + ".in"));
		PrintWriter out = new PrintWriter(new File(file + ".out"));

		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			int A = in.nextInt();
			int B = in.nextInt();

			int c = 0;
			int[] list = new int[ndigits(B)];
			numbers: for (int i = A; i <= B; i++) {
				int digs = ndigits(i);
				int rot = i;
				int pairs = 0;

				Arrays.fill(list, -1);
				list[0] = i;

				digits: for (int j = 1; j <= digs + 1; j++) {

					rot = rot(rot, digs);
					if(rot < i)
						continue;

					if (A <= rot && rot <= B) {
						for (int k = 0; k < j; k++) {
							if (list[k] == rot) {
								continue digits;
							}
						}
						pairs++;
						list[j] = rot;
					}
				}

				//c += pairs * (pairs + 1) / 2;
				c += pairs ;
				// c+=digs;
			}
			out.println("Case #" + t + ": " + c);
		}

		in.close();
		out.close();
	}
}
