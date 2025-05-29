package google.codejam.commons;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Utils {

	public static String[] readFromFile(String fileName) throws IOException {
		String[] lines = null;
		FileInputStream fstream = new FileInputStream(fileName);
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine = br.readLine();
		lines = new String[Integer.valueOf(strLine)];
		int i = 0;
		while ((strLine = br.readLine()) != null) {
			lines[i++] = strLine;
		}
		in.close();
		return lines;
	}

	public static void writeToFile(String[] lines, String fileName)
			throws IOException {
		FileWriter outFile = new FileWriter(fileName);
		PrintWriter out = new PrintWriter(outFile);
		for (String line : lines) {
			out.println(line);
		}
		out.close();
	}
}
