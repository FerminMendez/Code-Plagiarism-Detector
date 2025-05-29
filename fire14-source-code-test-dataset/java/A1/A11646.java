package qualify;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class B {

    public static void main(String[] args) throws Exception {
	Scanner input = new Scanner(new FileInputStream("B-small-attempt0.in"));
	PrintWriter output = new PrintWriter(new FileOutputStream("B-small-attempt0.out"));
	
	int T,ca;
	int N,S,p,t;
	int r;
	
	T = input.nextInt();
	for(ca=1;ca<=T;ca++) {
	    N = input.nextInt();
	    S = input.nextInt();
	    p= input.nextInt();
	    
	    r = 0;
	    for(int i=0;i<N;i++) {
		t = input.nextInt();
		if((t+2)/3 >= p ) {
		    r++;
		} else if((t+4)/3 >= p && (t+4)/3 >= 2) {		   
		    S--;
		    if(S>=0) 
			r++;
		}
	    }
	    
	    output.println(String.format("Case #%d: %d", ca,r));
	}
	
	input.close();
	output.close();

    }

}
