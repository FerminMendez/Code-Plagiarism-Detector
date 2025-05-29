package br.com.luan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int T = Integer.valueOf(line);

		// Process which number from stdin
		for (int i = 0; i < T; i++) {
			StringBuilder sb = new StringBuilder(line.length() + 11);
			sb.append("Case #");
			sb.append(i + 1);
			sb.append(": ");

			line = br.readLine();
			String[] split = line.split(" ");
			Integer N = Integer.parseInt(split[0]);
			Integer S = Integer.parseInt(split[1]);
			Integer p = Integer.parseInt(split[2]);
			Integer[] ti = new Integer[N];
			for (int j = 0; j < ti.length; j++) {
				ti[j] = Integer.parseInt(split[3 + j]);
			}

			int result = doProcess(N, S, p, ti);

			sb.append(result);

			sb.append('\n');
			System.out.print(sb.toString());

		}
	}

	private static int doProcess(Integer n, Integer s, Integer p, Integer[] ti) {
		final List<Integer> sureList = new ArrayList<Integer>(n);
		final List<Integer> posiList = new ArrayList<Integer>(n);

		final int impoMax = 3 * p.intValue() - 4;
		final int cerMin = 3 * p.intValue() - 2;

		for (int i = 0; i < ti.length; i++) {
			Integer in = ti[i];
			int sumScore = in.intValue();
			if (sumScore < impoMax) {
				// Impossible to get that score
			} else if (sumScore >= cerMin) {
				// Sure the dancer get that score
				sureList.add(in);
			} else if (sumScore > 0) {
				// Possibles dancer who can get that score depending the surprising
				posiList.add(in);
			}
		}

		int qualified = methodA(posiList, p, s);

		return sureList.size() + qualified;
	}

	private static int methodA(List<Integer> posiList, Integer p, Integer s) {
		int surprising = s.intValue();
		if (surprising == 0)
			return 0;

		int result = 0;

		for (int i = 0; i < surprising && posiList.size() > 0 ; i++) {
			posiList.remove(0);
			result += 1;
		}

		return result;
	}
}
