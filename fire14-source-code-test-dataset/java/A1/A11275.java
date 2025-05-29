package GooglerDancing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class GooglerDancing {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new FileReader("googlersInput"));
		PrintWriter pw = new PrintWriter(new File("googlersOutput"));
		String T = br.readLine();
		String line;
		int Case = 1;
		while ((line = br.readLine()) != null) {
			String[] strs = line.split(" ");
			int N = Integer.parseInt(strs[0]);
			int surprising = Integer.parseInt(strs[1]);
			int p = Integer.parseInt(strs[2]);
			int[] t = new int[N];
			System.out.println(p + " " + surprising);
			for (int i = 0; i < t.length; i++) {
				t[i] = Integer.parseInt(strs[i + 3]);
			}
			int threshold0 = p + p - 2 + p - 2;
			int threshold1 = p + p - 1 + p - 1;
			if (threshold0 < 0)
				threshold0 = 0;
			if (threshold1 < 0)
				threshold1 = 0;
			int count = 0;
			for (int i = 0; i < t.length; i++) {
				if (t[i] > 0 && t[i] >= threshold0 && t[i] < threshold1) {
					if (surprising > 0) {
						count++;
						surprising--;
						System.out.println(t[i]);

					}
				} else if (t[i] >= threshold1) {
					count++;
					System.out.println(t[i]);
				}
			}
			System.out.println(line + "\nCase #" + Case + ": " + count);
			pw.write("Case #" + Case + ": " + count + "\n");
			Case++;

		}
		pw.flush();
		pw.close();

	}

}
