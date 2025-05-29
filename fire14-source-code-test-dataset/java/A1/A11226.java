import java.util.Scanner;

/**
 * author - coolprosu
 * Problem - B
 */

public class DancingWithTheGooglers {
	private int T = 0;
	int N[], S[], p[], t[][];
	public static void main(String[] args) {
		DancingWithTheGooglers solveProb = new DancingWithTheGooglers();
		solveProb.solve();
	}
	private void solve() {
		Scanner sc = new Scanner(System.in);
		//Input no. of test cases
		T = sc.nextInt();
		//Solved strings
		String solutionArray[] = new String[T];		
		N = new int[T];
		S = new int[T];
		p = new int[T];
		t = new int[T][];
		for(int i=0;i<T;i++) {
			solutionArray[i] = "Case #"+(i+1)+": ";			
			N[i] = sc.nextInt();
			S[i] = sc.nextInt();
			p[i] = sc.nextInt();
			t[i] = new int[N[i]];
			for(int j=0;j<N[i];j++) {
				t[i][j] = sc.nextInt();
			}
			solutionArray[i] += solveCase(N[i],S[i],p[i],t[i]); 
		}
		//Output result
		for(int i=0;i<T;i++) {
			System.out.println(solutionArray[i]);
		}		
	}
	private int solveCase(int N, int S, int p, int t[])	{
		int maxPossibility = 0;
		/**
		 * Eliminitation
		 */
		//Reject impossible cases (where total points <= (p+p-2+p-2))
		int possibleN = 0;
		int possibleT[] = new int [N];
		int minPossibleTotal = p+p-2+p-2;
		minPossibleTotal = (p>minPossibleTotal)?p:minPossibleTotal; //minPossibleTotal should be at least p
		for(int i=0;i<N;i++)
		{
			if(t[i]>=minPossibleTotal)
			{
				possibleT[possibleN++] = t[i];
				//System.out.println("Possible:"+t[i]+" Possible N:"+possibleN);				
			}
		}
		// Run recursion
		maxPossibility = solveRecursion(possibleN, S, p, possibleT, 0, 0);
		return maxPossibility;
	}
	private int solveRecursion(int N, int S, int p, int t[], int surpriseScoreCount, int currN) {
		//System.out.println(currN+" "+t[currN]);
		if(currN>=N)
			return 0;
		int totalScore = t[currN];
		int possibility = 0;
		int highestPossible = 0;
		//Find possible combinations with max. score p
		for(int i=-10;i<=10;i++) {
			for(int j=-10;j<=10;j++) {
				for(int k=-10;k<=10;k++) {
					if(totalScore==(p+i+p+j+p+k))
					{
						//System.out.println("For:"+currN+" "+(p+i)+":"+(p+j)+":"+(p+k));
						if(isValid(p,p+i,p+j,p+k)) //Check if diff >2
						{
							if(isSurprise(p+i,p+j,p+k)) //Surprising score 
							{
								if(surpriseScoreCount+1 <= S)
								{
									//System.out.println("Surprise"+" For:"+currN+" "+(p+i)+":"+(p+j)+":"+(p+k));
									//Continue with recursion
									possibility = 1+solveRecursion(N, S, p, t, surpriseScoreCount+1, currN+1);
									if(possibility>highestPossible)
										highestPossible = possibility;
								}
							}
							else {
								//System.out.println("Possible"+" For:"+currN+" "+(p+i)+":"+(p+j)+":"+(p+k));
								//Continue with recursion
								possibility = 1+solveRecursion(N, S, p, t, surpriseScoreCount, currN+1);
								if(possibility>highestPossible)
									highestPossible = possibility;							
							}
						}
					}
				}
			}
		}
		if(highestPossible==0)
			highestPossible = solveRecursion(N, S, p, t, surpriseScoreCount+1, currN+1);
		return highestPossible;
	}
	private boolean isSurprise(int a, int b, int c)
	{
		return(Math.abs(a-b)==2||Math.abs(a-c)==2||Math.abs(b-c)==2);
	}
	private boolean isValid(int min, int a, int b, int c)
	{
		if(!(a>=min||b>=min||c>=min))
			return false;
		else if(a<0||b<0||c<0)
			return false;
		else if (a>10||b>10||c>10)
			return false;
		else
			return(!(Math.abs(a-b)>2||Math.abs(a-c)>2||Math.abs(b-c)>2));
	}	
}
