/**
 * Copyright 2012 Christopher Schmitz. All Rights Reserved.
 */

package com.isotopeent.codejam;

import com.isotopeent.codejam.lib.SolverBase;
import com.isotopeent.codejam.lib.Utils;
import com.isotopeent.codejam.lib.converters.IntArrayLine;

public class Solver extends SolverBase<int[]> {

	private static final String FILE_PATH = "C:\\codejam\\";
	private static final String FILE_NAME = "C-small-attempt0";
	private static final int INIT_PARAM_COUNT = 1;

	private static final int MAX_DIGITS = 8;
	// digits go from low to high place in array
	private static final int[] tempNumberArr = new int[MAX_DIGITS];

	public static void main(String [] args) {
		Utils.solve(FILE_PATH, FILE_NAME, new IntArrayLine(2), new Solver());
	}

	public Solver() {
		super(INIT_PARAM_COUNT);
	}

	@Override
	protected String solve(int[] input) {
		int[] min = getNumberArr(input[0]);
		int[] max = getNumberArr(input[1]);

		int length = min.length;
		int leadDigit = length - 1;
		int minLeadDigit = min[leadDigit];
		int maxLeadDigit = max[leadDigit];

		int permutationCount = 0;
		for (int shift = 1; shift < length; shift++) {
			for (int lead = minLeadDigit; lead <= maxLeadDigit; lead++) {
				int[] n = new int[length];
				int[] m = new int[length];
				int mLockStart = shift - 1;
				n[leadDigit] = lead;
				m[mLockStart] = lead;
				for (int shiftLead = lead; shiftLead <= maxLeadDigit; shiftLead++) {
					int nLockStart = leadDigit - shift;
					n[nLockStart] = shiftLead;
					m[leadDigit] = shiftLead;
					permutationCount += permutate(min, max, shift, n, nLockStart, m, mLockStart, leadDigit - 1, shiftLead > lead);
				}
			}
		}

		return Integer.toString(permutationCount);
	}

	private static int permutate(int[] min, int[] max, int shift, int[] n, int nLockStart,
			int[] m, int mLockStart, int digit, boolean onlyCheckBounds) {
		int permutationCount = 0;
		int nMin;
		int nMax;
		if (digit <= nLockStart) {
			nMin = n[digit];
			nMax = nMin;
		} else {
			// TODO: optimization possible
			nMin = 0;
			nMax = 9;
		}
		int mMin;
		int mMax;
		// TODO: optimization possible
		if (digit <= mLockStart) {
			mMin = m[digit];
			mMax = mMin;
		} else {
			mMin = 0;
			mMax = 9;
		}
		int compareSize = n.length - digit;
		for (int i = nMin; i <= nMax; i++) {
			n[digit] = i;
			int shiftDigit = shift - n.length + digit;
			if (shiftDigit >= 0) {
				m[shiftDigit] = i;
			}
			if (compare(n, min, compareSize) >= 0) {
				// still in range, so continue
				int j;
				if (!onlyCheckBounds && mMin < i) {
					j = i;
				} else {
					j = mMin;
				}
				for (/*j = mMin*/; j <= mMax; j++) {
					m[digit] = j;
					shiftDigit = digit - shift;
					if (shiftDigit >= 0) {
						n[shiftDigit] = j;
					}
					if (compare(m, max, compareSize) <= 0) {
						if (digit > 0) {
							permutationCount += permutate(min, max, shift, n, nLockStart, m, mLockStart, digit - 1,
									onlyCheckBounds || j > i);
						} else if (onlyCheckBounds || j > i) {
							// check for repetition (which causes duplicate results), can ignore if shift <= repetition size (count first instance)
							int start = n[0];
							for (int k = 2; k < shift; k++) {
								if (n[k] == start) {
									boolean repeated = true;
									for (int offset = n.length - 1 - k; repeated && offset > 0; offset--) {
										repeated = (n[offset] == n[offset + k]);
									}
									if (repeated) {
										permutationCount--;
									}
								}
							}
							permutationCount++;
						}
					}
				}
			}
		}
		return permutationCount;
	}

	private static int[] getNumberArr(int number) {
		int length = 0;
		tempNumberArr[length++] = number % 10;
		while (number >= 10) {
			number /= 10;
			tempNumberArr[length++] = number % 10;
		}
		int[] numberArr = new int[length];
		System.arraycopy(tempNumberArr, 0, numberArr, 0, length);
		return numberArr;
	}

	private static int compare(int[] n, int[] m, int digits) {
		int result = 0;
		int min = n.length - digits;
		for (int i = n.length - 1; i >= min && result == 0; i--) {
			result = n[i] - m[i];
		}
		return result;
	}

}
