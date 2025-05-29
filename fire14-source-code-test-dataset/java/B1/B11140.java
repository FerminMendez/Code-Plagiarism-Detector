import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;


public class C {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new FileReader(new File("C.in")));
		PrintWriter out = new PrintWriter(new FileWriter("C.out"));
		int tests = in.nextInt();
		int A,B;
		for (int i = 1; i <= tests; i++) {
			out.print("Case #" + (i) + ": ");
			System.out.print("Case #" + (i) + ": ");	
			A = in.nextInt();B = in.nextInt();
			int cnt = 0;
			for (int m = 1; m <= B; m++) {
				for (int n = A; n < m; n++) {
					if(cycle(n,m))cnt++;
				}
			}			
			out.println(cnt);
			System.out.println(cnt);
		}
		out.close();
	}
	
	public static boolean cycle(int x,int y){
		String n = x+"";
		String m = y+"";
		for (int i = 1; i < n.length(); i++) {
			String tmp = n.substring(i);
			if((tmp + n.substring(0,i)).equals(m))return true;
		}
		return false;
	}
}
