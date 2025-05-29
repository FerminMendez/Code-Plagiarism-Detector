import java.io.*;

public class dancing {
	
	static int N;
	static int S;
	static int p;
	static int[] t;
	
	public static boolean normal(int tot){
		int max = tot%3==0?tot/3:tot/3+1;
		return max>=p;
	}
	
	public static boolean surprising(int tot){
		int max = tot==0?0:(tot+1)/3+1;
		
		return max>=p;
	}
	
	
	public static int solve(){
		int DB=0;
		int SDB = S;
		for(int i=0; i<N; i++){
			if(normal(t[i])) DB++;
			else if(SDB > 0 && surprising(t[i])){
				DB++; SDB--;
			}
		}
		
		return DB;
	}
	
	public static void main (String args[]) throws IOException{
		
		
		BufferedReader be = new BufferedReader(new FileReader("B-small.in"));
		int T = Integer.parseInt(be.readLine());
		for(int i=1; i<=T; i++){
			String s = be.readLine();
			N = Integer.parseInt(s.split(" ")[0]);
			S = Integer.parseInt(s.split(" ")[1]);
			p = Integer.parseInt(s.split(" ")[2]);
			t = new int[N];
			for(int j = 0; j < N; j++)
				t[j] = Integer.parseInt(s.split(" ")[j+3]);
			System.out.println("Case #"+i+": "+solve());
		}
		be.close();
	}
}

