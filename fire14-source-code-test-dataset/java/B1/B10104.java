import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecycledNumber {

	public static void main(String[] args) {
		List<Integer> results = new ArrayList<>();
		int A, B;

		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		System.out.println();
		for (int i = 0; i < t; i++) {
			String line = in.nextLine();
			A = Integer.parseInt(line.split(" ")[0]);
			B = Integer.parseInt(line.split(" ")[1]);
			results.add(check(A, B));
		}

		System.out.println("Output");
		for (int i = 0; i < results.size(); i++) {
			System.out.println("Case #" + (i + 1) + ": " + results.get(i));
		}
	}

	public static int check(int A, int B) {
		int count = 0;
		List<Integer> M = new ArrayList<>();
		List<Integer> N = new ArrayList<>();
		for (int i = A; i <= B; i++) {
			N.add(i);
			M.add(i);
		}
		for (int i = 0; i < N.size(); i++) {
			String nn = N.get(i) + "";
			int n = Integer.parseInt(nn);
			for (int x = 1; x <= nn.length(); x++) {
				String sufix = nn.substring(0, x);
				String prefix = nn.substring(x);
				int newNum = Integer.parseInt(prefix + sufix);
				for (int j = 0; j < M.size(); j++) {
					int m = M.get(j);
					if (A <= n && n < m && newNum == m && m <= B) {
						count++;
					}
				}
			}
		}
		return count;
	}
}
