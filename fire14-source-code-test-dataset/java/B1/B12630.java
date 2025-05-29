

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class UtilGoogle {

	public static Scanner readFile(String path) throws FileNotFoundException{
		File in = new File(path);
		Scanner s = new Scanner(in);
		return s;
	}
	
	public static PrintWriter writeFile(String path) throws IOException{
		File out = new File(path);
		FileWriter w = new FileWriter(out);
		return new PrintWriter(w);
	}
}
