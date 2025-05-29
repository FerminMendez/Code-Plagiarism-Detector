package qr2012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

public class RecycledNumbers {
	public static void main(String[] args) throws Exception {
		String fileName = args[0];
		RecycledNumbers obj = new RecycledNumbers();
		obj.solve(fileName);
	}

	public void solve(String fileName) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		BufferedWriter bw = new BufferedWriter(
				new FileWriter(fileName + ".out"));

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String str = br.readLine();

			StringTokenizer token = new StringTokenizer(str, " ");

			int A = Integer.parseInt(token.nextToken());
			int B = Integer.parseInt(token.nextToken());

			boolean[] check = new boolean[B + 1];

			int n = (int) Math.log10(A);
			int c1 = (int) Math.pow(10, n);
			int c2 = c1 * 10;
			int cnt = 0;
			for (int j = A; j <= B; j++) {
				if (j >= c2) {
					c1 = c2;
					c2 = c1 * 10;
					n += 1;
				}
				if (check[j]) {
					continue;
				} else {
					check[j] = true;
					int tmp = j;
					int ccnt = 1;
					for (int k = 0; k < n; k++) {
						tmp = (tmp % 10) * c1 + tmp / 10;
						if (tmp <= B && tmp >= c1 && tmp >= A && !check[tmp]) {
							ccnt += 1;
							check[tmp] = true;
						}
					}
					cnt += ccnt * (ccnt - 1) / 2;
				}
			}

			bw.write("Case #" + (i + 1) + ": ");
			bw.write("" + cnt);
			bw.write("\r\n");
		}
		bw.close();
		br.close();
	}

	private int cycle(int x, int digits) {
		return (x % 10) * 10000 + (x / 10);
	}
}
