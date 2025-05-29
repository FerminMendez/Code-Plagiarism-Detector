package com.renoux.gael.codejam.cj2012.qc;

import java.util.HashSet;
import java.util.Set;

import com.renoux.gael.codejam.fwk.Solver;
import com.renoux.gael.codejam.utils.ArrayUtils;
import com.renoux.gael.codejam.utils.Input;
import com.renoux.gael.codejam.utils.Output;

public class QC extends Solver {

	public static void main(String... args) throws Exception {
		new QC().run();
	}

	@Override
	protected void solveCase(Input in, Output out) {
		System.out.println();
		int[] line = ArrayUtils.parseInts(in.readLine().split(" "));
		int a = line[0];
		int b = line[1];

		Set<Pair> pairs = new HashSet<Pair>();
		for (int i = a; i < b; i++) {
			String number = Integer.toString(i);
			for (int k = 1; k < number.length(); k++) {
				String modified = number.substring(k) + number.substring(0, k);
				int value = Integer.parseInt(modified);
				if (i < value && value <= b) {
					// System.out.println(i + " " + value);
					Pair p = new Pair(i, value);
					if (!pairs.add(p)) {
						// System.out.println("Duplicata !!!");
					}
				}
			}

		}

		out.writeLine(pairs.size());
	}

	@Override
	protected String getProblemName() {
		return "QC";
	}

	@Override
	protected boolean disableSample() {
		return true;
	}

	@Override
	protected boolean disableLarge() {
		return true;
	}

	public static class Pair {
		public int m, n;

		public Pair(int m, int n) {
			this.m = m;
			this.n = n;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + m;
			result = prime * result + n;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (m != other.m)
				return false;
			if (n != other.n)
				return false;
			return true;
		}

	}
}
