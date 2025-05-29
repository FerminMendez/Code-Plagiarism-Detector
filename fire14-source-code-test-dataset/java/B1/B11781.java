import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Hashtable;

/**
 * Input
 * @author jiptan
 *
 */

public class SolveC {

	static int isRecycledNum(char[] val, int n, int a, int b) {
		
		int recNum = 0;
		
		for (int i=0; i<val.length - 1; i++) {
			char lastElm = val[val.length - 1];
			System.arraycopy(val, 0, val, 1, val.length - 1);
			val[0] = lastElm;
			// System.out.println(String.valueOf(val));
		
			int shiftVal = Integer.parseInt(String.valueOf(val));
			
			if (shiftVal >= a && shiftVal > n && shiftVal <= b) {
				recNum = recNum + 1;
				
				// System.out.println(n + "  " + shiftVal);
				
			}
		}
		
		return recNum;
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		
		int num = Integer.parseInt(br.readLine());
		
		FileWriter fw = new FileWriter(new File("test"));
		
		StringBuilder sb2 = new StringBuilder();
		
		String[] values = null;
		
		for (int i=1; i<=num; i++) {

			String line = br.readLine();
			
			String[] abPair = line.split(" ");
			
			int a = Integer.parseInt(abPair[0]);
			int b = Integer.parseInt(abPair[1]);
			
			// System.out.println(a + "  " + b);
			
			int recNum = 0;
			for (int j=a; j<=b; j++) {
				
				int tmp = isRecycledNum(String.valueOf(j).toCharArray(), j, a, b);
				
				if (tmp > 0) {
					recNum = recNum + tmp;
				}
			}
			// System.out.println(recNum);
			
			String output = String.format("Case #%d: %d", i, recNum);
			sb2.append(output + "\n");
		}
		fw.write(sb2.toString());
		fw.close();
	}
}