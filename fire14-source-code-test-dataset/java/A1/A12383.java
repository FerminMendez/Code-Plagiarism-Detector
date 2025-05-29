import java.io.*;
import java.util.*;
import java.math.*;

public class DancingWithTheGooglers {
    
    public static void main (String args[]) throws Exception {
	Scanner scan = new Scanner(System.in);
	int T = scan.nextInt();
	for (int i = 1; i <= T; i++){
	    int N = scan.nextInt();
	    int S = scan.nextInt();
	    int p = scan.nextInt();
	    int result = 0;
	    for (int x = 0; x < N; x++){
		int tot_score = scan.nextInt();
		int ave = tot_score / 3;
		int rem = tot_score % 3;
		if (ave >= p){
		    result++;
		} else if (((rem == 1)||(rem ==2)) && ((ave + 1) == p)){
		    result++;
		} else if ( S > 0) {
		    if ((rem == 2) && ((ave + rem) == p)){
			result++;
			S--;
		    } else if ((rem == 0) && ((ave + 1) == p)){
			if (ave == 0){
			    ;
			} else {
			    result++;
			    S--;
			}
		    }
		}
	    }
	    System.out.println("Case #" + i + ": " + result);
	}
    }
}