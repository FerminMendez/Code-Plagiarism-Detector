import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

class Factory implements TestCaseFactory {

	@Override
	public TestCase getInstance(int number) {
		return new RecycledNumbers(number);
	}
}

public class RecycledNumbers extends TestCase {

	int caseItem;

	int A;
	int B;

	int order;
	int power;

	int count;

	public RecycledNumbers(int caseItem) {
		this.caseItem = caseItem;
	}

	@Override
	public void readInput(BufferedReader in) throws IOException,
			MalformedInputFileException {
		final String str1 = in.readLine();
		final String[] tokens = str1.split("\\s");
		A = Integer.parseInt(tokens[0]);
		B = Integer.parseInt(tokens[1]);
	}

	private int pow(int x, int p) {
		int result = 1;
		for (int i = 0; i < p; i++) {
			result *= x;
		}
		return result;
	}

	private int shift(int x) {
		final int digit = x / power;
		final int remainder = x % power;
		return remainder * 10 + digit;
	}

	private int findNumberOfPairs(int x) {
		final Set<Integer> distint = new HashSet<Integer>();
		distint.add(x);
		int shifted = x;
		for (int i = 0; i < order; i++) {
			shifted = shift(shifted);
			if (shifted >= A && shifted < x) {
				return 0;	// we've already seen all these permutations
			} else if (shifted > x && shifted <= B) {
				distint.add(shifted);
			}
		}
		final int size = distint.size();
		return size * (size - 1) / 2;
	}

	@Override
	public void solve() {
		order = (int) Math.log10(A);
		power = pow(10, order);

		count = 0;
		for (int x = A; x < B; x++) {
			count += findNumberOfPairs(x);
		}
	}

	@Override
	public void writeOutput(PrintWriter out) {
		out.print("Case #" + (caseItem + 1) + ": ");
		out.print(count);
		out.print("\n");

	}

	public static void main(String[] args) throws IOException,
			MalformedInputFileException {
		new Processor().process(new Factory(), args[0], args[1]);
	}
}