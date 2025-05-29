import java.util.Scanner;
import java.lang.Math;

class q2{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Score s = new Score();

		int size = new Integer(sc.nextLine());

		int j = 1;

		while(sc.hasNextLine() && size > 0){
			String str = sc.nextLine();
			String[] tok = str.split(" ");
			int nGooglers = new Integer(tok[0]);
			int sTrips = new Integer(tok[1]);
			int pScore = new Integer(tok[2]);
			int[] tPoints = new int[nGooglers];
			
			for(int i=3; i<nGooglers+3; ++i)
				tPoints[i-3] = new Integer(tok[i]);

			int best = s.in(nGooglers, sTrips, pScore, tPoints);
			
			System.out.println("Case #" + j + ": " + best);
			++j;
			--size;
		}
	}
}

class Score{

	public int in(int n, int s, int p, int[] t){
		int moreThanp = 0;
		for(int i=0; i<n; ++i){
			int ave = (int)Math.ceil(t[i]/3.00);
			int r = t[i]%3;
			
			if(ave >= p)
				++moreThanp;
			else if(s>0 && (r == 0 || r == 2) && t[i]>1){
				++ave;
				if(ave >= p){
					++moreThanp;
					--s;
				}
			}
		}
		
		return moreThanp;
	}
}


