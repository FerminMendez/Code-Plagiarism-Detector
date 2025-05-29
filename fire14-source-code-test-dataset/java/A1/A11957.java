
package prg2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author Brijesh Mistry
 *
 */
public class GooglerDance {

	
	
	public static void main(String[] args) {
		
		try{
			FileInputStream fstream = new FileInputStream("b1.in");
		  
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String fileline;		
			
			//Read File Line By Line
			int j =0 ;
			String strTestcases ;
			int iTestcases = 0;
			
			//Read no of testcases			
			if(((strTestcases = br.readLine()) != null)){
				System.out.println("Test cases:"+strTestcases);
				iTestcases = Integer.parseInt(strTestcases);
			}
			//int noofGoogler = 0;
			//int noOfSurprises = 0;
			//int noOfSurprisesRemaining = 0;
			//int limitScore = 0;
			//int minscore = 0;
			//int totalWinner = 0;
			for(int k=1;k<=iTestcases;k++){
			//for(int k=1;k<=3;k++){
				int noofGoogler = 0;
				int noOfSurprises = 0;
				int noOfSurprisesRemaining = 0;
				int limitScore = 0;
				int minscore = 0;
				int totalWinner = 0;
				if((fileline = br.readLine()) != null){					
					//System.out.println ("line #"+(k)+" "+fileline);
					StringTokenizer st = new StringTokenizer(fileline, " "); 
					noofGoogler = Integer.parseInt(st.nextToken());
					noOfSurprises = Integer.parseInt(st.nextToken());
					limitScore = Integer.parseInt(st.nextToken());
					//System.out.println(k+"Parameters fetched:"+noofGoogler+" : "+noOfSurprises+ " : "+limitScore);
					
					//Logic that gives the no of players
					//store Max scores into ArrayList
					ArrayList<Integer> maxScores = new ArrayList<Integer>();
					ArrayList<Integer> secondscore =new ArrayList<Integer>();
					for(int i=0;i<noofGoogler;i++){
						maxScores.add(Integer.parseInt(st.nextToken()));
					}					
					//Max scores we have into List
					
					
					//NOW Check for normal score
					minscore = (limitScore-1)*2+limitScore;
					for(int score:maxScores){
						if(score>=minscore && score >= limitScore){
							totalWinner +=1;							
						}else{
							//System.out.println("adding score: case :"+k+":"+score);
							secondscore.add(score);
						}
					}
					
					noOfSurprisesRemaining = noOfSurprises; 
					if(noOfSurprisesRemaining>0){						
						minscore = (limitScore-2)*2+limitScore;
						//System.out.println("min score"+minscore);
						
						for(int score:secondscore){
							if(score>=minscore && noOfSurprisesRemaining>0 && score >= limitScore){
								//ystem.out.println("for Surprises score: case :"+k+":" +score);
								totalWinner +=1;
								noOfSurprisesRemaining --;								
							}
						}
					}
					
				
					
					System.out.println("Case #"+k+": "+totalWinner);
					
				}
			}
			
		  //Close the input stream
		  in.close();
		 }catch (Exception e){//Catch exception if any
			  e.printStackTrace();
		 }

	}

}
