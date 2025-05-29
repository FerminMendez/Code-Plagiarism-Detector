import java.util.ArrayList;
import java.util.Scanner;


public class GooglersDancing {
	
	public static int[][] array = new int[11][4];
	
	public void generateArray() {
		for (int i=0;i<=10; i++) {
			array[i][0] = Integer.MAX_VALUE;
			array[i][2] = Integer.MAX_VALUE;
			array[i][1] = Integer.MIN_VALUE;
			array[i][3] = Integer.MIN_VALUE;
			//ArrayList<Integer> possibleList = new ArrayList<Integer>();
			for (int j=i-2; j<=i+2 ; j++) {
				if (j>=0 && j<=10) {
					if (Math.abs(j-i) < 2) {
						if (array[i][2] > (j+j)) {
							array[i][2] = j+j;
						}
						else if (array[i][3] < (j+j)) {
							array[i][3] = j+j;
						}
						if (array[i][0] > (j+j)) {
							array[i][0] = j+j;
						}
						else if (array[i][1] < (j+j)) {
							array[i][1] = j+j;
						}
					}
					else {
						if (array[i][0] > (j+j)) {
							array[i][0] = j+j;
						}
						else if (array[i][1] < (j+j)) {
							array[i][1] = j+j;
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		GooglersDancing g = new GooglersDancing();
		g.generateArray();
		for (int i=0; i<=10; i++) {
			System.out.println(i + ":" + array[i][0] + "*" + array[i][1] + "*" + array[i][2] + "*" + array[i][3] + "*");
		}
		
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int cases=1;
		while (cases <= T) {			
			int N,S,p, count=0;
			N = in.nextInt();
			S = in.nextInt();
			p = in.nextInt();
			while (N-->0) {
				boolean inRange=false, outRange=false;
				int t = in.nextInt();
				int p2 = p;
				while (p2<=10) {
					int sum = t-p2;
					if (sum >= array[p2][2] && sum <= array[p2][3]) {
						inRange = true;
						break;
					}
					else if (sum >= array[p2][0] && sum <= array[p2][1]) {
						outRange = true;
					}
					p2++;
				}
				if (inRange) {
					count++;
				}
				else if (outRange && S>0) {
					count++;
					S--;
				}
			}
			System.out.println("Case #" + cases + ": " + count);
			cases++;
		}
	}

}
