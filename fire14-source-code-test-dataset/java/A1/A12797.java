import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

public class Googlers {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new FileReader("B-small-attempt0.in"));
		PrintWriter output = new PrintWriter(new FileOutputStream("output.txt"));
		
		int T = Integer.parseInt(input.readLine());
		String line;
		String[] Ts = new String[103];
		
		int N, S, P, M, Ti;
		
		for (int i = 1; i <= T; i++) {
			line = input.readLine();
			Ts = line.split(" ");
			N = Integer.parseInt(Ts[0]);
			S = Integer.parseInt(Ts[1]);
			P = Integer.parseInt(Ts[2]);
			M = 0;
			
			for (int j = 0; j < N; j++) {
				Ti = Integer.parseInt(Ts[j+3]);
				if (P == 0) {
					M++;
				} else if(Ti > 0) {
					if (Ti >= 3*P-2) {
						M++;
					} else if (Ti >= 3*P-4 && S > 0) {
						M++;
						S--;
					}
				}
			}
			
			output.println("Case #" + i + ": " + M);
		}
		
		input.close();
		output.close();
	}
}
