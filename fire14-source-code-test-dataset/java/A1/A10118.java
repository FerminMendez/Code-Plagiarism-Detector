package GCJ;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ProblemB {
	public static void main(String args[]) throws IOException{
		File file = new File("I:/res/ACMCS/GCJ/B-small-attempt0.in");
		File outFile = new File("I:/res/ACMCS/GCJ/problemB.out.txt");
		FileWriter fw = new FileWriter(outFile);
		BufferedWriter bw = new BufferedWriter(fw);
		//FileReader fileReader = new FileReader(file);
		Scanner in = new Scanner(file);
		int cs = in.nextInt();
		int c = 0;
		while(cs -- > 0){
			++ c;
			int ans = 0;
			int n = in.nextInt();
			int map[] = new int[n];
			int s = in.nextInt();
			int p = in.nextInt();
			for(int i = 0; i < n; ++ i)
				map[i] = in.nextInt();
			ans = ProblemB.ans(map, s, p);
			bw.write("Case #");
			bw.write(String.valueOf(c));
			bw.write(": ");			
			bw.write(String.valueOf(ans));
			bw.newLine();
		}
		bw.close();
	}
	
	public static int suprise(int triSco){
		int max = (triSco + 4) / 3 + 1;
		int min = triSco / 3  -1 > 0 ? triSco / 3  -1 : triSco / 3;
		int sco = 0;
		for(int i = max; i >= min; -- i){
			sco = triSco - i;
			for(int j = (sco + 2) / 2 + 1; j >= (sco) / 2 - 1; -- j){
				int k = sco - j;
				if(Math.abs(i - j) <= 2 && Math.abs(i - k) <= 2 && Math.abs(j - k) <= 2 && i >= 0 && j >= 0 && k >= 0)
					return Math.max(Math.max(i, j), k);
			}
		}
		return max;
	}
	
	public static int nonSuprise(int triSco){
		int max = (triSco + 2) / 3 + 1;
		int min = triSco / 3 - 1;
		int sco = 0;
		for(int i = max; i >= min; -- i){
			sco = triSco - i;
			for(int j = (sco + 1) / 2 + 1; j >= (sco) / 2 - 1; -- j){
				int k = sco - j;
				if(Math.abs(i - j) <= 1 && Math.abs(i - k) <= 1 && Math.abs(j - k) <= 1 && i >= 0 && j >= 0 && k >= 0)
					return Math.max(Math.max(i, j), k);
			}
		}
		return max;
	}
	
	public static int ans(int map[], int s, int p){
		int max = 0;
		for(int i : map){
			if(nonSuprise(i) >= p)
				++ max;
			else if(suprise(i) >= p && s > 0){
				++ max;
				-- s;
			}
		}
		return max;
	}
	
}
