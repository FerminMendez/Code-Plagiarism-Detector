import java.util.*;

public class Dancing {
	
	public static boolean wasS(int score){
		switch(score) {
			case 0:
				return false;
			case 1:
				return false;
			case 30:
				return false;
			case 29:
				return false;		
		}
		int resi = score%3;
		if(resi == 1){
			return false;
		}
		return true;
	}
	
	public static int maxp(int score, boolean surpr){
		switch(score) {
			case 0:
				return 0;
			case 1:
				return 1;
			case 30:
				return 10;
			case 29:
				return 10;		
		}
		int mid = score/3;
		int resi = score%3;
		switch (resi) {
			case 0:
				if(surpr)
					return mid+1;
				else 
					return mid;
			case 1:
				return mid+1;
			case 2:
				if(surpr)
					return mid+2;
				else
					return mid+1;
		}
		return mid;
	}
	
	public static int solve( int n, int sur, int p, int[] sc){
		
		int abovep = 0;
		for(int i = 0; i<sc.length; i++){
			int maxpos = maxp(sc[i], false);
			if(maxpos >= p ){
				abovep++;
			}else {
				if(sur > 0){
					maxpos = maxp(sc[i], true);
					//wasSurpr = wasS(sc[i]);
					if(maxpos >= p){
						abovep++;
						sur--;				
					}
				}
			}
	//		System.out.println(sc[i]+" max "+maxpos);
	//		System.out.println(" abovep "+abovep+" sur "+sur);

		}
		return abovep;
	}
	
	public static void main(String args[]){
	
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		
		for(int i = 1; i<=T; i++){
			int n = s.nextInt();
			int sur = s.nextInt();
			int p = s.nextInt();
			int sc[] = new int[n];
			for(int j = 0; j<n; j++){
				sc[j] = s.nextInt();
			}
			int y = solve(n, sur, p, sc);
			System.out.println("Case #"+i+": "+y);
		}

	}
}