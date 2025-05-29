package mgg.main;

import mgg.problems.ProblemB;
import mgg.utils.FileUtil;


public class Main {

//	public final static String inFileName = ProblemA.EXAMPLE_IN;
//	public final static String outFileName = ProblemA.EXAMPLE_OUT;
//	public final static String inFileName = ProblemA.A_SMALL_IN;
//	public final static String outFileName = ProblemA.A_SMALL_OUT;
	
//	public final static String inFileName = ProblemB.EXAMPLE_IN;
//	public final static String outFileName = ProblemB.EXAMPLE_OUT;
	public final static String inFileName = ProblemB.B_SMALL_IN;
	public final static String outFileName = ProblemB.B_SMALL_OUT;
//	public final static String inFileName = ProblemB.B_LARGE_IN;
//	public final static String outFileName = ProblemB.B_LARGE_OUT;
	
//	public final static String inFileName = ProblemC.EXAMPLE_IN;
//	public final static String outFileName = ProblemC.EXAMPLE_OUT;
//	public final static String inFileName = ProblemC.C_SMALL_IN;
//	public final static String outFileName = ProblemC.C_SMALL_OUT;
//	public final static String inFileName = ProblemC.C_LARGE_IN;
//	public final static String outFileName = ProblemC.C_LARGE_OUT;
	

	
	public final static String delim = " ";

	public static void main(String[] args) {

		FileUtil util = new FileUtil(inFileName, outFileName);

		String firstLine = util.getLine();
		//System.out.println("FIRST LINE: '" + firstLine + "'");

		int numLines = Integer.parseInt(firstLine);
		//System.out.println("NUMBER OF LINES: " + numLines);
		
		String result;
		
		for	(int i = 1; i <= numLines; i++) {
			
			//System.out.println("----------------------------------------------------");
			
			System.out.println("Case #" + i);
			
//			result = ProblemA.solve(util);
			result = ProblemB.solve(util);
//			result = ProblemC.solve(util);
//			result = ProblemD.solve(util);
			
			util.printLine(i, result);
			
		}
		util.closeFiles();
	}

}
