import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Runner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Runner().run();
	}
	
	
void printHelloWorld(String x)
{
	System.out.println("Print Hello World For ," + x);
}

void run()
{
	File file = new File("input.in"); 
	    
	    Scanner input;
	    FileWriter fstream = null;
	    
		try {
			input = new Scanner(file);
		
		int numberOfTestCases = input.nextInt();
		fstream = new FileWriter("out.out");
	    BufferedWriter out = new BufferedWriter(fstream);
	    
	    for(int i = 0 ; i < numberOfTestCases ; i++){
	    	
	    	int numberOfGooglers = input.nextInt();
	    	int surprisingAllowed = input.nextInt();
    		int limitScore = input.nextInt();
	    	
    		int numberOfAddedSuperrised = 0;
    		int numberOfMayUsedSurprisedGooglers = 0;
    		int totalNumberOfGoolgersPassedLimit = 0;
	    	
	    	for (int j = 0; j < numberOfGooglers; j++) {
	    		
	    		int googlerTotalScore = input.nextInt();
	    		int division = googlerTotalScore / 3;
	    		
	    		if(googlerTotalScore % 3 == 0 ){
		    		
	    			if(division >= limitScore){
	    				totalNumberOfGoolgersPassedLimit++;
	    			}else{
	    				if(division != 0 && division+1 >= limitScore){
	    					numberOfMayUsedSurprisedGooglers++;
	    				}
	    			}

		    	}else if(googlerTotalScore % 3 == 1 ) {
		    		
		    		if(division+1 >= limitScore){
	    				totalNumberOfGoolgersPassedLimit++;
	    			}
		    		
		    	}else if(googlerTotalScore % 3 == 2 ){
		    		
		    		if(division+1 >= limitScore){
	    				totalNumberOfGoolgersPassedLimit++;
	    			}else if(division+2 >= limitScore){
	    				numberOfMayUsedSurprisedGooglers++;
	    			}
		    		
		    	}
			}
	    	
	    	numberOfAddedSuperrised = (numberOfMayUsedSurprisedGooglers > surprisingAllowed) ? surprisingAllowed : numberOfMayUsedSurprisedGooglers;
	    	totalNumberOfGoolgersPassedLimit += numberOfAddedSuperrised;
	    	out.write("Case #" + (i+1) +": "+ totalNumberOfGoolgersPassedLimit +"\n");
	    }
	    
	    
	    input.close(); 
    	out.close();
    	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	  
	
}

}
