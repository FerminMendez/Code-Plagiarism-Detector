import java.util.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

public class B {
	static Scanner fin = null;
	static PrintWriter fout = null;
	static String fname = "B-small";

	public static void main (String[] args) throws IOException {
		try {
			fin = new Scanner(System.in);
			fout = new PrintWriter(new FileWriter(fname + ".out"));

			int T = fin.nextInt();
			String s0 = fin.nextLine();

			for (int i = 1; i <= T; i++) {
				String s = fin.nextLine();
				String tokens[] = s.split(" ");
				int scores = Integer.parseInt(tokens[0]);
				int suprising = Integer.parseInt(tokens[1]);
                int target = Integer.parseInt(tokens[2]);
                int ok = 0;
                int possible = 0;
                for (int j = 0; j < scores; j++) {
                    int cur = Integer.parseInt(tokens[3 + j]);
                    if (cur >= target + 2 * Math.max(target - 1, 0)) {
                        ok++;
                    } else if (cur >= target + 2 * Math.max(target - 2, 0)) {
                        possible++;
                    }
                }

				System.out.println("Case #" + i + ": " + (ok + Math.min(suprising, possible)));
			}
		} finally {
			fin.close();
			fout.close();
		}
	}
}
