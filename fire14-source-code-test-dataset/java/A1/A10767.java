import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

class Factory implements TestCaseFactory {

	@Override
	public TestCase getInstance(int number) {
		return new DancingWithGooglers(number);
	}
}

public class DancingWithGooglers extends TestCase {

	int caseItem;

	int ngooglers;
	int[] scores;
	int surprising;
	int target;

	int max;

	public DancingWithGooglers(int caseItem) {
		this.caseItem = caseItem;
	}

	@Override
	public void readInput(BufferedReader in) throws IOException,
			MalformedInputFileException {
		final String str1 = in.readLine();
		final String[] tokens = str1.split("\\s");
		ngooglers = Integer.parseInt(tokens[0]);
		surprising = Integer.parseInt(tokens[1]);
		target = Integer.parseInt(tokens[2]);
		scores = new int[ngooglers];
		for (int i = 0; i < ngooglers; i++) {
			scores[i] = Integer.parseInt(tokens[i + 3]);
		}
	}

	private int guaranteedMax(int googler) {
		if (scores[googler] == 0) {
			return 0;
		} else {
			return (scores[googler] - 1) / 3 + 1;
		}
	}

	private int higherScores(int googler) {
		if (scores[googler] == 3) {
			return 0;
		} else {
			return (scores[googler] - 1) % 3 + 1;
		}
	}

	@Override
	public void solve() {
		int guaranteed = 0;
		int marginal = 0;
		for (int googler = 0; googler < ngooglers; googler++) {
			final int guaranteedMax = guaranteedMax(googler);
			if (guaranteedMax >= target) {
				guaranteed++;
			} else if (guaranteedMax == target - 1
					&& higherScores(googler) >= 2 && scores[googler] > 0) {
				marginal++;
			}
		}
		max = guaranteed + Math.min(marginal, surprising);
	}

	@Override
	public void writeOutput(PrintWriter out) {
		out.print("Case #" + (caseItem + 1) + ": ");
		out.print(max);
		out.print("\n");

	}

	public static void main(String[] args) throws IOException,
			MalformedInputFileException {
		new Processor().process(new Factory(), args[0], args[1]);
	}
}