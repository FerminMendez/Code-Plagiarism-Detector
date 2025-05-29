package MyAllgoritmicLib;

public class SimpleNumbers {
	public static boolean[] masInt;

	public static void initSimpleInt(int n) { // входные данные
		masInt = new boolean[n + 1];
		for(int i=0; i<=n;i++){
			masInt[i] = true;
		}
		masInt[0] = masInt[1] = false; // если кто-то будет использовать эти
		// значения
		for (int i = 2; i <= n; ++i) {
			if (masInt[i]) {
				for (int j = i + i; j < n; j += i) {
					masInt[j] = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		initSimpleInt(1000000);
		int col = 0;
		int max = 0;
		for (int i = 0; i < 1000000; i++) {
			if (masInt[i]) {
				col++;
				max = i;
			}
		}
		System.out.println(max);
		System.out.println(col);
	}
}
