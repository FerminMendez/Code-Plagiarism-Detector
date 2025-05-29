import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class QualQ3 {


	private final Scanner inputScanner = new Scanner(System.in);

	private Scanner testCaseScanner;


	int[] scores;
	
	private Set<String> set;
	private int A;
	private int B;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		QualQ3.init();
		QualQ3 speaking = new QualQ3();
		speaking.solve();
	}

	private static void init() {
		try {
			System.setIn(new FileInputStream("in.txt"));
			System.setOut(new PrintStream("out.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void solve() {
		// Number of test cases
		int T = inputScanner.nextInt();
		inputScanner.nextLine();
		for (int i = 1; i <= T; i++) {
			initTestCase();
			readTestCase();
			solveTestCase();
			printTestCase(i);
		}
	}


	private void initTestCase() {
		set = new HashSet<String>();
	}

	private void readTestCase() {
		testCaseScanner = new Scanner(inputScanner.nextLine());
		
		A = testCaseScanner.nextInt();
		B = testCaseScanner.nextInt();
	}

	private void solveTestCase() {
		String sA = (new Integer(A)).toString();

		int strLen = sA.length();
		
	
		for (int i=A; i<=B; i++) {
			String current = (new Integer(i)).toString();
					
			for (int j=1;j<strLen;j++) {
				String prefix = current.substring(0, j);
				String nextDigits = current.substring(j);
				
				String newNum = nextDigits+prefix;
				int newNumVal = Integer.valueOf(newNum);
				
//				System.out.println("" + i + " -> " + newNumVal);
				if (newNumVal > i && newNumVal<=B) {
					String pair = "" + i + "," + newNum;
//					System.out.println("" + i + " -> " + newNumVal);
					set.add(pair);
				}
					
			}
		}
	}


	private final MessageFormat printFormat = new MessageFormat("Case #{0}: ");

	private void printTestCase(int num) {
		System.out.print(printFormat.format(new Object[] { num }));
		System.out.println(set.size());
	}
}
