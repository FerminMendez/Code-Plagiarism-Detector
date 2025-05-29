import java.util.*;

public class RecycledNumbers {

	public static void main(String[] args) {
		
		System.out.println("Enter case input:");
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		int[][] numbers = new int[T][2];
		for (int t = 0; t < T; t++) {
			numbers[t][0] = sc.nextInt();
			numbers[t][1] = sc.nextInt();
			sc.nextLine();
		}
		
		for (int t = 1; t <= T; t++) {
			int a = numbers[t - 1][0];
			int b = numbers[t - 1][1];
			int numRecycledPairs = 0;
			
			for (int n = a; n < b; n++) {
				String N = n + "";
				int[] matches = new int[N.length()];
				boolean duplicate = false;
				
				for (int digitFromBack = 1; digitFromBack <= N.length() - 1; digitFromBack++) {
					int newInt = Integer.parseInt(N.substring(N.length() - digitFromBack) + N.substring(0, N.length() - digitFromBack));
					if (newInt > n && newInt <= b) {
						for (int match : matches) {
							if (newInt == match)
								duplicate = true;
						}
						//System.out.print(n + ":" + newInt + " ");
						if (!duplicate) {
							matches[digitFromBack] = newInt;
							numRecycledPairs++;
						}
					}
				}
			}
			
			System.out.println("Case #" + t + ": " + numRecycledPairs);
		}
		
		

	}

}
