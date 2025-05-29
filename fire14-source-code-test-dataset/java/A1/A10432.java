package Parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class MyReader {
	public String[] taskArray;
	public int currentString;

	public MyReader(String fileName) {
		// TODO Auto-generated constructor stub
		String taskString = readString(fileName);
		if (taskString.indexOf('\r') == -1) {
			taskArray = taskString.split("\n");
		} else {
			taskArray = taskString.split("\r\n");
		}
		currentString = 0;
	}

	public String readString(String fileName) {

		StringBuffer buffer = new StringBuffer();
		try {
			File file = new File(fileName);
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			Reader in = new BufferedReader(isr);
			int ch;
			while ((ch = in.read()) > -1) {
				buffer.append((char) ch);
			}
			in.close();
			return buffer.toString();
		} catch (IOException e) {
			return "";
		}
	}

	public String read() {
		return taskArray[currentString++];
	}
}
