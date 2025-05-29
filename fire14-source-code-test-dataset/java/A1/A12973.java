package mgg.problems;

import java.util.List;

import mgg.utils.FileUtil;
import mgg.utils.StringUtils;

/**
 * @author manolo
 * @date 14/04/12
 */
public class ProblemC {

	public final static String EXAMPLE_IN = "C-example.in";
	public final static String EXAMPLE_OUT = "C-example.out";

	public final static String C_SMALL_IN = "C-small-attempt0.in";
	public final static String C_SMALL_OUT = "C-small-attempt0.out";

	public final static String C_LARGE_IN= "C-large.in";
	public final static String C_LARGE_OUT = "C-large.out";

	public final static String delim = " ";

	public static String solve(FileUtil util) {

		String line = util.getLine();
		List<Integer> listOfArgs = StringUtils.stringWithIntegersToList(line, delim);

		final int A = listOfArgs.get(0);
		//System.out.println("\tA = " + A);

		final int B = listOfArgs.get(1);
		//System.out.println("\tB = " + B);

		//ArrayList<Pair> solution = new ArrayList<Pair>();
		int found = 0;
		for(int i = A; i < B ; i++){
			for(int j = A + 1; j <= B ; j++){
				if(i<j){
					if(recicled(i, j)){
						found++;//solution.add(new Pair(i, j));
					}
				}
			}
		}

		//System.out.println("Solution: " + solution);
		//System.out.println("Found: " + found);

		return "" + found;
	}

	private static boolean recicled(int n, int m) {

		int numCiphers = numCiphers(n);

		//System.out.println("n: " + n + "(" + numCiphers + ")");

		for(int i = 0; i < numCiphers; i++){
			int aux_n = moveCiphersToFront(n, i, numCiphers);
			//System.out.println("aux_n: " + aux_n);
			
			System.out.println("Comparing " + aux_n + " with " + m);
			if(aux_n == m){
				return true;
			}
		}

		return false;
	}

	private static int numCiphers(int n) {
		int result = 0;
		while(n > 0){
			n = n / 10;
			result++;
		}
		return result;
	}

	private static int moveCiphersToFront(int number, int howManyCiphers, int numCiphers) {
		String num = "" + number;

		String newNumber = num.substring(numCiphers-howManyCiphers, numCiphers) +
		num.substring(0, numCiphers-howManyCiphers);

		//System.out.println("new number: " + newNumber);

		return Integer.parseInt(newNumber);
	}

}
