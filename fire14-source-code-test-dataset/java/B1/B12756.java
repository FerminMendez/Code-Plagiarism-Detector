import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(args[0]));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int t = Integer.parseInt(scanner.nextLine());
		int count;
		int min, max;
		for (int i = 1; i <= t; i++) {
			count = 0;
			min = scanner.nextInt();
			max = scanner.nextInt();
			for (int j = min; j <= max; j++) {
				for (int k = j+1; k <= max; k++) {
					if (isRecycled(j, k)) {
						count++;
					}
				}
			}
			System.out.println("Case #"+i+": " + count);
		}
	}
	
	private static boolean isRecycled(int n, int m) {
		boolean flag = false;
		char[] na = String.valueOf(n).toCharArray();
		char[] ma = String.valueOf(m).toCharArray();
		if (na.length == ma.length && na[0] != '0' && ma[0] != '0') {
			if (sum(na) == sum(ma)) {
				char tmp;
				for (int i = 0; !flag && i < na.length; i++) {
					tmp = na[na.length-1];
					System.arraycopy(na, 0, na, 1, na.length-1);
					na [0] = tmp;
					if (Arrays.equals(na, ma)) {
						flag = true;
					}
				}
			}
		}
		return flag;
	}
	
	private static int sum(char[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

}
