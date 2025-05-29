package hk.polyu.cslhu.codejam.lib;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class ResultCollector {
	public static Logger logger = Logger.getLogger(ResultCollector.class);
	public static String IndexPartInRow = "%i";
	public static String ResultPartInRow = "%r";
	
	private Map<Integer, List<String>> resultMap;
	private String resultFile, resultPattern;
	private int amountOfTestCases, numOfProcessedTestCases;
	
	/**
	 * Constructs a instance of result collector
	 * 
	 * @param amountOfTestCases int The amount of test cases
	 * @param resultFile String The location of result file
	 */
	public ResultCollector(int amountOfTestCases, String resultFile, String resultPattern) {
		this.resultMap = new HashMap<Integer, List<String>> ();
		this.resultFile = resultFile;
		this.resultPattern = resultPattern;
		this.amountOfTestCases = amountOfTestCases;
		this.numOfProcessedTestCases = 0;
	}
	
	/**
	 * update the result stored in the object
	 * 
	 * @param partIndex int The part index of result
	 * @param partOfResult List<String> The part of result
	 */
	public synchronized void updateResult(int partIndex, List<String> partOfResult) {
		// add the part of result
		if (this.resultMap.containsKey(partIndex)) {
			logger.error("Failure to add the part of result with part index " + partIndex);
		} else {
			this.resultMap.put(partIndex, partOfResult);
			this.numOfProcessedTestCases += partOfResult.size();
			
			logger.info("The #" + partIndex + " is completed!");
		}
		
		// trigger the save method when all test cases are processed
		if (this.numOfProcessedTestCases == this.amountOfTestCases)
			this.save();
		else if (this.numOfProcessedTestCases > this.amountOfTestCases)
			logger.error(
					"The number of processed test cases is more than the amount of test cases (" 
					+ this.numOfProcessedTestCases + " > " 
					+ this.amountOfTestCases + ")");
	} 
	
	/**
	 * Save the result in the given file
	 * 
	 * @param filePath String The location of file to be saved
	 */
	private void save() {
		// constructs the content
		String content = this.constructTheContent();
		FileStream.save(this.resultFile, content);
		
		logger.info("The result of all test cases is saved with the path " + this.resultFile);
	}
	
	/**
	 * Construct the content to be saved
	 * 
	 * @return String The content of file
	 */
	private String constructTheContent() {
		// TODO Auto-generated method stub
		String content = "";
		int rowIndex = 1;
		
		// sort the key of result map
		List<Integer> keySet = new LinkedList<Integer>(this.resultMap.keySet());
		Collections.sort(keySet);
		
		
		for (Integer key : keySet) {
			List<String> resultList = this.resultMap.get(key);
			
			for (String result : resultList) {
				String rowContent = this.resultPattern.replaceAll(IndexPartInRow, String.valueOf(rowIndex)).replaceAll(ResultPartInRow, result);
				content += rowContent;
				rowIndex++;
			}
		}
		
		return content;
	}
}
