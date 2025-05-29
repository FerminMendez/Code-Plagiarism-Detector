package problem2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Bsmall implements Runnable {

	private final static long UPDATE_INTERVAL_MILLIS = 3000;
	
	private static long startTime;
	private static long currTime;
	private static long endTime;
	private static int run = 0;
	private static int totalNumberOfRuns = 0; 
	
	private String fileName = "B-small-attempt0.in";
	
	private BufferedReader br;
	private PrintWriter pw;
	
	/**
	 * This method is called, when set-up is complete. 
	 */
	private void solve() {

		totalNumberOfRuns = Integer.parseInt(readLine());
		
		for (run = 0; run < totalNumberOfRuns; run++) {
			
			String[] ins = readLine().split(" ");
			int index = 0;
			
			int numberOfDancers = Integer.parseInt(ins[index++]);
			int surprisingResults = Integer.parseInt(ins[index++]);
			int minResult =  Integer.parseInt(ins[index++]);
			
			int dancersWithMinResult = 0;
			
			for (int i = 0; i < numberOfDancers; i++) {
				int scoreSum = Integer.parseInt(ins[index + i]);
				
				int singleScore = scoreSum / 3;
				int remainder = scoreSum % 3;
				int bestResult = 0;
				
				if (scoreSum > 0) {
					if (remainder == 1) {
						bestResult = singleScore + 1;
					} else if (remainder == 2) {
						bestResult = singleScore + 1;
						if (bestResult + 1 == minResult && surprisingResults > 0) {
							surprisingResults--;
							bestResult++;
						}
					} else if (remainder == 0) {
						bestResult = singleScore;
						if (bestResult + 1 == minResult && surprisingResults > 0) {
							surprisingResults--;
							bestResult++;
						}
						
					}
				}
				if (bestResult >= minResult) dancersWithMinResult++;
			}
			
			write(run+1, String.valueOf(dancersWithMinResult));
		}
	}
	
	// =====================================================================================
	// File Access
	// =====================================================================================
	
	private String readLine() {
		try {
			return br.readLine();
		} catch (IOException e) {
			throw new IllegalStateException();
		}
	}

	private void write(int caseNumber, String result) {
		pw.println("Case #"+caseNumber+": "+result);
	}
	
	private void loadFile(String fileName) {
		File inFile = new File(this.getClass().getResource(fileName).getFile());
		File outFile = new File(inFile.getAbsolutePath().substring(0, (int)(inFile.getAbsolutePath().length()-2L))+"out");
		outFile.delete();
		try {
			outFile.createNewFile();
			br = new BufferedReader(new InputStreamReader(new FileInputStream(inFile)));
			pw = new PrintWriter(new FileOutputStream(outFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// =====================================================================================
	// Initialisation / cleanup
	// =====================================================================================
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Running...");
		startTime = System.currentTimeMillis();
		
		Thread thread = new Thread(new Bsmall());
		thread.start();
		
		while (thread.isAlive()) {
			Thread.sleep(UPDATE_INTERVAL_MILLIS);
			updateTime();
		}
		
		endTime = System.currentTimeMillis();
		System.out.println("Finished after "+(endTime-startTime)+" ms");
	}
	
	private static void updateTime() {
		currTime = System.currentTimeMillis();
		float timePerRun;
		if (run > 0)
			timePerRun = (currTime-startTime) / run;
		else
			timePerRun = 0;
		float timeLeft = timePerRun * (totalNumberOfRuns - run);
		
		System.out.println("Runs passed: " + run);
		System.out.println("Estimated time left: "+timeLeft+" ms");
		
	}

	@Override
	public void run() {
		loadFile(fileName);
		solve();
		cleanUp();
	}
	
	private void cleanUp() {
		try {
			pw.flush();
			pw.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}