import java.io.*;
import java.util.*;

public class Game {
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new FileReader(new File("/Users/atai/Play/Codejam/input.txt")));
		PrintWriter prn = new PrintWriter(new FileWriter("output.txt"));
		
		int numTests = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < numTests; i++) {
			String[] arg = br.readLine().trim().split(" ");
			int N = Integer.parseInt(arg[0]);
			int S = Integer.parseInt(arg[1]);
			int p = Integer.parseInt(arg[2]);
			
			int min;
			int surMin;
			if (p < 2) {
				min = p;
				surMin = -1;
			} else {
				min = 3*p-4;
				surMin = 3*p-3;
			}
			int pass = 0;
			int count_sur = 0;
			for (int j = 0; j < N; j++) {
				int val = Integer.parseInt(arg[3+j]);
				if (val < min)
					continue;
				else {
					if (val <= surMin)
						count_sur++;
					else
						pass++;
				}
			}
			if (count_sur >= S)
				prn.printf("Case #%d: %d\n", i+1, S+pass);
			else {
				
				prn.printf("Case #%d: %d\n", i+1, count_sur + pass);			
			}
		}
		
		prn.close();
	}
}
