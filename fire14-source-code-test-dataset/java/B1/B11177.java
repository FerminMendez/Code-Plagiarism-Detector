import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class RecycleNumber {
	public static void solution(String fileName) throws IOException {

		FileReader fileReader = new FileReader(new File(fileName));
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		String textLine = bufferedReader.readLine();

		int lines = Integer.parseInt(textLine);
		int[] ret = new int[lines];
		for (int i = 0; i < lines; i++) {
			textLine = bufferedReader.readLine();
			String[] t = textLine.split(" ");
			if (t.length < 2) {
				ret[i] = 0;
				continue;
			}
			long start = Long.parseLong(t[0]);
			long end = Long.parseLong(t[1]);
			int c = 0;
			for (long j = start; j < end; j++) {
				if (start < 10)
					break;
				c += getNumber(Long.toString(j), start, end);
			}
			ret[i] = c;
		}
		for (int i = 0; i < ret.length; i++) {
			System.out.println("Case #" + (i + 1) + ": " + ret[i]);
		}
	}

	public static int getNumber(String n, long s, long e) {
		int ret = 0;
		String t = n;
		long lo = Long.parseLong(n);
		HashSet<String> map = new HashSet<String>();
		for (int i = 1; i < n.length(); i++) {
			t = n.substring(i) + n.substring(0, i);
			String ts = n+";"+t;
			if (map.contains(ts)) continue;
			else map.add(ts);
			long l = Long.parseLong(t);
			if (l <= e && l >= s && lo < l)
				ret++;
		}

		return ret;
	}

	public static void main(String[] args) throws Exception {
		solution("c:\\sql\\C-small-attempt0.in");
	}
}
