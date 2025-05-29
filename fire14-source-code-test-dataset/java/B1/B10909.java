import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;



public class CRecycledNumbers {
	
	static int recycle(int a, int b) {
		System.out.println("-------------------------");
		System.out.println(a + " " + b);
		int count = 0;
		Set<String> used = new HashSet<String>();
		for(int i = a; i < b; ++i) {
			String s = Integer.toString(i);
			for(int j = 1; j < s.length(); ++j) {
				String pre = s.substring(0, j);
				String suf = s.substring(j);
				if(suf.startsWith("0")) continue;
				int c = Integer.parseInt(suf + pre);
				if(c <= b && c != i && i < c) {
					String p = i < c? (i + "-" + c) : (c + "-" + i);
					if(!used.contains(p)) {
						used.add(p);
						System.out.println(p);
						++count;
					}
				}
			}
			
		}
		
		return count;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		String filename = "C-small-attempt0.in";
		BufferedReader r = new BufferedReader(new FileReader(filename));
		int n = Integer.parseInt(r.readLine());
		PrintWriter p = new PrintWriter("c.out");
		for(int i = 0; i < n; ++i) {
			String[] test = r.readLine().split(" ");
			int j = i + 1;
			p.println("Case #" + j + ": " +  recycle(Integer.parseInt(test[0]), Integer.parseInt(test[1])));
			
		}
		p.flush();
		p.close();
	}

}
