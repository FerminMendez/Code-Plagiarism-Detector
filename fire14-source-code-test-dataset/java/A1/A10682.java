/**
 * 
 */
package google.exercise.b;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author tomtom
 * 
 */
public class B {

    private static Scanner in;
    private static PrintWriter out;
    private static int nbCase;

    private static class Solver {

	private int currentNbMax;
	private int currentNbMin;
	private int treshold;
	private int nbGooglers;
	private List<Integer> scores;
	private int nbSurprise;

	public void solve() {
	    for (int i = 1; i <= nbCase; i++) {
		out.printf("Case #%d: %s%n", i, doSolve());
		in.nextLine();
	    }
	}

	private int doSolve() {
	    int nbGoodScorer = 0;
	    scores = new ArrayList<Integer>();
	    nbGooglers = in.nextInt();
	    nbSurprise = in.nextInt();
	    treshold = in.nextInt();
	    currentNbMax = treshold * 3 - 2;
	    currentNbMin = ((treshold - 2) < 0 ? 0 : treshold - 2) * 2
		    + treshold;

	    for (int i = 0; i < nbGooglers; i++) {
		scores.add(in.nextInt());
	    }

	    Collections.sort(scores);
	    Collections.reverse(scores);

	    for (Integer score : scores) {
		if (score >= currentNbMax) {
		    nbGoodScorer++;
		} else if (score < currentNbMax && score >= (currentNbMax - 2)) {
		    if (nbSurprise > 0) {
			nbSurprise--;
			if (score >= treshold) {
			    nbGoodScorer++;
			}
		    }
		}
	    }

	    return nbGoodScorer;
	}

    }

    /**
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
	in = new Scanner(
		new File("/Users/tomtom/Desktop/jam-2012/input-B/B.in"));
	out = new PrintWriter(new FileOutputStream(
		"/Users/tomtom/Desktop/jam-2012/input-B/B.out"));

	nbCase = in.nextInt();
	in.nextLine();

	new Solver().solve();

	in.close();
	out.close();
    }
}
