package qualif.problem2;

import qualif.problem1.ReadWrite;

public class Main2 {
	
	private static String pathToFile = "src/qualif/problem2/";
	private static String fileName = "B-small";
	private static String outputName = "output";
	private static String filePath  = pathToFile + fileName + ".txt";
	private static String outputPath  = pathToFile + outputName + ".txt";
	
	public static void main(String[] arg){
		ReadWrite reader = new ReadWrite();
		DancingWithTheGooglers dancingWithTheGooglers = new DancingWithTheGooglers(reader.read(filePath));
		String[] outputs = dancingWithTheGooglers.process();
		reader.write(outputPath, outputs);
	}
	
	
}
