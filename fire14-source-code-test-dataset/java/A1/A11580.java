import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Googlers {
	public static void main(String args[]) {
		try {
			File file = new File("input.txt");
			FileReader filereader = new FileReader(file);
			BufferedReader br = new BufferedReader(filereader);

			File out = new File("output.txt");
			FileWriter filewriter = new FileWriter(out);
			BufferedWriter bw = new BufferedWriter(filewriter);
			PrintWriter pw = new PrintWriter(bw);

			String str = br.readLine();
			int line = Integer.valueOf(str);
			for (int i = 0; i < line; i++) {
				int x = i + 1;
				pw.print("Case #" + x + ": ");
				str = br.readLine();
				int ans = solve(str);
				pw.println(ans);
			}
			pw.close();
			bw.close();

		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}

	private static int solve(String s) {
		int count = 0;
		String[] elems = s.split(" ");
		int N = Integer.valueOf(elems[0]);
		int S = Integer.valueOf(elems[1]);
		int p = Integer.valueOf(elems[2]);

		for (int i = 3; i < N + 3; i++) {
			int score = Integer.valueOf(elems[i]);
			int q = score / 3;
			int mod = score % 3;
			if (q >= p) {
				count++;
			} else if ((mod == 0 && q + 1 >= p) && (S > 0 && score >= q + 1)) {
				count++;
				S--;
			} else if ((mod == 1 && q + 1 >= p) && (score >= q + 1)) {
				count++;
			} else if ((mod == 2 && q + 1 >= p) && (score >= q + 1)) {
				count++;
			} else if ((mod == 2 && q + 2 >= p) && (S > 0 && score >= q + 2)) {
				count++;
				S--;
			}
		}
		return count;

	}
}
