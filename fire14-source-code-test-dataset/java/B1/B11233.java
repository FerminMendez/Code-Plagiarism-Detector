import java.io.*;
import java.util.*;
public class CSmall {
	public static Set set = new HashSet();
	public static int counter = 0;
	public static void main(String[] args) throws IOException {
		
		Scanner in = new Scanner(new File("C-small-attempt0.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C-small.out")));
		
		int T = Integer.parseInt(in.nextLine());
		for (int i = 0; i < T; i++) {
			String[] lim = in.nextLine().split(" ");
			System.out.println(Arrays.toString(lim));
			for (int j = Integer.parseInt(lim[0]); j < Integer.parseInt(lim[1]); j++) {
				if (j >= 10) {
					pair(Integer.toString(j), lim);
				}
			}
			System.out.println(set.toString());
			
			
			out.write("Case #"+ (i+1) +": " + set.size());
			if (i != T-1)
				out.write("\n");
			set.clear();
			
		}	
		out.close();
		System.exit(0);
	}
	
	private static void pair(String num, String[] lim) {
		int len = num.length();
		int upLim = Integer.parseInt(lim[1]), lowLim = Integer.parseInt(lim[0]);
		for (int i = 0; i < len; i++) {
			String k = num;
			num = num.charAt(len-1) + num.substring(0,len-1);
			//System.out.println(num);
			
			int a = Integer.parseInt(num), b = Integer.parseInt(k);
			
			if (a!=b && a <= upLim && a >= lowLim && b <= upLim && b >= lowLim) {
				if (a<b) {
					set.add(num+k);
				} else {
					set.add(k+num);
				}
			}
		}
		
	}
}