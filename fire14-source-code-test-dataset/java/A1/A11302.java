import java.util.Scanner;
public class B {
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();
		for(int j = 1; j<T+1; j++) {
			int N = scanner.nextInt();
			int S = scanner.nextInt();
			int p = scanner.nextInt();
			int minS = p>2? (p-2)*2+p : p;
			int min = p>1? (p-1)*2+p : p;
			int total = 0;
			for(int i = 0; i<N; i++) {
				int t = scanner.nextInt();
				if(t >= min) total++;
				else {
					if(t >= minS && S > 0) {
						total++; S--;
					}
				}
			}
			System.out.println("Case #" + j + ": " + total);
			scanner.nextLine();
		}
    }
}
