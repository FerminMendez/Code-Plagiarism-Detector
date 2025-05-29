package practice;

import java.util.*;

public class GoogleDance {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int cases = Integer.parseInt(sc.nextLine());
		for(int i = 0; i<cases; i++){
			//Case starts here
			int caseCounter = i+1;
			String caseLine = sc.nextLine();
			String[] caseArray = caseLine.split(" ");
			int googlers = Integer.parseInt(caseArray[0]);
			int surprising = Integer.parseInt(caseArray[1]);
			int passing = Integer.parseInt(caseArray[2]);
			List<Integer> scores = new ArrayList<Integer>();
			for(int j = 3; j<caseArray.length;j++){
				scores.add(Integer.parseInt(caseArray[j]));
			}
			//Finding individual scores
			int result = 0;
			for(Integer score:scores){
				if(score%3==0){
					int individual = score/3;
					if(individual==0){
						if(individual>=passing){
							result++;
						}
					}else{
						if(individual>=passing){
							result++;
						}else if(surprising>0){
							individual++;
							if(individual>=passing){
								result++;
								surprising--;
							}
						}
					}
					
				}
				if(score%3==1){
					int individual = score/3+1;
					if(individual>=passing){
						result++;
					}
				}
				if(score%3==2){
					int individual = score/3+1;
					if(individual>=passing){
						result++;
					}else if(surprising>0){
						individual++;
						if(individual>=passing){
							result++;
							surprising--;
						}
					}
				}
			}
			System.out.println("Case #"+caseCounter+": " + result);
			//Case ends here
		}
	}
}
