package codeJam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer pal;
		ArrayList<Integer> puntajes= new ArrayList();
		int test= sc.nextInt(), N, S, P, rare, num, count;
		for (int i=1; i<=test; i++){
			N= sc.nextInt();
			S= sc.nextInt();		
			P= sc.nextInt();
			count=0;
			P=3*P-2;
			rare= P-2;
			if (P==1) rare =1;
			System.out.print("Case #"+i+": ");
			for (int j=0; j<N; j++){
				num=sc.nextInt();
				if (num>=P){
					count++;
				}
				else if ((S>0) && (num>=rare)){
					S--;
					count++;
				}
			}
			System.out.println(count);
		}
	}
}