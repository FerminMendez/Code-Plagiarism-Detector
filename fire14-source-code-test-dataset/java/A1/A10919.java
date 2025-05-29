import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class B {

	public static void readFile() throws FileNotFoundException {
		File f = new File("B-small.in");
		Scanner in = new Scanner(f);
		PrintWriter out = new PrintWriter(new File("B-small.out"));

		int T, S, p, N;

		T = in.nextInt();
		//System.out.println(T);

		ArrayList<int[]> L = new ArrayList<int[]>();
		int found, q, r;

		for (int i = 0; i < T; i++) {
			found = 0;
			N = in.nextInt();
			//System.out.print(N + " ");
			S = in.nextInt();
			//System.out.print(S + " ");
			p = in.nextInt();
			//System.out.println(p);

			int[] totalPoints = new int[N];

			for (int j = 0; j < N; j++) {
				totalPoints[j] = in.nextInt();
				q = totalPoints[j] / 3;
				r = totalPoints[j] % 3;
				// //System.out.println(q + "--" + r);
				if (r == 0)
					L.add(new int[] { q, q, q });
				else if (r == 1)
					L.add(new int[] { q, q, q + 1 });
				else
					L.add(new int[] { q, q + 1, q + 1 });

				int lastIndex = L.size() - 1;

				if (L.get(lastIndex)[0] >= p || L.get(lastIndex)[1] >= p
						|| L.get(lastIndex)[2] >= p) {
					//System.out.println("1111111111");
					found++;
					continue;
				} else {
					if (L.get(lastIndex)[0] + L.get(lastIndex)[1]
							+ L.get(lastIndex)[2] < 3 * p - 4) {
						//System.out.println("2222222222");
						continue;
					}
					if (S > 0 && q > 1) {
						//System.out.println("333333333333");
						L.get(lastIndex)[1]--;
						L.get(lastIndex)[2]++;
						S--;
						found++;
					}
				}
				
			}
			//System.out.println("Found : " + found);
			if (i < T - 1)
				out.println("Case #"+ (i + 1) + ": " + found);
			else
				out.print("Case #"+ (i + 1) + ": " + found);
		}

		// //System.out.println(L.get(3)[0]);

		out.close();
	}

	public static void main(String[] args) throws FileNotFoundException {
		readFile();

	}

}
