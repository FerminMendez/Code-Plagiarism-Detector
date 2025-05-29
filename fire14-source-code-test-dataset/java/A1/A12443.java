import java.util.*;

import static java.lang.Math.*;

public class B {
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();	
		for(int a = 1; a <= T;a++){ //caso de prueba
			in.nextLine();
			int N = in.nextInt();
			int S = in.nextInt();
			int pInt = in.nextInt();
			double p = (double) pInt;
			int scores[] = new int[N];
			int scoresaux[] = new int[N];
			int result = 0;						
			for(int b = 0; b < N;b++)
				scoresaux[b] = in.nextInt();
			Arrays.sort(scoresaux);
			for(int b = 0, c=N-1; b < N;b++, c--)
				scores[b] = scoresaux[c];
			for ( int b = 0; b < N;b++ ) 
			{
				double score = (double)scores[b];
				double aux = score/3;
				if(score/3 > (p-1.0) ) //Tiene mayor nota seguro
					result++;
				else 
					if(  score/3 <= 0.0 || score/3 < (p -1.5) ) 
						break;
					else 
						{
						if (S>0) { result++; S--;}
						else break;
						}
			}
			System.out.format("Case #%d: %d\n", a, result);
		}
	}
}
