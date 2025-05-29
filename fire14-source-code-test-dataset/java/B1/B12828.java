package Default_2012;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class C {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner("IO_2012/inputs/C-small-attempt0.in");
		PrintWriter out = new PrintWriter("IO_2012/outputs/C-small-attempt0.out");
		
		int n = in.nextInt();

		for (int i = 1; i <= n; i++) {
			in.nextLine();

			int a = in.nextInt();
			int b = in.nextInt();

			int count = 0;

			if (a < 10 && b < 10) {
				out.println("Case #" + i + ": 0");
				continue;
			}

			int v[] = new int[b + 1];

			for (int z = a; z <= b; z++) {
				String s = String.valueOf(z);

				for (int j = 0; j < s.length(); j++) {
					int num, total = 0;
					for (int ii = j + 1; ii < s.length(); ii++) {
						num = s.charAt(ii) - '0';
						total *= 10;
						total += num;
					}

					for (int ii = 0; ii <= j; ii++) {
						num = s.charAt(ii) - '0';
						total *= 10;
						total += num;
					}

					if (total != z && total >= a && total <= b && z < total
							&& v[total] != z) {
						count++;
						v[total] = z;
					}

				}
			}

			out.println("Case #" + i + ": " + count);
		}
		out.close();
	}

	public static class Scanner {
		private final BufferedReader in;
		private String line = "";
		private int pos;
		private int lineNo;

		public Scanner(String Arquive) throws Exception {
			in = new BufferedReader(new FileReader(Arquive));
			nextLine();
		}

		public boolean hasNext() throws IOException {
			return in.ready();
		}

		public void close() {
			try {
				in.close();
			} catch (IOException e) {
				throw new AssertionError("Failed to close with " + e);
			}
		}

		public void nextLine() {
			try {
				line = in.readLine();
			} catch (IOException e) {
				throw new AssertionError("Failed to read line with " + e);
			}
			pos = 0;
			lineNo++;
		}

		public String next() {
			if (pos != 0) {
				pos++;
			}
			StringBuilder sb = new StringBuilder();
			while (pos < line.length() && line.charAt(pos) > ' ')
				sb.append(line.charAt(pos++));
			return sb.toString();
		}

		public int nextInt() {
			int num, total = 0;
			boolean negativo = false;

			if (pos != 0) {
				pos++;
			}
			if (pos < line.length() && line.charAt(pos) == '-') {
				negativo = true;
				pos++;
			}

			while (pos < line.length() && line.charAt(pos) > ' ') {
				num = line.charAt(pos++) - '0';
				total *= 10;
				total += num;
			}
			if (negativo)
				total *= -1;

			return total;
		}

		public long nextLong() {
			long num, total = 0;
			boolean negativo = false;
			if (pos != 0) {
				pos++;
			}
			if (pos < line.length() && line.charAt(pos) == '-') {
				negativo = true;
				pos++;
			}
			while (pos < line.length() && line.charAt(pos) > ' ') {
				num = line.charAt(pos++) - '0';
				total *= 10;
				total += num;
			}
			if (negativo)
				total *= -1;
			return total;
		}
	}

}
