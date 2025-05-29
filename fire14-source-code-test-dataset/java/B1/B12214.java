package hk.polyu.cslhu.codejam.thread;

import hk.polyu.cslhu.codejam.lib.ResultCollector;
import hk.polyu.cslhu.codejam.solution.Solution;

import java.util.List;

import org.apache.log4j.Logger;

public abstract class JamThread implements Runnable {
	public static Logger logger = Logger.getLogger(JamThread.class);

	private ResultCollector resultCollector;
	private int indexOfList;
	private List<List<String>> testCaseList;
	private Solution solution;
	
	/**
	 * Return the solution
	 * 
	 * @return Solution
	 */
	public Solution getSolution() {
		return solution;
	}

	/**
	 * Set the solution used for test cases
	 * 
	 * @param solution Solution
	 */
	public void setSolution(Solution solution) {
		this.solution = solution;
	}

	/**
	 * Return the result collector
	 * 
	 * @return ResultCollector
	 */
	public ResultCollector getResultCollector() {
		return resultCollector;
	}

	/**
	 * Set the result collector
	 * 
	 * @param resultCollector ResultCollector
	 */
	public void setResultCollector(ResultCollector resultCollector) {
		this.resultCollector = resultCollector;
	}
	
	/**
	 * Return the index of list
	 *  
	 * @return int The index of list
	 */
	public int getIndexOfList() {
		return indexOfList;
	}

	/**
	 * Set the index of list
	 * 
	 * @param indexOfList int The index of list
	 */
	public void setIndexOfList(int indexOfList) {
		this.indexOfList = indexOfList;
	}

	/**
	 * Set the list of test cases
	 * 
	 * @param testCaseList List<LIst<String>>
	 */
	public void setTestCaseList(List<List<String>> testCaseList) {
		this.testCaseList = testCaseList;
		logger.debug("Total " + testCaseList.size() + " test cases have been added");
	}
	
	/**
	 * Get the list of test cases
	 * 
	 * @return List<List<String>> The list of test cases
	 */
	public List<List<String>> getTestCaseList() {
		return this.testCaseList;
	}
	
	public abstract void run();
}
