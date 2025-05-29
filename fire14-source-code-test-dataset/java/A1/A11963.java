import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class Try2 {

	/**
	 * @param args
	 */
	static BufferedWriter out;
	static String inputFile = "input";
	static String outputFile = "out.txt";
	
	public static void main(String[] args) {
		File file = new File(inputFile);
		if (file.exists()) {
			try {
				BufferedReader inFile = new BufferedReader(new FileReader(file));
				FileWriter fstream = new FileWriter (outputFile);
				out = new BufferedWriter (fstream);
				String sLine = null;
				int counter = 0;
				while ((sLine=inFile.readLine())!=null) {
					if (counter > 0) {
						out.write("Case #" + counter + ": ");
							
						handleIt(sLine);
					}
					counter++;
				}
				out.close();
			} catch (Exception e) {System.err.println(e);}
			
			
		}

	}
	private static void handleIt(String sLine) throws Exception{
		String [] array;
		array = sLine.split(" ");
		int numGooglers = Integer.parseInt(array[0]);
		int numSurprises = Integer.parseInt(array[1]);
		int N = Integer.parseInt(array[2]);
		int result = 0;
		for (int i=0; i<numGooglers; i++) {
			
			int currentNum = Integer.parseInt(array[i+3]);
			if (currentNum == 1) {
				if (N > 1)
					continue;
				result++;
			}
			else if (currentNum == 0) {
				if (N > 0)
					continue;
				result++;
			}
			else if (currentNum >= 3*N-2)
				result++;
			else if (currentNum == 3*N-3 || currentNum == 3*N-4) {
				if (numSurprises > 0) {
					numSurprises--;
					result++;
				}
				
			}
			
		}
		out.write(result+'0');
		
		out.newLine();
	}

}
