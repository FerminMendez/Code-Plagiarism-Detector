import java.util.*;

public class Main {

	static int digits(int A){
		if (A<10) return 1;
		return 1+digits(A/10);
	}
	static int[] decimal(int n, int d){
		int[] t = new int[d];
		
		for (int i = d-1; i>=0; i--){
			t[i]=n-10*(n/10);
			n=n/10;
		}
		
		return t;
	}
	static boolean equals(int[] t1, int[] t2, int d){
		for (int i=0; i<d; i++){
			if (t1[i]!=t2[i]) return false;
		}
		return true;
	}
	
	static boolean permute(int[] t1, int[] t2, int d){
		
		for (int j = 0; j<d; j++){
			int aux=t1[0];
			for (int i=0; i<d-1; i++) t1[i]=t1[i+1];
			t1[d-1]=aux;
			
			if (equals(t1, t2, d)) return true;
		}
		
		return false;
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int T =in.nextInt();
		for (int k = 1; k<=T; k++){
			int A = in.nextInt();
			int B = in.nextInt();
			int comp = 0;
			int d = digits(A);
			
			for(int m = A; m<=B; m++){
				for (int n =A; n<m; n++){
					int t1[] = decimal(n,d);
					int t2[] = decimal(m,d);
					if (permute(t1, t2, d)) comp++;
				}
			}
			
			
		
		
		
		System.out.println("Case #"+k+": "+comp);
		}
	}
}
