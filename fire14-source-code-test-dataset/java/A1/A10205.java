package qualification.problemB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProblemB {

	static int num;
	static String[] lines;

	static String dir = "./src/qualification/problemB";
	static String inTxt = dir + "/B-small-attempt1.in";
	static String outTxt = dir + "/B-small-attempt1.out";
//	static String inTxt = dir + "/ex_probb.txt";
//	static String outTxt = dir + "/ex_probb_ans.txt";

	public static void main(String[] args) {
		input(inTxt);
		String[] ansStrs = new String[num];
		for (int i = 0; i < lines.length; i++) {
			String[] strs = lines[i].split("\\s");
			int[] nums = new int[strs.length];
			for (int j = 0; j < strs.length; j++) {
				nums[j] = Integer.valueOf(strs[j]);
			}
			int ans = solve(nums[0], nums[1], nums[2], Arrays.copyOfRange(nums, 3, nums.length));
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

	public static int solve(int num, int sup, int better, int[] scores) {
		int count = 0;
		for (int i = 0; i < num; i++) {
			int score = scores[i] - better;
			if (2 * better <= score) {
				count++;
			} else if (1 <= better && 2 * (better - 1) <= score) {
				count++;
			} else if (2 <= better && 0 < sup && 2 * (better - 2) <= score) {
				count++;
				sup--;
			}
		}
		return count;
	}
}
