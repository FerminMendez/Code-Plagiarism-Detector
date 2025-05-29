import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ClientC {

	public static void main(String args[]) throws Exception {
		ClientC client = new ClientC();
		String[] inputLines = client.getInputLines(args[0]);

		int lineCount = Integer.valueOf(inputLines[0]);

		for(int i = 1; i <= lineCount; i++) {
			String currentLine = inputLines[i];
			String[] currentCase = currentLine.split(" ");
			int a = Integer.valueOf(currentCase[0]);
			int b = Integer.valueOf(currentCase[1]);
			
			int recycledPairs = 0;
			//System.out.println(new Date() + " : " + new Date().getTime());
			for(int j = a; j < b; j++) {
//				if(j % 10 == 0) {
//					System.out.println(new Date() + " : " + new Date().getTime()  + ": " + j);
//				}
				for(int k = b; k > j; k--) {
					if(client.isPossible(String.valueOf(j), String.valueOf(k))) {
						boolean isCyc = client.isRecycledPair(j, k);
						if(isCyc) recycledPairs++;
						//System.out.println("jk: ["+j+","+k+"] : " + isCyc);
					}
				}
			}
						
			
			System.out.println("Case #" + i + ": " + recycledPairs);
			//System.out.println();
		}
	}
	
	private boolean isPossible(String q, String w) {
		return getSumDigits(q) == getSumDigits(w);
	}
	
	private int getSumDigits(String num) {
		int tot = 0;
		for(char c : num.toCharArray()) {
			tot += Integer.valueOf(String.valueOf(c));
		}
		return tot;
	}
	
	private Set<String> findAllRotations(String someNum) {
		int len = someNum.length();
		Set<String> res = new HashSet<String>();
		
		for(int i=len; i> 0; i--) {
			String nxt = someNum.substring(i) + someNum.substring(0, i);
			//System.out.println(nxt);
			res.add(nxt);
		}
		res.remove(someNum);
		//prettyPrintSet(res);
		return res;
	}
	
	private boolean isRecycledPair(int n, int m) {
		//System.out.println("n: " + n + ", m: " + m);
		if(n >= m) return false;
		
		String nS = String.valueOf(n);
		String mS = String.valueOf(m);
						
		Set<String> rotSet =findAllRotations(nS);
		
		for(String each : rotSet) {
			if(each.equals(mS)) {
				return true;
			}
		}
		
		return false;
	}
	
	private String[] getInputLines(String fileName) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		List<String> lines = new ArrayList<String>();
		String nextLine;
		while((nextLine = reader.readLine()) != null) {
			lines.add(nextLine);
		}
		return lines.toArray(new String[lines.size()]);
	}
	
	private void prettyPrintSet(Set<String> st) {
		if(st.isEmpty()) {
			System.out.println("{}");
			return;
		}
		
		StringBuilder sb = new StringBuilder("{");
		for(String each : st) {
			sb.append(each).append(",");
		}
		System.out.println(sb.toString().replaceFirst(",$", "}"));
	}
	
}
