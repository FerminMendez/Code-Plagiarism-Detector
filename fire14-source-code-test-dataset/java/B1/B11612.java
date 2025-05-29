import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Recycled {

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
			List<String> list = new ArrayList<String>();
			int count = 0;
			String[] elems = s.split(" ");
			int A = Integer.valueOf(elems[0]);
			int B = Integer.valueOf(elems[1]);
			for (int i = A; i <= B; i++) {
				String str = String.valueOf(i);
				if(str.length() <= 1) continue;
				for(int j = 0; j < str.length() - 1; j++) {
					String after = str.substring(0, j+1);
					String before = str.substring(j+1,str.length());
					String strRecycled = before + after;
					int recycled = Integer.valueOf(strRecycled);
					if(i<recycled && recycled<=B) {
						String q = String.valueOf(i)+String.valueOf(recycled);
					    if(!list.contains(q)) { list.add(q); count++; }
					}
				}

			}
			return count;

		}
}


