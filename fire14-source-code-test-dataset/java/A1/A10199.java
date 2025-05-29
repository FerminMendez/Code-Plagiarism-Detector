import java.util.*;
import static java.lang.Math.*;

public class BB {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int zz = 1; zz <= T;zz++){
			int N = in.nextInt();
			int S = in.nextInt();
			int p = in.nextInt();
			int res = 0;
			for(int i = 0; i < N;i++){
				
				int t = in.nextInt();
				if(p==0){
					res++; continue;
				}
				if(t>=p && t>=(p*3-2)){
					res++;
				}
				else if(S>0 && t>=p && (t>=(p*3-4))){
					S--;
					res++;
				}
				
			}
			System.out.format("Case #%d: %d\n", zz, res);
		}
	}
}
