import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class qualb{
	
	public static void main(String[] args){
		qualb.solve();
	}
	
	private static void solve(){
		String fileName = "B-small-attempt0.in";
		String outputFileName = fileName;
		if(outputFileName.contains(".")){
			outputFileName = outputFileName.substring(0,outputFileName.indexOf("."));
		}
		outputFileName = outputFileName+".out";
        File file = new File(fileName); 

        try { 
        	FileWriter fstream = new FileWriter(outputFileName,true);
    		 BufferedWriter out = new BufferedWriter(fstream);
        	BufferedReader reader = new BufferedReader(new FileReader(file));       
        	
        	//Number of cases
        	String text = reader.readLine();
        	int NoCases = Integer.parseInt(text);
        	
        	for(int caseNo=0;caseNo<NoCases;caseNo++){
        		//Case line
        		text = reader.readLine();
        		String[] caseLine = text.split(" ");
        		
        		//No of googlers
        		int NoGooglers = Integer.parseInt(caseLine[0]);
        		
        		//No of supprising scores
        		int NoSupprising = Integer.parseInt(caseLine[1]);
        		
        		//Score in question
        		int p = Integer.parseInt(caseLine[2]);
        		
        		int minScoreUnSupprising = p*3-2;
        		if(minScoreUnSupprising<=0) minScoreUnSupprising = p;
        		int minScoreSupprising = p*3-4;
        		if(minScoreSupprising<=0) minScoreSupprising = p;
        		
        		int NoGooglersUnSupprising = 0;
        		int NoGooglersSupprising = 0;
        		
        		for(int Googler=0;Googler<NoGooglers;Googler++){
        			int GooglerScore = Integer.parseInt(caseLine[3+Googler]);
        			if(GooglerScore>=minScoreUnSupprising){
        				NoGooglersUnSupprising++;
        			} else if(GooglerScore>=minScoreSupprising){
        				NoGooglersSupprising++;
        			}
        		}
        		
        		if(NoGooglersSupprising>NoSupprising) NoGooglersSupprising = NoSupprising;
        		System.out.println("Case #"+(caseNo+1)+": "+(NoGooglersUnSupprising+NoGooglersSupprising));
        		out.write("Case #"+(caseNo+1)+": "+(NoGooglersUnSupprising+NoGooglersSupprising));
        		out.newLine();
        	}
        	out.close();
        } catch (Exception e) { 
            System.out.println(e); 
        }
	}
}