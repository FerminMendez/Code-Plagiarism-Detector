import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class RecycledNumbers {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		int a, b, q;
		String[] tok;
		for(int i = 1; i <= cases; i++){
			 tok = br.readLine().split(" ");
			 a = Integer.parseInt(tok[0]);
			 b = Integer.parseInt(tok[1]);
			 q = 0;
			 for(int j = a; j < b; j++){
				 for(int k = j+1; k <= b; k++){
					 if(isRecycled(j,k))
						 q++;
				 }
			 }
			 System.out.println("Case #"+i+": "+q);
		}

	}
	
	static boolean isRecycled(int n1, int n2){
		String a = Integer.toString(n1);
		String b = Integer.toString(n2);
		StringBuilder sb;
		String x;
		for(int i = a.length()-1; i >= 0; i--){
			sb = new StringBuilder(a.substring(i) + a.substring(0, i));
			x = sb.toString(); 
			if(x.equals(b)){
				return true;
			}
		}
		return false;
	}

}
