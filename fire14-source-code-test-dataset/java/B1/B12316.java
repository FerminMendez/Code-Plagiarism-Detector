package cj.qulification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class P3 {

	public static boolean isRecycled(int n, int m){
		String first=Integer.toString(n);
		for (int i=1;i<first.length();i++){
			String number=first.substring(i)+first.substring(0,i);
			if (Integer.parseInt(number)==m) return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader(new File("input/p3input.txt"));
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		int caseN=0;
		while ((line = br.readLine()) != null) {
			caseN++;
			int n=Integer.parseInt(line.split(" ")[0]);
			int m=Integer.parseInt(line.split(" ")[1]);
			int count=0;
			for (int i=n;i<=m;i++){
				for (int j=i+1;j<=m;j++){
					if (isRecycled(i,j)) count++;	
				}
			}
			System.out.println("Case #"+caseN+": "+count);
		}
		fr.close();
	}
}
