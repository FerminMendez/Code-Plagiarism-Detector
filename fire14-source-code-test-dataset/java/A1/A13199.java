package dancing;

import java.io.BufferedReader;
import java.io.FileReader;

public class MaxScoreDetector {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String fileName = null;
		if(args.length == 1){
			fileName = args[0];
		}else{
			System.err.println("Requires a command line argument: fileName");
			System.exit(1);
		};
		
		new MaxScoreDetector(fileName);

	}
	
	public MaxScoreDetector(String fileName){
		try{
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			int cases = Integer.parseInt(in.readLine());
			for(int i=0; i<cases; i++){
				String[] line = in.readLine().split(" ");
				int numScores = Integer.parseInt(line[0]);
				int specials = Integer.parseInt(line[1]);
				int min = Integer.parseInt(line[2]);
				int[] scores = new int[numScores];
				for(int j=0; j<scores.length; j++){
					scores[j] = Integer.parseInt(line[j+3]);
				}
				System.out.println("Case #" + (i+1) + ": " + testScores(scores, min, specials));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public int testScores(int[] scores, int min, int specials){
		int over = specials;
		int count = 0;
		for(int i=0; i<scores.length; i++){
			if(scores[i] < min) continue;
			double avg = scores[i]/3.;
			if(avg >= min || Math.ceil(avg)>=min){
				count++;
				continue;
			}
			if(Math.round(avg) == (int)avg + 1 && Math.round(avg) + 1 >= min && over > 0){
				count++;
				over--;
				continue;
			}
			if(avg == (int)avg && avg + 1 >= min && over > 0){
				over--;
				count++;
				continue;
			}
			
		}
		return count;
	}

}
