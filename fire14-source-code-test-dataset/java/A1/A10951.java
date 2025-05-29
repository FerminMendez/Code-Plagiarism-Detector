import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class Reader {
	private String fileName;
	private BufferedReader reader;
	
	public Reader(String fileName){
		this.fileName= fileName;
	}
	
	public void open() throws Exception{
		reader = new BufferedReader(new FileReader(new File(fileName)));
		reader.readLine();
	}
	
	public void close() throws Exception{
		reader.close();
	}
	
	public String getNext() throws Exception{
		String line = reader.readLine();
		return line;
	}
}
