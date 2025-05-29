package ex2;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		for(int i = 0; i < n; i++) {
			int g = in.nextInt(); // participants
			int su = in.nextInt(); // anomalies
			int s = in.nextInt(); // note maximum
			int ctn = 0;
			for(int j = 0; j < g; j++) {
				int p = in.nextInt(); // score
				
				if(3*s <= p || 2*(s-1)+s <= p || (s-1) + 2*s <= p) ctn++;
				else if (su > 0 && p > 0 && ((s-2)+2*s <= p || 2*(s-2)+s <= p || (s-2)+(s-1)+s <= p)) { ctn++; su--;}
			}
			System.out.println("Case #"+(i+1)+": "+ctn);
		}

	}

}
