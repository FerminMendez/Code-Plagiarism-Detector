package teardrop.jam2012.qr.dancing;

import java.io.*;

public class SetSolver {
	private final Reader reader;
	private final Writer writer;

	public SetSolver(Reader reader, Writer writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public void solve() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(reader)) {
            CaseSolver caseSolver = new CaseSolver(bufferedReader, writer);
            int caseCount = Integer.valueOf(bufferedReader.readLine());
            for (int i = 1; i <= caseCount; ++i) {
                writer.write(String.format("Case #%d: ", i));
                caseSolver.solve();
                writer.write('\n');
            }
        }
    }
}
