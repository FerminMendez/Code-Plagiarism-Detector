import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class C {

	public static void main(String[] args) throws Exception{
		new C().solve(args[0]);
	}

	private void solve(String file) throws Exception {
		Scanner s = new Scanner(new File(file));
		int x=s.nextInt();
		for(int i=1;i<=x;i++) {
			int y = calculate(s.nextInt(),s.nextInt());			
			System.out.format("Case #%d: %d\n",i,y);
		}
			
	}

	private int calculate(int a, int b) throws Exception {
		int r = 0;
		for ( int w=a; w<=b ; w++) {
			String A = Integer.toString(w);
			int l = A.length();
			List<Integer> list=new ArrayList<Integer>();
			for(int i=0;i<l;i++) {
				A=A.substring(1)+A.charAt(0);
				int bb = Integer.parseInt(A);
				if ( bb==w ) continue;
				if ( bb<=w ) continue;
				if ( bb>b  ) continue;
				if ( list.contains(bb))continue;
				list.add(bb);
				r++;
			}
		}
		return r;
	}
}
