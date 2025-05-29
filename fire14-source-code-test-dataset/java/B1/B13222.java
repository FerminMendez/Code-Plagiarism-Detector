import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

public class Main3 {

	public static final String fileName = "A-small-attempt0.in";
	public static int[] power = new int[] { 1, 10, 100, 1000, 10000, 100000,
			1000000, 10000000, 100000000, 1000000000 };

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		PrintWriter pw = new PrintWriter(new File("out.txt"));
		int num = Integer.valueOf(br.readLine());
		for (int i = 0; i < num; i++) {
			String inline = br.readLine();
			int result = 0;
			String[] tmp = inline.split(" ");
			int a = Integer.valueOf(tmp[0]);
			int b = Integer.valueOf(tmp[1]);
			int size = 0;
			int a2 = a;

			while (a2 > 0) {
				a2 /= 10;
				size++;
			}

			for (int j = a; j < b; j++) {
				int prev = -1;
				for (int k = 1; k < size; k++) {
					int swapNum = swap(j, k, size);

					if (j < swapNum && swapNum <= b && swapNum != prev) {
						prev = swapNum;
						result++;
					}
				}
			}

			pw.println("Case #" + (i + 1) + ": " + result);
		}
		pw.close();
	}

	private static int swap(int raw, int posNum, int size) {
		return (raw % power[posNum]) * power[size - posNum] + raw
				/ power[posNum];
	}

}
