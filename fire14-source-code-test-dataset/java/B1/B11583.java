import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//import java.util.Scanner;

public class C {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(
				new FileInputStream(
						"C:/Users/Ortiga/Downloads/C-small-attempt0.in")));
		byte length = Byte.parseByte(read.readLine());

		BufferedWriter write = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream("C:/Users/Ortiga/Downloads/outputC.txt")));
		for (int i = 0; i < length; i++) {
			String[] line = read.readLine().split(" ");
			int a = Integer.parseInt(line[0]), b = Integer.parseInt(line[1]), pairs = 0;
			String rit = "Case #" + (i + 1) + ": ";
			for (int j = a; j <= b; j++) {
				String cur = j + "";
				for (int k = 1; k < line[0].length(); k++) {
					int a1 = Integer.parseInt(cur.substring(k)
							+ cur.substring(0, k));
					if (a1 > j && a1 <= b)
						pairs++;
				}
			}
			rit += pairs;
			write.write(rit);
			if (i < length - 1)
				write.newLine();
		}
		read.close();
		write.close();
	}
}