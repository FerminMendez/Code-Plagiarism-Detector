import java.io.IOException;
import java.util.Scanner;

public class DancingWithTheGooglers {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();

		int counter = 1;
		while (T-- > 0) {
			int returned = 0;
			int N = scan.nextInt();
			int surp = scan.nextInt();
			int theMax = scan.nextInt();
			double[] array = new double[N];
			for (int i = 0; i < array.length; i++) {
				array[i] = scan.nextDouble();
			}
			for (int i = 0; i < array.length; i++) {
				if (Math.ceil((double) array[i] / 3) >= theMax) {
					returned++;
				} else if (array[i] >= theMax) {
					double temp = array[i] - theMax;
					double first = theMax;
					double second = Math.ceil((double) temp / 2);
					double third = temp - second;

					double diff1 = Math.abs(first - second);
					double diff2 = Math.abs(second - third);
					double diff3 = Math.abs(first - third);

					if (diff1 <= 2 && diff2 <= 2 && diff3 <= 2) {
						if (diff1 == 2 || diff2 == 2 || diff3 == 2) {
							if (surp > 0
									&& (first >= theMax || second >= theMax || third >= theMax)) {
								surp--;
								returned++;
							}
						}
					}
				}
			}
			System.out.println("Case #" + counter++ + ": " + returned);
		}
	}
}