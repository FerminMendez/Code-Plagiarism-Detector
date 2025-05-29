package qualification2012;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class RecycledNumbers {

	static int rotationCount(int x, int lower) {
		String s = String.valueOf(x);
		List<Integer> rotations = new ArrayList<Integer>();
		for (int i = 1; i < s.length(); i++)
			if (s.charAt(i) != '0') {
				int r = Integer.parseInt(s.substring(i) + s.substring(0, i));
				if(r >= lower && r < x && !rotations.contains(r))
					rotations.add(r);
			}
		return rotations.size();
	}

	static int solve(int A, int B) {
		int result = 0;
		for (int x = A + 1; x <= B; x++)
			result += rotationCount(x, A);
		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(args[0]));
		PrintWriter writer = new PrintWriter(args[1]);
		int ntests = Integer.parseInt(reader.readLine());
		for (int test = 0; test < ntests; test++) {
			String[] fields = reader.readLine().split(" ");
			int A = Integer.parseInt(fields[0]);
			int B = Integer.parseInt(fields[1]);
			writer.println("Case #" + (test + 1) + ": " + solve(A,B));
			writer.flush();
		}
		writer.close();
	}

}
