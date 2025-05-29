import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			long output = solve(a, b);
			System.out.println("Case #" + (i + 1) + ": " + output);
		}
	}

	private static long solve(int a, int b) {
		if (b <= 10)
			return 0;
		int start = a;
		
		if(a <= 10) start = 11;
		
		int count = 0;
		Set<Integer> found = new HashSet<Integer>();
		for(int i = start; i < b; i++){
			String toshift = String.valueOf(i);
			int len = toshift.length();
			
			for(int j =1; j<len;j++){
				String shifted = shift(toshift, j);
				int v = Integer.valueOf(shifted);
				if(v <= b && v >a && i < v && !found.contains(v) && !shifted.startsWith("0")) {
					found.add(v);
					count++;
				}
			}
			found.clear();
		}
		return count;
	}

	private static String shift(String toshift, int j) {
		String pre = toshift.substring(0, j);
		String post = toshift.substring(j);
		return post.concat(pre);
	}
}
