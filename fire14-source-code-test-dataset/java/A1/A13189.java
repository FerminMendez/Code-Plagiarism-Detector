
import java.io.*;
import java.text.*;
import java.math.*;
import java.util.*;

public class J12QB implements Runnable {
	Scanner in;
	PrintWriter out;
	static String taskname = ".\\src\\B-small-attempt0";
	int test, testn, i, j, k;
	int N,S,p;

	public static void main(String[] args) {
		new Thread(new J12QB()).start();
	}

	public void solve() throws Exception {
		testn = in.nextInt();

		for (test = 0; test < testn; test++) {
			int A=0,B=0,C=0,n; //A:must be surprise to be a candidate B: must not surprise C:candidate
			out.print("Case #" + (test + 1) + ": ");
			N = in.nextInt();
			S = in.nextInt();
			p = in.nextInt();
			for (int i = 0; i < N; i++) {
				n=in.nextInt();
				if (n==0)
					C+=(p==0)?1:0;
				else if (n>=3*p-4){
					C++;
					if (n==3*p-3 || n==3*p-4)
						A++;
				}
			}
			if(A>S)
				C-=(A-S);

			out.print(C+"\n");
		}
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
