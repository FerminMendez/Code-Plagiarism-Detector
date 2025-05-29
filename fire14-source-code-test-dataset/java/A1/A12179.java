package hk.polyu.cslhu.codejam.thread;

import hk.polyu.cslhu.codejam.lib.ResultCollector;
import hk.polyu.cslhu.codejam.solution.Solution;
import hk.polyu.cslhu.codejam.solution.impl.StoreCredit;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

public class JamThreadManager {
	public static Logger logger = Logger.getLogger(JamThreadManager.class);
	
	private final ExecutorService pool;
	private Solution solutionPrototype;
	private List<List<String>> testCaseList;
	private boolean allowMultiThreads;
	private int numOfThreads;
	private ResultCollector resultCollector;
	
	/**
	 * Constructs an instance of JamThreadManager
	 * 
	 * @param solutionPrototype Solution The prototype of solution
	 * @param testCaseList List<List<String>> The data of test cases
	 * @param resultFile String The location of result file
	 * @param allowMultiThreads boolean The multi-threads mode is enabled if true; otherwise single thread is used
	 */
	public JamThreadManager(
			Solution solutionPrototype, List<List<String>> testCaseList, String resultFile, String resultPattern, boolean allowMultiThreads) {
		this.pool = Executors.newCachedThreadPool();
		this.solutionPrototype = solutionPrototype;
		this.testCaseList = testCaseList;
		this.allowMultiThreads = allowMultiThreads;
		this.numOfThreads = this.allowMultiThreads ? Runtime.getRuntime().availableProcessors() : 1;
		this.resultCollector = new ResultCollector(testCaseList.size(), resultFile, resultPattern);
	}
	
	/**
	 * Initialize the threads to set off
	 * @throws CloneNotSupportedException 
	 */
	public void runThreads() throws CloneNotSupportedException {
		List<List<List<String>>> subTasks = this.divideTestCases();
		int testCaseIndex = 1;
		
		for (List<List<String>> subTask : subTasks) {
			JamThread jamThread = this.createJamThread();
			jamThread.setSolution(this.solutionPrototype.clone());
			jamThread.setIndexOfList(testCaseIndex);
			jamThread.setTestCaseList(subTask);
			jamThread.setResultCollector(this.resultCollector);
			
			// update testCaseIndex
			testCaseIndex++;
			
			// run the thread
			this.pool.execute(jamThread);
		}
	}
	
	/**
	 * Divide the test cases into numOfThreads pieces
	 * 
	 * @return List<List<List<String>>> The subtasks
	 */
	private List<List<List<String>>> divideTestCases() {
		// TODO Auto-generated method stub
		List<List<List<String>>> subTasks = new ArrayList<List<List<String>>>();
		
		// set the number of test cases per subtask
		int numOfTestCasesPerSubtask = this.testCaseList.size();
		
		if (this.allowMultiThreads) {
			if (this.testCaseList.size() < this.numOfThreads)
				numOfTestCasesPerSubtask = 1;
			else
				numOfTestCasesPerSubtask = (int) Math.floor(this.testCaseList.size() / this.numOfThreads); 
		}
			
		// dive the test case list
		for (int i = 0; i < Math.min(this.testCaseList.size(), this.numOfThreads); i++) {
			int fromIndex = i * numOfTestCasesPerSubtask;
			int toIndex = (i == this.numOfThreads - 1) ? this.testCaseList.size() : (i + 1) * numOfTestCasesPerSubtask;
			subTasks.add(this.testCaseList.subList(fromIndex, toIndex));
		}
		
		return subTasks;
	}

	// Factory method of creating jam thread
	private JamThread createJamThread() {
		// TODO Auto-generated method stub
		return new JamThread() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				List<String> result = new ArrayList<String>();
				
				for (List<String> testCase : this.getTestCaseList()) {
					this.getSolution().setProblem(testCase);
					this.getSolution().solve();
					result.add(this.getSolution().getResult());
				}
				
				this.getResultCollector().updateResult(this.getIndexOfList(), result);
			}
		};		
	}
}
