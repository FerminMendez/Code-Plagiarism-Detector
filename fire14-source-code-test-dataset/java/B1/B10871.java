package GoogleCodeJam.ed2012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class QualificationC2012 {

	private String inputFile;
	private String outputFile;

	private BufferedReader reader = null;
	private BufferedWriter writer = null;
	
	private int[] foundValues = new int[6];
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		QualificationC2012 qualificationC2012 = new QualificationC2012("QualificationC2012.in", "QualificationC2012.out");
		qualificationC2012.run();
	}

	private void run() throws Exception {
		openFiles();
		solve();
		closeFiles();
	}

	private void solve() throws Exception {
		long startTime = System.currentTimeMillis();
		int n = Integer.valueOf(reader.readLine());
		for (int i = 1; i<=n; i++) {
			writer.write("Case #"+i+": ");
			String[] line = reader.readLine().split(" ");
			int a = Integer.valueOf(line[0]);
			int b = Integer.valueOf(line[1]);
			int sum = 0;
			for (int j=a; j<b; j++) {
				sum+=getValidPairs(j,b);
			}
			writer.write(sum+"\n");
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Solve time = "+(endTime-startTime));
	}
	

	private int getValidPairs(int j, int b) {
		int decomposed = j;
		int validPairs = 0;
		StringBuilder transformedString = new StringBuilder();
		transformedString.append(j);
		int lastPosition = transformedString.length()-1;
		
		do {
			char c = transformedString.charAt(lastPosition);
			transformedString.deleteCharAt(lastPosition);
			transformedString.insert(0, c);
			decomposed /=10;
			int transformed = Integer.valueOf(transformedString.toString());
			if ((j<transformed) && (transformed<=b) && (!found(transformed,validPairs))) {
				foundValues[validPairs] = transformed;
				validPairs++;
			}
		}
		while (decomposed>9);
		return validPairs;
	}

	private boolean found(int n, int total) {
		for (int i=0; i<total; i++) {
			if (foundValues[i] == n) {
				return true;
			}
		}
		return false;
	}
	
	public QualificationC2012(String inputFile, String outputFile) {
		this.inputFile = inputFile;
		this.outputFile = outputFile;
	}
	
	private void closeFiles() {
		try {
			reader.close();
			writer.close();
		}
		catch (Exception e) {
			throw new RuntimeException();
		}

	}
	
	private void openFiles() {
		try {
			reader = new BufferedReader(new FileReader(inputFile));
			writer = new BufferedWriter(new FileWriter(outputFile));
		}
		catch (Exception e) {
			throw new RuntimeException("File initialization failed");
		}
	}
}
