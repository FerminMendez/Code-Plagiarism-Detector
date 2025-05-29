package qualification.problemC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class ProblemC {

	static int num;
	static String[] lines;

	static String dir = "./src/qualification/problemC";
	static String inTxt = dir + "/C-small-attempt0.in";
	static String outTxt = dir + "/C-small-attempt0.out";

	public static void main(String[] args) {
		input(inTxt);
		String[] ansStrs = new String[num];
		for (int i = 0; i < lines.length; i++) {
			String[] strs = lines[i].split("\\s");
			int[] nums = new int[strs.length];
			for (int j = 0; j < strs.length; j++) {
				nums[j] = Integer.valueOf(strs[j]);
			}
			// Solve Problem
			int ans = solve(nums[0], nums[1]);
			ansStrs[i] = String.valueOf(ans);
		}
		output(outTxt, ansStrs);
	}

	static void input(String fname) {
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(fname)));
			String line = br.readLine();
			num = Integer.valueOf(line);
			System.out.println(num);
			lines = new String[num];
			for (int i = 0; i < num; i++) {
				lines[i] = br.readLine();
				System.out.println(lines[i]);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	static void output(String fname, String[] output) {
		File outFile = new File(fname);
		try {
			FileWriter fw = new FileWriter(outFile);
			for (int i = 0; i < num && i < output.length; i++) {
				String out = "Case #"+(i+1)+ ": " + output[i] + '\n';
				System.out.print(out);
				fw.write(out);
				fw.flush();
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int solve(int min, int max) {
		int count = 0;
		char maxFirst = String.valueOf(max).charAt(0);
		for (int i = Math.max(10, min); i < max; i++) {
			String num = String.valueOf(i);
			char first = num.charAt(0);
			Set<Integer> set = new HashSet<Integer>();
			for (int j = 1; j < num.length(); j++) {
				char newFirst = num.charAt(j);
				if (newFirst < first || maxFirst < newFirst)
					continue;
				String tmp = num.substring(0, j);
				int newNum = Integer.valueOf(num.substring(j) + tmp);
				if (i < newNum && newNum <= max) {
					//System.out.println(num + ", " + newNum);
					set.add(newNum);
				}
			}
			count += set.size();
		}
		return count;
	}
}
