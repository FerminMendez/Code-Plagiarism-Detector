package teardrop.jam2012.qr.dancing;

import java.io.*;

public class Launcher {
	public static void main(String[] args) {
		if (args.length < 2) {
			System.err.println("Enter input and output filenames");
			System.exit(1);
		}

		try (
                Reader reader = new InputStreamReader(new FileInputStream(args[0]), "UTF-8");
                Writer writer = new OutputStreamWriter(new FileOutputStream(args[1]), "UTF-8")) {
			SetSolver solver = new SetSolver(reader, writer);
			solver.solve();
		} catch (UnsupportedEncodingException e) {
			System.err.println("Unsupported encoding: "+ e.getMessage());
		} catch (FileNotFoundException e) {
			System.err.println("Unable to open file: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("IO error: " + e.getMessage());
        }
	}
}
