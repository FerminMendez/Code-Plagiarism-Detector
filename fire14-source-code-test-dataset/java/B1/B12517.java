
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Recycled_Numbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {

			Scanner sc = new Scanner(new File("C-small-attempt0.in"));
			int caseNo = sc.nextInt();
			FileWriter fstream = new FileWriter("C-small-attempt0.out");
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
				System.out.println("test");
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

	private static boolean isValidPermutation(int num1, int num2) {
		boolean result = false;
		int noOfMatches = 0;
		int currentPointToBegin = -1;
		int temp = num2 % 10;

		int[] arr1 = getDigitsInArray(num1);

		for(int i = 0; i < arr1.length; i++) {
			if(arr1[i] == temp) {
				noOfMatches++;
				if(currentPointToBegin == -1) {
					currentPointToBegin = i;
				}
			}
		}

		int temp2 = num2;

		while(temp2 > 0) {
			if(noOfMatches > 0) {
				noOfMatches--;
				for(int i = 0; i < arr1.length; i++) {
					
				}
			}
		}

		return result;
	}

	private static int[] getDigitsInArray(int num) {
		int i = getNoOfDigits(num);
		int[] arr = new int[i];
		while(num > 0) {
			arr[i - 1] = num % 10;
			num /= 10;
			i--;
		}
		return arr;
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
