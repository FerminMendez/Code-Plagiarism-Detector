/**
 * 
 */
package br.com.softctrl.code.c;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * @author timoshenko
 * 
 */
public class CRecycledNumbers {

	private static int A = 0;
	private static int B = 0;
	private static int T = 4;
	private static int c = 0;

	private static String fileInput = "/Users/timoshenko/Development/Projects/SoftCtrl.com/eclipse-jboss/workspaces/google-code-jam/GoogleCodeJam2012/src/br/com/softctrl/in/C-small-attempt0.in";
	private static String fileOutput = "/Users/timoshenko/Development/Projects/SoftCtrl.com/eclipse-jboss/workspaces/google-code-jam/GoogleCodeJam2012/src/br/com/softctrl/out/C-small-attempt0_in.txt";
	private static SCFileReader scFr = null;
	private static SCFileWriter scFw = null;

	public static boolean valid(int n, int m) {
		// A ² n < m ² B
		// System.out.println(String.format("A(%d)<=n(%d)<m(%d)<=B(%d)", A, n,
		// m,
		// B));
		return (String.valueOf(n).length() == String.valueOf(m).length() ? (A <= n
				&& n < m && m <= B)
				: false);

	}

	public static void main(String[] args) {

		try {
			scFr = new SCFileReader(fileInput);
			scFw = new SCFileWriter(fileOutput);
			if (scFr.ready()) {
				T = Integer.parseInt(scFr.readLine());
				for (int z = 0; z < T; z++) {
					String[] row = scFr.readLine().split(" ");
					A = Integer.parseInt(row[0]);
					B = Integer.parseInt(row[1]);
					scFw.writeLn(String.format("Case #%d: %d", z + 1, count()));
				}
			}
			scFr.close();
			scFw.save();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static int count() {
		int count = 0;
		for (int i = A; i <= B; i++) {
			String n = String.valueOf(i);
			for (int length = n.length() - 1; (length >= 1); length--) {
				String m = n.substring(length, n.length())
						+ n.substring(0, length);
				if (valid(Integer.parseInt(n), Integer.parseInt(m))) {
					count++;
				}
			}
		}
		return count;
	}
}

class SCFileReader {
	private Reader reader = null;
	private BufferedReader bufferedReader = null;
	private File file = null;

	public SCFileReader(String fileName) throws FileNotFoundException {
		file = new File(fileName);
		reader = new FileReader(file);
		bufferedReader = new BufferedReader(reader);
	}

	public boolean ready() {
		try {
			return bufferedReader.ready();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public String readLine() throws IOException {
		return bufferedReader.readLine();
	}

	public void close() {
		if (this.ready()) {
			try {
				bufferedReader.close();
				reader.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
			bufferedReader = null;
			reader = null;
			file = null;
		}
	}

}

class SCFileWriter {
	private Writer writer = null;
	private BufferedWriter bufferedWriter = null;
	private File file = null;

	public SCFileWriter(String fileName) throws IOException {
		file = new File(fileName);
		if (file.exists()) {
			file.delete();
		}
		writer = new FileWriter(file);
		bufferedWriter = new BufferedWriter(writer);
	}

	public void write(String row) throws IOException {
		// System.out.println(row);
		bufferedWriter.write(row);
	}

	public void writeLn(String row) throws IOException {
		System.out.println(row);
		bufferedWriter.write(row + "\n");
	}

	public void save() {
		try {
			bufferedWriter.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		bufferedWriter = null;
		writer = null;
		file = null;

	}

}
