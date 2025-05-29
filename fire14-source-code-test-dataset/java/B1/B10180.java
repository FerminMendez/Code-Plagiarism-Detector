import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class RecycledPairs {
	public static void main(String [] args) throws IOException {
		Scanner fileScan = new Scanner(new File("C-small-attempt0.in"));
		BufferedWriter out = new BufferedWriter(new FileWriter("C-small-attempt0.out"));
		
		int N = Integer.parseInt(fileScan.nextLine());
		for (int i = 0; i < N; i++) {
			int A = fileScan.nextInt();
			int B = fileScan.nextInt();
			int numPairs = 0;
			
			int numDigits = 0;
			int temp = A;
			while (temp > 0) {
				numDigits++;
				temp /= 10;
			}
			
			for (int n = A; n <= B; n++) {
				int check = 0;
				for (int j = 1; j < numDigits; j++) {
					int m = (int) (n/Math.pow(10, j) + (n%Math.pow(10, j))*Math.pow(10, numDigits-j));
					if (m > n && m <= B && m != check) {
						numPairs++;
						check = m;
					}
				}
			}
			
			int printTemp = i + 1;
			out.write("Case #" + printTemp + ": " + numPairs + "\n");
		}
		
		out.close();
	}
}
