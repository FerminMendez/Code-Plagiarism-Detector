package qualif.problem2;

import java.util.Scanner;

public class DancingWithTheGooglers {

	public int testCaseNb = 0;
	private Scanner casesScanner;
	
	public DancingWithTheGooglers(Scanner input){
	
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
		if(testFound==testCaseNb){
			System.out.println("THIS WAS A SUCCESS");
		} else{
			System.out.println("!!!! FAILURE");
		}
		
		return outputs;
	}
	
	private String processLine(String line){
		String[] inputData = line.split(" ");
		
		int dancersNb = new Integer(inputData[0]);
		int surprizingTripletsNb = new Integer(inputData[1]);
		int atLeastBestResult = new Integer(inputData[2]);
		
		int[] totalPointsPerDancer = new int[dancersNb];
		
		for(int i = 0 ; i < dancersNb; i++){
			totalPointsPerDancer[i] =  new Integer(inputData[i+3]);
		}

		return findNumberOfBestDancer(surprizingTripletsNb,atLeastBestResult,totalPointsPerDancer);
	}
	
	private String findNumberOfBestDancer(int surprizingTripletsNb, int atLeastBestResult,int[] totalPointsPerDancer){
		Integer nbOfBestResult = 0;
		
		int nbOfPotentialSurprize = 0;
		for(int danceResult:totalPointsPerDancer){
			if(canReachBestResult(danceResult,atLeastBestResult)){
				if(isAboveBestAnyway(danceResult,atLeastBestResult)){
					nbOfBestResult+=1;
				} else{
					nbOfPotentialSurprize+=1;
				}
			}
		}
		
		nbOfBestResult += Math.min(nbOfPotentialSurprize,surprizingTripletsNb);
		return nbOfBestResult.toString();
	}
	
	private boolean isAboveBestAnyway(int total, int best) {
		return total>=best && total >= (best + 2*(best-1));
	}

	private boolean canReachBestResult(int total,int best){
		return total>=best && total >= (best + 2*(best-2));
	}
}
