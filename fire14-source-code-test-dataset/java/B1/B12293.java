package com.gnooo;

import java.util.HashMap;
import java.util.Scanner;

public class Solution {
	static final boolean DBG = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		long dStart = System.currentTimeMillis();

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= T; i++) {
			OneTask task = new OneTask(sc.nextInt(), sc.nextInt());
			long res = task.getSolution();
			sb.append("Case #");
			sb.append(i);
			sb.append(": ");
			sb.append(res);
			sb.append('\n');
		}

		if (DBG) {
			sb.append("time :");
			sb.append(System.currentTimeMillis() - dStart);
		}
		System.out.print(sb.toString());

	}

	static class OneTask {
		long a, b;

		public OneTask(long a, long b) {
			this.a = a;
			this.b = b;
		}

		long getSolution() {
			long c = 0;

			for (long i = a; i < b; i++) {
				c += numberHasRecycledPairs(a, b, i);
			}
			return c;
		}

	}

	static long numberHasRecycledPairs(long min, long max, long no) {
		String str = String.valueOf(no);

		final int len = str.length();
		int res = 0;
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		for (int i = 1; i < len; i++) {
			long tmp = Long.parseLong(str.substring(len - i)
					+ str.substring(0, len - i));
			if (min <= tmp && tmp <= max && tmp > no) {
				if (!map.containsKey(tmp)) {
					res++;
					map.put(tmp, 0);
				}
			}
		}

		return res;
	}
}
