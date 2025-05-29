import java.util.*;

public class RecycledNumbers{
	
	static HashSet<String> hs;
	public static int single(int n, int[] digits){
		int i = 0;
		while(n>0){
			digits[i] = n%10;
			n = n/10;
			i++;
		}
		return i;
	} 	
	
	public static int toNumber(int[] d){
		int n = 0;
		for(int i = d.length-1; i>=0; i--){
			n = (n*10)+d[i];
		}		
		return n;
	}
	
	public static int pairs(int nd, int[] d, int ja, int m){
		int total = 0;
		int last = nd -1;
	
		for(int ni = 0; ni<last; ni++){
			//System.out.println("Moving "+d[ni]);
			int[] arr = new int[nd];
			int pa  = 0;
			for(int i = ni+1; i< nd; i++){
				arr[pa] = d[i];
				pa++;
			}
			for(int i = 0; i<=ni; i++){
				arr[pa] = d[i];
				pa++;
			}
			//System.out.println("Array "+Arrays.toString(arr));
			int nn = toNumber(arr);
			//System.out.println("New number "+nn);
			if((nn>ja) && nn <= m){
				total++;
				hs.add(ja+","+nn);		
			}
			
		}
		
		return total;
	}

	public static int solve(int a, int b){
		String sa = a+"";
		String sb = b+"";
		hs =  new HashSet<String>();
		int la = sa.length();
		int lb = sb.length();
		if(la == 1)
			return 0;
		int[] digitsa  = new int[7];
		
		int[] digitsb  = new int[7];
		int ndigits = single(a, digitsa);
		single(b, digitsb);
		int  count  = 0;
		for(int ja =a; ja < b; ja++){
			int[] digitsja  = new int[7];
//			System.out.println("Checking "+ja);
			single(ja, digitsja);
			int npa = pairs(ndigits, digitsja, ja, b );
			
			count+=npa;	
			if(npa > 0){
	//			System.out.println("j "+ja+" npa "+npa);
			}
		}
		//System.out.println(count);
		return hs.size();
	}
	
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		
		for(int i = 0; i<T; i++){
			
			int a, b;
			a = s.nextInt();
			b = s.nextInt();
			
			System.out.println("Case #"+(i+1)+": "+solve(a, b));
			
		}

	}
}