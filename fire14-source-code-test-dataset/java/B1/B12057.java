import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


public class g {
	
	public static int go(String a, String b) {

		if (Integer.parseInt(a) > Integer.parseInt(b)) {
			return 0;
		}
		if (a.toCharArray().length == 1 || b.toCharArray().length == 1) {
			return 0;
		}
		
		HashSet<Object> hs = new HashSet<Object>();
//		ArrayList<GGG> al = new ArrayList<Object>();
//		HashMap<GGG, Integer> hm = new HashMap<Object, Integer>();
		
		int counter = 0;
		char[] ch_n;
		int d = 0, reminder = 0;
		int n = Integer.parseInt(a);
		int val = 0;
		int[] input;
		for (int i = Integer.parseInt(a) ; i < Integer.parseInt(b) ; i++) {
			n += 1;
			Integer in = new Integer(n);
			ch_n = in.toString().toCharArray();
//			System.out.println(n);
			val = n;
			for (int j = 0 ; j < ch_n.length - 1 ; j++) {
				d = (int) (val / Math.pow(10, ch_n.length - 1));
				reminder = (int) (val % Math.pow(10, ch_n.length - 1));
				val = reminder * 10 + d;
//				System.out.println(val);
				if (val < n) {
					if (val >= Integer.parseInt(a) && n <= Integer.parseInt(b)) {
//						System.out.println(val);
//						System.out.println(n);
//						System.out.println("------");
						input = new int[]{val, n};
//						System.out.println(Arrays.toString(input));
						HSC g = new HSC(val, n);
						hs.add(g);
						
					}
				} else if (val > n) {
					if (n >= Integer.parseInt(a) && val <= Integer.parseInt(b)) {
//						System.out.println(n);
//						System.out.println(val);
//						System.out.println("******");
//						counter++;
						
						input = new int[]{n, val};
//						System.out.println(Arrays.toString(input));
						HSC g = new HSC(n, val);
						hs.add(g);
					}
				}
			}
		}
		return hs.size();
//		System.out.println(hs.size());
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader f = new BufferedReader(new FileReader("C-small-attempt3.in"));
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
			String str;
			int T = 0;
			int c = 0;
			int answer = 0;
			String A = "", B = "";
			ArrayList<String> lines = new ArrayList<String>();
			
			while((str = f.readLine()) != null) {
				if (c == 0) {
					T = Integer.parseInt(str);
				} else {
					A = str.split(" ")[0];
					B = str.split(" ")[1];
					answer = go(A, B);
//					System.out.println(answer);
					out.print("Case #" + (new Integer(c)).toString() + ": " + (new Integer(answer)).toString());
					if (c != T) {
						out.println();
					}
				}
				c++;
			}
//			System.out.println(T);
//			
//			
//			int cc = 1;
//			for (String s : lines) {
//				A = s.split(" ")[0];
//				B = s.split(" ")[1];
//
//				answer = go(A, B);
//				
//				if (cc != T) {
//					out.println();
//				}
//				cc++;
//			}
			
			out.close();
			System.exit(0);  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
