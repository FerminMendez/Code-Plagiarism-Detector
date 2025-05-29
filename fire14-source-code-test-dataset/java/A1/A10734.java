package problems;

import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt(), N, S, P, Rnumber, number, aux;
		for (int i=1; i<=t; i++){
			N= sc.nextInt();
			S= sc.nextInt();		
			P= sc.nextInt();
			aux=0;
			P=3*P-2;
			Rnumber= P-2;
			if (P==1) Rnumber =1;
			System.out.print("Case #"+i+": ");
			for (int j=0; j<N; j++){
				number=sc.nextInt();
				if (number>=P){
					aux++;
				}
				else if ((S>0) && (number>=Rnumber)){
					S--;
					aux++;
				}
			}
			System.out.println(aux);
		}
	}
}