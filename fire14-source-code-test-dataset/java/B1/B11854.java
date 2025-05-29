package cjam.c;

import java.awt.Checkbox;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Program {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		 java.io.BufferedReader stdin = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
	      
	       try {
			int n = Integer.parseInt(stdin.readLine());
			 ArrayList<String> l = new ArrayList<String>();
			for (int i = 0; i < n; ++i){
				String[] spt = stdin.readLine().split(" ");
				int a = Integer.parseInt(spt[0]);
				int b = Integer.parseInt(spt[1]);
				
				int res = 0;
				for (int j = a; j <= b; ++j){
					for (int k = j+1; k <= b; ++k){
						if (check(j,k)){ res++;
//						check(j,k);
//						if (j == 178) {
//							int asd = 123;
//							check(j,k);
//							asd++;
//						}
//						System.out.println(j+" "+k);
						}
					}
				}
				l.add("Case #"+(i+1)+": "+res);
				
			}
			for (String s : l) {
		    	   System.out.println(s);
		       }
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static boolean check(int a, int b){
		
		if (b <= a) return false;
		int x = 10;
		int n = 1;
		while (a/x > 0){
			n++;
			x *= 10;
		}

		//System.out.println(n);
		for (int i = 1; i < n; ++i){
			int c = a % pow(10,i);
			int f = pow(10,(n-i))*c;
			int g = a / pow(10,i);
			if ( f+g  == b) return true;
		}
		
		return false;
	}
	static int pow (int x, int n){
		int y = x;
		for (int i =0; i<n-1; ++i) y*=x;
		return y;
	}
}
