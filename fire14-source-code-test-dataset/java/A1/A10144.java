import java.util.Scanner;

public class DanceWGoogle {

	public static int testcase(int S, int p, int[] arr) {
		int over = 0;
		int oneund = 0;
		int temp;
		for (int i = 0; i < arr.length; i++) {
			temp=0;
			if (arr[i] % 3 == 0) {
				temp = arr[i] / 3;
			} else {
				temp = arr[i] / 3;
				temp++;
			}
			if (temp >= p)
				over++;
			else if (temp == p - 1 && arr[i]>1)
				oneund++;
		}
		over += Math.min(S, oneund);
		return over;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		int arr[];
		for (int i = 0; i < T; i++) {
			arr = new int[scan.nextInt()];
			int S = scan.nextInt();
			int p = scan.nextInt();
			for (int a = 0; a < arr.length; a++) {
				arr[a] = scan.nextInt();
			}
			System.out.println("Case #" + (i + 1) + ": " + testcase(S, p, arr));
		}
	}
}