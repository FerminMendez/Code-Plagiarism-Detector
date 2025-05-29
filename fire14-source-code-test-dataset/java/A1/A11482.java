import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Dancing {
	
	static int N, S, p;
	static int[] t;
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader("dancing.in"));
		int tc = Integer.parseInt(reader.readLine());
		String line;
		StringTokenizer st;
		for (int c = 1; c <= tc; c++) {
			line = reader.readLine();
			st = new StringTokenizer(line);
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			t = new int[N];
			for (int i = 0; i < N; i++) {
				t[i] = Integer.parseInt(st.nextToken());
			}
			System.out.println("Case #"+c+": "+solve());
		}
	}

	static int solve(){
		boolean[] puedeSolo = new boolean[N];
		for (int i = 0; i < N; i++) {
			int k = t[i]/3;
			if (t[i]%3==0 && k>=p) puedeSolo[i]=true;
			if (t[i]%3!=0 && k+1>=p) puedeSolo[i]=true;
		}

		boolean[] puedeSorpresa= new boolean[N];
		for (int i = 0; i < N; i++) {
			int k = t[i]/3;
			if (t[i]%3==2 && k+2>=p) puedeSorpresa[i]=true;
			if (t[i]>=2 && t[i]%3<2 && k+1>=p) puedeSorpresa[i]=true;
		}
		
		int cps = 0;
		for (int i = 0; i < N; i++) {
			if (puedeSolo[i]) cps++;
		}
		
		int cpsor = 0;
		for (int i = 0; i < N; i++) {
			if (!puedeSolo[i] && puedeSorpresa[i]) cpsor++;
		}
		
		return Math.min(cps+cpsor, cps + S);
	}
	
}
