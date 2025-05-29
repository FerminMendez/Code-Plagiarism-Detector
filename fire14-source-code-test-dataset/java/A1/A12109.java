package qualif.problem2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadWrite {

	public Scanner read(String pathname){
		Scanner scanner = null;
		File data = new File(pathname);
		try{
			scanner = new Scanner(new FileReader(data));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 	
		return scanner;
	}

	public void write(String pathname, String[] contents){
		File file = new File(pathname);
		try {
			file.createNewFile();
			BufferedWriter output = new BufferedWriter(new FileWriter(file));
			try{
				for(int i = 0 ; i < contents.length; i++){
					if(i>0){
						output.newLine();
					}
					String content = "Case #"+(i+1)+": "+contents[i];
					output.write( content );
					System.out.println(content);
				}
			} finally{
				output.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
