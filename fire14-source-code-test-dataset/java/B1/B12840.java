
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

import javax.sql.rowset.Joinable;

import static java.lang.Math.*; 
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Character.*;  



public class C {
	static class Sol implements Runnable{
		boolean started = false;
		Scanner scan;
		int caseN;
		int a,b;
		int intLine(){
			return parseInt(scan.nextLine());
		}
		
		
		int res = 0;

		void readInput() {
			a = scan.nextInt();
			b = scan.nextInt();
		}

		public void run(){
			int[]u = new int[20];
			for(int i=a;i<=b;i++){
				String s = ""+i;
				int p =0;
				for(int j = 1;j<s.length();j++){
					String ns = s.substring(j)+s.substring(0,j);
					int x = parseInt(ns);
					boolean ok = true;
					if (x<=i)ok = false;
					if(x>b)ok = false;
					for(int k=0;k<p;k++)if(x==u[k])ok = false;
					if(ok){
						u[p++]=x;
					}
				}
				res+=p;
			}
			System.err.println(caseN+" finished");
		}

		void printResult() {
			System.out.format("Case #%d: %d\n",caseN+1, res);
		}
	}

    static Sol[] solvers;
    
    static synchronized Sol getNext() {
    	for(int i=0;i<solvers.length;i++) {
    		if(!solvers[i].started){
    			solvers[i].started = true;
    			return solvers[i];
    		}
    	}
    	return null;
    }
    
    static class Worker extends Thread {
    	public void run() {
    		while(true) {
    			Sol sol = getNext();
    			if (sol == null)break;
    			sol.run();
    		}
    	}
    }
    
	public static void main(String[] args) throws Exception{
		Locale.setDefault(Locale.US);
		String cn = C.class.getName();
		String sampleName = cn+"-sample.in";
		String smallName = cn+"-small-attempt0.in";
		String largeName = cn+"-large.in";
		InputStream in = new BufferedInputStream(new FileInputStream(smallName));
		Scanner scan = new Scanner(in);
		int N = parseInt(scan.nextLine());
		solvers = new Sol[N];
		for(int i=0;i<solvers.length;i++) {
			solvers[i] = new Sol();
			solvers[i].scan = scan;
			solvers[i].caseN = i;
			solvers[i].readInput();
		}
		Thread[]threads = new Thread[32];
		for(int i=0;i<threads.length;i++){
			threads[i]=new Worker();
			threads[i].start();
		}
		for(int i=0;i<threads.length;i++){
			threads[i].join();
		}
		for(Sol s:solvers)s.printResult();
		
	}

}
