import java.util.*;

public class C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		for(int ctr=0; ctr<cases; ctr++){
			int start = sc.nextInt();
			int end = sc.nextInt();
			HashSet<String> set = new HashSet<String>();
			for(int n=start; n<=end; n++){
				String s = Integer.toString(n);
				for(int i=1; i<s.length(); i++){
					String t = s.substring(i) + s.substring(0, i);
					int m = Integer.valueOf(t);
					if(t.replaceFirst("^0*", "").length() == s.length() && n != m && start <= m && m <= end){
						set.add(s+t);
					}
				}
			}
			System.out.printf("Case #%d: %d\n", ctr+1, set.size()/2);
		}
	}
}
