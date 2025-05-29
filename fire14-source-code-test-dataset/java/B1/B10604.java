import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

	static int MAX = 10000;
//	static int MAX = 2000000;
	static Object[] All = new Object[MAX+1];
	
	static int size( int x ) {
		if(x>999999) return 7;
		if(x>99999)  return 6;
		if(x>9999)   return 5;
		if(x>999)    return 4;
		if(x>99)     return 3;
		if(x>9)      return 2;
		return 1;
	}
	static List<Integer> rotate( int value ) {
		List<Integer> result = new ArrayList<Integer>();
		int[] V = new int[8];
		int s = size(value);
		int x = value;
		
		for(int i=s-1;i>=0;i--) {
			V[i] = x%10;
			x /=10;
		}
		int rot;
		for(int i=1; i<s; i++) {
			if(V[i]!=0){
				rot=0;
				for(int j=0,ii=i;j<s; j++,ii=(ii+1)%s){
					rot=rot*10+V[ii];
				}
				if(rot>value && !result.contains(rot))
					result.add(rot);
			}
		}
		return result;
	}
	
	static void precalculate() {
		for(int i=1; i<=MAX; i++){
			All[i] = rotate(i);
		}
	}
	static int solve( Scanner in ) {
		int A, B, sol=0;
		
		A = in.nextInt();
		B = in.nextInt();

		for( int i=A; i<=B; i++) {
//			List<Integer> result = rotate(i);
			List<Integer> result = (List<Integer>) All[i];
			for(Integer value: result ) {
				if( value <= B )
					sol++;
			}
		}

		return sol;
	}
	
	public static void main ( String args[] ) {
		int T; 
		Scanner in = new Scanner(System.in);
		T = in.nextInt();
		int cnt=0;
		int sol;
		precalculate();
		for( cnt=1; cnt<=T; cnt++ ) {
			sol = solve( in );
			System.out.printf("Case #%d: %d\n", cnt, sol);
		}

	}
}
