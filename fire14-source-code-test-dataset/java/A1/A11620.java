import java.io.*;
import java.util.*;

public class DancingGooglers {
	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(new File("C:/Users/Ross/Downloads/B-small-attempt1.in"));
			int T = in.nextInt();
			String out = "";
			for(int i = 0; i < T; i++) {
				int N = in.nextInt();
				int S = in.nextInt();
				int p = in.nextInt();
				int count = 0;
				for(int j = 0; j < N; j++) {
					int t = in.nextInt();
					if(t > 3*p-3) count++;
					else if(S > 0 && t >= 3*p-4 && t != 0) {
						S--;
						count++;
					}
				}
				out += "Case #" + (i+1) + ": ";
				out += count + "\n";
				System.out.println(out);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
