import java.util.*;
import java.io.*;
class probB {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(new File("probB.in"));
		PrintWriter output = new PrintWriter(new File("probB.txt"));
		int lines = input.nextInt();
		for (int onl = 0; onl<lines; onl++) {
			int googlers = input.nextInt();
			int sur = input.nextInt();
			int p = input.nextInt();
			int[] scores = new int[googlers];
			int ssf = 0; //Surprising so far
			int res = 0;
			for (int i=0; i<googlers; i++) {
				scores[i] = input.nextInt();
			}
			for (int cur : scores) {
				if (cur%3 == 0) { //Split evenly
					if (cur/3 >= p) {
						res++;
						System.out.println(cur + " Even");
						continue;
					}
					if (cur/3 + 1 >= p && cur > 1) {
						res++;
						ssf++;
						System.out.println(cur + " Even + 1");
						continue;
					}
				} else if (cur%3 == 1) {
					if (cur/3 + 1 >= p && cur > 1) {
						res++;
						System.out.println(cur + " R1");
						continue;
					}
				} else {
					if (cur/3 + 1 >= p && cur > 1) {
						res++;
						System.out.println(cur + " R2");
						continue;
					}
					if (cur/3 + 2 >= p && cur >= 2) {
						res++;
						ssf++;
						System.out.println(cur + " R2 S");
						continue;
					}
				}
				
			}
			System.out.println(ssf + " " + sur);
			if (ssf > sur) res -= (ssf - sur);
			output.println("Case #" + (onl+1) + ": " + res);
			System.out.println(onl+2 + "------");
		}
		output.close();
	}
}
