import java.io.*;
import java.util.*;
import java.text.*;

public class ProblemB {

	int N, S, P;
	int[] scores;
	
	Map<Integer, ArrayList<Triplet>> ts = new TreeMap<Integer, ArrayList<Triplet>>();
	int[] surprisecount = new int[31];
	int[][] bestsurprise = new int[31][11];
	int[][] notbestsurprise = new int[31][11];
	
	public static void main(String[] args) {
		try {
			new ProblemB().solve();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void appplySet() {
		int total = 0;
		for (int i=0;i<=30;i++) {
			this.surprisecount[i]=0;
			this.ts.put(i, new ArrayList<Triplet>());
		}
		for (int i=0;i<=10;i++) {
			for (int j=0;j<=10;j++) {
				for (int k=0;k<=10;k++) {
					if (!canHappen(i,j,k)) continue;
					Triplet t = new Triplet(i,j,k);
					total = i+j+k;
					ArrayList<Triplet> temp = ts.get(total);
					
					if (temp.contains(t)) {
						continue;
					}
					if (temp.add(t)) {
						if (t.isSurprise()) {
							this.surprisecount[total]++;
						}
					}
				}
			}
		}
		
//		for (Integer n : ts.keySet()) {
//			System.out.println(n);
//			for (Triplet t : ts.get(n)) {
//				System.out.println(t);
//			}
//		}
	}
	
	private boolean canHappen(int a, int b, int c) {
		int mx = Math.max(a, Math.max(b, c));
		int mn = Math.min(a, Math.min(b, c));
		if (mx - mn > 2) return false;
		return true;
	}
	
	public void solve() throws Exception {
		System.setIn(new FileInputStream("D:\\input.in"));
    	Scanner scan = new Scanner(System.in);
    	PrintWriter out = new PrintWriter(System.out);
    	
    	this.appplySet();
    	
    	int T = scan.nextInt();
    	scan.nextLine();
    	for (int i=0; i<T; i++) {
    		N = scan.nextInt();
    		S = scan.nextInt();
    		P = scan.nextInt();
    		
    		scores = new int[N];
    		for (int j=0;j<N;j++) scores[j] = scan.nextInt();
    		
    		
    		int r = process(0, 0, 0);
    		System.out.println("Case #"+(i+1)+": "+r);
    	}

		out.flush();
		out.close();
		scan.close();
	}
	
	private int process(int gindex, int scount, int bcount) {
		if (gindex >= N) {
			if (scount == S) {
				return bcount;
			} else {
				return 0;
			}
		}
		
		int mxt = 0;
		ArrayList<Triplet> tps = this.ts.get(scores[gindex]);
		for (Triplet t : tps) {
			if (t.isSurprise()) {
					scount++;
			}
			if (t.bestresult() >= P) {
				mxt = Math.max(mxt, process(gindex + 1, scount, bcount + 1)); 
			} else {
				mxt = Math.max(mxt, process(gindex + 1, scount, bcount)); 
			}
			if (t.isSurprise()) {
					scount--;
			}
		}
		//System.out.println(gindex+": "+scores[gindex]+"="+mxt);
		return mxt;
	}
	
}

class Triplet implements Comparable {
	int a,b,c;
	
	Triplet(int a, int b, int c) {
		int[] ns = new int[] {a,b,c};
		Arrays.sort(ns);
		this.a=ns[0];
		this.b=ns[1];
		this.c=ns[2];
	}
	
	@Override
	public boolean equals(Object o) {
		Triplet t = (Triplet)o;
		if (t.a==a && t.b==b && t.c==c) return true;
		return false;
	}
	
	public boolean isSurprise() {
		if (b-a == 2 || c-b==2 || c - a==2) return true;
		return false;
	}
	public int bestresult() {
		return c;
	}
	@Override
	public String toString() {
		return "("+ a+","+b+","+c+")";
	}

	@Override
	public int compareTo(Object o) {
		Triplet t = (Triplet)o;
		if (t.a == a && t.b==b && t.c==c) return 0;
		return -1;
	}

}
