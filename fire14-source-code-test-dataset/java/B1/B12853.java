import java.io.File;
import java.io.PrintWriter;
import java.util.*;


public class RecycledNumbers {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(new File("C-small-attempt0.in"));
		int num = scanner.nextInt();
		scanner.nextLine();
		PrintWriter writer = new PrintWriter(new File("Answer2.txt"));
		for(int a = 1;a<=num;a++) {
			Map<Integer,Set<Integer>> map = new HashMap<Integer,Set<Integer>>();
			int start = scanner.nextInt();
			int finish = scanner.nextInt();
			int count = 0;
			for(int x = start;x<=finish;x++) {
				map.put(x, new HashSet<Integer>());
				String s = "" + x;
				int length = s.length();
				for(int i=1;i<s.length();i++)
				{
					String f = s.substring(length-i) + s.substring(0,length-i);
					int fin = Integer.valueOf(f);
					if(!f.startsWith("0") && fin<=finish && x<fin) {
						map.get(x).add(fin);
					}
				}
				count+=map.get(x).size();
			}
			
			writer.println("Case #" + a + ": " + count);
			writer.flush();
			
		}
		writer.close();
	}
}
