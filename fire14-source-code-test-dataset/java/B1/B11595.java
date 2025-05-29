import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.Character.Subset;
import java.util.ArrayList;
import java.util.HashMap;

public class recyling_numbers {

	static ArrayList<Integer> superset = new ArrayList<Integer>();


	public static int[] range(int start, int end, int increment) {

		int[] values = new int[Math.abs((end - start) / increment) + 1];
		boolean reverse = start > end;

		for (int i = start, index = 0; reverse ? (i >= end) : (i <= end); i += increment, ++index) {
			values[index] = i;
		}
		return values;
	}

	private Exception IllegalArgumentException() {

		return null;
	}

	

	public static int get_solution(int A, int B) {
		superset = new ArrayList<Integer>();
		int count = 0;
		String seeds[] = new String[B - A + 1];
		
		for (int i = A, n = 0; n < seeds.length; i++, n++) {
			seeds[n] = Integer.toString(i);
		
		}

		for (int i = 0; i < seeds.length; i++) {
			count += binomial(CircularStringShift(seeds[i], A, B));
		}

		return count;
	}

	public static int CircularStringShift(String s, int lowerLimit,
			int upperLimit) {
		String tmp = s;
		char ph = ' ';
		int count = 0;
		int tmp2;

		for (int i = 0; i < s.length(); i++) {
			ph = tmp.charAt(0);
			tmp = tmp.substring(1, tmp.length()) + ph;
			tmp2 = Integer.parseInt(tmp);
			if (!superset.contains(tmp2) && tmp2 >= lowerLimit
					&& tmp2 <= upperLimit && tmp != s) {
				count++;
				superset.add(tmp2);
			}

		}

		return count;
	}

	static long binomial(int n) {

		
		return ((n - 1) * (n) / 2);
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		FileInputStream inFile = new FileInputStream(
				new File(
						"C:\\Users\\ruzbeh\\Downloads\\C-small-attempt0.in"));
		DataInputStream br = new DataInputStream(inFile);
		FileOutputStream outFile = new FileOutputStream(new File("out.in"));
		DataOutputStream out = new DataOutputStream(outFile);

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String[] str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			out.writeBytes("Case #" + (i + 1) + ": " + get_solution(a, b));
			out.writeBytes("\n");

		}
	}

}