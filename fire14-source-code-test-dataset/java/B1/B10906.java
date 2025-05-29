import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		new Main().go(args);
	}

	void go(String[] args) throws NumberFormatException, IOException {
		short n;// no of test cases
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File(args[0]))));
		BufferedWriter bufferedWriter = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(new File(args[1]))));
		n = Short.parseShort(bufferedReader.readLine());
		for (short i = 0; i < n; i++) {
			String input = bufferedReader.readLine();
			StringBuffer output = new StringBuffer();
			// Main logic is here
			perform(input, output);
			bufferedWriter.write("Case #" + (i + 1) + ": " + output.toString()
					+ "\n");
			bufferedWriter.flush();
		}
		bufferedReader.close();
		bufferedWriter.close();
	}

	private void perform(String input, StringBuffer output) {
		// TODO Auto-generated method stub
		String[] split = input.split(" ");
		int A = Integer.parseInt(split[0]);
		int B = Integer.parseInt(split[1]);
		if (A < 10 || B < 10) {
			output.append(0);
			return;
		}
		List<Pair> recycledPairs = new ArrayList<Pair>();
		for (int i = A; i <= B; i++) {
			String n = new Integer(i).toString();
			for (int j = 1; j < n.length(); j++) {
				String m = rotate(n, j);
				if (!n.equals(m) && !m.startsWith("0")
						&& Integer.parseInt(m) >= A && Integer.parseInt(m) <= B) {
					Pair pair = new Pair(n, m);
					if (!recycledPairs.contains(pair))
						recycledPairs.add(pair);
				}
			}
		}
		output.append(recycledPairs.size());
	}

	private String rotate(String n, int i) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		int iterations = 0;
		while (iterations < n.length()) {
			buffer.append(n.charAt(i));
			i = (i + 1) % n.length();
			iterations++;
		}
		return buffer.toString();
	}

	class Pair {
		String n;
		String m;

		public Pair(String n, String m) {
			// TODO Auto-generated constructor stub
			this.n = n;
			this.m = m;
		}

		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			if (obj instanceof Pair) {
				Pair temp = (Pair) obj;
				if ((temp.n.equals(this.n) && temp.m.equals(this.m))
						|| (temp.n.equals(this.m) && temp.m.equals(this.n))) {
					return true;
				}
			}
			return false;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return n + "," + m;
		}
	}
}

