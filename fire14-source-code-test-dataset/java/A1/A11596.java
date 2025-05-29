package quals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DancingWithTheGooglers {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());
		for (int i=1; i<=T; i++) {
			String line = reader.readLine();
			StringTokenizer tok = new StringTokenizer(line);
			int N = Integer.parseInt(tok.nextToken());
			int S = Integer.parseInt(tok.nextToken());
			int p = Integer.parseInt(tok.nextToken());
			int most = 0;
			while (tok.hasMoreTokens()) {
				int sum = Integer.parseInt(tok.nextToken());
				if (sum >= p*3-2) most++;
				else if (sum >= p*3-4 && S>0 && p>1) {
					most++;
					S--;
				}
			}
			System.out.printf("Case #%d: %d\n", i, most);
		}
	}

}
