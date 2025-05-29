import java.io.*;
import java.util.*;

public class ProblemB {
    public static void main(String[]args) {
	Scanner f = new Scanner(System.in);
	int T = f.nextInt();
	
	for(int set=0;set<T;set++) {
	    int N = f.nextInt(), S = f.nextInt(), p = f.nextInt();
	    int[] t = new int[N];
	    int result = 0;
	    for(int c=0;c<N;c++) {
		t[c] = f.nextInt();
		int base = t[c]/3;
		if(t[c]%3!=0) base++;
		//		666 567
		//		667 567
		//                677 668
		if(base>=p) {
		    result++;
		} else if((base==p-1 && t[c]%3==2 || base==p-1 && base>0 && t[c]%3==0) && S > 0) {
		    result++;
		    S--;
		}
	    }
	    
	    System.out.printf("Case #%d: %d\n",set+1,result);
	}
    }
}