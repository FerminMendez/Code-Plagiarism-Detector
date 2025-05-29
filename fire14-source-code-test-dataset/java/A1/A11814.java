import java.util.ArrayList;
import java.util.Scanner;

public class GooglerDancing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new GooglerDancing().run();

	}
	
	public void run(){
		
		int numDancers, targetScore, numSurprising, score, numWins;
		ArrayList<Dancer> dancers;
		Scanner input = new Scanner(System.in);
		int numCases = input.nextInt();
		input.nextLine();
		int caseNum = 1;
		
		while(caseNum <= numCases){
			
			numWins = 0;
			dancers = new ArrayList<Dancer>();
			numDancers = input.nextInt();
			numSurprising = input.nextInt();
			targetScore = input.nextInt();
			for(int dancer = 0; dancer < numDancers; dancer++){
				score = input.nextInt();
				dancers.add(new Dancer(score));
			}
			
			for(Dancer d : dancers){
				if(d.DefiniteWin(targetScore)){
					numWins++;
				} else if(d.score == 0 || d.DefiniteLoss(targetScore)){
					
					// Do nothing
				} else if (numSurprising > 0 && d.WinningSurprise(targetScore)){
					numWins++;
					numSurprising--;
				}
			}
			System.out.printf("Case #%d: %d%n", caseNum, numWins);
			caseNum++;
		}
	}

}

class Dancer {
	
	public int score;
	
	public Dancer(int score){
		this.score = score;
	}
	
	public boolean WinningSurprise(int targetScore){
		
		int firstScore = score - targetScore;
		int remainder = firstScore - (targetScore - 2);
		if(remainder >= (targetScore - 2)){
			return true;
		}
		return false;
	}
	
	public boolean DefiniteWin(int targetScore){
		int border = targetScore - 1;
		double avg = score / 3.0;
		if(avg > border){
			return true;
		}
		return false;
	}
	
	public boolean DefiniteLoss(int targetScore){
		int border = targetScore - 2;
		double avg = score / 3.0;
		if(avg >= border){
			return false;
		}
		return true;
	}
	
}
