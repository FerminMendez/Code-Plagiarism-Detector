import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InputReader {
	private BufferedReader br = null;

	public InputReader(String fileName) {
		try {
			br = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> loadLines() {
		ArrayList<String> lines = new ArrayList<String>();
		String[] arrLines = null;
		String tmp = null;
		try {
			while ((tmp = br.readLine()) != null) {
				lines.add(tmp);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lines;
	}
}
