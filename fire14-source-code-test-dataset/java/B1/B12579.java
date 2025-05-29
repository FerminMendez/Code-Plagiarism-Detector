import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class C {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 0; t < T; t++){
			int A = in.nextInt(); int B = in.nextInt();
			int n = A;
			int res = 0;
			while (n < B) {
				res = res+recycledPair(n,B);
				n++;
			}
			System.out.println("Case #"+(t+1)+": "+res);
		}
	}
	
	private static int recycledPair(int n, int B){
		int count = 0;
		int len = Integer.toString(n).length(); //len of digits
		String nstr = Integer.toString(n);
		List<Integer> solSofar = new ArrayList<Integer>();
		
		for (int i=1; i<len;i++){
			String toMove = nstr.substring(0, i);
			String last = nstr.substring(i);
			String mstr = last + toMove;
			Integer m = Integer.parseInt(mstr);
			if (mstr.length()==len && n < m && m <= B && !solSofar.contains(m)) {
				solSofar.add(m);
				count++;
			}
		}
		return count;
	}

}
