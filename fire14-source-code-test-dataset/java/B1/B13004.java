import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


public class C {

	public static void main(String[] args) throws NumberFormatException, IOException {
		File file = new File(args[0]);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		PrintStream printer = new PrintStream(new File("C-small.txt"));

		int T = Integer.parseInt(reader.readLine());
		for (int t = 0; t < T; t++) {
			String line = reader.readLine();
			String numStrArr[] = line.split(" ");
			int a = Integer.parseInt(numStrArr[0]);
			int b = Integer.parseInt(numStrArr[1]);
			String bs = b + "";
			long ans = 0;
			for (int n = a; n < b; n++) {
				String s = n + "";
				List<String> sl = new ArrayList<String>();
				for (int i = 1; i < s.length(); i++) {
					String sb = s.substring(i) + s.substring(0, i);
					if (sb.compareTo(bs) <= 0 && sb.compareTo(s) > 0 && !sl.contains(sb)) {
						ans++;
						sl.add(sb);
					}
				}
			}
			printer.println("Case #" + (t+1) + ": " + ans);
		}
		printer.close();
		reader.close();
	}
	
}
