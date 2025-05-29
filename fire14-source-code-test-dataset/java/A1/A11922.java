package test.cjam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Triplet {

	static HashMap<Integer, Integer> sMap = new HashMap<Integer, Integer>();

	static HashMap<Integer, Integer> nsMap = new HashMap<Integer, Integer>();

	static void generateMap() {
		for (int i = 2; i <= 28; i++) {

			// int res = 0
			if ((i + 2) % 3 == 0) {
				sMap.put(i, (i + 2) / 3);
			} else if ((i + 3) % 3 == 0) {
				sMap.put(i, (i + 3) / 3);
			} else if ((i + 4) % 3 == 0) {
				sMap.put(i, (i + 4) / 3);
			}
		}

	}

	static void generateNSMap() {
		for (int i = 0; i <= 30; i++) {
			if (i % 3 == 0) {
				nsMap.put(i, i / 3);
			} else if ((i + 2) % 3 == 0) {
				nsMap.put(i, (i + 2) / 3);
			} else if ((i + 1) % 3 == 0) {
				nsMap.put(i, (i + 1) / 3);
			}
		}

	}

	public static void main(String args[]) throws Exception {

		generateMap();
		generateNSMap();

		BufferedReader br = new BufferedReader(new FileReader(new File(
				"input.txt")));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			String[] inArr = br.readLine().split(" ");

			int N = Integer.parseInt(inArr[0]);

			int S = Integer.parseInt(inArr[1]);

			int p = Integer.parseInt(inArr[2]);

			Integer tempArr[] = new Integer[N];
			int ofs = 3;
			for (int i = 0; i < N; i++) {
				tempArr[i] = Integer.parseInt(inArr[i + ofs]);
			}

			Collections.sort(Arrays.asList(tempArr));

			int cnt = 0;

			int fIndex = -1;

			if (S == 0) {
				for (int i = 0; i < N; i++) {
					int val = tempArr[i];
					if (p <= nsMap.get(val)) {
						fIndex = i;
						cnt = N - fIndex;
						break;
					}
				}
			} else {
				for (int i = 0; i < N; i++) {
					int val = tempArr[i];
					if (val < 2 || val > 28)
						continue;
					if (p <= sMap.get(val)) {
						fIndex = i;
						S--;
						cnt++;
						break;
					}
				}

				int ind = fIndex + 1;

				while (S > 0) {
					if (ind >= N)
						break;
					int val = tempArr[ind];
					if (p <= sMap.get(val)) {
						S--;
						cnt++;
					}
					ind++;
				}

				for (int j = ind; j < N; j++) {
					int val = tempArr[j];
					if (p <= nsMap.get(val)) {
						fIndex = j;
						cnt += N - fIndex;
						break;
					}
				}

			}

			System.out.println("Case #" + t + ": " + cnt);

		}

		br.close();

	}
}
