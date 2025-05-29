import java.util.StringTokenizer;
public class DancingWithGooglers extends BaseSolution {
	public String solveTestCase() throws Exception {
		String inp = readLine();
		StringTokenizer st = new StringTokenizer(inp);
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int ans=0;
		for(int i=0;i<N;i++){
			int t = Integer.parseInt(st.nextToken());
			int maxNormal=t,maxSurprise=t;
			if(t>0){
				maxNormal = ((t-1)/3) + 1;
			}
			if(t>1){
				maxSurprise = ((t-2)/3) + 2;
				if(maxSurprise>10){
					maxSurprise = 10;
				}
			}
			if(maxNormal>=p){
				ans++;
			} else if(S>0&&maxSurprise>=p){
				S--;
				ans++;
			}
		}
		return ans+"";
	}
		
}
