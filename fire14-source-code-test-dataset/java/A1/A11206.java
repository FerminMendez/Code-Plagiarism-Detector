import java.io.*;
import java.util.*;
import java.math.*;
public class Solution {
	static int miracles=-1;
	static int tresh=1000;
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int N=sc.nextInt();
			miracles=sc.nextInt();
			tresh=sc.nextInt();
			int count=0;
			for(int i=0;i<N;i++) {
				int v=sc.nextInt();
				if(isAboveThres(v)||isAboveThresMiracle(v)) {
					count++;
				}
			}
			System.out.println("Case #"+(t+1)+": "+count);
		}
	}
	public static boolean isAboveThres(int v) {
		switch(v%3) {
			case 0:
				return (v/3)>=tresh;
			case 1:
				return ((v/3)+1)>=tresh;
			case 2:
				return ((v+1)/3)>=tresh;
		}
		return false;
	}
	public static boolean isAboveThresMiracle(int v) {
		if(miracles<=0)
			return false;
		switch(v%3) {
			case 0:
				if(v>0&&(v/3)+1>=tresh) {
					miracles--;
					return true;
				}
				break;
			case 2:
				if(((v+1)/3)+1>=tresh) {
					miracles--;
					return true;
				}
				break;
		}
		return false;
	}
}
