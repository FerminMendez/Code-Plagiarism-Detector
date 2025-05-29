package dancingwiththegooglers.codejam;

import java.util.Scanner;


public class Case {
	String str;
	int n, s, p;
	int[] t;
	Case(Scanner in){
		n = in.nextInt();
		s = in.nextInt();
		p = in.nextInt();
		t = new int[n];
		for (int i=0; i<n;i++){
			t[i] = in.nextInt();
		}
	}

	public String solve(){
		int y = 0;
		int minNotSuprInRange = 3*p - 2;
		int minSuprInRange = 3*p - 4;
		int numOfSupr = 0;
		for(int i=0; i<n; i++){
			if(t[i] >= p){
				if(t[i] >= minNotSuprInRange)
					y++;
				else if(t[i] >= minSuprInRange){
					if(numOfSupr < s){
						numOfSupr++;
						y++;
					}
				}
			}

		}
		return String.valueOf(y);
	}

}
