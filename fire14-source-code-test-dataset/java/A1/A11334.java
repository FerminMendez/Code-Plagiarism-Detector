import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;


public class Dancers {

	private static final int P_MIN = 0;
	private static final int P_MAX = 10;
	static final int MAXDIFFERENCEINTRIPLE=4;
	static final int REGULARDIFFERENCEINTRIPLE=2;
	static final Map<Integer, Integer> thresholdRegular=new HashMap<Integer, Integer>();
	static final Map<Integer, Integer> thresholdSurprising=new HashMap<Integer, Integer>();
	
	
	public static void main(String[] args) throws IOException {
		
		calcThresholdSumOfPointsForDifferentPs();
		Vector<String> result=readAndevaluateCases();
		writeResults(result);
		

	}

	
	// p between 0 and 10-> calculate min sum of points a dancer has to have been able to achieve at least p points once
	private static void calcThresholdSumOfPointsForDifferentPs() {
		Integer pointThresholdRegular=0;
		Integer pointThresholdSurprising=0;
		for (int p = P_MIN; p <= P_MAX; p++) {
			pointThresholdSurprising=Math.max(3*p-MAXDIFFERENCEINTRIPLE,p);
			thresholdSurprising.put(p, pointThresholdSurprising);
			
			pointThresholdRegular=Math.max(3*p-REGULARDIFFERENCEINTRIPLE,p);
			thresholdRegular.put(p, pointThresholdRegular);
		}
	}


	private static Vector<String> readAndevaluateCases() throws IOException {
	       
	    Vector<String> result = new Vector<String>();
	  		    
		try{
			  FileInputStream fstream = new FileInputStream("InputDancers");
			  BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			  String strLine;
			  int caseCounter=0;
			  int numberSurprisingTriplets;
			  int counterSurprisingT;
			  int p;
			  int minPointsNecessaryToBeAbleToAchievePRegulary;
			  int minPointsNecessaryToBeAbleToAchievePSurprisingly;
			  int sumOfPointsGoogeler;
			  int counterPAchieved=0;
			  //jump over first line
			  br.readLine();
			  while ((strLine = br.readLine()) != null)   {
				  String[] round=strLine.split(" ");
				  caseCounter++;
				  numberSurprisingTriplets=Integer.parseInt(round[1]);
				  counterSurprisingT=0;
				  p=Integer.parseInt(round[2]);
				  minPointsNecessaryToBeAbleToAchievePRegulary=thresholdRegular.get(p);
				  minPointsNecessaryToBeAbleToAchievePSurprisingly=thresholdSurprising.get(p);
				  counterPAchieved=0;
				  for (int i = 3; i < round.length; i++) {
					sumOfPointsGoogeler=Integer.parseInt(round[i]);
					if(employeAchievedThresholdForRegularT(sumOfPointsGoogeler,minPointsNecessaryToBeAbleToAchievePRegulary)) counterPAchieved++;
					else if (suprisingTripletsleft(numberSurprisingTriplets,counterSurprisingT) && employeeAchievedThresholdForSuprisingT(sumOfPointsGoogeler,minPointsNecessaryToBeAbleToAchievePSurprisingly)){
						counterSurprisingT++;
						counterPAchieved++;
					}
				  }
				  //System.out.println("Case #"+caseCounter+": "+counterPAchieved);
				  result.add("Case #"+caseCounter+": "+counterPAchieved);
				  
				 
			  }
			  fstream.close();
			    }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
		return result;
	    
	 }

	private static boolean employeeAchievedThresholdForSuprisingT(int sumOfPointsGoogeler, int minPointsNecessaryToBeAbleToAchievePSurprisingly) {
				return sumOfPointsGoogeler>=minPointsNecessaryToBeAbleToAchievePSurprisingly;
	}

	private static boolean suprisingTripletsleft(int numberSurprisingTriplets, int counterSurprisingT) {
		return numberSurprisingTriplets>counterSurprisingT;
	}

	private static boolean employeAchievedThresholdForRegularT(int sumOfPoint, int threshold) {
		return sumOfPoint>=threshold;
		
	}
	
	private static void writeResults(Vector<String> result) {
		 try{
			  FileWriter fw = new FileWriter("outputDancers");
			  BufferedWriter out = new BufferedWriter(fw);
			  for (int i = 0; i < result.size(); i++) {
					out.write(result.get(i));
					if(i<result.size()-1)out.write("\n");
				}
			  out.close();
			  }catch (Exception e){
			 
			  }
		
		
	}

	  
}
