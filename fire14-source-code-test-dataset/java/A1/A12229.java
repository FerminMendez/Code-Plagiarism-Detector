import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;


public class Outputter {

	public static void output(long[] results) throws IOException {
		Writer out = new BufferedWriter(new FileWriter("output.txt"));
		
		for (int i = 1; i < results.length; i++) {
			out.write("Case #" + i + ": " + results[i - 1] + '\n');			
		}
		
		out.write("Case #" + results.length + ": " + results[results.length - 1]);	
		
		out.close();
	}
}
