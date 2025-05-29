import java.util.*;
import java.io.*;
public class Sol2 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("B-small-attempt0.in"));
		System.setOut(new PrintStream(new File("B-small-attempt0.out")));
		int len = sc.nextInt();
		for (int i = 0; i < len; i++) {
			int nexlen = sc.nextInt();
			int surp = sc.nextInt();
			int minscore = sc.nextInt();
			int numb = 0;
			for (int a = 0; a < nexlen; a++) {
				int[] three = separate(sc.nextInt());
				if (isGood(three, minscore)) {
					numb++;
				} else {
					if (((three[0]==three[1]&&three[1]==three[2]&&three[0]!=0)||(three[0]==three[1]&&three[1]-1==three[2]))&&surp>0) {
						if (three[0]+1>=minscore) {
							numb++;
							surp--;
						}
					}
				}
			}
			System.out.println("Case #"+(i+1)+": "+numb);
		}
	}
	public static int[] separate(int i) {
		int[] ret = new int[3];
		ret[0] = (int)Math.ceil(i/3.);
		ret[1] = (int)Math.ceil((i-ret[0])/2.);
		ret[2] = i-ret[0]-ret[1];
		return ret;
	}
	public static boolean isGood(int[] in,int a) {
		for (int i = 0; i < 3; i++) {
			if (in[i]>=a) {
				return true;
			}
		}
		return false;
	}
}