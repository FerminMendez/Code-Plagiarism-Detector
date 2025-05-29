package dancingwiththegooglers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;


public class Input {
	static String path = "B-small-attempt0.in";
	
	public String getPath() {
		return path;
	}
		public Input(String path){
		this.path = path;
	}
	public static void main(String[] str) {
		try {
			// Open the file that is the first
			// command line parameter
			FileInputStream fstream = new FileInputStream(path);
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			// Read File Line By Line
			int lineNumber = 0;
			String strTestCase = "";
			List<String> lstpattern = null;
			Writer output = null;
			  
			  File file = new File("out.txt");
			  output = new BufferedWriter(new FileWriter(file));
			while ((strLine = br.readLine()) != null) {
				// Print the content on the console
				lineNumber++;
				if(lineNumber == 1){continue;}
				
				output.write("Case #" +(lineNumber-1)+ ": " + setValues(strLine) + "\n");
			}
			output.close();
			// Close the input stream
			in.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}

	}
	private static int setValues(String strLine) {
		int numberofPlayers = 0;
		int bestScore = 0;
		int surpriseScores = 0;
		List<Integer> scores = new ArrayList<Integer>();
		String[] arr = strLine.split(" ");
		for(int i = 0; i < arr.length; i++){
			switch (i) {
			case 0:
				numberofPlayers = Integer.parseInt(arr[i]);
				break;
			case 1:
				surpriseScores = Integer.parseInt(arr[i]);
				break;
			case 2:
				bestScore = Integer.parseInt(arr[i]);
				break;
			default:
				scores.add(Integer.parseInt(arr[i]));
				break;
			}			
		}
		TestCase tc = new TestCase(numberofPlayers, surpriseScores, bestScore, scores);
		return tc.execute();
	}

}
