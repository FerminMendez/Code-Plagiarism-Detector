import java.util.*;
import java.io.*;
import java.text.*;

public class Q {
	private static long solve(int from, int to) {
		int[] flag = new int[2000001];
		long res = 0;
		int t=from/10, b = 1; 
		while (t>0) {
			b*=10;t/=10;
		}
		for (int i = from; i < to; ++i) {
			t = i;			
			do {
				t = (t /10) + (t%10 * b);
				if (t > i && t<= to && flag[t] != i + 1) {
					flag[t] = i + 1;
					++res;
				}				
			} while (t != i);			
		}
		return res;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File("input.txt"));
		PrintStream out = new PrintStream("output.txt");
		
		int num = in.nextInt();
		in.nextLine();
		for (int i=0;i<num;++i) {
			int from = in.nextInt();
			int to = in.nextInt();			
			StringBuilder builder = new StringBuilder("Case #" +(i+1)+": ");
			builder.append(solve(from, to));
			System.out.println(builder.toString());
			out.println(builder.toString());
		}
		
		in.close();
		out.close();
	}	
}
