import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class RecycledNumbers {
	public static void main(String[] args) throws IOException {
		FileReader fReader = new FileReader("input/C-small-attempt0.in");
		BufferedReader br = new BufferedReader(fReader);
		int T = Integer.valueOf(br.readLine());
		int c = 1;
		while (T-- > 0) {
			String[] line = br.readLine().split("\\s");
			Integer first = Integer.valueOf(line[0]);
			Integer second = Integer.valueOf(line[1]);
			Set<String> set = new HashSet<String>();
			int totalCount = 0;
			for (int i = first; i <= second; ++i) {
				String ll = String.valueOf(i);
				for (int j = 1; j < ll.length(); ++j) {
					String tempLine = ll.substring(ll.length() - j);
					tempLine += ll.substring(0, ll.length() - j);
					if (tempLine.startsWith("0")) {
						continue;
					}
					int secondNum = Integer.valueOf(tempLine);
					if (i >= secondNum || secondNum > second) {
						continue;
					}
					String ss = i + "|" + secondNum;
					if (set.contains(ss)) {
						continue;
					}
					set.add(ss);
					totalCount++;
//					System.out.println(ss);
				}
			}
			System.out.println("Case #" + c + ": " + totalCount);
			c++;
			
		}
		fReader.close();
	}
}
