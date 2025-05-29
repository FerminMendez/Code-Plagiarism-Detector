package qualif.problem3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LaunchProblemC {
	
	private static String pathToFile = "src/qualif/problem3/";
	private static String fileName = "C-small";
	private static String outputName = "output";
	private static String filePath  = pathToFile + fileName + ".txt";
	private static String outputPath  = pathToFile + outputName + ".txt";
	
	public static void main(String[] arg){
		ProblemClass dancingWithTheGooglers = new RecycledNumbers(read(filePath));
		String[] outputs = dancingWithTheGooglers.process();
		write(outputPath, outputs);
	}
	
	private static Scanner read(String pathname){
		Scanner scanner = null;
		File data = new File(pathname);
		try{
			scanner = new Scanner(new FileReader(data));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 	
		return scanner;
	}

	private static void write(String pathname, String[] contents){
		File file = new File(pathname);
		try {
			if(file.exists()){
				file.delete();
			}
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
