import java.util.Scanner;
import java.io.File;

public class ScoreAnalyzer
 {
 	
 	public void analyzeInputFile(String fileName) throws Exception
 	 {
	   Scanner fileScanner = new Scanner (new File (fileName) ); 	
 	   
 	   String line;
 	   
 	   line = fileScanner.nextLine();
 	   
 	   int numberOfTestCases = Integer.parseInt(line.trim());
 	   
 	   int N,S,p;
 	   
 	   for(int i = 1; i<= numberOfTestCases ; i++)
 	    { 
 	       line = fileScanner.nextLine();	
 	       	 	
 	       Scanner lineScanner = new Scanner(line);
 	       
 	       N = Integer.parseInt(lineScanner.next().trim());
 	       S = Integer.parseInt(lineScanner.next().trim());
 	       p = Integer.parseInt(lineScanner.next().trim());
 	       
 	       // System.out.println("N= "+N+ " S = "+S + " p = "+p); 
 	       
 	       int noSurpriseLowerLimitScore;
 	       int surpriseLowerLimitScore;
 	       int surpriseHigherLimitScore;
 	       
 	       noSurpriseLowerLimitScore = 3*p - 2;
 	       surpriseLowerLimitScore   = 3*p - 4;
 	       surpriseHigherLimitScore  = 3*p - 3;
 	       
 	      // System.out.println("3p-2 = "+noSurpriseLowerLimitScore);
 	      // System.out.println("3p-4 = "+surpriseLowerLimitScore);
 	      // System.out.println("3p-3 = "+surpriseHigherLimitScore);
 	       
 	       
 	       int googlersWithBestResultOfAtLeastP = 0;
 	       int numberOfSurpriseScoresLeft = S;
 	       
 	       for(int j=1; j<=N ; j++)
 	        {
 	          int googlerScore = Integer.parseInt(lineScanner.next().trim());
 	          
 	          if(googlerScore >= p)
 	          {
 	          
 	           //  System.out.println("googlerScore = "+googlerScore+" ");
 	          
 	             if(googlerScore >= noSurpriseLowerLimitScore) 
 	              {
 	           	    googlersWithBestResultOfAtLeastP++;
 	           	    continue;
 	              }
 	           
 	             if(numberOfSurpriseScoresLeft > 0 )
 	              {
 	                if(googlerScore >= surpriseLowerLimitScore && googlerScore <= surpriseHigherLimitScore) 
 	                 {
 	              	   googlersWithBestResultOfAtLeastP++;
 	              	   numberOfSurpriseScoresLeft--;
 	                 } 	
 	              } 
 	           }
 	         } 
 	       
 	       System.out.println("Case #"+i+": "+googlersWithBestResultOfAtLeastP);
 	    }
 	 }
 	
 	
 	
    public static void main(String[] args) throws Exception
     {
     	ScoreAnalyzer SA = new ScoreAnalyzer();
     	String inputFile = "B-small-attempt0.in";
     	
     	SA.analyzeInputFile(inputFile);
     }	
 }