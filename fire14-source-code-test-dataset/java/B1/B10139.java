import java.io.*;
import java.util.*;

public class ProblemC {
    public static void main(String[]args) {
	Scanner f = new Scanner(System.in);
	int T = f.nextInt();
	
	for(int set=0;set<T;set++) {
	    int A = f.nextInt();
	    int B = f.nextInt();
	    
	    int b = B;
	    int leadingMult = 1;
	    while(b >= 10) {
		b /= 10;
		leadingMult*=10;
	    }
	    
	    // System.out.println("leadingMult: "+leadingMult);
	    
	    long pairs = 0;
	    for(int x=A;x<=B;x++) {
		// System.out.println("x: "+x);
		int y = x;
		do {
		    y = y/10 + leadingMult*(y%10);
		    // System.out.println("y: "+y);
		    if(x < y && y <= B) {
			//			System.out.printf("(%d,%d)\n",x,y);
			pairs++;
		    }
		} while(y!=x);
	    }
	    
	    System.out.printf("Case #%d: %d\n",set+1,pairs);
	}
    }
}