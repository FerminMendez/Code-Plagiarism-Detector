package problem.c;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProblemC {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		OutputBuilder out = new OutputBuilder();
		Set<Pair> pairs;
		int numCases;
		String A;
		String B;
		String[] linha;
		numCases = scanner.nextInt();
		scanner.nextLine();

		for (int k = 1; k <= numCases; k++) {
			linha = scanner.nextLine().split(" ");
			A = linha[0];
			B = linha[1];
			pairs = resolve(A, B);
			out.addLine(k, pairs.size());
		}
		System.out.println(out.toString());
	}

	private static Set<Pair> resolve(String A, String B) {
		Set<Pair> pairs = new HashSet<Pair>();
		int inicio = Integer.valueOf(A);
		int fim = Integer.valueOf(B);
		int k;
		for (int i = inicio; i <= fim; i++) {
			String N = String.valueOf(i);
			for (k = 1; k <= N.length() - 1; k++) {
				if ((Character.getNumericValue(N.charAt(k)) <= Character.getNumericValue(B.charAt(0))) && Character.getNumericValue(N.charAt(k)) != 0) {
					String M = (N.substring(k) + N.substring(0, k));
					if (!N.equals(M)) {
						if (Integer.valueOf(M) > inicio && Integer.valueOf(M) < fim) {
							pairs.add(new Pair(N, M));
						}
					}
				}
			}
		}
		return pairs;
	}

	private static class Pair {
		String n, m;

		public Pair(String n, String m) {
			this.n = n;
			this.m = m;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			return prime * ((this.m == null) ? 0 : this.m.hashCode()) + prime * ((this.n == null) ? 0 : this.n.hashCode());
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (this.getClass() != obj.getClass()) {
				return false;
			}
			Pair other = (Pair) obj;
			if (this.m.equals(other.n) && (this.n.equals(other.m))) {
				return true;
			}
			if (this.m == null) {
				if (other.m != null) {
					return false;
				}
			} else if (!this.m.equals(other.m)) {
				return false;
			}
			if (this.n == null) {
				if (other.n != null) {
					return false;
				}
			} else if (!this.n.equals(other.n)) {
				return false;
			}
			return true;
		}

	}

	private static class OutputBuilder {

		private StringBuilder sb = new StringBuilder();

		public void addLine(int i, int result) {
			this.sb.append("Case #");
			this.sb.append(i);
			this.sb.append(": ");
			this.sb.append(result);
			this.sb.append('\n');
		}

		@Override
		public String toString() {
			return this.sb.toString();
		}
	}

}
