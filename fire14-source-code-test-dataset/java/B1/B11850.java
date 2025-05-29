package ex3;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		for(int i = 0; i < n; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			ArrayList<Integer> al = new ArrayList<Integer>();
			
			for(int j = 1; j < a; j++) {
				for(int k = j+1; k <= b; k++) {
					int la, lb;
					int tmpa = j; int tmpb = k;
					for(la = 0; tmpa > 0; tmpa/=10)la++;
					for(lb = 0; tmpb > 0; tmpb/=10)lb++;
										
					tmpa = j; tmpb = k;

					while(lb>0){
						tmpa*=10; lb--;
					}
					while(la>0) {
						tmpb*=10; la--;
					}	
										
					if(tmpa+k != tmpb+j && tmpa+k >= a && tmpa+k <= b && tmpb+j >= a && tmpb+j <= b){ 
						int lp = al.indexOf(tmpa+k);
						if(lp > 0 && al.get(lp-1) == tmpb+j) {
							
						} else {
							al.add((tmpa+k));
							al.add((tmpb+j));
						}
					}
				}
			}
			System.out.println("Case #"+(i+1)+": "+(al.size()/2));
		}
	}
}
