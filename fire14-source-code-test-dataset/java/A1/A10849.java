package CodeJam2012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2 {

	public static void main(String[] args) throws IOException {
		FileReader buf = new FileReader("Input.in");
		BufferedReader br = new BufferedReader(buf);
		int cases = Integer.parseInt(br.readLine());
		String[] outputs = new String[cases];
		for (int i = 1; i <= cases; i++) {
			String input = br.readLine();
			String[] splits = input.split(" ");
			int N = Integer.parseInt(splits[0]);
			int S = Integer.parseInt(splits[1]);
			int p = Integer.parseInt(splits[2]);
			int thresh = 0;
			int special = S;
			int[] points = new int[splits.length - 3];
			for (int k = 0; k < points.length; k++) {
				points[k] = Integer.parseInt(splits[k + 3]);
			}
			for (int j = 0; j < points.length; j++) {
				int v = (int) (points[j] / 3);
				int rem = points[j] % 3;
				switch (rem) {
				case 2:
					if (v + 1 >= p || v >= p) {
						thresh++;
					} else if (special > 0 && v + 2 >= p) {
						thresh++;
						special--;
					}
					break;
				case 1:
					if (v >= p || v + 1 >= p) {
						thresh++;
					} else if (special > 0 && v + 1 >= p) {
						thresh++;
						special--;
					}
					break;
				case 0:
					if (v >= p) {
						thresh++;
					} else if (special > 0 && v > 0 && v + 1 >= p) {
						thresh++;
						special--;
					}
					break;
				}

			}
			if (i != cases)
				outputs[i - 1] = "Case #" + i + ": " + thresh + "\n";
			else
				outputs[i - 1] = "Case #" + i + ": " + thresh;
		}
		br.close();
		buf.close();
		FileWriter buf1 = new FileWriter(new File("OutputDance.txt"), true);
		BufferedWriter bw1 = new BufferedWriter(buf1);
		for (int i = 0; i < cases; i++) {
			bw1.write(outputs[i]);
		}
		bw1.close();
		buf1.close();

	}

}
