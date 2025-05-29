package fixjava;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class IOUtils {

	public static void writeLinesToFile(List<String> lineList, File outputFile) {
		try {
			PrintWriter writer = new PrintWriter(outputFile);
			for (String line : lineList)
				writer.println(line);
			writer.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static void writeLinesToFile(List<String> lineList, String outputFilename) {
		writeLinesToFile(lineList, new File(outputFilename));
	}

	// ---------------------------------------------------------------------------------------------------------

	public static ArrayList<String> readLinesFromFile(File inputFile) {
		ArrayList<String> lines = new ArrayList<>();
		for (String line : new FileLineIterator(inputFile))
			lines.add(line);
		return lines;
	}

	public static ArrayList<String> readLinesFromFile(String inputFilename) {
		return readLinesFromFile(new File(inputFilename));
	}

	// ---------------------------------------------------------------------------------------------------------

	public static String readFileAsString(File inputFile) {
		int len = (int) inputFile.length() + 1;
		StringBuilder buf = new StringBuilder(len);
		for (String line : new FileLineIterator(inputFile)) {
			buf.append(line);
			buf.append('\n');
		}
		return buf.toString();
	}

	public static String readFileAsString(String inputFilename) {
		return readFileAsString(new File(inputFilename));
	}
}
