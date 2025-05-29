
import java.io.*;
import java.text.*;
import java.math.*;
import java.util.*;

public class J12QC implements Runnable {
	Scanner in;
	PrintWriter out;
	static String taskname = ".\\src\\C-small-attempt0";
	int test, testn, i, j, k;

	public static void main(String[] args) {
		new Thread(new J12QC()).start();
	}

	public void solve() throws Exception {
		testn = in.nextInt();
		long A,B,C,M,M2,M1;
		int n, N;
		boolean t;

		for (test = 0; test < testn; test++) {
			out.print("Case #" + (test + 1) + ": ");
			A = in.nextLong();
			B = in.nextLong();
			M=1; C=A;
			while(C>0){C/=10; M*=10;}
			M2 = (B<M)?B:M;
			N=0; M1=M/10;
			for (long i = A; i <= M2; i++) { //length = Aexp
				n = count(i,A, M2, M);
				N+= n*(n-1)/2;
			}	
			while (M*10<B){
				M1=M; M*=10;
				for (long i = M1+1; i < M-1; i++) {
					n = count(i,M1+1, M-1, M);
					N+= n*(n-1)/2;
				}
			}
			if (M<B){
				M1=M; M*=10;
				for (long i = M1+1; i <= B; i++) {
					n = count(i,M1+1, B, M);
					N+= n*(n-1)/2;
				}
			}
			
			out.print(N+"\n");
		}
	}
	public int count(long c, long M1, long M2, long M){
		int n=0;
		boolean t =true;
		long m=M/10, C=c*10%M + c*10/M;
		if(C == c) return 0;
		C=c;
		while((m/=10) >0){
			C=C*10%M + C*10/M;
			if((C < M1)||(C>M2)) continue; //or -9*exp 
			if(C < c) {t=false; break;}
			if(C == c) {break;}
			n++;
		}
		if(t) return n+1;
		else return 0;
	}

	@Override
	public void run() {
		try {
			in = new Scanner(new File(taskname + ".in"));
			out = new PrintWriter(taskname+".out");
			//out = new PrintWriter(System.out, true);
			//			in = new BufferedReader( new InputStreamReader(System.in));
			//			out = new BufferedWriter( new OutputStreamWriter(System.out));
			solve();
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
