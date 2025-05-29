import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tt = 1; tt <= t; tt++) {
			int n = sc.nextInt();
			int s = sc.nextInt();
			int p = sc.nextInt();
			int v[] = new int[n];
			for (int i = 0; i < n; i++) {
				v[i] = sc.nextInt();
			}
			int c = 0;
			int vx[][] = new int[n][3];
			for (int i = 0; i < n; i++) {
				int x[] = new int[3];
				x[0] = x[1] = x[2] = v[i] / 3;
				if (v[i] != x[0] + x[1] + x[2]) {
					x[2]++;
				}
				if (v[i] != x[0] + x[1] + x[2]) {
					x[1]++;
				}
				vx[i] = x;
			}
			for (int i = 0; i < n; i++) {
				if (vx[i][0] >= p || vx[i][1] >= p || vx[i][2] >= p) {
					c++;
				} else {
					if (v[i] >= 2 && v[i] <= 28 && s != 0) {
						if (vx[i][1] == vx[i][2]) {
							vx[i][1]--;
							vx[i][2]++;
							if (vx[i][0] >= p || vx[i][1] >= p || vx[i][2] >= p && (vx[i][0] >= 0 && vx[i][1] >= 0 && vx[i][2] >= 0)) {
								c++;
								s--;
							}
						} else if (vx[i][0] == vx[i][1]) {
							vx[i][0]--;
							vx[i][1]++;
							if (vx[i][0] >= p || vx[i][1] >= p || vx[i][2] >= p && (vx[i][0] >= 0 && vx[i][1] >= 0 && vx[i][2] >= 0)) {
								c++;
								s--;
							}
						}
					}
				}
//				System.out.println(p + " " + c + " " + v[i] + " " + vx[i][0] + " " + vx[i][1] + " " + vx[i][2]);
			}
			System.out.println("Case #" + tt + ": " + c);
		}
	}

}
//WA