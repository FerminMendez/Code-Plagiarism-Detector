package Parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class MyWriter {
	Writer out;

	public MyWriter(String fileName) {
		// TODO Auto-generated constructor stub
		try {
			File file = new File(fileName);
			FileOutputStream fos;
			fos = new FileOutputStream(file);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			out = new BufferedWriter(osw);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeString(String text) {
		try {
			out.write(text + '\n');
		} catch (IOException e) {
		}
	}
	
	public void close(){
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
