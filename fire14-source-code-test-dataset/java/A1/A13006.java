import java.util.*;
class Dance {
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int numCases = sc.nextInt();
		for (int i = 0; i < numCases; i++) {
			int numScores = sc.nextInt();
			int numSuprises = sc.nextInt();
			int smallest = sc.nextInt();
			int won = 0;
			for (int k = 0; k < numScores; k++) {
				int score = sc.nextInt();
				if (smallest > score)
					continue;
				score -= smallest;
				score /= 2;
				if (score >= smallest - 1)
					won++;
				else if (score >= smallest - 2) {
					if (numSuprises != 0) {
						won++;
						numSuprises--;
					}
				}
			}
			System.out.println("Case #" + (i + 1) + ": " + won);
		}
	}
}