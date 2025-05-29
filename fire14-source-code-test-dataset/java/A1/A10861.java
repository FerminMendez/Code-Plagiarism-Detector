package code.google.com;

import java.util.Scanner;

public class problemB {

	public static void main(String[] Args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		int n, s, p;

		sc.nextLine();

		for (int i = 1; i <= tests; i++) {
			int t;
			int count = 0;
			int uCount = 0;
			n = sc.nextInt();
			s = sc.nextInt();
			p = sc.nextInt();

			for (int j = 1; j <= n; j++) {
				t = sc.nextInt();
				if (suprise(t) >= p && unsuprise(t) >= p)
					count++;
				else if (suprise(t) >= p)
					count++;
				else if (unsuprise(t) >= p)
					uCount++;
			}

			if (s < uCount)
				uCount = s;

			System.out.println("Case #" + i + ": " + (count + uCount));
			sc.nextLine();

		}

	}

	public static int max(int a, int b, int c) {
		int max = Integer.MIN_VALUE;

		if (a > max)
			max = a;
		if (b > max)
			max = b;
		if (c > max)
			max = c;

		return max;
	}

	public static int suprise(int t) {

		int dim;

		dim = t / 3;

		if (t == 0)
			return 0;
		if (t == 30)
			return 30;

		if (dim > 0) {
			int p;

			p = (dim + 1) + (dim + 1) + (dim);
			if (p == t)
				return max((dim + 1), (dim + 1), (dim));
			p = (dim + 1) + (dim) + (dim);
			if (p == t)
				return max((dim + 1), (dim), (dim));
			p = (dim) + (dim) + (dim);
			if (p == t)
				return max((dim), (dim), (dim));
			p = (dim - 1) + (dim) + (dim);
			if (p == t)
				return max((dim - 1), (dim), (dim));
			p = (dim - 1) + (dim - 1) + (dim);
			if (p == t)
				return max((dim - 1), (dim - 1), (dim));

		} else
			return 1;

		return -1;
	}

	public static int unsuprise(int t) {
		int dim;
		int p;

		dim = t / 3;

		if (t == 0)
			return 0;
		if (t == 30)
			return 30;

		if (dim > 1 && dim < 9) {

			p = (dim + 2) + (dim + 1) + (dim);
			if (p == t)
				return max((dim + 2), (dim + 1), (dim));
			p = (dim + 2) + (dim + 2) + (dim);
			if (p == t)
				return max((dim + 2), (dim + 2), (dim));
			p = (dim + 2) + (dim) + (dim);
			if (p == t)
				return max((dim + 2), (dim), (dim));
			p = (dim - 2) + (dim - 1) + (dim);
			if (p == t)
				return max((dim - 2), (dim - 1), (dim));
			p = (dim - 2) + (dim) + (dim);
			if (p == t)
				return max((dim - 2), (dim), (dim));
			p = (dim - 2) + (dim - 2) + (dim);
			if (p == t)
				return max((dim - 2), (dim - 2), (dim));
			p = (dim - 1) + (dim + 1) + (dim);
			if (p == t)
				return max((dim - 1), (dim + 1), (dim));

		}

		if (dim <= 1) {

			p = (dim + 2) + (dim) + (dim);
			if (p == t)
				return max((dim + 2), (dim), (dim));
			p = (dim + 2) + (dim + 2) + (dim);
			if (p == t)
				return max((dim + 2), (dim + 2), (dim));
			p = (dim + 2) + (dim + 1) + (dim);
			if (p == t)
				return max((dim + 2), (dim + 1), (dim));

			if (dim == 1) {
				p = (dim - 1) + (dim + 1) + (dim);
				if (p == t)
					return max((dim - 1), (dim + 1), (dim));
			}

		}

		if (dim >= 9) {

			p = (dim - 2) + (dim - 2) + (dim);
			if (p == t)
				return max((dim - 2), (dim - 2), (dim));
			p = (dim - 2) + (dim) + (dim);
			if (p == t)
				return max((dim - 2), (dim), (dim));
			p = (dim - 2) + (dim - 1) + (dim);
			if (p == t)
				return max((dim - 2), (dim - 1), (dim));

			if (dim == 9) {
				p = (dim - 1) + (dim + 1) + (dim);
				if (p == t)
					return max((dim - 1), (dim + 1), (dim));
			}

		}

		return -1;
	}
}
