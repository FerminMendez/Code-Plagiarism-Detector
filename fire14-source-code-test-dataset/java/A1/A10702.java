import java.io.*;

public class Test {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
		int num = Integer.parseInt(br.readLine());
		int nline = 1;
		String line;
		while ((line = br.readLine()) != null && nline <=num) {
			String[] tok = line.split(" ");
			int N = Integer.parseInt(tok[0]);
			int S = Integer.parseInt(tok[1]);
			int p = Integer.parseInt(tok[2]);
			int max = N;
			if (p == 1) {
				for (int i = 3; i < N+3; i++) {
					if ((Integer.parseInt(tok[i]) == 0)) {
						--max;
					}
				}
			}
			if (p >= 2) {
				for (int i = 3; i < N+3; i++) {
					if (Integer.parseInt(tok[i]) <= 3*p-5) {
						--max;
					}
					if ((Integer.parseInt(tok[i]) == 3*p-3) || (Integer.parseInt(tok[i]) == 3*p-4)) {
						if (S > 0) --S;
						else --max;
					}
				}
			}
			System.out.println("Case #" + nline + ": " + max);
			nline++;
		}

	}		

}


