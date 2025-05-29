import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dancing_with_the_googlers {
	public static int s;

	public static int max(int x, int s, final int sMax, int p) {
		int tmp, i = 0, mm = 0, maxx = 0, j = 0, xDIV = 0, min = 1000, k = 0;
		xDIV = Math.round(x / 3);
		mm = 1;
		maxx = xDIV;
		for (i = -1 * mm; i <= mm; i++) {
			for (j = 0; ((j <= mm) && (Math.abs(i - j) <= mm)); j++) {
				for (k = 0; k <= mm; k++) {
					tmp = (xDIV + k) + (xDIV + i) + (xDIV + j);
					// System.out.println("tmp = "+xDIV+" + "+ (xDIV+i)+
					// " + "+(xDIV+j));
					if ((x == tmp) && (xDIV + i >= 0) && ((xDIV + j) >= 0)
							&& ((xDIV + j) <= 10) && ((xDIV + i) <= 10)
							&& ((xDIV + k) >= 0) && ((xDIV + k) <= 10)) {
						if ((xDIV + i) > maxx) {
							maxx = xDIV + i;
						}
						if ((xDIV + i) < min) {
							min = xDIV + i;
						}
						if ((xDIV + j) < min) {
							min = xDIV + j;
						}
						if ((xDIV + j) > maxx) {
							maxx = xDIV + j;
						}
						if ((xDIV + k) < min) {
							min = xDIV + j;
						}
						if ((xDIV + k) > maxx) {
							maxx = xDIV + j;
						}

					}
				}
			}
		}
		if ((maxx < p) && (Dancing_with_the_googlers.s < sMax)) {
			mm = 2;
			// maxx = xDIV;
			for (i = -1 * mm; i <= mm; i++) {
				for (j = 0; (j <= mm) && (Math.abs(i - j) <= mm); j++) {
					for (k = 0; k <= mm; k++) {
						tmp = (xDIV + k) + (xDIV + i) + (xDIV + j);
						// System.out.println("tmp = "+xDIV+" + "+ (xDIV+i)+
						// " + "+(xDIV+j));

						if ((x == tmp) && (xDIV + i >= 0) && ((xDIV + j) >= 0)
								&& ((xDIV + j) <= 10) && ((xDIV + i) <= 10)
								&& ((xDIV + k) >= 0) && ((xDIV + k) <= 10)) {
							if ((xDIV + i) > maxx) {
								maxx = xDIV + i;
							}
							if ((xDIV + i) < min) {
								min = xDIV + i;
							}
							if ((xDIV + j) < min) {
								min = xDIV + j;
							}
							if ((xDIV + j) > maxx) {
								maxx = xDIV + j;
							}
							if ((xDIV + k) < min) {
								min = xDIV + j;
							}
							if ((xDIV + k) > maxx) {
								maxx = xDIV + j;
							}
						}
					}
				}
			}
		}
		if (maxx - min >= 2)
			Dancing_with_the_googlers.s = Dancing_with_the_googlers.s + 1;
		return maxx;
	}

	public static void main(String[] args) {
		String filename = "/myown/developpement/Google_Code_Jam/Dancing_With_the_Googlers.in";
		StringTokenizer st1;
		String ligne = "";
		int T = 0, j = 0, N = 0, S = 0, p = 0, i = 0, s = 0, y = 0;
		s = 0;
		int[] t;
		try {
			FileInputStream fStream = new FileInputStream(filename);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					fStream));
			if (in.ready()) {
				ligne = in.readLine();
				T = Integer.parseInt(ligne);
				for (j = 0; j < T; j++) {
					Dancing_with_the_googlers.s = 0;
					y = 0;
					ligne = in.readLine();
					st1 = new StringTokenizer(ligne, " ");
					N = Integer.parseInt(st1.nextToken());
					S = Integer.parseInt(st1.nextToken());
					p = Integer.parseInt(st1.nextToken());
					t = new int[N];
					for (i = 0; i < N; i++) {
						t[i] = Integer.parseInt(st1.nextToken());
						
						if (max(t[i], s, S, p) >= p)
							y++;
						// System.out.println("Ligne: " + i + " = " + t[i] +
						// " = "+ max(t[i], s, S,p));
					}
					System.out.println("Case #" + (j + 1) + ": " + y);
				}
			}

		} catch (IOException e) {
			System.out.println("File input error");
		}
	}
}
