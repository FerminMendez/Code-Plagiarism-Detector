import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class RecycledNumbers {
	static class Pair {
		public int n;
		public int m;
		public Pair(int n, int m) {
			this.n = n;
			this.m = m;
		}
	}
	public static void main(String[] args) throws IOException {
		recycleNumbers(new BufferedReader(new FileReader("C-small-attempt2.in")), new BufferedWriter(new FileWriter("out.txt")));
	}
	
	public static void recycleNumbers(BufferedReader in, BufferedWriter out) throws IOException {
		String line = in.readLine(); // we don't care about num test cases
		int caseNum = 1;
		
		while ((line = in.readLine()) != null && line.length() != 0 ) {
			String result = "Case #" + caseNum + ": ";
			String[] lineDetails = line.split(" ");
			int n = Integer.parseInt(lineDetails[0]);
			int m = Integer.parseInt(lineDetails[1]);
			int recyclablePairs = 0;
			//boolean test = false;
			//if (n == 747 && m == 789) {
			//	test = true;
			//}
																// 12345, 34512
			
			String cheat = Integer.valueOf(n).toString();
			int zeroes = cheat.length()-1;
			int mask = (int) Math.pow(10, zeroes);
			//int mask = 1;
			//while (((mask*10) / n) <= 1) {
			//	mask *= 10;
			//}
			
			
			//int zeroes = (int) Math.log10(mask);
			

			//if (test) {
			//	System.out.println("mask is " + mask + ", zeroes is " + zeroes);
			//}
			
			for (int i = n; i < m; i++) {
				for (int j = i + 1; j <= m; j++) {
					int lhs = i;								// 
					int rhs = j;								// 2100
					for (int k = 0; k < zeroes; k++) {
						int head = lhs % 10;					// 5		4
						int tail = lhs / 10;					// 1234		5123
						lhs = (head * mask) + tail;				// 51234	45123	


						//if (test) {
						//	System.out.println("head is " + head + ", tail is " + tail + ", lhs is " + lhs);
						//}
						if (lhs == rhs) {


							//if (test) {
							//	System.out.println("i is " + i + ", j is " + j);
							//}
							recyclablePairs++;
							break;
						}
					}
				}
			}
			result += recyclablePairs;
			out.write(result);
			out.newLine();
			caseNum++;
		}
		in.close();
		out.close();
	}
}
