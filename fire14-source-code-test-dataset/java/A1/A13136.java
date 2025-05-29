import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class B {
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
			int N = s.nextInt();
			int S = s.nextInt();
			int p = s.nextInt();
			int res = 0;
			for (int i=0;i<N;i++) {
				int v = s.nextInt();
				if (v<p) continue;
				if (p==0) res++;
				else if (v/p >= 3) res++;
				else if ((v+2)/p>=3) {
					res++;
				}
				else if (S!=0 && (v+4)/p>=3) {
					res++; S--;
				}
			}
			if (s.hasNext()) s.nextLine();
			System.out.println("Case #"+a+": "+res);
		}
		s.close();
	}

}
