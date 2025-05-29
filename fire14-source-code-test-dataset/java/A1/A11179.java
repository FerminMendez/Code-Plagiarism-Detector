import java.util.Scanner;

public class Googlers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		for (int x = 0; x < cases; x++) {
			sc.nextLine();
			int n = sc.nextInt();
			int s = sc.nextInt();
			int p = sc.nextInt();
			int posibles = 0;
			for (int i = 0; i < n; i++) {
				int ti = sc.nextInt();
				if (ti < p)
					continue;
				//if (ti == 3 * p || ti == 3 * p - 1 || ti == 3 * p - 2)
				if (ti >= 3 * p - 2)
					posibles++;
				else if (s > 0 && (ti >= 3 * p - 4)) {
					posibles++;
					s--;
				}
			}
			System.out.println("Case #" + (x+1) + ": " + posibles);
		}
	}
}
