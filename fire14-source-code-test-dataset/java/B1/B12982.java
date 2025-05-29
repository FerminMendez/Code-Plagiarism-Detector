import java.io.*;
import java.util.*;

public class c {

	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);

		int[][] list = new int[1000][2];
		for (int i=0; i<1000; i++)
			for (int j=0; j<2; j++)
				list[i][j] = -1;

		for (int i=10; i<1000; i++) {
			fill(i,list[i]);
		}

		int numCases = stdin.nextInt();

		for (int loop=1; loop<=numCases; loop++) {

			int A = stdin.nextInt();
			int B = stdin.nextInt();

			int sum = 0;
			for (int i=A; i<=B; i++) {
				for (int j=0; j<2; j++)
					if (list[i][j] != -1 && list[i][j] <= B)
						sum++;
			}
			System.out.println("Case #"+loop+": "+sum);
		}
	}

	public static void fill(int val, int[] array) {

		if (val < 100) {

			int other = (val%10)*10 + val/10;
			if (other > val)
				array[0] = other;
		}
		else {
			int orig = val;
			int index = 0;
			for (int i=0; i<2; i++) {
				val = (val%10)*100 + val/10;
				if (val > orig) {
					array[index] = val;
					index++;
				}

			}
		}
	}
}