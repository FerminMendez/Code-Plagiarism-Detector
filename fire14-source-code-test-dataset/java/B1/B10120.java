package GCJ;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ProblemC {
	
	public static void main(String args[]) throws IOException{
		File file = new File("I:/res/ACMCS/GCJ/C-small-attempt0.in");
		File outFile = new File("I:/res/ACMCS/GCJ/problemC.out.txt");
		FileWriter fw = new FileWriter(outFile);
		BufferedWriter bw = new BufferedWriter(fw);
		//FileReader fileReader = new FileReader(file);
		Scanner in = new Scanner(file);
		int cs = in.nextInt();
		int c = 0;
		while(cs -- > 0){
			++ c;
			int ans = 0;
			int A = in.nextInt();
			int B = in.nextInt();
			for(int i = A; i <= B; ++ i)
				for(int j = i + 1; j <= B; ++ j)
					if(isRecycle(i, j)) ++ ans;
			bw.write("Case #");
			bw.write(String.valueOf(c));
			bw.write(": ");			
			bw.write(String.valueOf(ans));
			bw.newLine();
		}
		bw.close();
	}
	
	public static boolean isRecycle(int n, int m){
		String str = String.valueOf(n);
		int len = str.length();
		int mapN[] = new int[len];
		for(int i = len - 1; i >= 0; -- i){
			mapN[i] = n % 10;
			n /= 10;
		}
		int mapM[] = new int[len];
		for(int i = len - 1; i >= 0; -- i){
			mapM[i] = m % 10;
			m /= 10;
		}
		for(int i = 0; i < len; ++ i){
			boolean flag = true;
			for(int j = i, k = 0; k < len; ++ k){
				if(mapN[(j + k) % len] != mapM[k]) {flag = false;break;}
			}
			if(flag) return true;
		}
		return false;
	}
}





