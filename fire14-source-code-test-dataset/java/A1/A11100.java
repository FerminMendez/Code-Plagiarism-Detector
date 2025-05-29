
public class caseHandler {

	int N;
	int S;
	int P;
	
	int bestNum;
	
	int[] scores;
	
	public caseHandler(int N, int S, int P, int[] scores){
		this.N = N;
		this.S = S;
		this.P = P;
		this.scores = scores;
		this.bestNum = 0;
	}
	
	public int solveCase(){
		loopCase(scores[0], 0, 0, 0);
		return bestNum;
	}
	
	private void loopCase(int score, int currN, int Scount, int pNumCount){
		int currSCount = Scount;
		int currpNumCount = pNumCount;
		
		int aproxMinScore = score/3 - 1;
		if (aproxMinScore < 0) aproxMinScore = 0;
		for(int i=aproxMinScore;i<=10;i++){
			for(int j=aproxMinScore;j<=10;j++){
				if(Math.abs(i-j)>2) continue;
				for(int k=aproxMinScore;k<=10;k++){
					int min = Math.min(Math.min(i, j), k);
					if(Math.abs(min-i)>2 || Math.abs(min-j)>2 || Math.abs(min-k)>2) continue;
					if(i+j+k == score){
						int s = 0;
						int p = 0;
						if(Math.abs(i-j)==2 || Math.abs(k-j)==2 || Math.abs(k-i)==2) s = 1;
						if(currSCount+s > S) continue;
							else{
							if(i>=P || j>=P || k>=P) p = 1;
							
							if(currN == N-1){
								if(currpNumCount+p > bestNum) bestNum=currpNumCount+p;
							}
							else loopCase(scores[currN+1], currN+1, currSCount+s, currpNumCount+p);
						}
					}
				}
			}
		}
	}
}
