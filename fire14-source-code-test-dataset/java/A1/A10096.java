package codejam2012.qualification;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


public class B {
	static File inFile = new File("inQBsmall.txt");
	static File outFile = new File("outQBsmall.txt");
	static BufferedReader in;
	static BufferedWriter out;
	static Scanner sc;

	static int T = 0;
	
	
	public static void solve() throws IOException{
		T = sc.nextInt();
		for (int i=0;i<T;i++) {						

			int N = sc.nextInt();
			int S = sc.nextInt();
			int p = sc.nextInt();

			int res = 0;
			
			for (int j=0;j<N;j++) {
				int g = sc.nextInt();
				if (p==0) {
					res++;					
				} else if (p==1) {
					if (g>=1) res++;
				}
				else if (g>=p+(p-1)+(p-1)) res++;				
				else if (S>0 && g>=p+(p-2)+(p-2)) {
					res++;
					S--;
				}
			}
			

			//StringBuffer res = new StringBuffer();

			//System.out.println(res.toString());
			out.write("Case #"+(i+1)+": "+String.valueOf(res)+"\n");
		}
	}
	
	public static void main(String[] args) throws IOException {
		try {
			in = new BufferedReader(new FileReader(inFile));
			out = new BufferedWriter(new FileWriter(outFile));
			sc = new Scanner(in);
			solve();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			in.close();
			out.close();		
		}		

	}
}

