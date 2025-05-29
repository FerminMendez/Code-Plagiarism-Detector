import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class B {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// BufferedReader read = new BufferedReader(new InputStreamReader(
		// new FileInputStream(
		// "C:/Users/Ortiga/Downloads/B-small-attempt0.in")));

		BufferedWriter write = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream("C:/Users/Ortiga/Downloads/outputB.txt")));
		Scanner sc = new Scanner(new InputStreamReader(new FileInputStream(
				"C:/Users/Ortiga/Downloads/B-small-attempt1.in")));
		byte length = sc.nextByte();
		for (byte i = 0; i < length; i++) {
			byte t = sc.nextByte(), s = sc.nextByte(), p = sc.nextByte(), max = 0, getDuringSurp = 0;
			String rit = "Case #" + (i + 1) + ": ";
			byte[] t_i = new byte[t];
			for (byte j = 0; j < t; j++)
				t_i[j] = sc.nextByte();
			Arrays.sort(t_i);
			int sCounter = 0;
			for (byte j = 0; j < t; j++) {
				byte currT_i = t_i[j];
				if (currT_i == 0 && p > 0)
					continue;
				if (sCounter < s) {
					if ((currT_i - 2) % 3 == 0) {
						if ((((currT_i - 2) / 3) + 2 >= p)) {
							max++;
							getDuringSurp++;
						}
						sCounter++;
						continue;
					} else if ((currT_i - 3) % 3 == 0) {
						if ((((currT_i - 3) / 3) + 2 >= p)) {
							max++;
							getDuringSurp++;
						}
						sCounter++;
						continue;
					}
				}
				if ((currT_i - 1) % 3 == 0) {
					if ((((currT_i - 1) / 3) + 1 >= p))
						max++;
					else if (currT_i + 4 / 3 >= p && getDuringSurp < sCounter) {
						sCounter--;
						j--;
					}
				} else if ((currT_i - 2) % 3 == 0) {
					if ((((currT_i - 2) / 3) + 1 >= p))
						max++;
					else if (currT_i + 4 / 3 >= p && getDuringSurp < sCounter) {
						sCounter--;
						j--;
					}
				} else {
					if (currT_i / 3 >= p)
						max++;
					else if (currT_i + 4 / 3 >= p && getDuringSurp < sCounter) {
						sCounter--;
						j--;
					}
				}
			}
			rit += max;
			write.write(rit);
			if (i < length - 1)
				write.newLine();
		}
		sc.close();
		write.close();
	}
}
