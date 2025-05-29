import java.util.Scanner;

class RecycledNumbers {

    Scanner s = new Scanner(System.in);

    public static void main(String args[]) {
	    RecycledNumbers p = new RecycledNumbers();
	    p.run();
	}
	
	void run() {
	    int nCases = s.nextInt();
		for (int i=0; i<nCases; i++) {
		    int A = s.nextInt();
			int B = s.nextInt();
			System.out.println("Case #"+(i+1)+": "+count(A, B));
		}
	}

    int count(int A, int B) {
	    boolean[] dids = new boolean[B-A+1];
        int count = 0;
		int rotates = Integer.toString(A).length() - 1;
		int level = (int) Math.pow(10, rotates);

	    for (int i=A; i<B; i++) {
		    if (dids[i-A]) continue;
			int possibility = countPossibility(i, A, B, rotates, level, dids);
            if (possibility>1) count+=(possibility *(possibility-1)) / 2;			
		}
		return count;
	}

	int countPossibility(int v, int A, int B, int rotates, int level, boolean[] dids) {
	    int count = 1;
		dids[v-A] = true;
		
        for (int i=0; i<rotates; i++) {
		    int leftMost= v / level;
			v = (v % level) * 10 + leftMost;
			if (v<A || v>B) continue;
			if (dids[v-A]) continue;
			dids[v-A] = true;
			count++;
		}
    	return count;
	}
}