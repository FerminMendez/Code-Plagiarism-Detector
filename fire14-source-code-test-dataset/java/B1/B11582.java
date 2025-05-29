import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class RecycledNumbers {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("input"));
		int cases = scan.nextInt();
		
		for (int i = 1; i <= cases; i++) {
			int A = scan.nextInt();
			int B = scan.nextInt();
			
			int numDigits = (int) (Math.log(A) / Math.log(10)) + 1;
			
			int digits[] = new int[numDigits];
			
			int tmp = A;
			
			for (int j = numDigits-1; j >= 0; j--) {
				digits[j] = tmp % 10; 
				tmp /= 10;
			}
			
			int recycled = 0;
			
			for (int j = A; j <= B; j++) {
				int val = j;
				for (int k = 0; k < numDigits; k++) {
					int temp = val % 10;
					val = (val / 10) + (temp * ((int) Math.pow(10, numDigits-1)));
					
					if (val == j) {
						break;
					}
					
					if (val >= A && val <= B && val > j) {
						recycled++;
					}
				}
			}
			
			System.out.println("Case #" + i + ": " + recycled);
		}
	}

}
