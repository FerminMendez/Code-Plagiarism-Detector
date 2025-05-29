package Controller;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IO {

	private String fileName;
	private BufferedReader reader;

	public IO(String fileName) {
		this.fileName = fileName;
		createReader();
	}

	public String readLine() {
		try {
			return reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int readInt() {
		try {
			return Integer.parseInt(reader.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}

	private void createReader() {
		FileReader file = null;
		try {
			file = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		reader = new BufferedReader(file);
	}
}
