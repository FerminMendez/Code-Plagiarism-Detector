import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ReadFile {
	
	private static ArrayList<String> elements = new ArrayList<String>();

	public static void read(String path) throws IOException{
	    //BufferedReader br = new BufferedReader(new FileReader("C:\\test\\input.txt"));
		BufferedReader br = new BufferedReader(new FileReader(path));
	    String thisLine;
	    while ((thisLine = br.readLine()) != null) { // while loop begins here
	    	elements.add(thisLine);
	 	   
	    }
	    br.close();	
	}
	
	public static ArrayList<String> getElements() {
		return elements;
	}
}
