import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Learn {
	static void one(Object s) {
		System.out.print("Object");
	}

	static void one(List s) {
		System.out.print("String");
	}

	public static void main(String[] s) throws IOException {
		// one(null);
		FileInputStream fstream = new FileInputStream("q.txt");
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;
		// Read File Line By Line
		int tc;
		tc = Integer.parseInt(br.readLine());
		for (int o = 0; o < tc; o++) {
			String line = br.readLine();
			int n = Integer.parseInt(line.split(" ")[0]);
			int m = Integer.parseInt(line.split(" ")[1]);
			int res = 0;
			String s1, s2 = null;
			List l = new ArrayList();
			for (int i = n + 1; i <= m; i++) {
				s1 = Integer.toString(i);

				for (int j = 1; j < s1.length(); j++) {
					String s3 = s1.substring(0, j);
					String s4 = s1.substring(j, s1.length());
					String s5 = s4 + s3;
					if (s5.indexOf("0") == 0)
						continue;
					int y = Integer.parseInt(s5);
					String va = i + "&" + y;
					if (l.contains(va))
						continue;
					l.add(va);
					if (y != i && y <= m && y >= n) {
						res++;
						
					}
				}
			}
			
			System.out.println("Case #" + (o+1) + ": "+ res / 2);
			// Close the input stream
			in.close();

		}
	}
}
