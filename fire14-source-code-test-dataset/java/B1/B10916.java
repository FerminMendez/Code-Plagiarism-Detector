import java.util.Scanner;

public class C {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int nCases = sc.nextInt();
		for (int i = 1; i <= nCases; i++) {
			int zzz = 0;
			int a = sc.nextInt();
			int b = sc.nextInt();

			for (int aa = a; aa <= b; aa++) {
				for (int bb = aa + 1; bb <= b; bb++) {
					if (isRecycled(aa, bb)) {
						zzz++;
					}
				}
			}
			System.out.println("Case #" + i + ": " + zzz);
		}
	}

	private static boolean isRecycled(int aa, int bb) {
		int nDigits = 0;
		int temp = aa;
		while (temp > 0) {
			nDigits++;
			temp = temp / 10;
		}

		for (int zxc = 1; zxc < nDigits; zxc++) {
			int tempa = aa;
			tempa = (tempa % (int) Math.pow(10, zxc)) * (int) Math.pow(10,(nDigits - zxc)) + tempa / (int) Math.pow(10, zxc);
			if (tempa == bb) return true;
		}
		return false;
	}
}
