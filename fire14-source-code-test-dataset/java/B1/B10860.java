package be.mokarea.gcj.recyclednumbers;

import java.io.PrintWriter;
import java.util.HashSet;

import be.mokarea.gcj.common.TestCaseReader;
import be.mokarea.gcj.common.Transformation;

public class RecycledNumbersTransformation extends
		Transformation<RecycledNumbersTestCase> {

	public RecycledNumbersTransformation(
			TestCaseReader<RecycledNumbersTestCase> caseReader,
			PrintWriter outputWriter) {
		super(caseReader, outputWriter);
	}

	@Override
	protected String transform(RecycledNumbersTestCase testCase) {
		HashSet<PairOfInteger> setOfN_M = new HashSet<PairOfInteger>();
		final int a = testCase.getA();
		final int b = testCase.getB();
		for (int n = a; n <= b; n++) {
			for (int m : recycledNumberOf(n)) {
				if ( a <= n && n < m && m <= b) {
					setOfN_M.add(new PairOfInteger(n,m));
				}
			}
		}
		return formatOutput(testCase.getCaseNumber(), setOfN_M.size());
	}
	
	private String formatOutput(int caseNumber, int nbMatches) {
		StringBuffer buf = new StringBuffer();
		buf.append("Case #");
		buf.append(caseNumber);
		buf.append(": ");
		buf.append(nbMatches);
		return buf.toString();
	}

	private HashSet<Integer> recycledNumberOf(int n) {
		HashSet<Integer> recycledNumbers = new HashSet<Integer>();
		String nAsString = String.valueOf(n);
		for (int nbDigit = 1 ; nbDigit < nAsString.length(); nbDigit++) {
			final String end = nAsString.substring(nbDigit, nAsString.length());
			final String front = nAsString.substring(0, nbDigit);
			final String n2 = end + front;
			recycledNumbers.add(Integer.parseInt(n2));
		}
		return recycledNumbers;
	}

	class PairOfInteger {
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
			PairOfInteger other = (PairOfInteger) obj;
			if (m != other.m)
				return false;
			if (n != other.n)
				return false;
			return true;
		}

		private final int n;
		private final int m;
		
		PairOfInteger(int n, int m) {
			this.n = n;
			this.m = m;
		}
	}
}
