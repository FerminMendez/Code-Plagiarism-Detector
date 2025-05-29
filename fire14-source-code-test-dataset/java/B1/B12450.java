import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class C {
	public static HashSet<Integer> used;
	public static void main(String[] args) throws IOException {
		PrintWriter out = new PrintWriter(new File("C.out"));
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		used = new HashSet<Integer>();
		for(int caseOn = 1; caseOn <= cases; caseOn++) {
			used.clear();
			int a = in.nextInt();
			int b = in.nextInt();
			
			int ans = 0;
			for(int i = a; i < b; i++) {
				if(used.contains(i))
					continue;
				int count = 0;
				ArrayList<Integer> rotations = gen(i);
				for(int t : rotations) {
					if(!used.contains(t)) {
						used.add(t);
						if(a <= t && t <= b) {
							count++;
						}
					}
				}
				count--;
				ans+=(count*(count+1))/2;
			}
			out.printf("Case #%d: %d\n",caseOn,ans);
		}
		out.close();
	}
	
	public static ArrayList<Integer> gen(int a) {
		int dig = countDigits(a);
		int ten = 1;
		for(int i = 1; i < dig; i++) {
			ten*=10;
		}
		ArrayList<Integer> ret = new ArrayList<Integer>();
		for(int i = 0; i < dig; i++) {
			if(countDigits(a)==dig)
				ret.add(a);
			a = (a%10)*ten + (a/10);
		}
		return ret;
	}
	
	public static int countDigits(int a) {
		int c = 0;
		while(a!=0) {
			c++;
			a/=10;
		}
		return c;
	}
}
/*

4
1 9
10 40
100 500
1111 2222


*/
