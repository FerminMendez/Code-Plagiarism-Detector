import java.util.Arrays;
import java.util.Scanner;

public class DanceJudging {
	
	public static int count(int[] totalPoints, int numSurprise, int target) {
		final int totalMin = target + ((target >= 1) ? (target - 1) : 0) * 2;
		final int surpriseTotalMin = target + ((target >= 2) ? (target - 2) : 0) * 2;
		int count = 0;
		Arrays.sort(totalPoints);
		for (int i = totalPoints.length - 1; i >= 0; i--) {
			if (totalPoints[i] >= totalMin) {
				count++;
			} else if (numSurprise > 0 && totalPoints[i] >= surpriseTotalMin) {
				numSurprise--;
				count++;
			} else {
				break;
			}
		}

		return count;
	}
	
	public static void main(String[] args) {
		final Scanner in = new Scanner(System.in);
		final int numCase = in.nextInt();
		in.nextLine();
		int numGoogler, numSurprise, target;
		int[] totalPoints;
		for (int i = 0; i < numCase; i++) {
			numGoogler = in.nextInt();
			numSurprise = in.nextInt();
			target = in.nextInt();
			totalPoints = new int[numGoogler];
			for (int j = 0; j < numGoogler; j++) {
				totalPoints[j] = in.nextInt();
			}
			System.out.println("Case #" + (i+1) + ": " + count(totalPoints, numSurprise, target));
			in.nextLine();
		}
	}
}
