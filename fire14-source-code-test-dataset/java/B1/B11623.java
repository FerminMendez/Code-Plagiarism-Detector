import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class WriteFile {

	public static void write(String path, String content) throws IOException {
		//BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\test\\output.txt",false));
		BufferedWriter bw = new BufferedWriter(new FileWriter(path,false));
		bw.write(content);
		bw.flush();
		bw.close();
	}	
	
}
