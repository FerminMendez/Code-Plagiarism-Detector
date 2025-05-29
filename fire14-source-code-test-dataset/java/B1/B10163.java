import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;


/**
 * @author Paul LaMotte
 *
 */
public class RecycledNumbers {

	public static void main(String[] args) {
		Scanner in;
		try {
			System.setOut(new PrintStream(new File("qualC.out")));
			in = new Scanner(new File("C-small-attempt0.in"));
			int lines = Integer.parseInt(in.nextLine());
			for (int i = 0; i < lines; i++) {
				int start = in.nextInt();
				int end = in.nextInt();
				
				int count = 0;
				for (int j = start; j <= end; j++) {
					int digits = 0;
					int num = j;
					while (num != 0) {
						digits++;
						num /= 10;
					}
					int tmp = j;
					int e = (int)Math.pow(10, digits - 1);
					HashSet<Integer> set = new HashSet<Integer>();
					for (int k = 0; k < digits - 1; k++) {
						int front = tmp % 10;
						tmp /= 10;
						tmp += front * e;
						if (tmp > j && tmp <= end && !set.contains(tmp)) {
							count++;
							set.add(tmp);
						}
					}
				}
				
				
				System.out.printf("Case #%d: %d\n", i + 1, count);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
