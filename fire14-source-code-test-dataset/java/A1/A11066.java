import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class B {
	public static final String FILENAME = "B-small-0";
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("src/"+FILENAME+".in"));
		BufferedWriter out = new BufferedWriter(new FileWriter("src/"+FILENAME+".out"));
		Scanner s = new Scanner(in);
		int T = s.nextInt();
		for(int i = 1; i <= T; i++) {
			int N = s.nextInt();
			int S = s.nextInt();
			int p = Math.min(10, s.nextInt());
			int ok = 0;
			int maybe = 0;
			for(int j = 0; j < N; j++) {
				int total = s.nextInt();
				if(total >= p + 2*Math.max(0, p-1)) {
					ok++;
				}
				else if(total >= p + 2*Math.max(0, p-2)) {
					maybe++;
				}
			}
			int ret = ok + Math.min(maybe, S);
			out.write("Case #"+i+": "+ret+"\n");
		}
		in.close();
		out.close();
	}
}
