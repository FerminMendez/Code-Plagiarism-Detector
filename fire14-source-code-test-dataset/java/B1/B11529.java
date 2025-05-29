import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class RecNum {

	public static void main(String[] args) throws Exception {
		// long start = System
		String filename = "D:\\Hardik\\workspace\\CodeJam\\C-small-attempt2.in";
		FileInputStream file = new FileInputStream(filename);
		DataInputStream in = new DataInputStream(file);
		int testCases = Integer.parseInt(in.readLine());
		FileOutputStream fos = new FileOutputStream(
				"D:\\Hardik\\workspace\\CodeJam\\Output.txt");
		int a, b;
		int caseNo = 1;
		String output = "";
		while (testCases > 0) {
			String input = in.readLine();
			String nu[] = input.split(" ");
			a = Integer.parseInt(nu[0]);
			b = Integer.parseInt(nu[1]);
			testCases--;
			output += "Case #" + Integer.toString(caseNo++) + ": "
					+ Integer.toString(solve(a, b)) + "\n";
		}
		fos.write(output.getBytes());
		fos.close();
		file.close();
	}

	public static int solve(int a, int b) {
		int output = 0;
		for (int i = a; i <= b; i++) {
			for (int j = a; j <= b; j++) {
				if (isRecycledNumber(i, j)) {
					output++;
					j += 5;
				}
			}
		}
		return (output / 2);
	}

	public static boolean isRecycledNumber(int number1, int number2) {
		String n1 = Integer.toString(number1), n2 = Integer.toString(number2);
		if (number1 < 10) {
			return false;
		}
		if (n1.length() != n2.length()) {
			return false;
		}
		if (number1 == number2) {
			return false;
		}
		for (int i = 1; i <= n1.length(); i++) {
			for (int j = 1; j <= n2.length(); j++) {
				String n3, n4, n5, n6;
				n3 = n1.substring(0, i);
				n4 = n1.substring(i, n1.length());
				n5 = n2.substring(0, j);
				n6 = n2.substring(j, n2.length());
				int num1, num2, num3, num4;
				num1 = Integer.parseInt(n3 + n4);
				num2 = Integer.parseInt(n4 + n3);
				num3 = Integer.parseInt(n5 + n6);
				num4 = Integer.parseInt(n6 + n5);
				if (num1 == num3)
					return true;
				else if (num1 == num4)
					return true;
				if (num2 == num3)
					return true;
				else if (num2 == num4)
					return true;
			}
		}
		return false;
	}

}