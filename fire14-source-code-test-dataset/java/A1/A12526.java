import java.util.ArrayList;
import java.util.Scanner;


public class GooglersDancing {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noCases = in.nextInt();
		
		for(int i = 0; i < noCases; i++){
			int noGooglers = in.nextInt();
			int noSuprises = in.nextInt();
			int minBestResult = in.nextInt();
			ArrayList<Integer> scores = new ArrayList<Integer>();
			ArrayList<Integer> possibleSurprises = new ArrayList<Integer>();
			for(int j = 0; j < noGooglers; j++){
				scores.add(in.nextInt());
				possibleSurprises.add(0);
			}
			int counter = 0;
			for(int j = 0; j < noGooglers; j++){
				int score = scores.get(j);
				int others = score - minBestResult;
				if(others < 0){
					possibleSurprises.set(j,-2);
					continue;
				}
				if(score < 2){
					possibleSurprises.set(j,-1);
					if(score == 0 && minBestResult == 0){
						counter++;
						continue;
					}
					if(score == 1 && (minBestResult <= 1)){
						counter++;
						continue;
					}
					continue;
				}
				if(score > 28){
					possibleSurprises.set(j,-1);
					counter++;
					continue;
				}
				if(Math.ceil(others / 2) < (minBestResult - 2)){
					possibleSurprises.set(j,-2);
					continue;
				}
				counter++;
				if((others >= minBestResult*2-2) && (others <= minBestResult*2+2)){
					possibleSurprises.set(j,1); //maybe surprise
				}
				else {
					boolean foundMaybe = false;
					for(int k = minBestResult+1; k <= 10; k++){
						others = score - k;
						if((others >= k*2-2) && (others <= k*2+2)){
							possibleSurprises.set(j,1); //maybe surprise
							foundMaybe = true;
							break;
						}
					}
					if(!foundMaybe){
						possibleSurprises.set(j,2); // must be surprise
					}
				}
			}
			
			int must = 0;
			int maybe = 0;
			int noes = 0;
			for(Integer surp : possibleSurprises){
				if(surp.intValue() == 1){
					maybe++;
				}
				if(surp.intValue() == 2){
					must++;
				}
				if(surp.intValue() == -1){
					noes++;
				}
			}
			if(must > noSuprises){
				System.out.println("Case #"+(i+1)+": " + (noSuprises+maybe+noes));
			}
			else{
				System.out.println("Case #"+(i+1)+": " + counter);
			}
		}
	}

}
