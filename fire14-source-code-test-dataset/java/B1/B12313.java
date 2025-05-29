import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class RecycledNumbersCodeJam2012Q {

	public long  solves(String A,String B){
		long a = Long.parseLong(A);
		long b = Long.parseLong(B);
		long s = 0 ; 
		for(long i = a ;i <= b; i++){
			s+= possibilities( Long.toString(i), a, b);
		}
		return s;
	}
	public long possibilities(String A,long a , long b ){
		long s = 0 ;
		long a0 = Long.parseLong(A);
		List<String> dup = new ArrayList<String>();
		dup.add(A);
		for(int i = 1 ; i < A.length();i++){
			String n= A.substring(i);
			String n1= A.substring(0,i);
			String aa = new String(n+n1);
			//System.out.println(aa);
			
			long a1= Long.parseLong(aa);
			
			if ( a1 < a0 &&  a1>= a && a1<=b && !dup.contains(aa)){	
				++s;
				dup.add(aa);
			}
		}
		return s ;
	}
	public static void main(String[] args) throws IOException {
		RecycledNumbersCodeJam2012Q si = new RecycledNumbersCodeJam2012Q();
	
		int T ;
		String CurLine = ""; 
	        
		InputStreamReader converter = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(converter);
		CurLine = in.readLine();
		T= Integer.parseInt(CurLine);
		
		for(int i = 0 ; i < T;i++) {
			CurLine = in.readLine();
			String A = CurLine.split(" ")[0];
			String B = CurLine.split(" ")[1];
			System.out.println("Case #"+ (i+1)+": "+si.solves(A,B));
			
		}
	}
	
}
