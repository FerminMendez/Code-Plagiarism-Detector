import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class GoogleDancers {

	public static void main(String args[]) throws IOException{
		Scanner scan = new Scanner(System.in);
		PrintWriter print = new PrintWriter(new FileWriter("GoogleDancers.out"));
		Integer cases = Integer.parseInt(scan.nextLine());
		for(int i=0; i<cases; i++){
			int numDancers = scan.nextInt();
			int surprises = scan.nextInt();
			int threshHoldScore = scan.nextInt();
			int numAccepted = 0;
			for(int j=0;j<numDancers;j++){
				int totalScore = scan.nextInt();
				int topScore = totalScore/3;
				
				if(threshHoldScore*3 <= totalScore){
					numAccepted++;
					continue;
				}
				
				if(totalScore%3==0 && totalScore != 0){
					if(topScore >= threshHoldScore){
						numAccepted++;
					}else if(topScore+1 >= threshHoldScore && surprises > 0){
							numAccepted++;
							surprises--;
						}
					
				}
				
				if(totalScore%3==1){
					topScore++;				
					if(topScore >= threshHoldScore){
						numAccepted++;
					}
				} 
				
				if(totalScore %3 == 2){
					topScore++;
					if(topScore >= threshHoldScore){
						numAccepted++;
					}else if(topScore+1 >= threshHoldScore && surprises > 0){
						numAccepted++;
						surprises--;
					}
				}
			}
			print.println("Case #" + (i+1) + ": " + numAccepted );
			System.out.println("Case #" + (i+1) + ": " + numAccepted);
			print.flush();
			//print.close();
		}
		print.close();
	}
}
