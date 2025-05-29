import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class DancingWithTheGooglers {
	public static void main(String args[]){
		try {
			Scanner scanner = new Scanner(new File("B-small-attempt0.in"));
			int noOfCase = scanner.nextInt();
			scanner.nextLine();
//			System.out.println(noOfCase);
			String [] cases = new String [noOfCase];
			int counter=0;
			while(scanner.hasNextLine()){
				cases[counter] = scanner.nextLine();
//				System.out.println(cases[counter]);
				counter++;
			}
			
			for(int i =0 ;i<noOfCase;i++){
				System.out.println("Case #"+(i+1)+": "+processInt(cases[i]));
			
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static int processInt(String caseString){
		Scanner processer = new Scanner(caseString);
		int noOfPeople = processer.nextInt();
		int noOfSuprise = processer.nextInt();
		int leastScore = processer.nextInt();
		
		int [] scoreOfPeople = new int [noOfPeople] ;
		int counter=0;
		while(processer.hasNextInt()){
			scoreOfPeople [counter]=processer.nextInt();
//			System.out.print(scoreOfPeople [counter]+" ");
			counter++;
		}
		
		int leastScoreCounter = 0; 
		int superisingCounter = 0; 
		
		for(int i =0; i<noOfPeople;i++){
			int averageScore= scoreOfPeople [i]/3;
			int extraScore = scoreOfPeople [i]%3;
			int diff = (leastScore-averageScore);
//			System.out.println(scoreOfPeople [i]+" "+averageScore+" "+extraScore+" "+diff+" "+superisingCounter+" "+noOfSuprise+" "+leastScoreCounter);
			if (scoreOfPeople[i] > 0) {
				if (extraScore == 0) {
					if (superisingCounter < noOfSuprise) {
						if (diff == 1) {
							leastScoreCounter++;
							superisingCounter++;
						}
					}
					if (diff < 1) {
						leastScoreCounter++;
					} else {

					}

				} else if (extraScore == 1) {

					if (diff <= 1) {
						leastScoreCounter++;
					} else {

					}

				} else {
					// extraScore ==2
					if (superisingCounter < noOfSuprise) {
						if (diff == 2) {
							leastScoreCounter++;
							superisingCounter++;
						}
					}

					if (diff <= 1) {
						leastScoreCounter++;
					}
				}
			} else if (scoreOfPeople[i] == 0) {
				if(diff ==0 ){
					leastScoreCounter++;
				}
			}
		}
		
		
//		System.out.println();
		
		return leastScoreCounter;
	}
}
