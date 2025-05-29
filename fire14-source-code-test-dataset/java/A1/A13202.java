import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class DancingGooglers {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DancingGooglers test = new DancingGooglers();
		test.botInit("B-small-attempt0.in", "B-small.txt");
		//test.ropeInit("Rope-small.in", "Rope-small.txt");
	}
	
	public void botInit(String inputFile, String outputFile){
		
		BufferedReader input;
		List<Integer> result = new Vector<Integer>();
		
		try {
		
			input = new BufferedReader(new FileReader(inputFile));
			
			int cases = Integer.parseInt(input.readLine());
			
			for (int i = 0; i < cases; i++){
				
				result.add(caseSolver(input));
			}
			
			printResult(result, outputFile);
			
		} catch (FileNotFoundException fnte) {
			
			System.out.println("File " + inputFile + " not found");
			
		} catch (IOException ioe) {
			
			System.out.println("Error reading file");
		}
	}
	
	public int caseSolver(BufferedReader input) throws IOException{
		
		String line = input.readLine();
		String data[] = line.split(" ");
		int googlers = Integer.parseInt(data [0]);
		int surprises = Integer.parseInt(data[1]);
		int score = Integer.parseInt(data[2]);
		int result = 0;
		
		int surpriseScore1 = (score - 1) * 3;
		int surpriseScore2 = ((score - 1) * 3) - 1;
		//Set chick data positions
		for (int i = 3; i < data.length; i++){
			
			int currentScore = Integer.parseInt(data[i]);
			
			if (currentScore == 0 && score > 0){
				
				continue;
			}
			
			if (currentScore > surpriseScore1){
				
				result++;
				
			} else if ((currentScore == surpriseScore1 || currentScore == surpriseScore2) && surprises > 0){
				
				result++;
				surprises--;
			}
		}
		
		return result;
	}
	
	
	public void printResult(List<Integer> results, String outputFile) throws IOException{
		PrintWriter printer = new PrintWriter(new File(outputFile));
		
		for (int i = 0; i < results.size(); i++){
			
			int state = results.get(i);
			
			printer.println("Case #" + (i + 1) + ": " + state);
			printer.flush();
		}
	}
}
