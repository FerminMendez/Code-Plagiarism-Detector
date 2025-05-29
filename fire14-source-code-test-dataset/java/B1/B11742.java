import java.util.*;

public class C {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int zz = 1; zz <= T;zz++){
			int A = in.nextInt();
			int B = in.nextInt();
			int result = 0;
			for(int i=A;i<=B;i++) {
				ArrayList<Integer> pairs = new ArrayList<Integer>();
				String ns = i+"";
				for (int j=ns.length()-1;j>0;j--) {
					String k = ns.substring(j);
					String newval = k + ns.substring(0,j);
					int m = Integer.parseInt(newval);
					if (m>i && A<m && B>=m) { 
						if (pairs.indexOf(m)==-1)
							pairs.add(m);
					}
				}
				result += pairs.size();
			}
			
			System.out.format("Case #%d: %d\n", zz, result);
		}
	}
	
}
