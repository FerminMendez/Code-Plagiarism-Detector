import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;


public class QBGoogleDance {
	public static void solve(BufferedReader reader, BufferedWriter writer) throws IOException {
		int testCount = readIntFromLine(reader);
		
		for (int test = 1; test <= testCount; test++) {
			writer.append("Case #").append(Integer.toString(test)).append(": ");
			
			solveTestCase(reader, writer);
			
			writer.newLine();
		}
		writer.flush();
	}

	private static void solveTestCase(BufferedReader reader, BufferedWriter writer) throws IOException {
		String testCase = reader.readLine();
		StringTokenizer tokenizer = new StringTokenizer(testCase);
		
		int dancerCount = Integer.parseInt(tokenizer.nextToken());
		int surprisesCount = Integer.parseInt(tokenizer.nextToken());
		int bestScore = Integer.parseInt(tokenizer.nextToken());
		
		if (bestScore == 0) {
			writer.append(Integer.toString(dancerCount));
			return;
		}
		
		int maxBestDancers = 0;
		int definitelyBestScore = bestScore*3 - 2;
		int surprizinglyBest = bestScore*3 - 4;
		if (surprizinglyBest < bestScore) {
			surprizinglyBest = bestScore;
		}
		
		for (int i=0; i < dancerCount; i++) {
			int dancersScore = Integer.parseInt(tokenizer.nextToken());
			
			if (dancersScore >= definitelyBestScore) {
				maxBestDancers++;
				
			} else if (dancersScore >= surprizinglyBest && surprisesCount > 0) {
				maxBestDancers++;
				surprisesCount--;
			}
		}
		
		writer.append(Integer.toString(maxBestDancers));
	}
	
	public static void solve(String inputFile, String outputFile) throws IOException {
		File input = new File(inputFile);
		File output = new File(outputFile);
		
		if (!input.exists()) {
			throw new IllegalArgumentException("Input file doesn't exist: " + inputFile);
		}
		
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
			reader = new BufferedReader(new FileReader(input));
			writer = new BufferedWriter(new FileWriter(output));
			solve(reader, writer);
		
		} finally {
			if (reader != null)
				reader.close();
			if (writer != null)
				writer.close();
		}
	}
	
	public static int readIntFromLine(BufferedReader reader) throws IOException {
		String line = reader.readLine();
		int testCount = Integer.parseInt(line);
		return testCount;
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("Start...");
		solve("res/input.txt", "res/output.txt");
		System.out.println("Done!");
	}
}
