import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class dancing {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = new StringTokenizer("");

	public static String next() throws Exception {
		while (true) {
			if (st.hasMoreTokens())
				return st.nextToken();
			String s = br.readLine();
			if (s == null)
				return null;
			st = new StringTokenizer(s);
		}
	}

	public static int nextInt() throws Exception {
		return Integer.parseInt(next());
	}
	
	
	public static void main(String[] args) throws Exception {
	
		int T = nextInt();
		
		for(int t = 1 ; t <= T ; t++){
			int N = nextInt();
			int S = nextInt();
			int p = nextInt();
			
			
			int count = 0;
			
			for(int i = 0 ; i < N ; i ++){
				int x = nextInt();
				if(x==0){
					if(p==0)
						count++;
					continue;
				}
				if(x==1){
					if(p<=1)
						count++;
					continue;
				}
				
				if(x % 3 == 0){
					if(x/3 >= p){
						count++;
					}else if(S>0&&x/3 + 1 >= p){
						count ++;
						S--;
					}
				}else if(x%3 == 1){
					if(x/3 +1>= p){
						count++;
					}
				}else {
					if(x/3+1 >= p){
						count++;
					}else if(S>0&&x/3 +2 >= p){
						count ++;
						S--;
					}
				}
			}
			System.out.println("Case #"+t+": "+count);
		}
		
	}
}
