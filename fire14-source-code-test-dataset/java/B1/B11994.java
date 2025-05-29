import java.io.File;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Recycled {
	public void calc() {
		Scanner in = null;
		PrintStream out = null;
		try {
			// in = new Scanner(new File("./A-small-attempt3.in"));
			in = new Scanner(System.in);
			out = new PrintStream(new File("./out.txt"));
		} catch (Exception e) {
			System.err.println(e);
			System.exit(-1);
		}

		int lines = in.nextInt();
		in.nextLine();
		for (int i = 0; i < lines; i++) {
			out.print("Case #");
			out.print(i + 1);
			out.print(": ");
			int b = in.nextInt();
			int e = in.nextInt();
			in.nextLine();
			int count = 0;
			Set<String> set = new HashSet<String>();
			for (int j = b; j < e; j++) {
				set.clear();
				String s = Integer.toString(j);
				for (int c = 1; c < s.length(); c++) {
					String d = s.substring(c).concat(s.substring(0, c));
					int di = Integer.parseInt(d, 10);
					if (di > j && di <= e) {
						if (!set.contains(d)) {
							set.add(d);
							count++;
						}
					}
				}
			}
			out.print(count);
			out.print('\n');
		}
		out.flush();
		out.close();
		in.close();
	}

	public static void main(String[] args) {
		Recycled g = new Recycled();
		g.calc();
	}

}
