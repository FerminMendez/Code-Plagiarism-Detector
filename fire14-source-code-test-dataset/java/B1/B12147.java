import java.io.*;
import java.util.*;
import java.math.*;

public class C {
	public static void main(String[] args) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C-small-attempt0.in"));
		BufferedReader br = new BufferedReader(new InputStreamReader(bis));
		PrintWriter out = new PrintWriter("C-small-attempt0.out");
		int cases = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		for (int c = 1; c <= cases; c++) {
			int res = 0;
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			for (int i = A; i <= B; i++) {
				String iStr = i+"";
				int len = iStr.length();
				for (int j = 1; j < len; j++) {
					int curr = getNext(iStr, j, len);
					if(curr > i && curr <= B)
						res++;
				}
			}
			out.println("Case #" + c + ": " + res);
		}
		out.close();
	}
	public static int getNext(String s, int st, int len) {
		String res = s.charAt(st)+"";
		for (int i = st+1; i%len != st; i++) {
			res += s.charAt(i%len);
		}
		return Integer.parseInt(res);
	}
}