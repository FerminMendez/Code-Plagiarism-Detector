import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T, N, S, p, t, y;
		int[] min = new int[31];
		int[] max = new int[31];
		min[0] = max[0] = 0;
		max[1] = 1;
		int cont = 1;
		for (int i = 1; i < 28; i+= 3) {
			min[i] = min[i + 1] = min[i + 2] = cont++;
			max[i + 1] = max[i + 2] = max[i + 3] = cont;
		}
		min[28] = min[29] = min[30] = max[29] = max[30] = 10;
		
		
		/*for (int i = 0; i <= 30; i++)
			System.out.println("i: " + i + ", min: " + min[i] + ", max: " + max[i]);*/
		
		
		T = in.nextInt();
		for (int x = 1; x <= T; x++) {
			y = 0;
			N = in.nextInt();
			S = in.nextInt();
			p = in.nextInt();
			for (int i = 0; i < N; i++) {
				t = in.nextInt();
				if (min[t] >= p)
					y++;
				else if (S > 0 && max[t] >= p) {
					y++;
					S--;
				}
			}

			System.out.println("Case #" + x + ": " + y);
		}
	}
}
