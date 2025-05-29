

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class TestCase {
	
	public abstract void readInput(BufferedReader in) throws IOException, MalformedInputFileException;
	
	public abstract void solve();
	
	public abstract void writeOutput(PrintWriter out);
	
}