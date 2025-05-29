import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;



public class BDancingWithTheGooglers {
	
	static int dance(int n, int s, int p, int[] tot) {
		int count = 0;
		int countSurprise = 0;
		int min = p + 2*Math.max(0, p - 1);
		int minSurprise = p + 2*Math.max(0, p - 2);
		for(int i = 0; i < n; ++i) {
			if(tot[i] >= min) {
				++count;
				continue;
			}
			if(tot[i] >= minSurprise && countSurprise < s) {
				++count;
				++countSurprise;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		String filename = "B-small-attempt0.in";
		BufferedReader r = new BufferedReader(new FileReader(filename));
		int t = Integer.parseInt(r.readLine());
		PrintWriter p = new PrintWriter("b.out");
		for(int i = 0; i < t; ++i) {
			String[] test = r.readLine().split(" ");
			int n = Integer.parseInt(test[0]);
			int s = Integer.parseInt(test[1]);
			int pp = Integer.parseInt(test[2]);
			int[] tot = new int[n];
			for(int a = 0; a < n; ++a) {
				tot[a] = Integer.parseInt(test[3 + a]);
			}
			int j = i + 1;
			p.println("Case #" + j + ": " +  dance(n, s, pp, tot));
			
		}
		p.flush();
		p.close();
	}

}
