import java.util.Scanner;


public class triplets {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numCases = scan.nextInt();
		for(int i = 0; i < numCases; i++) {
			int size = scan.nextInt();
			int s = scan.nextInt();
			int p = scan.nextInt();
			int[] scores = new int[size];
			for(int j = 0; j < size; j++) {
				scores[j] = scan.nextInt();
			}
			System.out.println("Case #" + (i+1) + ": " + number(scores,s,p));
		}
	}

	
	public static int number(int[] scores, int s, int p) {
		int minScore = Math.max(p*3 - 2, p);
		int minS = Math.max(p*3 - 4, p);
		int count = 0;
		for(int i = 0; i < scores.length; i++) {
			if(scores[i]>=minScore) count++;
			else if(scores[i] >= minS) {
				if(s>0) {
					s--;
					count++;
				}
			}
		}
		return count;
	}
}
