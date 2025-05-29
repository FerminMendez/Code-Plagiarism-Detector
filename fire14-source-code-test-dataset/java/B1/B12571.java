import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;


public class RecycledNumbers {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(new FileReader("C-small-attempt0.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("outputC1.txt"));

		int caseCount = sc.nextInt();
		sc.nextLine();

		int a, b, count, c, k, l;
		for (int caseNum = 0; caseNum < caseCount; caseNum++) {

			a = sc.nextInt();
			b = sc.nextInt();

			count = 0;
			for (int i = a; i <= b; i++) {

				k = 10;
				l = (int) Math.pow(10, (int) Math.log10(i));
				HashSet<Integer> pairs = new HashSet<Integer>();
				while (k < i) {
					c = (i % k)*l + i/k;

					if (i < c && c <= b) {
						pairs.add(c);
					}

					k *= 10;
					l /= 10;
				}
				count += pairs.size();
			}

			pw.write("Case #" + (caseNum + 1) + ": ");
			pw.write(count + "\n");
		}

		pw.flush();
		pw.close();
		sc.close();
	}
}
