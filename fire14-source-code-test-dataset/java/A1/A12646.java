package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public abstract class Runner {

	public void run(String[] args) throws Exception {
		String inputFileName = args[0];
		String outputFileName = args[1];
		BufferedReader br = new BufferedReader(new FileReader(inputFileName));
		BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName));
		int noOfCases = Integer.parseInt(br.readLine());
		for (int i = 1;i <= noOfCases; i++) {
			String caseResult = dealWithCase(br.readLine());
			bw.append("Case #"+i+": " + caseResult + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
	
	public abstract String dealWithCase(String line);
	
	
}
