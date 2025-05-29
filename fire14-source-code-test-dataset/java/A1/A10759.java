import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class QuestionB {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("B-small-attempt0.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));

		int t = sc.nextInt(); // number of test cases

		for (int i = 0; i < t; i++) {
			pw.print("Case #" + (i + 1) + ": ");
			System.out.print("Case #" + (i + 1) + ": ");
			int n = sc.nextInt(); // number of Googlers
			int s = sc.nextInt(); // number of surprising scores
			int p = sc.nextInt(); // min score for best result

			int count = 0;
			for (int j = 0; j < n; j++) {
				int target = sc.nextInt();
				if (target < p)
					continue;
				int temp = target / 3;
				if (temp + temp + temp == target && temp >= p) {
					count++;
					continue;
				}
				if (temp + temp + (temp - 1) == target && temp >= p) {
					count++;
					continue;
				}
				if (temp + temp + (temp + 1) == target && temp + 1 >= p) {
					count++;
					continue;
				}
				if (temp + (temp - 1) + (temp - 1) == target && temp >= p) {
					count++;
					continue;
				}
				if (temp + (temp + 1) + (temp + 1) == target && temp + 1 >= p) {
					count++;
					continue;
				}
				if (s > 0) {
					if (temp + (temp + 1) + (temp + 2) == target
							&& temp + 1 >= p) {
						count++;
						s--;
						continue;
					}
					if (temp + (temp - 1) + (temp - 2) == target && temp >= p) {
						count++;
						s--;
						continue;
					}
					if (temp + temp + (temp + 2) == target && temp + 2 >= p) {
						count++;
						s--;
						continue;
					}
					if (temp + temp + (temp - 2) == target && temp >= p) {
						count++;
						s--;
						continue;
					}
					if (temp + (temp + 2) + (temp + 2) == target
							&& temp + 2 >= p) {
						count++;
						s--;
						continue;
					}
					if (temp + (temp - 2) + (temp - 2) == target && temp >= p) {
						count++;
						s--;
						continue;
					}
					if (temp + (temp - 1) + (temp + 1) == target
							&& temp + 1 >= p) {
						count++;
						s--;
						continue;
					}
				}
			}
			pw.print(count + "\n");
			System.out.println(count);
		}
		pw.flush();
		pw.close();
		sc.close();
	}

}
