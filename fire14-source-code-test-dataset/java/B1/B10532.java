/**
 * 
 */
package hu.herba.codejam.cj2012.qualification;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import hu.herba.codejam.AbstractCodeJamBase;

/**
 * Recycled Numbers
 * 
 * @author csorbazoli
 */
public class ProblemC extends AbstractCodeJamBase {

    public static void main(String[] args) {
	new ProblemC(args);
    }

    int T; // number of test case

    public ProblemC(String[] args) {
	super(args, AbstractCodeJamBase.READER_TYPE);
    }

    private boolean contains(String[] pairs, int found, String num) {
	boolean ret = false;
	for (int i = 0; i < found; i++) {
	    if (num.equals(pairs[i])) {
		// * TEST */System.out.println("  Pair already found before: " +
		// num);
		ret = true;
		break;
	    }
	}
	return ret;
    }

    private int countRecycled(int A, int B) {
	int result = 0, len;
	String strA = Integer.toString(A);
	String strB = Integer.toString(B);
	String orig, numbers, num;
	len = Integer.toString(A).length();
	String[] pairs = new String[len];
	int found;
	if (len > 1) {
	    for (int i = A; i <= B; i++) {
		orig = Integer.toString(i);
		numbers = orig + orig;
		found = 0;
		for (int j = 1; j <= len; j++) {
		    num = numbers.substring(j, j + len);
		    // each pair was counted twice
		    // if (!num.equals(orig) && (num.compareTo(strA) >= 0)
		    // &&
		    // (num.compareTo(strB) <= 0)) {
		    if ((num.compareTo(orig) > 0) && (num.compareTo(strA) >= 0) && (num.compareTo(strB) <= 0) && !this.contains(pairs, found, num)) {
			// *TEST*/ System.out.println("  " + orig +
			// " recycled with " +
			// num);
			pairs[found++] = num;
			result++;
		    }
		}
	    }
	}
	// *TEST*/System.out.println(" result: " + result);
	return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see hu.herba.codejam.AbstractCodeJamBase#process(java.io.BufferedReader,
     * java.io.PrintWriter)
     */
    @Override
    protected void process(BufferedReader reader, PrintWriter pw) throws IOException, IllegalArgumentException {
	// The first line of the input gives the number of test cases, T. T test
	// cases follow, one per line.
	// Each test case consists of a single line containing the integers A
	// and B.
	this.T = this.readInt(reader, "Number of cases");
	int[] items;
	for (int i = 1; i <= this.T; i++) {
	    items = this.readIntArray(reader, "testCase");
	    if (items.length == 2) {
		if (Integer.toString(items[0]).length() != Integer.toString(items[1]).length()) {
		    System.out.println("Test case " + i + " INVALID: A and B has different length - " + Arrays.toString(items));
		}
		// * TEST */System.out.println("Case #" + i + ": input = " +
		// Arrays.toString(items));
		// For each test case, output one line containing "Case #x: y",
		// where x is the case number (starting from 1), and y is the
		// number of recycled pairs (n, m) with A ≤ n < m ≤ B.
		pw.println("Case #" + i + ": " + this.countRecycled(items[0], items[1]));
	    } else {
		System.out.println("Test case " + i + " INVALID: test case should contain 2 integers A, B with same length" + Arrays.toString(items));
	    }
	}
    }
}
