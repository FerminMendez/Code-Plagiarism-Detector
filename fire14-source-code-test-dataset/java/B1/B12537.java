import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CodeJam {

//	public static final String INPUT_FILE_PATH = "D://CodeJamInput.txt";
	public static final String INPUT_FILE_PATH = "D://C-small-attempt0.in";
	public static final String OUTPUT_FILE_PATH = "D://CodeJamOutput.txt";

	public static List<String> readInput() {
		List<String> list = new ArrayList<String>();
		try {
			BufferedReader input = new BufferedReader(new FileReader(
					INPUT_FILE_PATH));
			try {
				String line = null;

				while ((line = input.readLine()) != null) {
					list.add(line);
				}
			} finally {
				input.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return list;
	}

	public static void writeOutput(List<String> output) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileWriter(OUTPUT_FILE_PATH));
			for (String line : output) {
				writer.println(line);
			}
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null)
				writer.close();
		}
	}
	
	public static void main(String[] args) {
		List<RecycledNumbers> recycledNumbers = RecycledNumbers.parseFromFile(CodeJam.readInput());
		List<String> output = new ArrayList<String>();

		for(int i = 0; i < recycledNumbers.size(); i++) {
			System.out.println(recycledNumbers.get(i));
			String line = "";
			line += "Case #" + (i + 1) + ": " + recycledNumbers.get(i).calculate();
			output.add(line);
		}
		
		CodeJam.writeOutput(output);
	}
}

