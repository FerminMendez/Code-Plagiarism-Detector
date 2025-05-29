import java.io.*;
import java.util.*;

public class googlers {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		Scanner fe = new Scanner(new FileInputStream(
				"/home/gllera/Desktop/data.in"));
		FileWriter fs = new FileWriter("/home/gllera/Desktop/data.out");

		int cases = fe.nextInt();

		for (int i = 0; i < cases; i++) {
			int n = fe.nextInt();
			int s = fe.nextInt();
			int p = fe.nextInt();

			int sol = 0;

			for (int j = 0; j < n; j++) {
				int num = fe.nextInt();

				if (num == 0) {
					if (p == 0)
						sol++;

					continue;
				}

				if (num / 3 >= p) {
					sol++;
					continue;
				}

				if (num % 3 != 0)
					if (num / 3 + 1 >= p) {
						sol++;
						continue;
					}

				if (num % 3 != 1)
					if (s != 0)
						
						if (num % 3 != 0) {
							
							if (num / 3 + 2 >= p) {
								sol++;
								s--;
							}
							
						} else {
							
							if (num / 3 + 1 >= p) {
								sol++;
								s--;
							}
							
						}
			}

			fs.write("Case #" + (i + 1) + ": " + sol + '\n');
		}

		fe.close();
		fs.flush();
		fs.close();
	}

}
