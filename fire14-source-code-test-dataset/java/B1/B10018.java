import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class OutputWriter {
private BufferedWriter bw = null;
private long counter = 1;

	public OutputWriter(String fileName) {
		try {
			bw = new BufferedWriter(new FileWriter(new File(fileName)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeCaseLine(String output) {
		try {
			bw.write("Case #" + counter + ": " + output+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		counter++;
	}

	public void flushAndClose() {
		try {
			bw.flush();

			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
