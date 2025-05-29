import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class B {

	PrintWriter out;

	public void read() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("B-small-attempt4.in"));
		out = new PrintWriter(new FileWriter("B-small-attempt4.out"));
		int n = Integer.parseInt(br.readLine());
		int i = 0;
		String line;
		while (i < n) {
			line = br.readLine();
			solve(i + 1, line);

			i++;
		}

		out.close();
		out.flush();
	}

	public void solve(int c, String line) {

		int max = 0;
		String[] tokens = line.split(" ");
		out.print("Case #" + c + ": ");

		List<Integer> t = new ArrayList<Integer>();
		Integer N = Integer.parseInt(tokens[0]);
		Integer S = Integer.parseInt(tokens[1]);
		Integer p = Integer.parseInt(tokens[2]);

		
			for (int i = 3; i < (N + 3); i++) {
				if (Integer.parseInt(tokens[i]) >= p)
					t.add(Integer.parseInt(tokens[i]));
			}
			
			for (int x = 0; x < t.size(); x++) {
				int sub = t.get(x) - p;

				if (sub >= (2 * p)) {
					max = max + 1;
				} else {
					if (p + (p - 1) > sub) {
						if ((p - 1) + (p - 1) > sub) {
							if (S > 0) {
								if ((p - 2) + p > sub) {
									if ((p - 2) + (p - 1) > sub) {
										if ((p - 2) + (p - 2) > sub) {
											continue;
										} else if ((p - 2) + (p - 2) == sub) {
											max = max + 1;
											S = S - 1;
										}
									} else if ((p - 2) + (p - 1) == sub) {
										max = max + 1;
										S = S - 1;
									}
								} else if ((p - 2) + p == sub) {
									max = max + 1;
									S = S - 1;
								}
							}
						} else if ((p - 1) + (p - 1) == sub) {
							max = max + 1;
						}
					} else if (p + (p - 1) == sub) {
						max = max + 1;
					}
				}
			}
		

		out.print(max);
		out.println();
	}

	public static void main(String[] args) throws IOException {
		new B().read();
	}
}
