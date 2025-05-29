package cat.aubricoc.codejam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class DancingWithTheGooglers {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new FileReader(ClassLoader.getSystemResource("in.txt").getFile()));
		PrintWriter out = new PrintWriter(new File("C:/esilog/codejam/dancing-with-the-googlers/src/main/resources/out.txt"));
		int num = Integer.parseInt(in.readLine().trim());
		for (int iter = 0; iter < num; iter++) {
			String line = in.readLine();
			Integer sol = calculate(line);
			out.println("Case #" + (iter + 1) + ": " + sol);
		}
		in.close();
		out.flush();
		out.close();
	}

	private static Integer calculate(String line) {
		int n = 0;
		String[] nums = line.split(" ");
		int numGooglers = Integer.parseInt(nums[0].trim());
		int numSurpises = Integer.parseInt(nums[1].trim());
		int punts = Integer.parseInt(nums[2].trim());
		
		for (int iter = 0; iter < numGooglers; iter++) {
			int score = Integer.parseInt(nums[3 + iter].trim());
			int mid = score / 3;
			int res = score % 3;
			if (mid >= punts) {
				n++;
			} else {
				int diff = punts - mid;
				if (res == 0 && diff == 1 && numSurpises > 0 && mid > 0) {
					n++;
					numSurpises--;
				} else if (res == 1 && diff == 1) {
					n++;
				} else if (res == 2) {
					if (diff == 1) {
						n++;
					} else if (diff == 2 && numSurpises > 0) {
						n++;
						numSurpises--;
					}
				}
			}
		}
		
		return n;
	}
}
