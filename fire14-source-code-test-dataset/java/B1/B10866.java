import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TestC {

	/**
	 * @param args
	 */
	public static void main(String[] arg) {
		try {
			String filein = "testC.in";
			String fileout = "testC.out";

			String currentdir = System.getProperty("user.dir");

			Scanner scanner = new Scanner(new File(currentdir + "/" + filein));
			FileWriter fWriter = new FileWriter(new File(currentdir + "/" + fileout));
			String line = "", resultat = "";

			int i = 0;

			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				if (i == 0) {
					try {
						Integer iNumber = Integer.valueOf(line);
					} catch (Exception ex) {
						resultat = " NaN !!!!";
						break;
					}
					i++;
					continue;
				}

				resultat = "Case #" + i + ": ";

				String[] s = line.split(" ");

				Integer A = Integer.valueOf(s[0]);
				Integer B = Integer.valueOf(s[1]);

				if (A < 10) {
					resultat += "0";
				} else {
					int n = 0;
					for (int j = A; j <= B; j++) {
						String n0 = Integer.toString(j);

						for (int k = 1; k < n0.length(); k++) {
							String first = n0.substring(0, k);
							String second = n0.substring(k, n0.length());

							String ricycled = second + first;
							Integer iRecycl = Integer.valueOf(ricycled);

							if (iRecycl > j && iRecycl <= B) {
								n++;
							}
						}
					}
					resultat += "" + n;
				}
				fWriter.append(resultat + "\r\n");

				i++;
			}
			scanner.close();
			fWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
