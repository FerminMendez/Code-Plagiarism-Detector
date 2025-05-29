import java.util.Scanner;


public class Recycle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cases = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i < cases; i++) {
			Scanner line = new Scanner(sc.nextLine());
			int A = line.nextInt();
			int B = line.nextInt();			
			
			int k = Integer.toString(A).length();
			
			int fac = (int) (Math.pow(10, k-1));
			
			IntSet set = new IntSet(k);
			
			int pairCount = 0;
			for(int n = A; n < B; n++) {
				set.clear();
				int m = n;
				for(int j = 0; j < k-1; j++) {
					int mod = m % 10;
					m = m / 10;
					m = m + (fac * mod);
					if(m <= B && m > n) {
						//if not already there
						if(!set.insert(m)) {
							pairCount++;
						}
					}
				}
			}
			System.out.printf("Case #%d: %d\n", i+1, pairCount);
		}

	}
	

}

class IntSet {
	
	int[] ints;
	int ctr = 0;
	
	public IntSet(int k) {
		ints = new int[k];
		ctr = 0;
	}
	
	public boolean contains(int x) {
		for(int i = 0; i < ctr; i++) {
			if(ints[i] == x) {
				return true;
			}
		}
		return false;
	}
	
	//true if x already contained
	public boolean insert(int x) {
		if(contains(x)) {
			return true;
		}
		ints[ctr] = x;
		ctr++;
		return false;
	}
	
	public void clear() {
		ctr = 0;
	}
}