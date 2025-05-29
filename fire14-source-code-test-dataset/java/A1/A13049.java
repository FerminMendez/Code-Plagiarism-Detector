package Q2;
public class ChooseCalc {
	private long[][] chooseCache;

	public ChooseCalc(int cacheSize, boolean readyCache) {
		chooseCache = new long[cacheSize][cacheSize];
		for(int i=0;i<cacheSize;i++){
			for(int j=0;j<cacheSize;j++){
				chooseCache[i][j] = readyCache ? perm(i, j) : -1;
			}
		}
	}

	public static long perm(int n, int k){
		if(n < k) return 0;
		long $=1;
		for(int i=n;i>Math.max(k, n-k);i--){
			$ *= i;
		}
		for(int i=1;i<=Math.min(k, n-k);i++){
			$ /= i;
		}
		return $;
	}

	public long choose(int k, int n) {
		if(chooseCache[n][k] == -1) chooseCache[n][k] = perm(n, k);
		return chooseCache[n][k];
	}

	public long cached(int k, int n){
		return chooseCache[n][k];
	}
	
	public long choosewithRep(int k, int n){
		return choose(k, n)*(n-k);
	}
}
