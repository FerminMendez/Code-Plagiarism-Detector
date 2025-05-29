package bsevero.codejam.qualification;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		String inputPath = args[0];
		String outputPath = args[1];
		
		List<String> inputLines = IOUtils.readFile(inputPath);
		inputLines.remove(0);
		
		Map<Integer, String> casesResult = new HashMap<Integer, String>();
		
		int caseNum = 1;
		for(String text: inputLines) {
			String[] minMax = text.split(" ");
			int result = RecycledNumbers.recycle(minMax[0], minMax[1]);
			casesResult.put(caseNum, String.valueOf(result));
			caseNum++;
		}
		
		IOUtils.writeFile(outputPath, casesResult);
	}

}
