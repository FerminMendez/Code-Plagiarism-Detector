
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;

public class Processor {

	public void process(TestCaseFactory factory, String filenameIn,
			String filenameOut) throws IOException, MalformedInputFileException {
		System.out.println("Started!");

		final Reader in = new FileReader(filenameIn);
		final BufferedReader br = new BufferedReader(in);

		final PrintWriter out = new PrintWriter(new File(filenameOut));

		final String str1 = br.readLine();
		final int ncases = Integer.parseInt(str1);

		for (int i = 0; i < ncases; i++) {
			final TestCase item = factory.getInstance(i);
			item.readInput(br);
			item.solve();
			item.writeOutput(out);
		}

		in.close();
		out.close();

		System.out.println("Finished!");
	}
}