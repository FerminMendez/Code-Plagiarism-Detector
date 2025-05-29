import java.util.Scanner;

public class B {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int T = in.nextInt();

		in.nextLine();

		for (int i = 1; i <= T; i++) {

			int numDancers = in.nextInt();
			int numSurprisingTriplets = in.nextInt();
			int p = in.nextInt();
			int triplet, div, mod;
			int res = 0;

			for (int j = 0; j < numDancers; j++) {
				triplet = in.nextInt();

				div = triplet / 3;
				mod = triplet % 3;

				if (triplet != 0) {
					if (div >= p)
						res++;
					else {
						if (mod != 0) {
							div++;
							if (div >= p)
								res++;
							else {
								mod--;
								if (mod != 0) {
									div++;
									if (div >= p && numSurprisingTriplets > 0) {
										res++;
										numSurprisingTriplets--;
									}
								}
							}
						} else {
							div++;
							if (div >= p && numSurprisingTriplets > 0) {
								res++;
								numSurprisingTriplets--;
							}
						}
					}

				}
				else
					if (p == 0)
						res++;
			}
			System.out.println("Case #" + i + ": " + res);
		}
	}

}
