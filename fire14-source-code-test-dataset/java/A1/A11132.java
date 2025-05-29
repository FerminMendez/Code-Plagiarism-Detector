import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GoogleDancing {
	public static void solution(String fileName) throws IOException {

		FileReader fileReader = new FileReader(new File(fileName));
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		String textLine = bufferedReader.readLine();

		int lines = Integer.parseInt(textLine);
		int[] ret = new int[lines];
		for (int i = 0; i < lines; i++) {
			textLine = bufferedReader.readLine();
			String[] t = textLine.split(" ");
			int N = Integer.parseInt(t[0]);
			int S = Integer.parseInt(t[1]);
			int p = Integer.parseInt(t[2]);
			int c = 0;
			int c1 = 0;
			int min = p * 3 - 2;
			min = min > 0 ? min : 0;
			int min1 = min - 2;
			min1 = min1 > 0 ? min1 : 0;
			for (int j = 3; j < t.length; j++) {
				int tt = Integer.parseInt(t[j]);
				if (tt == 0) {
					if (p == 0) {
						c++;
					}
					continue;
				}
				if (tt < p)
					continue;
				if (tt >= min) {
					c++;
				} else if (tt >= min1 && c1 < S) {
					c++;
					c1++;
				}
			}
			ret[i] = c;
		}
		for (int i = 0; i < ret.length; i++) {
			System.out.println("Case #" + (i + 1) + ": " + ret[i]);
		}

	}

	public static void main(String[] args) throws Exception {
		solution("c:\\sql\\B-small-attempt1(1).in");
	}
}
