import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Third {

	int left;
	int right;
	int[][] working;

	public Third(int left, int right) {
		this.left = left;
		this.right = right + 1;

	}

	public static void main(String[] args) throws IOException {

		List<String> result = new ArrayList<>();

		List<String> input = FileRW.readFile("input.txt");

		for (String inp : input) {
			String[] range = inp.split(" ");
			result.add(new Third(Integer.valueOf(range[0]), Integer.valueOf(range[1])).process());
		}
		
		FileRW.writeOutput("output.txt", result);
	}

	public String process() throws IOException {

		int total = right - left;

		working = new int[total][total];

		for (int i = 0; i < working.length; i++) {
			char[] cur = deriveArr(left + i);
			for (int j = i + 1; j < working.length; j++) {
				char[] next = deriveArr(left + j);
				if (next.length > cur.length) {
					working[i][j] = -1;
					break;
				}
				if (compare(cur, next)) {
					working[i][j] = 1;
					working[j][j] = -1;
				}
			}
		}
		int result = 0;

		for (int i = 0; i < working.length; i++) {
			// if (working[i][i] == -1) {
			// continue;
			// }
			int j = i + 1;
			while (j < working[i].length && working[i][j] != -1) {
				result += working[i][j];
				j++;
			}
		}

		return "" + result;
	}

	public boolean compare(char[] cur, char[] next) {
		int start = findIndex(cur[0], next, -1);
		outer: while (start != -1) {
			int loop = start;
			for (int i = 0; i < cur.length; i++) {
				if (loop >= cur.length) {
					loop = 0;
				}
				if (cur[i] != next[loop]) {
					start = findIndex(cur[0], next, start);
					continue outer;
				}
				loop++;
			}
			return true;
		}
		return false;
	}

	private int findIndex(char c, char[] next, int from) {
		for (int i = from + 1; i < next.length; i++) {
			if (c == next[i]) {
				return i;
			}
		}
		return -1;
	}

	public char[] deriveArr(int i) {
		char[] digits = String.valueOf(i).toCharArray();
		return digits;
	}
}
