import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BDanceWithGooglers {

	public static void solve() throws IOException {
		File f = new File("E:\\downloads\\B-small-attempt2.in");
		BufferedReader reader = new BufferedReader(new FileReader(f));
		File f2 = new File("C:\\Users\\kimo\\Desktop\\out.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(f2));
		int x = Integer.parseInt(reader.readLine());
		int a[] = null;
		String st[] = null;
		for (int i = 0; i < x; i++) {
			st = reader.readLine().split(" ");
			a = new int[st.length];
			for (int j = 0; j < st.length; j++)
				a[j] = Integer.parseInt(st[j]);

			int s = a[1];
			int p = a[2];
			int count = 0;
			int exact = p + p - 1 + p - 1;
			int surp = p + p - 2 + p - 2;
			for (int k = 3; k < a.length; k++)
				if (a[k] / 3 >= p || a[k] >= exact&&a[k]>=p)
					count++;
				else

				if (a[k] >= surp && s-- > 0&&a[k]>=p)
					count++;
			writer.write("Case #" + (i + 1) + ": " + count);
			writer.newLine();
			
		}
		reader.close();
		writer.close();
	}

	public static void main(String[] args) throws IOException {
		solve();

	}

}
