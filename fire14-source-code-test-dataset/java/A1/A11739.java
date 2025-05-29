
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
	public static List<String> readFile(String fileName) {
		List<String> list = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader in = new BufferedReader(fr);
			
			String s; 
			while ( (s=in.readLine()) != null ) {
				list.add(s);
			}
			
			in.close();
			fr.close();
			
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("ERROR");
		}
		
		return list; 
	}
	
	public static void writeFile(String fileName, List<String> contents) {
		try {
			FileWriter fw = new FileWriter(fileName, false); // overwrite
			BufferedWriter out = new BufferedWriter(fw);

			for (String s : contents) {
				out.write(s);
				out.write("\r\n");
			}

			out.close();
			fw.close(); 

			
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("ERROR");
		}

	}
}
