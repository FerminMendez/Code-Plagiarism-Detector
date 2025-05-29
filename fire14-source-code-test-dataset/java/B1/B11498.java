import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem3 {
	
	
	public static String getNext(String input){
		char last = input.charAt(input.length() - 1);
		input = last + input.substring(0, input.length()-1);
		return input;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("C-small.txt"));
		PrintWriter out = new PrintWriter("C-out.txt");
		int testCases = Integer.parseInt(in.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			StringTokenizer tokenizer = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(tokenizer.nextToken());
			int end = Integer.parseInt(tokenizer.nextToken());
			boolean map[] = new boolean[10000000];
			int count = 0;
			for (int j = start; j <= end; j++) {
				if(map[j]){
					continue;
				}
				String number = j + "";
				int tmpCount = 0;
				Set<Integer> set = new HashSet<Integer>();
				String prev = j + "";
				for (int k = 0; k < number.length(); k++) {
					String nextS = getNext(prev);
					int next = Integer.parseInt(nextS);
					if(next == j){
						continue;
					}
					if(set.contains(next)){
						continue;
					}
					
					if(next >= start && next <= end){
						map[next] = true;
						tmpCount++;
						set.add(next);
					}
					prev = nextS;
				}
				map[j] = true;
				if(tmpCount != 0){
					count += (tmpCount*(tmpCount+1))/2;
				}
			}
			out.println("Case #" + (i+1) + ": " + count);
		}
		out.close();
	}
}
