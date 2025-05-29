import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
/**
 * Base class to provide a framework for Google Code Jam type of problems and avoid redundant tasks 
 * @author nitin
 */
public class BaseSolution {
         
	/**
	 * Used to write log for debugging
	 */
	PrintWriter logger;
	/**
	 * to print solution to output.txt
	 */
	PrintWriter output;
	/**
	 * used to read the problem file
	 */
	BufferedReader br;
	boolean logToConsole = false;
	public void setLogToConsole(boolean flag){
		logToConsole = flag;
	}
	public void start(String probPath) throws Exception {
	        logger = new PrintWriter(new FileWriter("debug.txt"));
		output = new PrintWriter(new FileWriter("output.txt"));
                br =  new BufferedReader(new FileReader(probPath));
		init();
		closeAll();
	}
	public void logTo(PrintWriter pw){
		logger = pw;
	}
	public void init() throws Exception{
		int num_test_cases = readInt();
		log("Total test cases : "+num_test_cases);
		for(int i=0;i<num_test_cases;i++)
		{
			solveTestCase(i,num_test_cases);
		}
	}
	public void solveTestCase(int index,int total_test_cases) throws Exception{
		solveTestCase(index);
	}
	public String solveTestCase() throws Exception{
              return "Solve method not implemented";
	}
	public void solveTestCase(int index) throws Exception{
	       printSol(index,solveTestCase());
	}
	public String readLine() throws Exception{
		return br.readLine();
	}
	public int readInt() throws Exception{
		return Integer.parseInt(readLine());
	}
	public void finalize() throws Exception{
		if(logger!=null){
			logger.close();
		}
		if(output!=null){
			output.close();
		}
		if(br!=null){
			br.close();
		}
	}
	public void closeAll() throws Exception{
		try{
		if(logger!=null){
		logger.close();
		logger = null;
		}
		}catch(Exception e){
			System.out.println("Exception "+e);
		}
		finally{
		if(output!=null){
		output.close();
		output = null;
		if(br!=null)
		{
			br.close();
		}
		}
		}
	}
	public void printSol(int i,String str){
		printSol("Case #"+(i+1)+": "+str);
	}
	public void printSol(String str){
		output.println(str);
	}
	public void log(String str){
                if(1==1) return;
		if(logToConsole==false){
			logger.println(str);
		} else {
			System.out.println(str);
		}
	}
       
	
}
