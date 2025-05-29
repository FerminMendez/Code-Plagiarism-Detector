package qualif.problem3;

import java.util.Scanner;

public abstract class ProblemClass {

	public int testCaseNb = 0;
	private Scanner casesScanner;
	
	public ProblemClass(Scanner input){
		
		try{
			String nextLine = input.nextLine();
			testCaseNb = new Integer(nextLine);
		} finally{

		}
		this.casesScanner = input;
	}
	
	public String[] process(){
		String[] outputs = new String[testCaseNb];
		int testFound = 0;
		try{
			while ( casesScanner.hasNextLine() ){
				String result = processLine( casesScanner.nextLine() );
				outputs[testFound] = result;
				testFound+=1;
		}
		}finally{
			casesScanner.close();
		}
		
		System.out.println("*******************************************************");
		if(testFound==testCaseNb){
			System.out.println("**** There were the expected number of lines  ****");
		} else{
			System.out.println("**** Failure : not the right number of inputs  ****");
		}
		System.out.println("*******************************************************");
		return outputs;
	}
	
	protected abstract String processLine(String line);
}
