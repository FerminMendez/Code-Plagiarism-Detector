import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Anvesh
 *
 */
public class C {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {

			Scanner sc = new Scanner(System.in);
			int caseNo = sc.nextInt();
			FileWriter fstream = new FileWriter("C:/Users/Anvesh/Desktop/out.txt");
			BufferedWriter out = new BufferedWriter(fstream);

			for(int i = 1; i <= caseNo; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int recyclableNo = 0;
				int start;
				int end;

				if(a > b) {
					end = a;
					start = b;
				} else {
					end = b;
					start = a;
				}

				for(int j = start; j <= end; j++) {
					for(int k = end; k > j; k--) {
						if(isPermutation(j, k)) {
							if(isEquivalent(j, k)) {
								recyclableNo++;
							}
						}
					}
				}

				System.out.println("Case #" + i + ": " + recyclableNo);



				out.write("Case #" + i + ": " + recyclableNo);
				out.newLine();

			}

			//Close the output stream
			out.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static int getNoOfDigits(long num) {
		int digitCount = 0;
		while(num > 0) {
			num /= 10;
			digitCount++;
		}
		return digitCount;
	}

	private static boolean isPermutation(int num1, int num2) {
		boolean result = false;
		int[] arr = new int[10];

		int temp = num2;
		while (temp > 0) {
			arr[temp % 10]++;
			temp /= 10;
		}

		temp = num1;
		while (temp > 0) {
			arr[temp % 10]--;
			temp /= 10;
		}


		for (int i = 0; i < 10; i++) {
			if (arr[i] != 0) {
				result = true;                
			}
		}

		return !result;
	}

	private static boolean isEquivalent(int num1, int num2) {
		boolean result = false;
		int rem;
		int digitNo = getNoOfDigits(num1);
		for(int i = 0; i < digitNo; i++) {
			if(num1 == num2) { 
				result = true;
				break;
			}
			rem = num1 % 10;
			num1 /= 10;
			num1 += rem * Math.pow(10, digitNo - 1);
		}
		return result;
	}
}
