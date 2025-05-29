import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class B {

	public static void main(String[] args) throws NumberFormatException, IOException {
		File file = new File(args[0]);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		PrintStream printer = new PrintStream(new File("B-small.txt"));

		int t = Integer.parseInt(reader.readLine());
		for (int i = 0; i < t; i++) {
			String sa = reader.readLine();
			String[] nums = sa.split(" ");
			// int n = Integer.parseInt(nums[0]);
			int s = Integer.parseInt(nums[1]);
			int p = Integer.parseInt(nums[2]);
			int cs = 0;
			int ans = 0;
			for (int j = 3; j < nums.length; j++) {
				int a = Integer.parseInt(nums[j]);
				if (isP(a, p)) {
					if (isSurprising(a, p)) {
						// not taking care of the scenario where 
						// mandate surprising are less than 's'
						// as the question confims there will atleast
						// be s ts that can be surprising
						cs++;
						if (cs > s)
							continue;
						ans++;
					}
					else
						ans++;
				}
			}
			printer.println("Case #" + (i+1) + ": " + ans);
		}
		printer.close();
		reader.close();
	}

	static boolean isSurprising(int a, int p) {
		if (((a - p) / 2) >= p)
			return false;
		if (Math.abs(p - ((a - p) / 2)) == 2)
			return true;
		return false;
	}
	
	static boolean isP(int a, int p) {
		if (a < p)
			return false;
		if (((a - p) / 2) >= p)
			return true;
		if (Math.abs(p - ((a - p) / 2)) <= 2)
			return true;
		return false;
	}
}
