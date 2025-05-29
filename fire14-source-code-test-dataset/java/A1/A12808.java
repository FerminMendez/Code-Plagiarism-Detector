import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

import static java.lang.Math.*; 
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Character.*;  



public class B {

	Scanner scan;
	InputStream in;
	
	int intLine(){
		return parseInt(scan.nextLine());
	}
	
	long solve(){
		long res=0;
		int n = scan.nextInt();
		int s = scan.nextInt();
		int p = scan.nextInt();
		int[]A = new int[n];
		for(int i=0;i<n;i++)A[i]=scan.nextInt();
		sort(A);
		for(int i=n-1;i>=0;i--){
			
			int x = (A[i]+2)/3;
			if(x>=p)res++;
			else {
				x = (A[i]+4)/3;
				if(x>=p && s>0 && A[i]>0){
					res++;s--;
				}
			}
		}
		
	    return res;
	}
	
	void solveAll(){
		int N = parseInt(scan.nextLine());
		for(int i=0;i<N;i++){
			long r =solve();
			System.out.format("Case #%d: %d\n",i+1,r);
		}
	}
	
	B() throws Exception{
		String cn = B.class.getName();
		String sampleName = cn+"-sample.in";
		String smallName = cn+"-small-attempt0.in";
		String largeName = cn+"-large.in";
		InputStream in = new BufferedInputStream(new FileInputStream(smallName));
		scan = new Scanner(in);
	}
	
	public static void main(String[] args) throws Exception{
	    Locale.setDefault(Locale.US); 
	    new B().solveAll();
	}

}
