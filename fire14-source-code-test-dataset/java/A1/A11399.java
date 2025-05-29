import java.util.*;

class ProbB {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder out = new StringBuilder();
		int numCases = in.nextInt();
		for(int count = 1; count <= numCases; ++count) {
			out.append("Case #" + count + ": ");
			int n = in.nextInt();
			int numSurp = in.nextInt();
			int p = in.nextInt();
			int ans = 0;
			int possible = 0;
			int num = 0;
			for(int i = 0; i < n; ++i) {
				num = in.nextInt();
				if(num < p) {
					continue;
				}
				num = num - p;
				num = num / 2;
				if(num >= p-1) {
					++ans;
				}
				else if(num >= p-2) {
					if(numSurp > 0) {
						++ans;
						--numSurp;
					}
				}
				else {
					continue;
				}
			}
			out.append(ans + "\n");
		}
		System.out.println(out);
	}
}