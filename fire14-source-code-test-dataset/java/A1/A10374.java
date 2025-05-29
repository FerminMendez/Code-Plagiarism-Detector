import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;


public class BQ {
	public static void main(String[] args) {
		BufferedReader reader = null;
		BufferedWriter writer = null;
		int T = 0, k, j, N, S, p, i, ti, tis, mod, G = 0;
		String line = null, caseSolution;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1])));	
			T = Integer.parseInt(reader.readLine());
			for (k = 1; k <= T; k++) {
				line = reader.readLine();
				N = Integer.parseInt(line.substring(0, j = line.indexOf((int)' ', 0)));
				S = Integer.parseInt(line.substring(++j, j = line.indexOf((int)' ', j)));
				p = Integer.parseInt(line.substring(++j, j = line.indexOf((int)' ', j)));
				for (i = 0; i < N; i++) {
					if (i != N - 1) {
						ti = Integer.parseInt(line.substring(++j, j = line.indexOf((int)' ', j)));
					}
					else {
						ti = Integer.parseInt(line.substring(++j));
					}
					tis = ti/3;
					mod = ti%3;
					if (tis >= p || (tis + 1 >= p && mod > 0)) {
						G++;
					}
					else {
						if (((tis + 1 >= p && mod == 0 && tis > 0) || (tis + 2 >= p && mod == 2)) && S > 0) {
							G++;
							S--;
						}
					}
				}
				writer.write("Case #" + k + ": " + G + "\n");
				G = 0;			
			}
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		try {
			if (reader != null) {
				reader.close();
			}
			if (writer != null) {
				writer.close();
			}
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}