import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Dancing_With_the_Googlers {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("input.in"));
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		FileWriter fw = new FileWriter("output.txt");
		int t = Integer.parseInt(in.readLine());
		int num = 1;
		while (t-- > 0) {
			String[] a = in.readLine().split(" ");
			int n = Integer.parseInt(a[0]);
			int s = Integer.parseInt(a[1]);
			int p = Integer.parseInt(a[2]);
			Integer[] inp = new Integer[n];
			for (int i = 0; i < inp.length; i++) {
				inp[i] = Integer.parseInt(a[i + 3]);
			}
			Arrays.sort(inp);
			int c = 0;
			for (int i = 0; i < inp.length; i++) {
				int first = inp[i] / 3;
				int rem = inp[i] - first;
				int second = rem / 2;
				int third = rem - (rem / 2);

				if (first == second && second == third) {
					if (first >= p) {
						c++;
					} else if (s > 0 && first > 0 && first + 1 >= p) {
						c++;
						s--;
					}
				} else if (first == second && second == third - 1) {
					if (third >= p)
						c++;
				} else if (second == third) {
					if (third >= p) {
						c++;
					} else if (third > 0 && third + 1 >= p && s > 0) {
						c++;
						s--;
					}
				}
			}
			fw.write("Case #" + num++ + ": " + c + "\n");
		}
		fw.flush();
		fw.close();
	}
}
