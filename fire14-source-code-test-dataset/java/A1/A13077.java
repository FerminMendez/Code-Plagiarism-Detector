public class Googlers {
	public static int google(int N, int S, int P, int[] googler) {
		int counter = 0;
		for (int j = 0; j < googler.length; j++) {
			if (googler[j] % 3 == 0 && P >= 0) {
				if (googler[j] != 0) {
					if (googler[j] / 3 >= P) {
						counter++;
					} else if (googler[j] / 3 + 1 >= P && S != 0) {
						counter++;
						S--;
					}	
				}
				else if (googler[j] == 0 && P == 0) {
					counter++;
				}
			} else if (googler[j] % 3 == 1) {
				if (googler[j] / 3 + 1 >= P) {
					counter++;
				}
			} else if (googler[j] % 3 == 2) {
				if (googler[j] / 3 + 1 >= P) {
					counter++;
				}
				else if (googler[j] / 3 + 2 >= P && S != 0) {
					counter++;
					S--;
				}
			}
		}
		return counter;
	}
}
