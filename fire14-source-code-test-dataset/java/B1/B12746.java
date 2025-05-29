import java.io.*;
import java.util.Set;
import java.util.HashSet;

public class Recycler {
	public static void main(String[] args)
		throws IOException, FileNotFoundException {

		StreamTokenizer st = new StreamTokenizer(
				new FileReader(args[0]));

		FileWriter out = new FileWriter(args[1]);

		st.parseNumbers();
		if (st.nextToken() == StreamTokenizer.TT_EOF) eof_error();

		int numTestCases = (int) st.nval;
		int numDistinctPairs = 0;
		boolean twins = false;
		Set<Integer> partners = new HashSet<Integer>();

		for (int t = 0; t < numTestCases; ++t) {

			if (st.nextToken() == StreamTokenizer.TT_EOF) eof_error();
			int A = (int) st.nval;
			if (st.nextToken() == StreamTokenizer.TT_EOF) eof_error();
			int B = (int) st.nval;

			for (int i = A; i < B; ++i) {

				String curNumberString = String.valueOf(i);

				for(int j = 1; j < curNumberString.length(); ++j) {

					String sub1 = curNumberString.substring(j);
					String sub2 = curNumberString.substring(0, j);

					String test = sub1 + sub2;


					if (Integer.valueOf(test) > i &&
							Integer.valueOf(test) <= B) {

						if (! partners.contains(Integer.valueOf(test))) {
							++numDistinctPairs;
							partners.add(Integer.valueOf(test));
						}

					}

				}

				partners.clear();
			}
			out.write("Case #" + (t+1) + ": " + numDistinctPairs + "\n");
			numDistinctPairs = 0;
		}

		out.close();
	}

	private static void eof_error() {
		throw new RuntimeException("Unexpected end of file reached");
	}
}
