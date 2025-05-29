import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class ProblemC {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		FileReader fr = new FileReader("C.in");
		FileWriter fw = new FileWriter("C.out");
		BufferedReader in = new BufferedReader(fr);
		int cases = Integer.parseInt(in.readLine()), kase = 0;
		StringTokenizer s;
		while(cases-- > 0) {
			int A, B, count = 0;
			s = new StringTokenizer(in.readLine());
			A = Integer.parseInt(s.nextToken());
			B = Integer.parseInt(s.nextToken());
			for(int i = A; i < B; i++) {
				for(int j = i + 1; j <= B; j++) {
					String str = i + "";
					for(int c = 0; c < str.length(); c++) {
						String a = str.substring(c);
						String b = str.substring(0, c);
						String res = a + b;
						if(Integer.parseInt(res) == j) {
							count++;
							break;
						}
					}
				}
			}
			fw.write("Case #" + ++kase + ": " + count + "\n");
		}
		fw.close();
	}

}
