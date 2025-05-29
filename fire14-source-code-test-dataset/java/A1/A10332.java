package QR_2012;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Utils.IOStreams;

public class B_Dancing_With_The_Googlers {
	
	public static void main(String[] args) throws IOException {
		
		IOStreams streams = new IOStreams(args[0]);
		System.setIn(new FileInputStream(args[0]));
		Scanner sc = new Scanner(System.in);
		
		sc.nextLine(); // Skip number of cases
		int caseNumber = 1;
		while (sc.hasNextInt()) {
			
			int numberOfGooglers = sc.nextInt();
			int surprisingTriplets = sc.nextInt();
			int minimumScore = sc.nextInt();
			List<Integer> totalPoints = new ArrayList<Integer>();
			for(int i=0 ; i<numberOfGooglers ; i++){
				totalPoints.add(sc.nextInt());
			}
			
			streams.printLine("Case #" + (caseNumber++) + ": " + solveIt(numberOfGooglers, surprisingTriplets, minimumScore, totalPoints) + "\n");
		}
		
		streams.closeStreams();
					
	}

	private static int solveIt(int numberOfGooglers, int surprisingTriplets, int minimumScore, List<Integer> totalPoints) {
		
		int solution = 0;
		
		for (Integer integer : totalPoints) {
			
			if(integer==0){
				if(minimumScore==0) solution++;
				continue;
			}
			
			if(integer%3!=0){
				if((integer/3+1)>=minimumScore)
					solution++;
				else if(integer/3+1<minimumScore && (integer/3)+(integer%3)>=minimumScore && surprisingTriplets>0){
					solution++;
					surprisingTriplets--;
				}
			}
			else if (integer%3==0){
				if(integer/3>=minimumScore)
					solution++;
				else if(integer/3<minimumScore && integer/3+1>=minimumScore && surprisingTriplets>0){
					solution++;
					surprisingTriplets--;
				}
			}
		}
		
		return solution;
	}

}
