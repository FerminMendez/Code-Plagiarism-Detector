
import java.io.*;
import java.util.*;

class triple{
	static int p;
	int a , b, c;
	
	public triple(int i ,int j ,int  k){
		a = i;
		b = j;
		c = k;
	}
	boolean isSurprise(){
		return a - c == 2;
	}
	boolean isP(){
		return a >= p;
	}
	
}
public class QualB{		
		
		private BufferedReader in;	
		private StringTokenizer st;
		private PrintWriter out;
		
		
		void solve() throws IOException{
			
			ArrayList<triple>[] s = new ArrayList[31];
			for (int i = 0; i < s.length; i++) {
				s[i] = new ArrayList<triple>();
			}
			HashSet<String> h = new HashSet<String>();
			for (int i = 0; i <= 10; i++) {
				for (int j = Math.max(0, i-2); j <= Math.min(i+2, 10); j++) {
					for (int k = Math.max(0, i-2); k <= Math.min(i+2, 10); k++) {
						if(Math.abs(k-j) > 2) continue;
						int [] a = {i,j,k};						
						Arrays.sort(a);
						String str = a[0]+","+a[1]+","+a[2];
						if(!h.contains(str)){
							h.add(str);
							triple t = new triple(a[2],a[1],a[0]);
							s[i+j+k].add(t);
						}						
					}
				}
			}
			int kases = nextInt();
			int kase = 0;
			while(kases-->0){
				kase++;
				out.print("Case #"+kase+": ");
				int n = nextInt();
				int sp = nextInt();
				int p = nextInt();
				triple.p = p;
				int []vals = new int[n];
				for (int i = 0; i < vals.length; i++) {
					vals[i] = nextInt();
				}
				int ans = 0;
				int P = 0;
				int PnotS = 0;
				for (int i = 0; i < vals.length; i++) {
//					System.out.println(vals[i]);
//					System.out.print(s[vals[i]].get(0).a+" ");
//					System.out.print(s[vals[i]].get(0).b+" ");
//					System.out.println(s[vals[i]].get(0).c);
//					if(s[vals[i]].size() > 1){
//						System.out.print(s[vals[i]].get(1).a+" ");
//						System.out.print(s[vals[i]].get(1).b+" ");
//						System.out.println(s[vals[i]].get(1).c);
//					}					
//					System.out.println("-------------------------------");
					if(s[vals[i]].size() == 1){
						if(s[vals[i]].get(0).isP() && s[vals[i]].get(0).isSurprise()) P++;
						if(s[vals[i]].get(0).isP() && !s[vals[i]].get(0).isSurprise()) ans++;
					}
					else{
						boolean a = s[vals[i]].get(0).isP();
						boolean b = s[vals[i]].get(1).isP();
						if(a&&b){
							ans++;
						}
						else if( a || b){
							int j = a?0:1;
							if(s[vals[i]].get(j).isP() && s[vals[i]].get(j).isSurprise()) P++;
							if(s[vals[i]].get(j).isP() && !s[vals[i]].get(j).isSurprise()) PnotS++;
						}
					}
				}
//				System.out.println(ans);
//				System.out.println(P);
//				System.out.println(PnotS);
				if(sp > P){
					ans += P;
					sp -= P;
					PnotS -= sp;
					PnotS = Math.max(0, PnotS);
					ans += PnotS;
				}
				else{
					ans += sp + PnotS;
				}
//				ans += Math.min(sp, P);
				out.println(ans);
			}
		}
			

		QualB() throws IOException {
			in = new BufferedReader(new FileReader("input.txt"));	
			out = new PrintWriter(new FileWriter("output.txt"));
			eat("");
			solve();	
			out.close();
		}

		private void eat(String str) {
			st = new StringTokenizer(str);
		}

		String next() throws IOException {
			while (!st.hasMoreTokens()) {
				String line = in.readLine();
				if (line == null) {
					return null;
				}
				eat(line);
			}
			return st.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public static void main(String[] args) throws IOException {
			new QualB();
		}

		int gcd(int a,int b){
			if(b>a) return gcd(b,a);
			if(b==0) return a;
			return gcd(b,a%b);
		}

}
