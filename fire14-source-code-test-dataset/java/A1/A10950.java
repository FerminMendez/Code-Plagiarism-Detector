import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class Writer {
	private String fileName;
	private BufferedWriter writer;
	private int i = 1;
	
	public Writer(String fileName){
		this.fileName = fileName;
	}
	
	public void open() throws Exception{
		writer = new BufferedWriter(new FileWriter(new File(fileName)));
	}
	
	public void close() throws Exception{
		writer.close();
	}
	
	public void write(String erg) throws Exception{
		writer.write("Case #" + i +": " + erg + "\n");
		i++;
	}
}
