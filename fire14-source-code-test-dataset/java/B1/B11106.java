import java.util.TreeSet;


public class SolveThread implements Runnable{
	
	private TreeSet<Integer> nbs;
	int pairs = 0, casenb;
	private ThreadDispatcher td;
	private int A, B;
	
	public SolveThread(int A, int B, int casenb, ThreadDispatcher td){
		nbs = new TreeSet<Integer>();
		this.A = A;
		this.B = B;
		for(int i = A; i <= B; i++){
			nbs.add(i);
		}
		this.casenb = casenb;
		this.td = td;
	}
	
	public void solve(){
		while(!nbs.isEmpty()){
			int n = nbs.first();
			findAndRemoveRecycledOf(n);
		}
	}

	private void findAndRemoveRecycledOf(int n) {
		nbs.remove((Integer)n);
		String nstr = "" + n;
		if(nstr.length() == 1)
			return;
		int nbInPair = 1;
		for(int i = 0; i < nstr.length()-1;i++){
			String sstr = shiftRight(nstr,i);
			sstr.replaceFirst("^0+(?!$)", "");
			int sn = Integer.parseInt(sstr);
			if(nbs.contains(sn)){
				nbInPair++;
				nbs.remove((Integer)sn);
			}
		}
		pairs += nbInPair * (nbInPair - 1) / 2;
	}

	private String shiftRight(String nstr, int i) {
		return nstr.substring(nstr.length() - 1 - i, nstr.length()) +  nstr.substring(0, nstr.length() - 1 - i);
	}

	@Override
	public void run() {
		solve();
		td.finish(this);
	}

}
