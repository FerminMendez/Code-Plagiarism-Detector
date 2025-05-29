import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//1
//3 1 5 15 13 11
//
public class DancingWiththeGooglersCodeJam2012Q {
	
	public int  solves(int N,int S,int P,int scores[]){
		int i = 0 ;
		int sol = 0 ;
		Arrays.sort(scores);
		int TT = scores.length ; 
		for ( i = 0 ; i < TT ;i++){
			if ( scores[i] <P){ scores[i]=-1; continue;}
			else break;
		}
		
		//total score itself is < P not possible case;
		if( i == TT && S ==0 ) return 0;

		// solve for combination without surprise case
		for ( i = 0 ; i < TT  ;i++){
			if ( scores[i] !=-1 && scores[i]>= P){
				for ( int j = 0 ; j <=10 ;j++){
					for (int k = 0 ; k <=10 ;k++){
						for (int  l = 0 ; l <=10;l++){
							if( l+j+k != scores[i] ) continue;
							
							if( l+j+k == scores[i] && 
								(	Math.abs(j-k) < 2 && Math.abs(k-l) < 2 && Math.abs(l-j) < 2 ) && 
								(	l >= P || j  >= P || k >= P	)
								
							){
								//System.out.println(j + " " + k + " " + l + " " + scores[i] + " " + sol  );
								scores[i]= -1 ;
								++sol;
							}
						}
					}
				}
			}
		}
		for ( i = 0 ; i < TT && S>0  ;i++){
			if ( scores[i] !=-1 && scores[i]>= P){
				for ( int j = 0 ; j <=10 ;j++){
					for (int k = 0 ; k <=10 ;k++){
						for (int  l = 0 ; l <=10;l++){
							if( l+j+k != scores[i] ) continue;
							if( l+j+k == scores[i] && ( 
									(	Math.abs(j-k) ==2 &&    Math.abs(k-l) <= 2  && Math.abs(l-j) <=2 ) ||
									(	Math.abs(j-k) <=2 &&    Math.abs(k-l) == 2  && Math.abs(l-j) <=2 ) ||
									(	Math.abs(j-k) <=2 &&    Math.abs(k-l) <= 2  && Math.abs(l-j) ==2 ) ) &&
									(	l >= P || j  >= P || k >= P	)
									
								){
									//System.out.println(" FF" + j + " " + k + " " + l + " " + scores[i] + " " + sol  );
									scores[i]= -1 ;
									--S;
									++sol;
								}
						}
					}
				}
			}
		}
		
		//System.out.println(" sol3 : " + sol);
		return sol;
		
	}
	
	public static void main(String[] args) throws IOException {
		DancingWiththeGooglersCodeJam2012Q si = new DancingWiththeGooglersCodeJam2012Q();
	
		int T ;
		String CurLine = ""; 
	        
		InputStreamReader converter = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(converter);
		CurLine = in.readLine();
		T= Integer.parseInt(CurLine);
		String s[] = new String[T];
		for(int i = 0 ; i < T;i++) {
			CurLine = in.readLine();
			
			String []input = CurLine.split(" ");
			
			
			int N = Integer.parseInt(input[0]);
			int S = Integer.parseInt(input[1]);
			int P = Integer.parseInt(input[2]);
			int scores[] = new int [N];
			for( int j = 0 ; j < N;j++){
				scores[j] = Integer.parseInt(input[j+3]);
				
			}
			System.out.println("Case #"+ (i+1)+": "+si.solves(N,S,P,scores));
			
		}
	}
}
