package compete;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Dance {
	
	private static void print(String sth) {
		System.out.println(sth);
	}
	
	private static int best(int S, int P, int [] totals) {
        int ret=0;
        if (P==0) return totals.length;
        for (int i = 0;i<totals.length;i++) {
            int t = totals[i];
            if (t>=P*3-2) {
                ret++;
                continue;
            } else if (P*3>3 && t>=P*3-4 && S>0) {
                S--;
                ret++;
            }
        }
        return ret;
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		
		int num = Integer.parseInt(in.readLine());
		
		for (int i=0;i<num;i++) {
			String sentence = in.readLine();
			Scanner s = new Scanner(sentence);
			
			int N = s.nextInt();
			int S = s.nextInt();
			int P = s.nextInt();
			
			int totals[] = new int[N];
			for (int j=0;j<N;j++) {
				totals[j] = s.nextInt();
			}
			print("Case #"+(1+i)+": "+best(S,P,totals));
		}	
	}
}
