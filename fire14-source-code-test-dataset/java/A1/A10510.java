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
 * Dancing with the Googlers
 * 
 * @author csorbazoli
 */
public class ProblemB extends AbstractCodeJamBase {

    public static void main(String[] args) {
	new ProblemB(args);
    }

    int T; // number of test case

    public ProblemB(String[] args) {
	super(args, AbstractCodeJamBase.READER_TYPE);
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
	this.T = this.readInt(reader, "Number of cases");
	int[] items;
	int result = 0;
	int N, S, p;
	int surp, smallest, cur, diff;
	for (int i = 1; i <= this.T; i++) {
	    items = this.readIntArray(reader, "N, S, p and N integers");
	    // The first integer will be N, the number of Googlers,
	    // and the second integer will be S, the number of surprising
	    // triplets of scores.
	    // The third integer will be p, as described above.
	    // Next will be N integers ti: the total points of the Googlers.
	    if ((items.length > 0) && (items.length == 3 + items[0])) {
		// * TEST */System.out.println("Case #" + i + ": input = " +
		// Arrays.toString(items));
		N = items[0];
		S = items[1];
		p = items[2];
		// For each test case, output one line containing "Case #x: y",
		// where x is the case number (starting from 1) and y is the
		// maximum number of Googlers who could have had a best result
		// of greater than or equal to p.
		surp = result = 0;
		for (int j = 0; j < N; j++) {
		    cur = items[3 + j];
		    if (cur >= p) {
			// smallest result
			smallest = (cur - p) / 2;
			diff = p - smallest;
			if (diff <= 2) {
			    if (diff == 2) { // only when suprising
				surp++;
				// * TEST */System.out.println("	" + cur +
				// " -> SUPP");
			    } else { // even if not surprising
				// * TEST */System.out.println("	" + cur +
				// " -> MAX");
				result++;
			    }
			} // else not possible
		    }
		}
		// at most S googlers may have p points amoung surp
		// * TEST */System.out.println("	result = " + result + " + " +
		// Math.min(surp, S));
		result += Math.min(surp, S);
		pw.println("Case #" + i + ": " + result);
	    } else {
		System.out.println("Test case " + i + " INVALID: input line should contain N, S, p and N integers" + Arrays.toString(items));
	    }
	}
    }
}
