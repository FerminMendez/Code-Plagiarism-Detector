/*
 * @author Magix.Lu
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RecycledNum {
	public static void main(String[] args) throws IOException {
		Scanner scanInput = new Scanner(System.in);
		String target = scanInput.next();

		File inputFile = new File(target);
		Scanner fileScan = new Scanner(inputFile);

		String outpFileName = "output.txt";
		FileWriter googlewriter = null;
		googlewriter = new FileWriter(outpFileName);

		PrintWriter diskFile = new PrintWriter(googlewriter);

		int count = fileScan.nextInt();
		int min = 0;
		int max = 0;
		int len = 0;

		int a = 0;
		int b = 0;

		int counter = 0;

		for (int i = 0; i < count; i++) {
			min = fileScan.nextInt();
			max = fileScan.nextInt();

			a = min;
			len = Integer.toString(a).length();
			counter = 0;

			if (len == 1) {
				diskFile.print("Case #" + (i + 1) + ": " + counter + "\n");

				System.out.println(counter);
			} else {
				while (a <= max) {
					b = a;
					String num = Integer.toString(b);

					for (int j = 0; j < len - 1; j++) {

						if (len == 2) {
							String result = Character.toString(num.charAt(1))
									+ num.charAt(0);

							num = result;
							b = Integer.parseInt(result);
						}

						else {

							String front = Character.toString(num.charAt(num
									.length() - 1));
							String behind = num.substring(0, num.length() - 1);

							String result = front + behind;

							num = result;
							b = Integer.parseInt(num);
						}

						if (min <= a && a < b && b <= max) {
							counter++;
							System.out.println(a + "	" + b);
						}

					}

					a++;
				}
				diskFile.print("Case #" + (i + 1) + ": " + counter + "\n");
				System.out.println(counter);
			}
		}

		diskFile.close();

	}

}
