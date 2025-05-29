import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DancingWithGooglers {

	public static void main(String[] args) {

		try {

			BufferedReader br = new BufferedReader(new FileReader("input.txt"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));

			int K, N, S, p, i, j;

			K = Integer.parseInt(br.readLine());
			for (i = 0; i < K; i++) {

				String[] line = br.readLine().split(" ");
				N = Integer.parseInt(line[0]);
				S = Integer.parseInt(line[1]);
				p = Integer.parseInt(line[2]);

				int[] data = new int[line.length - 3];
				for (j = 0; j < data.length; j++) {
					data[j] = Integer.parseInt(line[j + 3]);
					// System.out.print(data[j] + " ");
				}
				// System.out.println();

				int counter = 0;
				for (j = 0; j < data.length; j++) {

					int a, b, c;

					int res;
					a = (int) Math.floor((double) data[j] / 3);
					res = data[j] - a;
					b = (int) Math.floor((double) res / 2);
					res = res - b;
					c = res;

					if (a >= p || b >= p || c >= p) {
						counter++;
					} else if ((a + b + c) != 0 && (a + b + c) != 1) {
						int temp = (p - a) + (p - b) + (p - c);

						if (temp == 3 && S > 0) {

							counter++;
							S--;
						} else if (temp == 4 && S > 0) {
							counter++;
							S--;

						}
					}

				}
				bw.write("Case #" + (i+1) + ": " + counter);
				bw.newLine();

			}
			br.close();
			bw.close();

		} catch (IOException io) {
		}

	}

}
