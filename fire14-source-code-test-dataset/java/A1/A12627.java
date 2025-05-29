package q2;

import java.util.Scanner;

public class DWG {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int _t = 0; _t < t; _t++) {
			
			int n = sc.nextInt();
			int s = sc.nextInt();
			int p = sc.nextInt();
			
			int floor, sfloor;
			if (p == 0){
				floor = 0;
			} else {
				floor = p+(2*(p-1));
			}
			if (p == 1){
				 sfloor = 1;
			} else {
				sfloor = p+(2*(p-2));
			}

			int y = 0;
			for (int _n=0; _n<n; _n++){
				int ti = sc.nextInt();
				if (ti >= floor) {
					y++;
				} else if (ti >= sfloor && s > 0 && sfloor >= 0) {
					y++;
					s--;
				}
			}
			

			System.out.printf("Case #%d: %d\n",_t+1,y);
		}
	}

}
