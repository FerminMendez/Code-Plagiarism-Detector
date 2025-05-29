import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;


public class GooglerDancing {
	
	public static void main(String[] args) {
		try {
			BufferedReader fileIn = new BufferedReader(new FileReader("B-small-attempt1.in"));
			int cases = Integer.valueOf(fileIn.readLine());
			for(int i = 0; i < cases; i++) {
				StringTokenizer str = new StringTokenizer(fileIn.readLine());
				int googlers = Integer.valueOf(str.nextToken());
				int surprises = Integer.valueOf(str.nextToken());
				int minScore = Integer.valueOf(str.nextToken());
				int scoreNoSurprise = minScore + (minScore - 1) * 2;
				int scoreSurprise = minScore + (minScore - 2) * 2;
				int numHigher = 0;
				for(int j = 0; j < googlers; j++) {
					int score = Integer.valueOf(str.nextToken());
					if(score >= scoreNoSurprise) {
						numHigher++;
					} else if(score >= scoreSurprise && surprises > 0 && score != 0) {
						numHigher++;
						surprises--;
					} else if(score >= scoreSurprise && surprises == 0) {
						//System.out.println("Error Case #"+(i+1)+": min (" + minScore + ") score ("+score+") ith ("+j+")");
					}
				}
				System.out.println("Case #"+(i+1)+": " + numHigher);
			}
			
		} catch(Exception err) {
			System.out.println("Another fabulous error: " + err);
			err.printStackTrace();
		}
	}
}
