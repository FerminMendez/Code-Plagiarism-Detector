import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class RecycledNumbers {
//	private static String INPUT_FILE = "input.txt";
	private static String INPUT_FILE = "C-small-attempt0.in";
	
	
	private static final String DELIM = " ";
	
	public void solve() {
		try {
			BufferedReader in = new BufferedReader(new FileReader(INPUT_FILE));
			
			int T = Integer.valueOf(in.readLine());
			
			String line;
			for(int i = 0; i < T; i++) {
				line = in.readLine();
				
				StringTokenizer st = new StringTokenizer(line, DELIM);
				
				int A = Integer.valueOf(st.nextToken());
				int B = Integer.valueOf(st.nextToken());
				
				process(i + 1, A, B);
			}
		}
		catch(Exception e) {}
	}
	
	protected void process(int idx, int A, int B) {
		int cnt = 0;
		
		String digit;
		int len;
		StringBuffer sb;
		String r;
		int d;
		LinkedList<String> list = new LinkedList<String>();
		String pair;
		
		for(int i = A; i <= B; i++) {
			digit = Integer.toString(i);
			len = digit.length();
			
			if(len > 1 && !digit.endsWith("0")) {
				for(int j = 1; j <= len - 1; j++) {
					sb = new StringBuffer();
					sb.append(digit.substring(len - j, len));
					sb.append(digit.substring(0, len - j));
					
					r = sb.toString();
					
					if(r.charAt(0) != '0' && !r.equals(digit)) {
						d = Integer.valueOf(r);
						
						if(d >= A && d <= B) {
							if(i < d)
								pair = i + "|" + d;
							else
								pair = d + "|" + i;
							
							if(!list.contains(pair)) {
								list.add(pair);
								cnt++;
							}
						}
					}
				}
			}
		}
		
		System.out.println("Case #" + idx + ": " + cnt);
	}
	
	public static void main(String[] args) {
		RecycledNumbers r = new RecycledNumbers();
		r.solve();
	}

}
