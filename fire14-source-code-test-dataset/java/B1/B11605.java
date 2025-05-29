package recyclednumbers;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Input {
	List<TestCase> cases = null;
	public List<TestCase> getCases() {
		return cases;
	}

	String path = "";
	public String getPath() {
		return path;
	}

	public Input(String path) {
		this.path = path;
	}

	public void setInputData() {
		try {
			// Open the file that is the first
			// command line parameter
			FileInputStream fstream = new FileInputStream(this.path);
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			// Read File Line By Line
			int lineNumber = 0;
			cases = new ArrayList<TestCase>();
			while ((strLine = br.readLine()) != null) {
				// Print the content on the console
				lineNumber++;
				if(lineNumber == 1){continue;}
				cases.add(new TestCase(Integer.parseInt(strLine.split(" ")[0]), Integer.parseInt(strLine.split(" ")[1])));				
			}
			// Close the input stream
			in.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}

	}
}
