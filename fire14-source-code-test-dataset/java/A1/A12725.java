import java.util.Scanner;

public class DancingWithGooglers {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numberOfTests = Integer.parseInt(in.nextLine());
		
		for(int i = 0; i < numberOfTests; i++) {
			int googlers = in.nextInt(), suprises = in.nextInt(), query = in.nextInt();
			int numberSatisfyingQuery = 0, numberNeedingSuprises = 0;
			for(int j = 0; j < googlers; j++) {
				int total = in.nextInt();
				if(total % 3 == 0) {
					int high = total / 3;
					if(high >= query) {
						numberSatisfyingQuery++;
					} else if(high + 1 >= query && high >= 1) {
						numberNeedingSuprises++;
					}
				} else if(total % 3 == 1) {
					int high = total / 3 + 1;
					if(high >= query) {
						numberSatisfyingQuery++;
					} // Surprise not possible
				} else if(total % 3 == 2) {
					int high = total / 3 + 1;
					if(high >= query) {
						numberSatisfyingQuery++;
					} else if(high + 1 >= query && high >= 1) {
						numberNeedingSuprises++;
					}
				}
			}
			int result = numberSatisfyingQuery + Math.min(numberNeedingSuprises, suprises);
			System.out.println("Case #" + (i + 1) + ": " + result);
		}
	}
}