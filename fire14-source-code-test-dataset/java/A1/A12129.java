import java.util.*;

public class Scores {
	public static int tests = 0;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		tests = Integer.parseInt(scan.nextLine());
		
		for (int i=1; i<=tests; i++) {
			String[] input = scan.nextLine().split("\\s+");
//			int g = Integer.parseInt(input[0]);
			int surprises = Integer.parseInt(input[1]);
			int goal = Integer.parseInt(input[2]);
			
			int numGoal = 0;
			
			for (int j=3; j<input.length; j++) {
				int score = Integer.parseInt(input[j]);
				int max = score/3;
				
				if (score != 0) {
					if (score == 1) {
						if (1>=goal)
							numGoal++;
					}
					else if (score == 29 || score == 30) {
						if (10>=goal)
							numGoal++;
					}
					else if (score % 3 == 0) {
						if (max >= goal)
							numGoal++;
						else
							if (max+1 >= goal && surprises > 0){
								numGoal++;
								surprises--;
							}
					}
					else if (score % 3 == 1) {
						if (max+1 >= goal)
							numGoal++;
					}
					else if (score % 3 == 2) {
						if (max+1 >= goal)
							numGoal++;
						else
							if (max+2 >= goal && surprises > 0) {
								numGoal++;
								surprises--;
							}
					}
				}
				else if (score==0 && max>=goal)
					numGoal++;
			}
			
			System.out.println("Case #" + i + ": " + numGoal);
		}
	}
}
