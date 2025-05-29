/*
 * Problem C. Recycled Numbers
 * 
 * Do you ever become frustrated with television because you keep seeing the
 * same things, recycled over and over again? Well I personally don't care about
 * television, but I do sometimes feel that way about numbers.
 * 
 * Let's say a pair of distinct positive integers (n, m) is recycled if you can
 * obtain m by moving some digits from the back of n to the front without
 * changing their order. For example, (12345, 34512) is a recycled pair since
 * you can obtain 34512 by moving 345 from the end of 12345 to the front. Note
 * that n and m must have the same number of digits in order to be a recycled
 * pair. Neither n nor m can have leading zeros.
 * 
 * Given integers A and B with the same number of digits and no leading zeros,
 * how many distinct recycled pairs (n, m) are there with A ≤ n < m ≤ B?
 * 
 * Input
 * 
 * The first line of the input gives the number of test cases, T. T test cases
 * follow. Each test case consists of a single line containing the integers A
 * and B.
 * 
 * Output
 * 
 * For each test case, output one line containing "Case #x: y", where x is the
 * case number (starting from 1), and y is the number of recycled pairs (n, m)
 * with A ≤ n < m ≤ B.
 * 
 * Limits
 * 
 * 1 ≤ T ≤ 50.
 * 
 * A and B have the same number of digits.

Small dataset

1 ≤ A ≤ B ≤ 1000.

Large dataset

1 ≤ A ≤ B ≤ 2000000.

Sample


Input 
 	
Output 
 
4
1 9
10 40
100 500
1111 2222
Case #1: 0
Case #2: 3
Case #3: 156
Case #4: 287
 */

package google.codejam.y2012.qualifications;

import google.codejam.commons.Utils;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * @author Marco Lackovic <marco.lackovic@gmail.com>
 * @version 1.0, Apr 14, 2012
 */
public class RecycledNumbers {

	private static final String INPUT_FILE_NAME = "C-small-attempt0.in";
	private static final String OUTPUT_FILE_NAME = "C-small-attempt0.out";

	/*
	 * Per c è una ricerca pseudocubica in un range finito Per ogni m, per ogni
	 * n entrambi compresi tra a e b con m<n esiste una permutazione barrelshift
	 * di m taleche produca n? Questo è il succo La difficoltà di c sta in due
	 * punti Prima di tutto nel weeding out dei risultati certamente errati 15
	 * non diventerà mai 42 manco se ti ammazzi E poi nella verifica dei
	 * risultati possibilmente corretti... 11201 potrebbe diventare 20111 Se lo
	 * fa incrementa un contatore E poi stampa i risultati Questi due casi vanno
	 * ottimizzati Successivamente bisogna vedere se c'è un barrelshift decimale
	 * "economico" in Java, altrimenti non si può fare granché :/ Anche
	 * trattandoli come char [] si perde moto tempo nella stringizzazione e nel
	 * parseint Leggili, magari vengono più facili per te ;)
	 */

	public static void main(String[] args) throws IOException {
		String[] input = Utils.readFromFile(INPUT_FILE_NAME);
		String[] output = new String[input.length];
		int x = 0;
		for (String line : input) {
			StringTokenizer st = new StringTokenizer(line);
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			System.out.println("Computing case #" + (x + 1));
			output[x++] = "Case #" + x + ": " + recycledNumbers(a, b);
		}
		Utils.writeToFile(output, OUTPUT_FILE_NAME);
	}

	private static int recycledNumbers(int a, int b) {
		int count = 0;
		for (int n = a; n < b; n++) {
			count += getNumGreaterRotations(n, b);
		}
		return count;
	}

	private static int getNumGreaterRotations(int n, int b) {
		int count = 0;
		char[] chars = Integer.toString(n).toCharArray();
		for (int i = 0; i < chars.length; i++) {
			chars = rotateRight(chars);
			if (chars[0] != '0') {
				int m = Integer.valueOf(new String(chars));
				if (n == m) {
					break;
				} else if (n < m && m <= b) {
					count++;
				}
			}
		}
		return count;
	}

	private static char[] rotateRight(char[] chars) {
		char last = chars[chars.length - 1];
		for (int i = chars.length - 2; i >= 0; i--) {
			chars[i + 1] = chars[i];
		}
		chars[0] = last;
		return chars;
	}

}
