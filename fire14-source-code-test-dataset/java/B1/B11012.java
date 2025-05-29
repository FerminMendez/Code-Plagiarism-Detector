import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
public class ProblemC {
	static long[] pow = new long[12];
	private static long solve(int a, int b) {
		HashMap<Integer, LinkedList<Integer>> f = new HashMap<Integer, LinkedList<Integer>>();
		long res = 0;
		for (int i = a; i <= b; i++) {
			int s = (i + "").length();
			for (int j = 1; j < s; j++) {
				int c = (int) ((i / pow[j]) + pow[s - j] * (i % pow[j]));
				if (c <= b && c >= a && c != i && (c + "").length() == s) {
					boolean k = f.containsKey(i);
					if (!k)f.put(i, new LinkedList<Integer>());
					if (f.containsKey(c))k = f.get(c).contains(i);
					if (!k) {f.get(i).add(c);res++;
					}
				}
			}
		}
		return res;
	}
	public static void main(String[] args) throws IOException {
		pow[1] = 10;
		for (int i = 2; i < 12; i++)
			pow[i] = pow[i - 1] * 10;
		Scanner input = new Scanner(new FileReader("input"));
		BufferedWriter output = new BufferedWriter(new FileWriter("output"));
		long res;
		int n = input.nextInt();
		for (int j = 1; j <= n; j++) {
			res = solve(input.nextInt(), input.nextInt());
			output.write("Case #" + j + ": " + res);
			output.newLine();
		}
		output.close();
	}
}