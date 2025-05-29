import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Dancing {
	
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		int t = 0;
		String str = "";
		String regex = " ";
		String[] split;
		String[] result = new String[T+1];
		int N = 0;
		int S = 0;
		int p = 0;
		for(int x = 1; x <= T; x++){
			str = in.readLine();
			split = str.split(regex);
			N = Integer.parseInt(split[0]);
			S = Integer.parseInt(split[1]);
			p = Integer.parseInt(split[2]);
			for(int y = 3; y < (3 + N); y++ ) {
				if(bestScore(N, S, p, Integer.parseInt(split[y])) == 1) {
					t++;
				}
				if(bestScore(N, S, p, Integer.parseInt(split[y])) == 2) {
					S--;
					t++;
				}
			}
			
			result[x] = "Case #" + x + ": " + t;
			t=0;
		}
		for(int u = 1; u <= T; u++){
			System.out.println(result[u]);
		}
		
	}
	
	public static int bestScore (int N, int S, int p, int t){
		int work = 0;
		int temp = t;
		int score;
		int special = 2;
		if(S != 0){
			for(score = 10; score > 0; score--){
				
				if(t - score >= (score - special)*(2) && (t-score > 0)) {
					temp = score;
					score = -1;
				}
			}
			if(temp >= p)
			{
				work = 2;
				
			}
		}
		temp = t;
		special = 1;
		for(score = 10; score >= 0; score--){
		
			if(t - score >= (score - special)*(2) && (t-score > 0)) {
				temp = score;
				score = -1;
			}
		}
		if(temp >= p)
		{
			work = 1;
			
		}
		return work;
		
	}

}
