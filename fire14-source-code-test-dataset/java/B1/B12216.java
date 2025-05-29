package hk.polyu.cslhu.codejam;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import hk.polyu.cslhu.codejam.lib.FileStream;
import hk.polyu.cslhu.codejam.lib.ResultCollector;
import hk.polyu.cslhu.codejam.solution.Solution;
import hk.polyu.cslhu.codejam.solution.impl.StoreCredit;
import hk.polyu.cslhu.codejam.solution.impl.qualificationround.DancingWithTheGooglers;
import hk.polyu.cslhu.codejam.solution.impl.qualificationround.RecycledNumbers;
import hk.polyu.cslhu.codejam.solution.impl.qualificationround.SpeakingInTongues;
import hk.polyu.cslhu.codejam.thread.JamThreadManager;

/**
 * Hello world!
 *
 */
public class App 
{
	public static Logger logger = Logger.getLogger(App.class);
	
	public List<List<String>> getTestCaseList(String filePath) {
		List<List<String>> testCaseList = new ArrayList<List<String>>();
		List<String> content = FileStream.read(filePath);
		logger.info("The amount of lines: " + content.size());
		logger.info("The amount of test cases: " + content.get(0));
		
		for (int i = 1; i < content.size(); i++)
			testCaseList.add(content.subList(i, i + 1));
		
		return testCaseList;
	}
	
    public static void main( String[] args )
    {
    	String filePath = "C:\\Users\\Allen HU\\Dropbox\\Misc\\C-small-attempt1.in";
    	String resultFile = filePath + ".result";
    	String resultPattern = "Case #" + ResultCollector.IndexPartInRow + ": " + ResultCollector.ResultPartInRow + "\n";
    	boolean allowMultiThreads = false;
    	
    	List<List<String>> testCaseList = new App().getTestCaseList(filePath);
    	
    	Solution solution = new RecycledNumbers();
    	
        JamThreadManager jtm = new JamThreadManager(solution, testCaseList, resultFile, resultPattern, allowMultiThreads);
        try {
			jtm.runThreads();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
