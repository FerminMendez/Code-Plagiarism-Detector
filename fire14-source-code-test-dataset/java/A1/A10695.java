import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.MessageFormat;
import java.util.Map;
import java.util.Scanner;


public class QualQ2 {


	private final Scanner inputScanner = new Scanner(System.in);

	private Scanner testCaseScanner;

	private int answer;
	
	int[] scores;
	
	int N;
	int p;
	int S;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		QualQ2.init();
		QualQ2 speaking = new QualQ2();
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
		answer = 0;
	}

	private void readTestCase() {
		testCaseScanner = new Scanner(inputScanner.nextLine());
		
		N = testCaseScanner.nextInt();
		S = testCaseScanner.nextInt();
		p = testCaseScanner.nextInt();
		
		scores = new int[N];
		for (int i=0;i<N;i++)
			scores[i] = testCaseScanner.nextInt();

	}

	private void solveTestCase() {
		if (p==0) {
			answer = N;
			return;
		}
		
		for (int i=0;i<N;i++) {
			int high = (int)(Math.ceil(((float) scores[i] / 3.0f)));
			if (high >= p) {
				answer++;
				continue;
			}
			if (high == p-1 && S>0 && high !=0) {
				int mod = scores[i] % 3;
				if (mod == 0 || mod == 2) {
					answer++;
					S--;
				}				
			}			 
		}
	}


	private final MessageFormat printFormat = new MessageFormat("Case #{0}: ");

	private void printTestCase(int num) {
		System.out.print(printFormat.format(new Object[] { num }));
		System.out.println(answer);
	}
}
