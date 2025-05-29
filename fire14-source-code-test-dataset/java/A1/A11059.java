import java.util.Scanner;


public class QualB {
	
	private int googlers, surprising, p, maxnr;
	private int[] totals;
	
	public QualB(String line){
		String[] limitsStr = line.split("\\s"); 
		googlers = Integer.parseInt(limitsStr[0]);
		surprising = Integer.parseInt(limitsStr[1]);
		p = Integer.parseInt(limitsStr[2]);
		totals = new int[googlers];
		for(int i = 3; i < googlers + 3;i++){
			totals[i-3] = Integer.parseInt(limitsStr[i]);
		}
		
		solve();
	}
	
	private void solve() {
		for(int score : totals){
			if(canSolveTotal(score))
				maxnr++;
		}
	}

	private boolean canSolveTotal(int score) {
		if(score < p)
			return false;
		if(canSolveWithNormalScore(score))
			return true;
		if(canSolveWithSurprisingScore(score)){
			surprising--;
			return true;
		}
		return false;
	}

	private boolean canSolveWithNormalScore(int totalscore) {
		for(int score1 = p; score1 <= 10; score1++){
			for(int score2 = score1-1; score2 <= score1+1; score2++){
				for(int score3 = score1-1; score3 <= score1+1; score3++){
					if(score1+score2+score3 != totalscore)
						continue;
					if(score2 >= score1 - 1 && score2 <= score1 + 1 &&
					   score3 >= score1 - 1 && score3 <= score1 + 1 &&
					   score2 >= score3 - 1 && score2 <= score3 + 1){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private boolean canSolveWithSurprisingScore(int totalscore) {
		if(surprising <= 0)
			return false;
		boolean suprisingScoreFound = false;
		for(int score1 = p; score1 <= 10; score1++){
			for(int score2 = score1-2; score2 <= score1+2; score2++){
				for(int score3 = score1-2; score3 <= score1+2; score3++){
					if(score1+score2+score3 != totalscore)
						continue;
					if(score2 >= score1 - 2 && score2 <= score1 + 2 &&
							   score3 >= score1 - 2 && score3 <= score1 + 2 &&
							   score2 >= score3 - 2 && score2 <= score3 + 2){
						return true;
					}
					
				}
			}
		}
		return false;
	}
	
	

	public String toString(){
		String toReturn =  String.format("Googlers: %1$d \nSuprising: %2$d \np: %3$d \nscores: [",
							googlers,
							surprising,
							p,
							totals);
		for(int score : totals)
			toReturn += "" + score + " ";
		toReturn = toReturn.substring(0, toReturn.length() - 1);
		return toReturn += "]";
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = Integer.parseInt(scan.nextLine());
		int i = 0;
		while(scan.hasNextLine()){
			String line = scan.nextLine();
			i++;
			QualB sol = new QualB(line);
			System.out.println("Case #" + i + ": " + sol.maxnr);
		}
	}

}
