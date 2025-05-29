import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class CodeJamTextOutputWriter {
	private final BufferedWriter writer;
	
	CodeJamTextOutputWriter(File outputFile) throws IOException {
		writer = new BufferedWriter(new FileWriter(outputFile));
	}
	
	public void outputTestCase(int num, String out) throws IOException {
		writer.append("Case #");
		writer.append(Integer.toString(num));
		writer.append(": ");
		writer.append(out);
		writer.newLine();
	}
	
	public void close() throws IOException {
		writer.close();
	}
}
