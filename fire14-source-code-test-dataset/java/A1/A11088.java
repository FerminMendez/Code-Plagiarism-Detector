import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;


public class B {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new FileReader(new File("B.in")));
		PrintWriter out = new PrintWriter(new FileWriter("B.out"));
		int tests = in.nextInt();
		int N,S,p;
		for (int i = 1; i <= tests; i++) {
			out.print("Case #" + (i) + ": ");
			System.out.print("Case #" + (i) + ": ");	
			N = in.nextInt();S = in.nextInt();p = in.nextInt();
			int cnt = 0,updateable = 0;
			for (int j = 0; j < N; j++) {
				int x = in.nextInt();
				int y = x/3;
				int rem = x%3;
				if(rem == 0){
					if(y >= p)cnt++;
					else if(y+1 <= x && y+1 == p)updateable++;
				}else if(rem == 1){
					if(y+1 >= p)cnt++;
				}else{//rem == 2 
					if(y+1 >= p)cnt++;
					else if(y+2 == p)updateable++;
				}
			}
			cnt += Math.min(S,updateable);
			out.println(cnt);
			System.out.println(cnt);
		}
		out.close();
	}
}