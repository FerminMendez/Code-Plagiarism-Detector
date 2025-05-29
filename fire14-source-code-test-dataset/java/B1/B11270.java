import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.LinkedList;

class RecycledNumbers {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input? ");
		String input = in.readLine();
		if(!input.equals("System.in")) {
			in = new BufferedReader(new FileReader(new File(input)));
		}
		
		PrintStream out;
		out = new PrintStream(new File("C.out"));
		//out = System.out;
		
		int cases = Integer.parseInt(in.readLine());
		
		for(int i = 1; i <= cases; i++) {
			String[] line = in.readLine().split(" ");
			
			int A = Integer.parseInt(line[0]);
			int B = Integer.parseInt(line[1]);
			
			int recycledPairs = 0;
			HashMap<Integer,LinkedList<Integer>> cache = new HashMap<Integer,LinkedList<Integer>>();
			for(int n = A; n < B; n++) {
				String nStr = Integer.toString(n);
				for(int wrap = 0; wrap < nStr.length(); wrap++) {
					String mStr = recycle(nStr, wrap);
					int m = Integer.parseInt(mStr);
					if(A <= n && n < m && m <= B) {
						System.out.println(A + "<=" + nStr + "<" + mStr + "<=" + B);
						if(cache.get(n) == null) {
							cache.put(n, new LinkedList<Integer>());
							cache.get(n).add(m);
							recycledPairs++;
						}
						else if(!cache.get(n).contains(m)) {
							cache.get(n).add(m);
							recycledPairs++;
						}
					}
				}
			}
			
			out.print("Case #" + i + ": " + recycledPairs);
			if(i != cases) out.println();
		}
		
		if(out != System.out) out.close();
	}
	
	public static String recycle(String number, int offset) {
		offset = offset > number.length() - 1 || offset < 0 ? offset % number.length() : offset;
		if(offset == 0) return number;
		
		char[] oldNumber = number.toCharArray();
		char[] newNumber = new char[number.length()];
		
		System.arraycopy(oldNumber, offset, newNumber, 0, number.length() - offset);
		System.arraycopy(oldNumber, 0, newNumber, number.length() - offset, offset);
		
		return new String(newNumber);
	}
}