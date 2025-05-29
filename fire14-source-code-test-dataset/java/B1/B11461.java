import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;


public class C {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("c.txt")));
//		Scanner s = new Scanner(System.in);
		Scanner s = new Scanner(new File("c.in"));
//		BufferedReader in = new BufferedReader(new FileReader(new File("a-small.in")));
		int n = s.nextInt();
		for(int t=1;t<=n;t++){
			int a = s.nextInt(), b = s.nextInt();
			System.out.println("Case #"+t+": "+go(a,b));
			pw.println("Case #"+t+": "+go(a,b));
			pw.flush();
		}
	}
	static int go(int a,int b){
		int r = 0;
		for(int n=a;n<b;n++){
			for(int m=n+1;m<=b;m++){
				if(n<m){
					if(ok(n,m)) ++r;
				}
			}
		}
		return r;
	}
	static boolean ok(int a,int b){
		String aa = a+"", bb = b+"";
		if(aa.length() != bb.length()) return false;
		for(int i=0;i<aa.length();i++){
			if((aa.substring(i) + aa.substring(0,i)).equals(bb)) return true;
			
		}
		return false;
	}
}
