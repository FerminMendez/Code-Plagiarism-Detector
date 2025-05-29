package qr2012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class DancingWithTheGooglers {
	public static void main(String[] args) throws Exception {
		String fileName = args[0];
		DancingWithTheGooglers obj = new DancingWithTheGooglers();
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

			int N = Integer.parseInt(token.nextToken());
			int S = Integer.parseInt(token.nextToken());
			int p = Integer.parseInt(token.nextToken());
			int[] t = new int[N];
			for (int j = 0; j < N; j++) {
				t[j] = Integer.parseInt(token.nextToken());
			}

			// Arrays.sort(t);

			int cnt = 0;
			int scnt = 0;

			for (int j = N - 1; j >= 0; j--) {
				if (t[j] >= 3 * p - 2) {
					cnt += 1;
				} else if (t[j] >= 3 * p - 4 && t[j] >= 2 && scnt < S) {
					cnt += 1;
					scnt += 1;
				}
			}

			bw.write("Case #" + (i + 1) + ": ");
			bw.write("" + cnt);
			bw.write("\r\n");
		}
		bw.close();
		br.close();
	}
}
