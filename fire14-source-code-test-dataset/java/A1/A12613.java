import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public abstract class FileReaderWriter {
	FileInputStream in;
	FileWriter out;
	BufferedReader br;
	BufferedWriter bw;
	String strLine;
	String outPath;
	
	int nTestCases;
	
	FileReaderWriter(String inPath, String outPath) throws FileNotFoundException {
		in  = new FileInputStream(inPath);
		br = new BufferedReader(new InputStreamReader(in));
		this.outPath = outPath;
	}
	
	public void reader() throws IOException {
		
	}
	
	public void writer() throws IOException {
		//String test = ClassLoader.getSystemResource(".").getPath();
		out = new FileWriter(this.outPath);
		bw = new BufferedWriter(out);		
	}	

}