import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Dancing {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int cases = Integer.parseInt(in.readLine());
		for (int i = 1; i <= cases; i++) {
			String[] inp = in.readLine().trim().split(" ");
			int N = Integer.parseInt(inp[0]);
			int S = Integer.parseInt(inp[1]);
			int p = Integer.parseInt(inp[2]);
			List<Integer> scores = new ArrayList<Integer>();
			for (int j = 3; j < N+3; j++) {
				scores.add(Integer.parseInt(inp[j]));
			}
			int out = 0;
			Collections.sort(scores);
			Collections.reverse(scores);
			int j=0;
			while(j<N && scores.get(j)>=(3*p-2)) { out++; j++; }
			if(p>1) while(j<N && scores.get(j)>=(3*p-4) && S>0) { out++; j++; S--; }
			System.out.println("Case #"+i+": "+out);
		}
	}
	
}
