package qualifier;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

public class TB {

	private Map<Character, Character> translate = null;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		try {
			File file = new File("src/qualifier/B-small-attempt0.in");
			String a = file.getAbsolutePath();
			in = new Scanner(file);
			out = new PrintWriter(new File("src/qualifier/B-small-attempt0.out"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TB worker = new TB();
		int n = in.nextInt();
		
		for (int i=1; i<=n; i++) {
			int k = in.nextInt();
			int s = in.nextInt();
			int p = in.nextInt();
			
			int[] scores = new int[k];
			for (int j=0;j<k;j++) {
				scores[j] = in.nextInt();
			}
			out.println("Case #" + i + ": " + worker.maxGs(k,p,s,scores));
		}
		out.flush();
	}
	
	public int maxGs(int k, int p, int s, int[] scores) {
		int res = 0;
		int subres = 0;
		int acceptable = 3*p-4;
		if (p == 1) acceptable = 1;
		for (int i=0; i<k; i++)
			if (scores[i]>=3*p-2) 
				res++;
			else if (scores[i]>=acceptable) subres++;
			
		res += Math.min(subres, s);
		return res;
	}
}
