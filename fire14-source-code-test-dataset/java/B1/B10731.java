import java.io.*;

public class Test {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
		int num = Integer.parseInt(br.readLine());
		int nline = 1;
		String line;
		while ((line = br.readLine()) != null && nline <=num) {
			String[] tok = line.split(" ");
			int size = tok[0].length();
			double result = 0;
			if (size != 1) {
				int A = Integer.parseInt(tok[0]);
				int B = Integer.parseInt(tok[1]);
				for (int i = A; i <= B; i++) {
					int n = size;
					String str = Integer.toString(i);
					for (int j = 1; j < size; j++) {
						String str2 = str.substring(j) + str.substring(0, j);
						if ((Integer.parseInt(str2) < A) || (Integer.parseInt(str2) > B) || (Integer.parseInt(str2) == Integer.parseInt(str)))
							--n;
					}
					if (n >= 2)
						result += n * (n-1) / 2.0 * 1.0 / n;
				}
			}
			System.out.println("Case #" + nline + ": " + (int) result);
			nline++;
		}

	}		

}


