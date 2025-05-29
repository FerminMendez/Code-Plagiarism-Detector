import java.util.*;

public class B{
	static TreeMap<Character, Character> map = new TreeMap<Character, Character>();
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		int num = input.nextInt();
		input.nextLine();
		for (int n = 1; n <= num; n++){
			int googlers = input.nextInt(); // No more than 3 for small
			int surprises = input.nextInt();
			int targetScore = input.nextInt(); // p from problem - best single score
			int[] scores = new int[googlers];
			int[][] individualScores = new int[googlers][3];
			int[][] maxScores = new int[googlers][3];
			for (int i = 0; i < googlers; i++){
				scores[i] = input.nextInt();
				if(scores[i]%3 == 0){
					individualScores[i][0]=scores[i]/3;
					individualScores[i][1]=scores[i]/3;
					individualScores[i][2]=scores[i]/3;
					if (scores[i] > 0){
						maxScores[i][0]=scores[i]/3+1;
						maxScores[i][1]=scores[i]/3;
						maxScores[i][2]=scores[i]/3-1;
					}
				}
				else if (scores[i]%3 == 1){
					individualScores[i][0]=scores[i]/3+1;
					individualScores[i][1]=scores[i]/3;
					individualScores[i][2]=scores[i]/3;
					if (scores[i] > 1){
						maxScores[i][0]=scores[i]/3+1;
						maxScores[i][1]=scores[i]/3;
						maxScores[i][2]=scores[i]/3;
					}
				}
				else{//2
					individualScores[i][0]=scores[i]/3+1;
					individualScores[i][1]=scores[i]/3+1;
					individualScores[i][2]=scores[i]/3;
					maxScores[i][0]=scores[i]/3+2;
					maxScores[i][1]=scores[i]/3;
					maxScores[i][2]=scores[i]/3;
				}
			}
			int possibilities = 0;
			for (int j = 0; j < googlers; j++){
				if (individualScores[j][0] >= targetScore){
					possibilities++;
				}
				else if (maxScores[j][0] >= targetScore && surprises > 0){
					possibilities++;
					surprises--;
				}
			}
			System.out.println("Case #" + n + ": " + possibilities);
		}
		
	}
}
