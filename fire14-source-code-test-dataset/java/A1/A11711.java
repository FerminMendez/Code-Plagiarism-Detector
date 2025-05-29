import java.util.*;

public class B {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
	
		int T = in.nextInt();
		for(int zz = 1; zz <= T;zz++){
			int n = in.nextInt();
			int s = in.nextInt();
			int p = in.nextInt();
			int ok = 0;
			int maybe = 0;
			
			for (int i=0;i<n;i++) {
				int score = in.nextInt();
				int best = (int)Math.ceil((double)(score / new Float(3)));
				if (best>=p) ok++;
				else if (best+1==p && best>0) maybe++;
			}
			
			System.out.format("Case #%d: %d\n", zz, Math.min(ok + Math.min(maybe, s),n));
		}
	}
}
