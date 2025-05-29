import java.util.Scanner;


public class RecycledNumbers {
	
	static int recycle(int n, int B) {
		String nString = String.valueOf(n);
		
		int out = 0;

		for (int i = 0; i < nString.length(); i++) {
			int cut = nString.length() - (i + 1);
			String temp = nString.substring(cut) + nString.substring(0, cut);
			
			int pair = Integer.parseInt(temp);
				
			if (n < pair && pair <= B) {
				//System.out.println(n + " " + pair);
				out++;
			}
		}
		
		return out;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cases = sc.nextInt();
		
		StringBuilder out = new StringBuilder();
		for (int i = 1; i <= cases; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			int pairs = 0;
			
			for (int j = A; j < B; j++) {
				pairs += recycle(j, B);
			}
			
			out.append("Case #" + i + ": " + pairs + "\n");
		}
		
		System.out.print(out);
	}
}
