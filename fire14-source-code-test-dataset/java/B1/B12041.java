import java.io.*;
import java.util.Set;
import java.util.HashSet;

public class recycled {
	public static int A,B;
	public static int[] t = {1,10,100,1000,10000,100000,1000000};
	
	public static int solve(){
		if(B<10) return 0;
		int DB=0,kit,m,n;
		
		int lg = 0;
		while(lg < 6 && A >= t[lg+1]) lg++; 
		//System.out.println(A+" "+lg);
		
		for(n = A; n <B; n++){
			kit = 1;
			Set H = new HashSet();
			while(t[kit] < n){
				m = t[lg-kit+1]*(n%t[kit])+(n/t[kit]);
				//System.out.println("testing >>> "+n+" - "+m);	
				if( n < m && m <= B && (n%t[kit])*10>=t[kit] && !H.contains(m)) {
					
					DB++;
					H.add(m);
					//System.out.println("OK >>> "+n+" - "+m+" DB= "+DB);	
				}
				kit++;
			}
		}
		return DB;
	}
	
	public static void main (String args[]) throws IOException{
		
		
		BufferedReader be = new BufferedReader(new FileReader("C-small.in"));
		int T = Integer.parseInt(be.readLine());
		for(int i=1; i<=T; i++){
			String s = be.readLine();
			A = Integer.parseInt(s.split(" ")[0]);
			B = Integer.parseInt(s.split(" ")[1]);
			System.out.println("Case #"+i+": "+solve());
		}
		be.close();
	}
}

