import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;


public class C {
	static Scanner s;
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		s = new Scanner(new File("a.txt"));
		int T = s.nextInt();
		for(int a=1;a<=T;a++) {
			int A = s.nextInt();
			int B = s.nextInt();
			int res = 0;
			for(int i=A; i<B; i++) {
				String v = String.valueOf(i);
				int len = v.length();
				HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
				for(int j=1; j<len; j++) {
					String w = v.substring(j,len) + v.substring(0,j);
					int n = Integer.parseInt(w);
					if (n>i && n<=B && !hm.containsKey(n)) {
						res++;
						hm.put(n, 1);
					}
				}
			}
			System.out.println("Case #"+a+": "+res);
		}
		s.close();
	}

}
