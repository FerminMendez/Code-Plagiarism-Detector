
public class Recycled {
	JamInputReader ir;	
	
	public Recycled(String fileName) {
		ir = new JamInputReader(fileName);
		int t = ir.getNumItems();
		
		for(int i = 0; i < t; i++) {
			System.out.println("Case #" + (i + 1) + ": " + proc(ir.getNextItem(), ir.getNextItem()));
		}
	}
	
	int proc(String A, String B) {
		int r = 0;
		int a, b, d;
		
		a = Integer.parseInt(A);
		b = Integer.parseInt(B);
		d = A.length();

		for(int i = a; i <= b; i++) {
			r += checkRecycleList(a, b, d, i);
		}
		return r;
	}

	boolean nodup(int[]l, int c, int m) {
		for(int i = 0; i< c; i++)
			if(l[i] == m)
				return false;
		
		return true;
	}
	
	int checkRecycleList(int a, int b, int d, int m) {
		int[] l = new int[d];
		int c = 0;
		int n = m;
		int d10 = (int)Math.pow(10, d - 1);
	
		for(int i = 0; i < d - 1 ; i++) {
			int temp = m % 10;
			m = m / 10 + (temp * d10);

			if(m >= a && m <= b && n < m && nodup(l, c, m)) {
				l[c] = m;
				c++;
			}
		}
	
		return c;
	}



	public static void main(String[] args) {
		new Recycled(args[0]);
	}
}
